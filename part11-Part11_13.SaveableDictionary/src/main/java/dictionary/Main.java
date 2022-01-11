package dictionary;

public class Main {
    public static void main(String[] args) {
		SaveableDictionary dictionary = new SaveableDictionary("words.txt");
		boolean wasSuccessful = dictionary.load();
		System.out.println(wasSuccessful);
		dictionary.add("Yahoo", "means happy");
		dictionary.add("minions", "cartoon");
		dictionary.add("cartoon", "minions");
		dictionary.add("kaja", "quick");
		dictionary.save();
    }
}
