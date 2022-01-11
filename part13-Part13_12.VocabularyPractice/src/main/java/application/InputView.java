package application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derry
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class InputView {

	private Dictionary dictionary;

	public InputView(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public Parent getView() {
		Label word = new Label("Word");
		TextField wordField = new TextField();
		Label trans = new Label("Translation");
		TextField transField = new TextField();
		Button addBtn = new Button("Add the word pair");

		GridPane pane = new GridPane();
		pane.add(word, 0, 0);
		pane.add(wordField, 0, 1);
		pane.add(trans, 0, 2);
		pane.add(transField, 0, 3);
		pane.add(addBtn, 0, 4);

		pane.setVgap(10);
		pane.setHgap(10);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10, 10, 10, 10));

		addBtn.setOnAction((event) -> {

			String dictWord = wordField.getText();
			String dictTrans = transField.getText();

			this.dictionary.add(dictWord, dictTrans);

			wordField.clear();
			transField.clear();
		
		});
		
		
		return pane;
	}
	
}
