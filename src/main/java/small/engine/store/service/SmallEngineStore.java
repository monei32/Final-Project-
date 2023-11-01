package small.engine.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import small.engine.store.controller.model.LocationData;
import small.engine.store.dao.LocationDao;
import small.engine.store.entity.Location;

@Service
public class SmallEngineStore {
   
	@Autowired
	private LocationDao locationDao; 
	
	@Transactional(readOnly = false)
	public LocationData saveLocation(LocationData locationData) {
		Location location = locationData.toLocation(); 
		Location dbLocation = locationDao.save(location); 
		
		return new LocationData(dbLocation); 
		
	}

}
