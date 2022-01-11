package ticTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class UserInterface {

	// there are repeating code in this example
	// I can use *Button[]* array to keep the buttons and create a buttonFactory method to simplify the code
	// Next time, design the class before implementation, it will be faster and much cleaner code.


	private String mark;
	private int count;
	private Button xy00;
	private Button xy01;
	private Button xy02;
	private Button xy10;
	private Button xy11;
	private Button xy12;
	private Button xy20;
	private Button xy21;
	private Button xy22;
	private Label promptText;
	private boolean finished;

	public UserInterface() {
		this.mark = "X";
		count = 0;
		finished = false;
	}

	public Parent getView() {

		// create elements
		BorderPane borderpane = new BorderPane();
		promptText = new Label("Turn: X");
		promptText.setFont(Font.font("Monospaced", 40));
		GridPane gridPane = new GridPane();
		xy00 = new Button(" ");
		xy01 = new Button(" ");
		xy02 = new Button(" ");
		xy10 = new Button(" ");
		xy11 = new Button(" ");
		xy12 = new Button(" ");
		xy20 = new Button(" ");
		xy21 = new Button(" ");
		xy22 = new Button(" ");
		xy00.setFont(Font.font("Monospaced", 40));
		xy01.setFont(Font.font("Monospaced", 40));
		xy02.setFont(Font.font("Monospaced", 40));
		xy10.setFont(Font.font("Monospaced", 40));
		xy11.setFont(Font.font("Monospaced", 40));
		xy12.setFont(Font.font("Monospaced", 40));
		xy20.setFont(Font.font("Monospaced", 40));
		xy21.setFont(Font.font("Monospaced", 40));
		xy22.setFont(Font.font("Monospaced", 40));

		// add button to the gridpane
		gridPane.add(xy00, 0, 0);
		gridPane.add(xy01, 0, 1);
		gridPane.add(xy02, 0, 2);
		gridPane.add(xy10, 1, 0);
		gridPane.add(xy11, 1, 1);
		gridPane.add(xy12, 1, 2);
		gridPane.add(xy20, 2, 0);
		gridPane.add(xy21, 2, 1);
		gridPane.add(xy22, 2, 2);

		// pane styling
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		borderpane.setPadding(new Insets(20, 20, 20, 20));
		borderpane.setPrefSize(180, 180);

		// button event
		xy00.setOnAction((event) -> {
			if (this.finished) {
				return;
			}
			if (xy00.getText().equals(" ")) {
				xy00.setText(getMark());
				promptText.setText("Turn: " + this.mark);
				count++;
			}
			if (count >= 5) {
				checkWinner();
			}
		});
		xy01.setOnAction((event) -> {
			if (this.finished) {
				return;
			}
			if (xy01.getText().equals(" ")) {
				xy01.setText(getMark());
				promptText.setText("Turn: " + this.mark);
				count++;
			}
			if (count >= 5) {
				checkWinner();
			}
		});
		xy02.setOnAction((event) -> {
			if (this.finished) {
				return;
			}
			if (xy02.getText().equals(" ")) {
				xy02.setText(getMark());
				promptText.setText("Turn: " + this.mark);
				count++;
			}
			if (count >= 5) {
				checkWinner();
			}
		});
		xy10.setOnAction((event) -> {
			if (this.finished) {
				return;
			}
			if (xy10.getText().equals(" ")) {
				xy10.setText(getMark());
				promptText.setText("Turn: " + this.mark);
				count++;
			}
			if (count >= 5) {
				checkWinner();
			}
		});
		xy11.setOnAction((event) -> {
			if (this.finished) {
				return;
			}
			if (xy11.getText().equals(" ")) {
				xy11.setText(getMark());
				promptText.setText("Turn: " + this.mark);
				count++;
			}
			if (count >= 5) {
				checkWinner();
			}
		});
		xy12.setOnAction((event) -> {
			if (this.finished) {
				return;
			}
			if (xy12.getText().equals(" ")) {
				xy12.setText(getMark());
				promptText.setText("Turn: " + this.mark);
				count++;
			}
			if (count >= 5) {
				checkWinner();
			}
		});
		xy20.setOnAction((event) -> {
			if (this.finished) {
				return;
			}
			if (xy20.getText().equals(" ")) {
				xy20.setText(getMark());
				promptText.setText("Turn: " + this.mark);
				count++;
			}
			if (count >= 5) {
				checkWinner();
			}
		});
		xy21.setOnAction((event) -> {
			if (this.finished) {
				return;
			}
			if (xy21.getText().equals(" ")) {
				xy21.setText(getMark());
				promptText.setText("Turn: " + this.mark);
				count++;
			}
			if (count >= 5) {
				checkWinner();
			}
		});
		xy22.setOnAction((event) -> {
			if (this.finished) {
				return;
			}
			if (xy22.getText().equals(" ")) {

				xy22.setText(getMark());
				promptText.setText("Turn: " + this.mark);
				count++;
			}
			if (count >= 5) {
				checkWinner();
			}
		});

		// add to the borderpane
		borderpane.setTop(promptText);
		borderpane.setCenter(gridPane);

		return borderpane;
	}

	public String getMark() {
		String output = mark;
		if (this.mark.equals("X")) {
			this.mark = "O";
		} else {
			this.mark = "X";
		}
		return output;
	}

	public void checkWinner() {

		// The default text I gave to button is " " a space. Add this condition in case 3 boxes of " " are cosider a win
		
		// row string is the same
		if (xy00.getText().equals(xy01.getText()) && xy00.getText().equals(xy02.getText()) && !xy00.getText().equals(" ")) {
			promptText.setText("The end!");
			this.finished = true;
			return;
		}
		if (xy10.getText().equals(xy11.getText()) && xy10.getText().equals(xy12.getText()) && !xy10.getText().equals(" ")) {
			promptText.setText("The end!");
			this.finished = true;
			return;
		}
		if (xy20.getText().equals(xy21.getText()) && xy20.getText().equals(xy22.getText()) && !xy20.getText().equals(" ")) {
			promptText.setText("The end!");
			this.finished = true;
			return;
		}

		// column string is the same
		if (xy00.getText().equals(xy10.getText()) && xy00.getText().equals(xy20.getText()) && !xy00.getText().equals(" ")) {
			promptText.setText("The end!");
			this.finished = true;
			return;
		}
		if (xy01.getText().equals(xy11.getText()) && xy01.getText().equals(xy21.getText()) && !xy01.getText().equals(" ")) {
			promptText.setText("The end!");
			this.finished = true;
			return;
		}
		if (xy02.getText().equals(xy12.getText()) && xy02.getText().equals(xy22.getText()) && !xy02.getText().equals(" ")) {
			promptText.setText("The end!");
			this.finished = true;
			return;
		}

		// diagoal is the same
		if (xy00.getText().equals(xy11.getText()) && xy00.getText().equals(xy22.getText()) && !xy00.getText().equals(" ")) {
			promptText.setText("The end!");
			this.finished = true;
			return;
		}
		if (xy02.getText().equals(xy11.getText()) && xy02.getText().equals(xy20.getText()) && !xy02.getText().equals(" ")) {
			promptText.setText("The end!");
			this.finished = true;
			return;
		}

		if (count == 9) {
			this.finished = true;
			promptText.setText("The end!");
		}
		return;

	}
	/*
	public void checkWinner() {

		// The default text I gave to button is " " a space. Add this condition in case 3 boxes of " " are cosider a win
		
		// row string is the same
		if (xy00.getText().equals(xy01.getText()) && xy00.getText().equals(xy02.getText()) && !xy00.getText().equals(" ")) {
			promptText.setText("The winner is: " + xy00.getText());
			this.finished = true;
			return;
		}
		if (xy10.getText().equals(xy11.getText()) && xy10.getText().equals(xy12.getText()) && !xy10.getText().equals(" ")) {
			promptText.setText("The winner is: " + xy10.getText());
			this.finished = true;
			return;
		}
		if (xy20.getText().equals(xy21.getText()) && xy20.getText().equals(xy22.getText()) && !xy20.getText().equals(" ")) {
			promptText.setText("The winner is: " + xy20.getText());
			this.finished = true;
			return;
		}

		// column string is the same
		if (xy00.getText().equals(xy10.getText()) && xy00.getText().equals(xy20.getText()) && !xy00.getText().equals(" ")) {
			promptText.setText("The winner is: " + xy00.getText());
			this.finished = true;
			return;
		}
		if (xy01.getText().equals(xy11.getText()) && xy01.getText().equals(xy21.getText()) && !xy01.getText().equals(" ")) {
			promptText.setText("The winner is: " + xy01.getText());
			this.finished = true;
			return;
		}
		if (xy02.getText().equals(xy12.getText()) && xy02.getText().equals(xy22.getText()) && !xy02.getText().equals(" ")) {
			promptText.setText("The winner is: " + xy02.getText());
			this.finished = true;
			return;
		}

		// diagoal is the same
		if (xy00.getText().equals(xy11.getText()) && xy00.getText().equals(xy22.getText()) && !xy00.getText().equals(" ")) {
			promptText.setText("The winner is: " + xy00.getText());
			this.finished = true;
			return;
		}
		if (xy02.getText().equals(xy11.getText()) && xy02.getText().equals(xy20.getText()) && !xy02.getText().equals(" ")) {
			promptText.setText("The winner is: " + xy02.getText());
			this.finished = true;
			return;
		}

		if (count == 9) {
			this.finished = true;
			promptText.setText("The end!");
		}
		return;

	}
		this method prints out the winner. After submission, I found they don't ask for the winner, so I commented out this part.
	*/

}
