
import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

	public int compare(Card c1, Card c2) {
		// compare 2 cards' suit
		int value = c1.getSuit().ordinal() - c2.getSuit().ordinal();

		if (value == 0) {
			value = c1.getValue() - c2.getValue();
		}
		
		return value;
	}

}
