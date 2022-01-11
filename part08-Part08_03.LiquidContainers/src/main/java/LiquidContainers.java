
import java.util.Scanner;

public class LiquidContainers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int first = 0;
		int second = 0;

		while (true) {
			System.out.println("First:" + first + "/100");
			System.out.println("Second:" + second + "/100");

			String input = scan.nextLine();
			if (input.equals("quit")) {
				break;
			}
			String[] parts = input.split(" ");
			String command = parts[0];
			int number = Integer.valueOf(parts[1]);

			// if number < 0, no point to preceed
			if (number < 0) {
				continue;
			}

			if (command.equals("add")) {
				first = first + number;
			}
			// first 30  move 20

			if (command.equals("move")) {
				if (first >= number) {
					first = first - number;
					second = second + number;
				} else {
					second = second + first;
					first = first - number; // first will be minus
				}
			}
			if (command.equals("remove")) {
				second = second - number;
			}

			// if container > 100 or < 0
			if (first > 100) {
				first = 100;
			}
			if (first < 0) {
				first = 0;
			}
			if (second > 100) {
				second = 100;
			}
			if (second < 0) {
				second = 0;
			}

		}
	}

}
