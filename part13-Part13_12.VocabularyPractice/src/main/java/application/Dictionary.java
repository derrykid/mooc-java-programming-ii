package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Dictionary {

	private ArrayList<String> words;
	private HashMap<String, String> dictionary;

	public Dictionary() {
		this.words = new ArrayList<>();
		this.dictionary = new HashMap<>();
		add("Default", "Default");
	}

	// add
	public void add(String word, String translation) {
		if (!this.dictionary.containsKey(word)) {
			this.words.add(word);
		}
		this.dictionary.put(word, translation);
	}

	// get translation
	public String get(String word){
		return this.dictionary.get(word);
	}

	// get random word
	public String randomWord() {
		Random random = new Random();
		return this.words.get(random.nextInt(this.words.size()));
	}
	
}
