/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author derry
 */
public class PracticeView {

	private Dictionary dictionary;
	private String word;

	public PracticeView(Dictionary dictionary) {
		this.dictionary = dictionary;
		this.word = this.dictionary.randomWord();

	}

	public Parent getView() {
		// the scene frame work
		Label prompText = new Label("Translate the word " + this.word);
		TextField ansField = new TextField();
		Button btn = new Button("Check");
		Label response = new Label("");

		GridPane pane = new GridPane();
		pane.add(prompText, 0, 1);
		pane.add(ansField, 0, 2);
		pane.add(btn, 0, 3);
		pane.add(response, 0, 4);
		pane.setVgap(10);
		pane.setHgap(10);
		pane.setPrefSize(300, 180);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setAlignment(Pos.CENTER);

		// botton action
		btn.setOnAction((event) -> {

			String userAns = ansField.getText();
			if (userAns.equals(this.dictionary.get(this.word))) {
				response.setText("Correct!");
			} else {
				response.setText("Incorrect! The translation of the word '" + this.word + "' is '" + this.dictionary.get(this.word)+"'");
			}

			// next word for practice
			this.word  = this.dictionary.randomWord();
			prompText.setText("Translate the word " + this.word);
			ansField.clear();

		});

		return pane;
	}
}
