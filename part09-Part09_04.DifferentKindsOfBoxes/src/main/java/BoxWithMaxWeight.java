import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

	private int capacity;
	private ArrayList<Item> itemList;

	public BoxWithMaxWeight(int capacity) {
		this.capacity = capacity;
		this.itemList = new ArrayList<>();
	}

	@Override
	public void add(Item item) {
		int itemWeight = item.getWeight();
		int boxWeight = 0;
		for (Item per: itemList) {
			boxWeight = boxWeight + per.getWeight();
		}

		if (boxWeight + itemWeight > this.capacity) {
			return;
		}
		this.itemList.add(item);
	}

	@Override
	public boolean isInBox(Item item){
		return this.itemList.contains(item);
	}

	
}
