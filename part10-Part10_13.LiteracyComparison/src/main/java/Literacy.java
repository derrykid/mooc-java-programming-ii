public class Literacy implements Comparable<Literacy> {

	private String country;
	private String gender;
	private double literacyRate;
	private int year;

	public Literacy(String country, String gender, double rate, int year) {
		this.country = country;
		this.gender = gender;
		this.literacyRate = rate;
		this.year = year;
	}

	public String getCountry() {
		return this.country;
	}
	public String getGender() {
		if (this.gender.contains("female")) {
			return "female";
		}
		return "male";
	}

	public double getRate() {
		return this.literacyRate;
	}

	public int getYear() {
		return this.year;
	}

	@Override
	public int compareTo(Literacy input) {
		double num =  this.literacyRate - input.literacyRate;
		if (num > 0) {
			return 1;
		} else if (num < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
