package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class NotifierApplication extends Application {

	@Override
	public void start(Stage window) {

		// BorderPane pane = new BorderPane();
		VBox vbox = new VBox();
		TextField area = new TextField();
		Button btn = new Button("Update");
		Label label = new Label();

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				label.setText(area.getText());
			}
		
		});
		
		

		vbox.getChildren().addAll(area, btn, label);

		Scene scene = new Scene(vbox);

		window.setScene(scene);
		window.show();
	
	}


    public static void main(String[] args) {
		launch(NotifierApplication.class);
    }

}
