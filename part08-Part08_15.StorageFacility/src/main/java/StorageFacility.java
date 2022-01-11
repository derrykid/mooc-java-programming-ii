import java.util.*;

public class StorageFacility {

	private HashMap<String, ArrayList<String>> units;

	public StorageFacility() {
		this.units = new HashMap<>();
	}

	public void add(String unit, String item) {
		this.units.putIfAbsent(unit, new ArrayList<String>());
		ArrayList<String> existedUnites = this.units.get(unit);
		existedUnites.add(item);
	}

	public ArrayList<String> contents(String StorageUnit) {
		return this.units.getOrDefault(StorageUnit, new ArrayList<>());
	}
	
	public void remove(String storageUnit, String item) {
		this.units.get(storageUnit).remove(item);
		if (this.units.get(storageUnit).size() == 0) {
			this.units.remove(storageUnit);
		}
	}

	public ArrayList<String> storageUnits() {
		ArrayList<String> unitName = new ArrayList<>();
		for (String per : this.units.keySet()) {
			if (this.units.get(per).size() == 0) {
				continue;
			}
			unitName.add(per);
		}
		return unitName;
	}
	
}
