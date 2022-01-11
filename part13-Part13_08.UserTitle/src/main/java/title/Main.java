package title;

import javafx.application.Application;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a title:");
		String title = scan.nextLine();

		Application.launch(UserTitle.class, "--title=" + title );

	}


}
