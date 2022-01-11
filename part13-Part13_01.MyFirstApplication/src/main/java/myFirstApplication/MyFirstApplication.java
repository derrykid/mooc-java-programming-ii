package myFirstApplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class MyFirstApplication extends Application {

	@Override
	public void start(Stage window) {
		Label textComponent = new Label("Text element");
		Button test = new Button("Yahoo");

		FlowPane componentGroup = new FlowPane();
		componentGroup.getChildren().add(textComponent);
		componentGroup.getChildren().add(test);

		Scene view = new Scene(componentGroup);

		window.setScene(view);
		window.setTitle("Window I created");
		window.show();
	}
    

    public static void main(String[] args) {
		launch(MyFirstApplication.class);
    }

}
