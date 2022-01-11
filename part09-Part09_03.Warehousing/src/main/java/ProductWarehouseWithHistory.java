import java.util.ArrayList;

public class ProductWarehouseWithHistory extends ProductWarehouse {

	private ChangeHistory history;
	
	public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
		super(productName, capacity);
		this.setBalance(initialBalance);
		this.history = new ChangeHistory();
		this.history.add(initialBalance);
	}

	@Override
	public void addToWarehouse(double amount) {
		super.addToWarehouse(amount);
		this.history.add(this.getBalance());
	}

	@Override
	public double takeFromWarehouse(double amount) {
		double output = super.takeFromWarehouse(amount);
		this.history.add(this.getBalance());
		return output;
	}

	public void printAnalysis() {
		System.out.println(
				"Product: " + this.getName() + "\n" +
				"History: " + this.history() +"\n" +
				"Largest amount of product: " + this.history.maxValue() +"\n" +
				"Smallest amount of product: " + this.history.minValue() +"\n" +
				"Average: " + this.history.average()
		);
	}
	
	public String history() {
		return this.history.toString();
	}
}
