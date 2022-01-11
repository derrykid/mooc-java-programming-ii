
public class Program {

    public static void main(String[] args) {
		int rows = 2;
		int columns = 3;
		int[][] matrix = new int[rows][columns];
		matrix[0][1] = 5;
		matrix[1][0] = 3;
		matrix[1][2] = 7;
		System.out.println(arrayAsString(matrix));
    }

	public static String arrayAsString(int[][] array) {
		StringBuilder outputString = new StringBuilder();
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				outputString.append(array[row][column]);
			}
			outputString.append("\n");
		}
		return outputString.toString();
	}

}
