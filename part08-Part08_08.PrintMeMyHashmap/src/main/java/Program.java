import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
		HashMap<String, String> hashmap = new HashMap<>();
		hashmap.put("f.e", "for example");
		hashmap.put("etc.", "and so on");
		hashmap.put("i.e", "more precisely");

		printKeys(hashmap);
		System.out.println("---");
		printKeysWhere(hashmap, "i");
		System.out.println("---");
		printValuesOfKeysWhere(hashmap, ".e");
    }

	public static void printValuesOfKeysWhere(HashMap<String,String> hashmap, String text) {
		text = sanitizedString(text);
		for (String per: hashmap.keySet()) {
			if (per.contains(text)) {
				System.out.println(hashmap.get(per));
			}
		}
	}
	
	public static void printKeysWhere(HashMap<String,String> hashmap, String text) {
		text = sanitizedString(text);
		ArrayList<String> list = new ArrayList<>();
		
		for (String per: hashmap.keySet()) {
			if (per.contains(text)) {
				System.out.println(per);
			}
		}
	}

	public static void printKeys(HashMap<String, String> hashmap) {
		for (String per: hashmap.keySet()) {
			System.out.println(per);
		}
	}

	public static String sanitizedString(String string) {
		string = string.toLowerCase();
		return string.trim();
	}

}
