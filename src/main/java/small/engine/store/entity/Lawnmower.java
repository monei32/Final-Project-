package small.engine.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Entity
@Data
public class Lawnmower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lawnmowerId; 
    
    @EqualsAndHashCode.Exclude
	private String model; 
	@EqualsAndHashCode.Exclude
    private String type; 
	@EqualsAndHashCode.Exclude
    private String serialNumber; 
	
    
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location; 
    
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
    		name = "lawnmower_brand", 
    		joinColumns = @JoinColumn (name = "lawnmower_id"), 
    		inverseJoinColumns = @JoinColumn(name = "brand_id")
    		)
    private Set<Brand> brands = new HashSet<>();  
    
    
	
}
