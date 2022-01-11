import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Warehouse {

	private Map<String, Integer> product;
	private Map<String, Integer> stock;

	public Warehouse() {
		this.product = new HashMap<>();
		this.stock = new HashMap<>();
	}

	public void addProduct(String product, int price, int stock) {
		this.product.put(product, price);
		this.stock.put(product, stock);
	}

	public int price(String product) {
		if (!this.product.containsKey(product)) {
			return -99;
		}
		return this.product.get(product);
	}

	public int stock(String product) {
		if (!this.stock.containsKey(product)) {
			return 0;
		}
		return this.stock.get(product);
	}

	public boolean take(String product) {
		// check if there's stock
		// take one if true;
		// return true
		if (!this.stock.containsKey(product)) {
			return false;
		}

		if (this.stock.get(product) == 0) {
			return false;
		}

		if (this.stock.get(product) > 0) {
			this.stock.put(product, (this.stock.get(product) - 1));
		}
		return true;
		
	}

	public Set<String> products() {
		Set<String> list = new HashSet<>();
		for (String per: this.product.keySet()) {
			list.add(per);
		}
		return list;	
	}
	
}
