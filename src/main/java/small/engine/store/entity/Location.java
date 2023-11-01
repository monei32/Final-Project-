package small.engine.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
	private Long locationId;
	
    
    @EqualsAndHashCode.Exclude
    private String storeName; 
    @EqualsAndHashCode.Exclude
	private String streetAddress; 
    @EqualsAndHashCode.Exclude
    private String city; 
    @EqualsAndHashCode.Exclude
    private String state; 
    @EqualsAndHashCode.Exclude
    private String zip;
    @EqualsAndHashCode.Exclude
    private String phone; 
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Lawnmower> lawnmowers = new HashSet<>(); 
	
	
}
