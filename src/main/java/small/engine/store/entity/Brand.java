package small.engine.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Brand {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandId; 
	
	private String brandName;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude 
	@ManyToMany(mappedBy = "brands")
	private Set<Lawnmower> lawnmowers = new HashSet<>(); 
	
}
