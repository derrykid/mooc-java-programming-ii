import java.util.ArrayList;

public class ChangeHistory {
	
	private ArrayList<Double> inventory;

	public ChangeHistory() {
		this.inventory = new ArrayList<>();
	}

	public void add(double status) {
		this.inventory.add(status);
	}

	public void clear() {
		this.inventory.clear();
	}

	public double maxValue() {
		if (this.inventory.size() == 0) {
			return 0.0;
		}	
		double max = this.inventory.get(0);
		for (Double per: this.inventory) {
			if (max < per) {
				max = per;
			}
		}
		return max;
	}

	public double minValue() {
		if (this.inventory.size() == 0) {
			return 0.0;
		}	
		double min = this.inventory.get(0);
		for (Double per: this.inventory) {
			if (min > per) {
				min = per;
			}
		}
		return min;
	}

	public double average() {
		if (this.inventory.size() == 0) {
			return 0;
		}
		double count = 0;
		double sum = 0;
		for (Double per: this.inventory) {
			sum = sum + per;
			count++;
		}
		return sum / count;
	}
	
	@Override
	public String toString() {
		return this.inventory.toString();
	}
	
}
