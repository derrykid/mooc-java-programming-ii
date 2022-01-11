import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		ArrayList<Book> booklist = new ArrayList<>();

		while (true) {
			System.out.println("Input the name of the book, empty stops:");
			String input = scanner.nextLine();
			if (input.equals("")) {
				break;
			}
			System.out.println("Input the age recommendation:");
			int recommendAge = Integer.valueOf(scanner.nextLine());
			booklist.add(new Book(input, recommendAge));
		}
		// sort the list
		Comparator<Book> comparator = Comparator.comparing(Book::getAge).thenComparing(Book::getName);
		Collections.sort(booklist, comparator);

		System.out.println(booklist.size() + " books in total.");
		System.out.println("Books: \n");
		for (Book per: booklist) {
			System.out.println(per);
		}

    }

}
