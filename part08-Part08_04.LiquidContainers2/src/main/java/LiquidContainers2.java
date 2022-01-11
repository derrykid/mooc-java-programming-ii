
import java.util.Scanner;

public class LiquidContainers2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Container first = new Container();
		Container second = new Container();
		while (true) {
			System.out.println("First:" + first.contains() + "/100");
			System.out.println("Second:" + second.contains() + "/100");

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
				first.add(number);
			}
			// first 30  move 20

			if (command.equals("move")) {
				// e.g. first = 30; number 10; second container can always add the num
				if (first.contains() >= number) {
					second.add(number);
					first.remove(number);
					continue;
				}
				// first = 10; remove 30;
				if (first.contains() < number) {
					second.add(first.contains());
					first.remove(number); // negative number, then be 0;
				}
			}
			if (command.equals("remove")) {
				second.remove(number);
			}

		}

	}
}
