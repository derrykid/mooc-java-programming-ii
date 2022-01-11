package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ButtonAndLabelApplication extends Application {

	@Override
	public void start(Stage window) {
		FlowPane pane = new FlowPane();
		Label label1 = new Label("label one");
		Button btn = new Button("button one");

		label1.setOnMouseEntered((MouseEvent e) -> {
			label1.setScaleX(15);
			label1.setScaleY(15);
		});

		label1.setOnMouseExited((MouseEvent e) -> {
			label1.setScaleX(1);
			label1.setScaleY(1);
		});

		//pane.getChildren().add(btn);
		pane.getChildren().add(label1);

		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.setTitle("Btn and label");
		window.show();
	}

	public static void main(String[] args) {
		launch(ButtonAndLabelApplication.class);
	}

}
