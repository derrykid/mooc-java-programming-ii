package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class ButtonAndTextFieldApplication extends Application  {

	@Override
	public void start(Stage window) {

		Button btn = new Button("Button");
		TextField txt = new TextField("TextField");

		FlowPane pane = new FlowPane();
		pane.getChildren().add(btn);
		pane.getChildren().add(txt);

		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.show();
		
	}


    public static void main(String[] args) {
		launch(ButtonAndTextFieldApplication.class);
    }

}
