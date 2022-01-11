
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LiteracyComparison {

	public static void main(String[] args) {

		try {
			ArrayList<Literacy> list = Files.lines(Paths.get("literacy.csv")).map(each -> each.split(","))
					// Literacy(String country, String gender, double rate, int year)
					//Adult literacy rate, population 15+ years, male (%),Angola,2014,82.15105
					.map(parts -> new Literacy(parts[3].trim(), parts[2].trim(), Double.valueOf(parts[5]), Integer.valueOf(parts[4]))).sorted((x,y) -> x.compareTo(y))
					.collect(Collectors.toCollection(ArrayList::new));
			for (Literacy per : list) {
				System.out.println(per.getCountry() + " (" + per.getYear() + "), " + per.getGender() + ", " + per.getRate());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
