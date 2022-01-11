
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class ShoppingCart {

	private Map<String, Item> cart;

	public ShoppingCart() {
		this.cart = new HashMap<>();
	}

	public void add(String product, int price) {
		if (this.cart.containsKey(product)) {
			this.cart.get(product).increaseQuantity();
		} else {
			this.cart.put(product, new Item(product, 1, price));
		}
	}

	public int price() {
		int sum = 0;
		for (Item per : this.cart.values()) {
			sum = sum + per.price();
		}
		return sum;
	}

	public void print() {
		for (Item e : this.cart.values()) {
			System.out.println(e);
		}
	}
}
