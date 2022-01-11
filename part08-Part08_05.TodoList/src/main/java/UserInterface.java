/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derry
 */
import java.util.Scanner;
public class UserInterface {
	
	private Scanner scanner;
	private TodoList list;

	public UserInterface(TodoList list, Scanner scanner) {
		this.list = list;
		this.scanner = scanner;
	}

	public void start() {
		while (true) {
			System.out.println("Command:");
		
			String input = scanner.nextLine();
			if (input.equals("stop")) {
				break;
			}

			if (input.equals("add")) {
				System.out.println("To add: ");
				String task = scanner.nextLine();
				this.list.add(task);
			}
			if (input.equals("remove")) {
				System.out.println("Which one to removed?");
				int removed =Integer.valueOf(scanner.nextLine());
				this.list.remove(removed);
			}
			if (input.equals("list")) {
				this.list.print();
			}
		
		}
	}
}
