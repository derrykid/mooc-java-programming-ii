package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class TextStatisticsApplication extends Application {

	@Override
	public void start(Stage window) {

		BorderPane bp = new BorderPane();
		TextArea ta = new TextArea("");
		Label letter = new Label("Letters: ");
		Label word = new Label("Words: ");
		Label longest = new Label("The longest word is: ");


		ta.textProperty().addListener((change, oldValue, newValue) -> {
			int characters = newValue.length();
			String[] parts = newValue.split(" ");
			int words = parts.length;
			String longestString = Arrays.stream(parts)
					.sorted((s1, s2) -> s2.length() - s1.length())
					.findFirst()
					.get();

			letter.setText("Letters: " + characters);
			word.setText("Words: " + words);
			longest.setText("The longest word is: " + longestString);
		}
		);

		HBox button = new HBox();
		button.setSpacing(10);
		button.getChildren().addAll(letter, word, longest);

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
