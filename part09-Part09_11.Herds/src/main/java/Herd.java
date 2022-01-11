
import java.util.ArrayList;

public class Herd implements Movable {

	private ArrayList<Movable> list;

	public Herd() {
		this.list = new ArrayList<>();
	}

	public String toString() {
		String output = "";
		for (Movable per : this.list) {
			output = output + per.toString() + "\n";
		}
		return output;
	}

	public void move(int dx, int dy) {
		for (Movable per : this.list) {
			per.move(dx, dy);
		}
	}

	public void addToHerd(Movable movable) {
		this.list.add(movable);
	}

}
