package FlightControl;
import FlightControl.ui.TextUI;
import FlightControl.logic.FlightControl;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
		FlightControl fl = new FlightControl();
		Scanner scan = new Scanner(System.in);
		
		TextUI ui = new TextUI(fl, scan);
		ui.start();
    }
}
