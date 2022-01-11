
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
		HashMap<String, Book> hashmap = new HashMap<>();
		hashmap.put("sense", new Book("Sense and Sensibility", 1811, "..."));
		hashmap.put("prejudice", new Book("Pride and prejudice", 1813, "...."));

		printValues(hashmap);
		System.out.println("---");
		printValueIfNameContains(hashmap, "prejud");
    }

	public static void printValues(HashMap<String, Book> hashmap) {
		for (Book per: hashmap.values()) {
			System.out.println(per.toString());
		}
	
	}

	public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
		text = sanitizedString(text);

		for(Book per: hashmap.values()) {
			if (per.getName().contains(text)) {
				System.out.println(per.toString());
			}
		}
	
	}

	public static String sanitizedString(String text) {
		text = text.toLowerCase();
		return text.trim();
	}
}
