package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {

	@Override
	public void start(Stage window) {

		// init the objects - dict inputview, practice view
		BorderPane layout = new BorderPane();
		Dictionary dict = new Dictionary();
		InputView inputView = new InputView(dict);
		PracticeView practiceView = new PracticeView(dict);


		// HBox and buttons
		HBox topbox = new HBox();
		Button inputViewBtn = new Button("Enter new words");
		Button practiceViewBtn = new Button("Practice");
		topbox.getChildren().addAll(inputViewBtn, practiceViewBtn);
		topbox.setSpacing(10);
		topbox.setAlignment(Pos.CENTER_LEFT);
		topbox.setPadding(new Insets(20, 20, 20, 20));

		// layout of the app
		layout.setTop(topbox);

		// button action
		inputViewBtn.setOnAction((event)-> {
			layout.setCenter(inputView.getView());
		});
		
		practiceViewBtn.setOnAction((event)-> {
			layout.setCenter(practiceView.getView());
		});


		// default and windows
		layout.setCenter(inputView.getView());
		Scene scene = new Scene(layout, 400, 300);

		window.setScene(scene);
		window.show();

	}

	public static void main(String[] args) {
		launch(VocabularyPracticeApplication.class);
	}
}
