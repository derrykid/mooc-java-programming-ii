package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

	@Override
	public void start(Stage window) {
	
		// enter your name scene
		Label fieldTitle = new Label("Enter your name and start.");
		TextField text = new TextField();
		Button start = new Button("Start");
		GridPane pane = new GridPane();
		pane.add(fieldTitle, 0, 0);
		pane.add(text, 0, 1);
		pane.add(start, 0, 2);
		pane.setPadding(new Insets(20, 20, 20, 20));

		Scene greet = new Scene(pane);

		// welcome page
		StackPane stackpane = new StackPane();
		Label welcome = new Label("");
		stackpane.getChildren().add(welcome);
		stackpane.setPrefSize(300, 200);
		Scene welcomeScene = new Scene(stackpane);

		// button event
		start.setOnAction((event)->  {
			String name = text.getText();
			welcome.setText("Welcome " + name + "!");
			window.setScene(welcomeScene);
		});

		// window method
		window.setScene(greet);
		window.show();
	
	}

	public static void main(String[] args) {
		launch(GreeterApplication.class);
	}
}
