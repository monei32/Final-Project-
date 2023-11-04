package small.engine.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import small.engine.store.controller.model.LocationData;
import small.engine.store.controller.model.LocationData.LawnmowerData;
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
	
	@GetMapping("/location/{locationId}")
	public LocationData retrieveLocation(@PathVariable Long locationId) {
		log.info("Retrieving location with ID={}", locationId ); 
		return smallEngineStore.retrieveLocationById(locationId); 
	}
	
	@GetMapping("/location")
	public List<LocationData> retrieveAllLocations() {
		log.info("Retrieving All Locations");
		return smallEngineStore.retrieveAllLocations(); 
	}
	
	@PutMapping("/location/{locationId}")
	public LocationData updateLocation(@PathVariable Long locationId, @RequestBody LocationData locationData) {
		locationData.setLocationId(locationId); 
		log.info("Updating Location {}", locationData); 
		return smallEngineStore.saveLocation(locationData); 
	}
	
	@DeleteMapping("/location/{locationId}")
	public Map<String, String> deleteLocation(@PathVariable Long locationId){
		log.info("Deleting Location with ID=" + locationId + "." ); 
		smallEngineStore.deleteLocation(locationId); 
		
		return Map.of("message", "Location with Id=" + locationId + "was deleted sucessfully"); 
	}
	//@PostMapping("/location/{locationId}/lawnmower")
	//@ResponseStatus(HttpStatus.CREATED)
	//public LawnmowerData insertLawnmowerData(@PathVariable Long locationId, @RequestBody LawnmowerData lawnmowerData) {
		//log.info("Creating Lawnmower {} for location with ID={}", lawnmowerData, locationId);
		//return smallEngineStore.saveLawnmower(locationId, lawnmowerData);
	//}
}
