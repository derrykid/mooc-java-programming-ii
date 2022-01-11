import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {

	private ArrayList<Card> hand;

	public Hand() {
		this.hand = new ArrayList<>();
	}

	public void add(Card card) {
		this.hand.add(card);
	}

	public void sort() {
		Collections.sort(hand);
	}

	@Override
	public int compareTo(Hand comparedHand) {
		int thisHand = this.hand.stream().mapToInt(each -> each.getValue()).sum();
		int compHand = comparedHand.hand.stream().mapToInt(each -> each.getValue()).sum();
		if (thisHand > compHand) {
			return 1;
		} else if (thisHand < compHand) {
			return -1;
		} else {
			return 0;
		}
	}

	public void sortBySuit() {
		Collections.sort(this.hand, new BySuitInValueOrder());
	}

	public void print() {
		this.hand.stream().forEach(per -> System.out.println(per));
	}

}