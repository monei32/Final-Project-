package small.engine.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import small.engine.store.entity.Location;

public interface LocationDao extends JpaRepository<Location, Long> {

}
