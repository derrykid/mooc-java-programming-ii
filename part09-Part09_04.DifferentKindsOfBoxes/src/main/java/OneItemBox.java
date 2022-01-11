import java.util.ArrayList;

public class OneItemBox extends Box {

	private ArrayList<Item> onlyOne;
	
	public OneItemBox() {
		this.onlyOne = new ArrayList<>();
	}

	@Override
	public void add(Item item) {
		if (this.onlyOne.size() != 0) {
			return;
		}
		this.onlyOne.add(item);
	}

	@Override
	public boolean isInBox(Item item) {
		return this.onlyOne.contains(item);
	}
	
	
}
