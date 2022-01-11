import java.util.HashMap;
public class Abbreviations {

	private HashMap<String, String> abbreviation;

	public Abbreviations() {
		this.abbreviation = new HashMap<>();
	}

	public void addAbbreviation(String abbreviation, String explanation) {
		String name = sanitizedString(abbreviation);
		if (this.abbreviation.containsKey(name)) {
			System.out.println("Already exist");
		}
		
		this.abbreviation.put(name, explanation);
	}

	public boolean hasAbbreviation(String input) {
		input = sanitizedString(input);
		if (this.abbreviation.containsKey(input)) {
			return true;
		}
		return false;
	}

	public String findExplanationFor (String abbreviation) {
		abbreviation = sanitizedString(abbreviation);
		if (this.hasAbbreviation(abbreviation)) {
			return this.abbreviation.get(abbreviation);
		} else {
			System.out.println("");
		}
		return null;
	}

	public static String sanitizedString (String input) {
		if (input == null) {
			return "";
		}

		input.toLowerCase();
		return input.trim();
	}
	
}
