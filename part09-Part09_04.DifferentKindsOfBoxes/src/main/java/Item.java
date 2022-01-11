
public class Item {

	private String name;
	private int weight;

	public Item(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public Item(String name) {
		this(name, 0);
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public boolean equals(Object comparedObject) {
		if (this == comparedObject) {
			return true;
		}

		if (!(comparedObject instanceof Item)) {
			return false;
		}

		Item comparedObj = (Item) comparedObject;
		
		if (this.getName().equals(comparedObj.getName())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}
