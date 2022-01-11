/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author derry
 */
import java.nio.file.Files;
import java.util.HashMap;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.io.IOException;

public class SaveableDictionary {

	private HashMap<String, String> dictionary;
	private String fileName;

	public SaveableDictionary() {
		this.dictionary = new HashMap<>();
	}

	public SaveableDictionary(String file) {
		this.dictionary = new HashMap<>();
		this.fileName = file;
	}

	public boolean save() {
		try ( PrintWriter write = new PrintWriter(this.fileName)) {
			for (String key : this.dictionary.keySet()) {
				write.println(key + ":" + this.dictionary.get(key));
			}
				write.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean load() {
		try {
			
			Files.lines(Paths.get(this.fileName))
					.map(row -> row.split(":"))
					.forEach(each -> this.dictionary.put(each[0], each[1]));
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	public void add(String word, String translation) {
		if (this.dictionary.containsKey(word)) {
			return;
		}
		this.dictionary.put(word, translation);
		this.dictionary.put(translation, word);
	}

	public String translate(String word) {
		String translation = null;

		if (this.dictionary.containsKey(word)) {
			translation = this.dictionary.get(word);
		}
		if (this.dictionary.containsValue(word)) {
			for (String per : this.dictionary.keySet()) {
				if (this.dictionary.get(per).equals(word)) {
					translation = per;
				}
			}
		}
		return translation;

	}

	public void delete(String word) {
		String translation = this.translate(word);
		this.dictionary.remove(word);
		this.dictionary.remove(translation);
	}

}
