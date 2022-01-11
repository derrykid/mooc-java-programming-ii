package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

	@Override
	public void start(Stage window) {

		// first view
		BorderPane pane = new BorderPane();
		Label labelFirst = new Label("First view");
		Button firstBtn = new Button("To the second view!");
		pane.setTop(labelFirst);
		pane.setCenter(firstBtn);
		Scene first = new Scene(pane);

		// second view
		VBox box = new VBox();
		Button secondBtn = new Button("To the third view!");
		Label secondLabel = new Label("Second view!");
		box.getChildren().addAll(secondBtn, secondLabel);
		Scene second = new Scene(box);
		
		// third view
		GridPane gp = new GridPane();
		Label thirdLabel = new Label("Third view!");
		Button thirdBtn = new Button("To the first view!");
		gp.add(thirdLabel, 0, 0);
		gp.add(thirdBtn, 1, 1);
		Scene third = new Scene(gp);

		// botton event
		firstBtn.setOnAction((event) -> window.setScene(second));
		secondBtn.setOnAction((event) -> window.setScene(third));
		thirdBtn.setOnAction((event) -> window.setScene(first));

		

		window.setScene(first);
		window.show();

	}

	public static void main(String[] args) {
		launch(MultipleViews.class);
	}

}
