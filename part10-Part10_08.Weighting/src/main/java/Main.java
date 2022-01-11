

public class Main {

    public static void main(String[] args) {
		Item phone = new Item("phone", 1);
		Item candy = new Item("candy", 2);
		Suitcase blue = new Suitcase(10);
		blue.addItem(phone);
		blue.addItem(candy);
		Hold gameHold = new Hold(30);
		gameHold.addSuitcase(blue);
		gameHold.printItems();
    }

}
