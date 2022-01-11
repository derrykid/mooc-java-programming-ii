
import java.util.*;

public class DictionaryOfManyTranslations {

	private HashMap<String, ArrayList<String>> dictionary;

	public DictionaryOfManyTranslations() {
		this.dictionary = new HashMap<>();
	}

	public void add(String word, String translation) {

		this.dictionary.putIfAbsent(word, new ArrayList<>());
		ArrayList<String> existedDictionary = this.dictionary.get(word);
		existedDictionary.add(translation);

	}

	public ArrayList<String> translate(String word) {

		return this.dictionary.getOrDefault(word, new ArrayList<String>());

	}

	public void remove(String word) {
		this.dictionary.remove(word);
	}
}
