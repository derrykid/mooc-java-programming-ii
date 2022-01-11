package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class UserTitle extends Application {


	@Override
	public void start(Stage window) {

		Parameters param = getParameters();
		String title = param.getNamed().get("title");

		window.setTitle(title);
		window.show();
	}

}
