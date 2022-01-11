
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> mmap = new HashMap<>();
		mmap.add("First", 123);
		mmap.add("Second", 23);
		mmap.add("Third", 127);

		System.out.println(mmap.getSize());

    }

}
