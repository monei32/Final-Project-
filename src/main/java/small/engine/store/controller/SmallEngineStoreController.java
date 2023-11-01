package small.engine.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import small.engine.store.controller.model.LocationData;
import small.engine.store.service.SmallEngineStore;

@RestController
@RequestMapping("/small_engine_store")
@Slf4j
public class SmallEngineStoreController {
   
	@Autowired 
	private SmallEngineStore smallEngineStore; 
	
	@PostMapping("/location")
	@ResponseStatus(code = HttpStatus.CREATED)
	public LocationData createLocation(@RequestBody LocationData locationData) {
		log.info("Creating location {}", locationData); 
		return smallEngineStore.saveLocation(locationData); 
		
	}
	
}
