package small.engine.store.controller.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import small.engine.store.entity.Brand;
import small.engine.store.entity.Lawnmower;
import small.engine.store.entity.Location;

@Data
@NoArgsConstructor
public class LocationData {

	private Long locationId;
	private String storeName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String phone;

	private Set<LawnmowerData> lawnmowers = new HashSet<>();

	public LocationData(Location location) {
		this.locationId = location.getLocationId();
		this.storeName = location.getStoreName();
		this.streetAddress = location.getStreetAddress();
		this.city = location.getCity();
		this.state = location.getState();
		this.zip = location.getZip();
		this.phone = location.getPhone();

		for (Lawnmower lawnmower : location.getLawnmowers()) {
			this.lawnmowers.add(new LawnmowerData(lawnmower));
		}
	}

	public LocationData(Long locationId, String storeName, String streetAddress, String city, String state, String zip,
			String phone) {
		this.locationId = locationId;
		this.storeName = storeName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	public Location toLocation() {
		Location location = new Location();

		location.setLocationId(locationId);
		location.setStoreName(storeName);
		location.setStreetAddress(streetAddress);
		location.setCity(city);
		location.setState(state);
		location.setZip(zip);
		location.setPhone(phone);

		for (LawnmowerData lawnmowerData : lawnmowers) {
			location.getLawnmowers().add(lawnmowerData.toLawnmower());
		}

		return location;
	}

	@Data
	@NoArgsConstructor
	public class LawnmowerData {

		private Long lawnmowerId;
		private String model;
		private String type;
		private String serialNumber;
		private Set<BrandData> brands = new HashSet<>();

		public LawnmowerData(Lawnmower lawnmower) {
			this.lawnmowerId = lawnmower.getLawnmowerId();
			this.model = lawnmower.getModel();
			this.type = lawnmower.getType();
			this.serialNumber = lawnmower.getSerialNumber();

			for (Brand brand : lawnmower.getBrands()) {
				this.brands.add(new BrandData(brand));
			}
		}

		public Lawnmower toLawnmower() {
			Lawnmower lawnmower = new Lawnmower();

			lawnmower.setLawnmowerId(lawnmowerId);
			lawnmower.setModel(model);
			lawnmower.setType(type);
			lawnmower.setSerialNumber(serialNumber);

			for (BrandData brandData : brands) {
				lawnmower.getBrands().add(brandData.toBrand());
			}

			return lawnmower;
		}

	}

	@Data
	@NoArgsConstructor
	public class BrandData {

		private Long brandId;
		private String brandName;

		public BrandData(Brand brand) {
			this.brandId = brand.getBrandId();
			this.brandName = brand.getBrandName();

		}

		public Brand toBrand() {
			Brand brand = new Brand();

			brand.setBrandId(locationId);
			brand.setBrandName(city);

			return brand;

		}

	}

}
