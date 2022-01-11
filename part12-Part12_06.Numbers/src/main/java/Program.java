
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int time = Integer.valueOf(scanner.nextLine());
		Random ran = new Random();
		for (int i = 0; i < time; i++) {
			int number = ran.nextInt(11);
			System.out.println(number);
		}
    }

}
