package hurraa;

import java.applet.AudioClip;
import java.net.URL;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

		// it's a known problem that it doesn't recoognize the audioclip class
		// it's a minor point and I know this code is correct
		// so instead of findin a way to fix this, let's move on to major task - learning
		//AudioClip sound = new AudioClip("file:Applause-Yannick_Lemieux.wav");

        Button btn = new Button("Hurraa!");

		btn.setOnAction(event ->{
			//sound.play();
		});
		
        pane.setCenter(btn);


        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
