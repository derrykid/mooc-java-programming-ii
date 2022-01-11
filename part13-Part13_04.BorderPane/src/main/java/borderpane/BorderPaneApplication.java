package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;

public class BorderPaneApplication extends Application {

	@Override
	public void start(Stage window) {

		BorderPane bp = new BorderPane();
		bp.setTop(new Label("NORTH"));
		bp.setBottom(new Label("SOUTH"));
		bp.setLeft(new Label("WEST"));
		bp.setRight(new Label("EAST"));

		Scene scene = new Scene(bp);
		window.setScene(scene);
		window.show();
	
	}

    public static void main(String[] args) {
		launch(BorderPaneApplication.class);
    }

}
