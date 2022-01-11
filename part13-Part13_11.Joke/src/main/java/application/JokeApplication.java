package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

	@Override
	public void start(Stage window) {


		// Create the HBox, button on top
		HBox box = new HBox();
		Button joke = new Button("Joke");
		Button ans = new Button("Answer");
		Button explanation = new Button("Explanation");
		box.getChildren().addAll(joke, ans, explanation);
		box.setSpacing(10);
		box.setAlignment(Pos.CENTER);
		

		// create the stackpane
		StackPane jokePane = createStackPane("What do you call a bear with no teeth?");
		StackPane ansPane = createStackPane("A gummy bear.");
		StackPane expPane = createStackPane("Because it cannot eat!");

		// default set
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(box);
		borderPane.setCenter(jokePane);
		Scene scene = new Scene(borderPane);
		
		// button action
		ans.setOnAction((event) -> borderPane.setCenter(ansPane));
		explanation.setOnAction((event) -> borderPane.setCenter(expPane));
		joke.setOnAction((event) -> borderPane.setCenter(jokePane));


		window.setScene(scene);
		window.show();
		
	}

	private StackPane createStackPane(String text) {
		StackPane pane = new StackPane();
		pane.setPrefSize(300, 180);
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().add(new Label(text));

		return pane;
	}

	public static void main(String[] args) {
		launch(JokeApplication.class);
	}
}
