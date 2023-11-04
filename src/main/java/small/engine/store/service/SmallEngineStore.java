package small.engine.store.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import small.engine.store.controller.model.LocationData;
import small.engine.store.controller.model.LocationData.LawnmowerData;
import small.engine.store.dao.LocationDao;
import small.engine.store.dao.LawnmowerDao;
import small.engine.store.entity.Lawnmower;
import small.engine.store.entity.Location;
@Slf4j
@Service
public class SmallEngineStore {

	@Autowired
	private LawnmowerDao lawnmowerDao; 
	
	@Autowired
	private LocationDao locationDao;

	@Transactional(readOnly = false)
	public LocationData saveLocation(LocationData locationData) {
		Location location = locationData.toLocation();
		Location dbLocation = locationDao.save(location);

		return new LocationData(dbLocation);

	}
  
	
	
	
	
	@Transactional(readOnly = true)
	public LocationData retrieveLocationById(Long locationId) {
		Location location = findLocationById(locationId);
		return new LocationData(location);
	}

	private Location findLocationById(Long locationId) {
		
		return locationDao.findById(locationId)
				.orElseThrow(() -> new NoSuchElementException("Location with ID=" + locationId + "Was Not Found"));
	}

	@Transactional(readOnly = true)
	public List<LocationData> retrieveAllLocations() {
		List<Location> locationEntities = locationDao.findAll();
		List<LocationData> locationDtos = new LinkedList<>();

		for (Location location : locationEntities) {
			LocationData locationData = new LocationData(location);
			locationDtos.add(locationData);

		}
		return locationDtos;

	}
    
	@Transactional(readOnly = false)
	public void deleteLocation(Long locationId) {
		Location location = findLocationById(locationId); 
		locationDao.delete(location);
	}

	
    


}	