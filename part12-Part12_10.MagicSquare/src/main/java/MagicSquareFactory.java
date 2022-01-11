
public class MagicSquareFactory {

	public MagicSquare createMagicSquare(int size) {

		MagicSquare square = new MagicSquare(size);

		// implement the creation of a magic square with the Siamese method algorithm here
		// - 0 1 2 3 4
		// 0 - - - - -
		// 1 - - - - -
		// 2 - - - - -
		// 3 - - - - -
		// 4 - - - - -
		// the center of column will always be 1
		// top - right direction
		// column always add 1
		// row always minus 1
		int startColumn = square.getWidth() / 2;
		int input = 1;
		// 2
		int column = startColumn;
		int row = 0;

		// 4
		int indexLimit = square.getHeight() - 1;

		while (input <= size * size) {

			if (square.readValue(column, row) != 0) {
				row++;
				column--;
				row++;
				square.placeValue(column, row, input);
			}

			square.placeValue(column, row, input);

			// if it's at the top right corner now
			if (row == 0 && column == indexLimit) {
				row++;
				input++;
				continue;
				
			}

			row--; // start with 0
			column++; // start with 2
			input++;	// start with 1

			if (row == -1) {
				row = indexLimit;
			}
			if (column == indexLimit + 1) {
				column = 0;
			}

		}

		return square;
	}

}
