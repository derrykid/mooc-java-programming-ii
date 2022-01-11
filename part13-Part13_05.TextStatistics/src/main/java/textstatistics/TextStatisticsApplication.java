package textstatistics;

import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class TextStatisticsApplication extends Application {

	@Override
	public void start(Stage window) {
	
		BorderPane bp = new BorderPane();
		TextArea ta = new TextArea("");
		
		// bottom 
		HBox button = new HBox();
		button.setSpacing(10);
		button.getChildren().add(new Label("Letters: 0"));
		button.getChildren().add(new Label("Words: 0"));
		button.getChildren().add(new Label("The longest word is:"));
		
		bp.setCenter(ta);
		bp.setBottom(button);

		Scene scene = new Scene(bp, 500, 500);
		window.setScene(scene);
		window.show();
		
	
	}


    public static void main(String[] args) {
		launch(TextStatisticsApplication.class);
    }

}
