package small.engine.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import small.engine.store.entity.Lawnmower;

public interface LawnmowerDao extends JpaRepository<Lawnmower, Long> {

}
