package small.engine.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import small.engine.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class SmallEngineStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallEngineStoreApplication.class, args); 

	}

}
