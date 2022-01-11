
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

	private int[][] square;

	// ready constructor
	public MagicSquare(int size) {
		if (size < 2) {
			size = 2;
		}

		this.square = new int[size][size];
	}

	// implement these three methods
	public ArrayList<Integer> sumsOfRows() {
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int row = 0; row < this.square.length; row++) {
			for (int column = 0; column < this.square[row].length; column++) {
				sum = sum + this.square[row][column];
			}
			list.add(sum);
			sum = 0;
		}
		return list;
	}

	// 00 + 10 + 20
	public ArrayList<Integer> sumsOfColumns() {
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<>();

		for (int column = 0; column < this.square.length; column++) {
			for (int j = 0; j < this.square.length; j++) {
				sum = sum + this.square[j][column];
			}
			list.add(sum);
			sum = 0;
		}

		return list;
	}

	// 00 11 22
	// 20 11 02
	// - 0 1 2
	// 0 - - -
	// 1 - - -
	// 2 - - -
	public ArrayList<Integer> sumsOfDiagonals() {
		int sumOfSameAxis = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int x = 0; x < this.getWidth(); x++) {
			sumOfSameAxis = sumOfSameAxis + this.square[x][x];
		}
		list.add(sumOfSameAxis);

		// sum from Left Bottom to Right top
		int sumLB = 0;
		for (int row = this.getHeight() - 1; row >= 0; row --) {
			for (int column = 0; column <= this.getWidth() - 1; column ++) {
				if (row + column == this.square.length - 1) {
					sumLB = sumLB + this.square[row][column];
				}
			}
		}
		list.add(sumLB);
		return list;
	}

	// ready-made helper methods -- don't touch these
	public boolean isMagicSquare() {
		return sumsAreSame() && allNumbersDifferent();
	}

	public ArrayList<Integer> giveAllNumbers() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int row = 0; row < square.length; row++) {
			for (int col = 0; col < square[row].length; col++) {
				numbers.add(square[row][col]);
			}
		}

		return numbers;
	}

	public boolean allNumbersDifferent() {
		ArrayList<Integer> numbers = giveAllNumbers();

		Collections.sort(numbers);
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i - 1) == numbers.get(i)) {
				return false;
			}
		}

		return true;
	}

	public boolean sumsAreSame() {
		ArrayList<Integer> sums = new ArrayList<>();
		sums.addAll(sumsOfRows());
		sums.addAll(sumsOfColumns());
		sums.addAll(sumsOfDiagonals());

		if (sums.size() < 3) {
			return false;
		}

		for (int i = 1; i < sums.size(); i++) {
			if (sums.get(i - 1) != sums.get(i)) {
				return false;
			}
		}

		return true;
	}

	public int readValue(int x, int y) {
		if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
			return - 1;
		}

		return this.square[y][x];
	}

	public void placeValue(int x, int y, int value) {
		if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
			return;
		}

		this.square[y][x] = value;
	}

	public int getWidth() {
		return this.square.length;
	}

	public int getHeight() {
		return this.square.length;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int row = 0; row < square.length; row++) {
			for (int col = 0; col < square[row].length; col++) {
				result.append(square[row][col]).append("\t");
			}

			result.append("\n");
		}

		return result.toString();
	}
}
