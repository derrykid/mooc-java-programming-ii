import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

	private HashMap<LicensePlate, String> registry;

	public VehicleRegistry() {
		this.registry = new HashMap<>();
	}

	public boolean add(LicensePlate licensePlate, String owner) {
		for (LicensePlate per : this.registry.keySet()) {
			if (per.equals(licensePlate)) {
				return false;
			}
		}
		this.registry.put(licensePlate, owner);
		return true;

	}

	public String get(LicensePlate license) {
		return this.registry.get(license);
	}

	public boolean remove(LicensePlate license) {
		for (LicensePlate per : this.registry.keySet()) {
			if (per.equals(license)) {
				this.registry.remove(license);
				return true;
			}
		}
		return false;
	}

	public void printLicensePlates() {
		for (LicensePlate per: this.registry.keySet()) {
			System.out.println(per);
		}
	
	}

	public void printOwners() {
		// key-value; might have same value
		ArrayList<String> owners = new ArrayList<>();
		for (String per: this.registry.values()) {
			if (!owners.contains(per)) {
				owners.add(per);
			}
		}
		// print owners
		for (String per: owners) {
			System.out.println(per);
		}
	
	}
}
