package small.engine.store.controller.error;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalControllerErrorHandler {

	private enum LogStatus{
		STACK_Trace, MESSAGE_ONLY
	}
	
	@Data
	@NoArgsConstructor
	private class ExcpetionMessage{
		private String message; 
		private String statusReason; 
		private int statusCode; 
		private String timestamp; 
		private String uri; 
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExcpetionMessage handleNoSuchElementException(NoSuchElementException ex, WebRequest webRequest) {
		return buildExceptionMessage(ex, HttpStatus.NOT_FOUND, webRequest, LogStatus.MESSAGE_ONLY);  
	}

	private ExcpetionMessage buildExceptionMessage(NoSuchElementException ex, HttpStatus status,
			WebRequest webRequest, LogStatus logStatus) {
		
		String message = ex.toString(); 
		String statusReason = status.getReasonPhrase(); 
		int statusCode = status.value(); 
		String uri = null; 
		String timestamp = ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
		
		if(webRequest instanceof ServletWebRequest swr) {
			uri = swr.getRequest().getRequestURI(); 
		}
		
		if(logStatus == LogStatus.MESSAGE_ONLY) {
			log.error("Excpetion: {}", ex.toString());
		}
		else {
			log.error("Exception: ", ex);	
		}
		
		ExcpetionMessage excMsg = new ExcpetionMessage(); 
		
		excMsg.setMessage(message);
		excMsg.setStatusCode(statusCode);
		excMsg.setStatusReason(statusReason);
		excMsg.setTimestamp(timestamp);
		excMsg.setUri(uri);
		
		return excMsg; 
	}
}
