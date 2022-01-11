
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();

		while (true) {
			int input = Integer.valueOf(scanner.nextLine());
			if (input < 0) {
				break;
			}
			list.add(input);
		}
		// print numbers > 0
		list.stream().filter(e -> e > 0 && e <= 5).forEach(e -> System.out.println(e));
    }
}
