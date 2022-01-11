package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

	@Override
	public void start(Stage window) {
	
		Canvas paintingCanvas = new Canvas(800, 800);
		BorderPane layout = new BorderPane();
	
		GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

		painter.setFill(Color.BLACK);
		painter.fillRect(160, 80, 80, 80);
		painter.fillRect(480, 80, 80, 80);

		painter.fillRect(80, 400, 80, 80);
		painter.fillRect(560, 400, 80, 80);
		
		painter.fillRect(160, 480, 80, 80);
		painter.fillRect(240, 480, 80, 80);
		painter.fillRect(320, 480, 80, 80);
		painter.fillRect(400, 480, 80, 80);
		painter.fillRect(480, 480, 80, 80);
		
		layout.setCenter(paintingCanvas);
		layout.setStyle("-fx-background-color: white");

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	
	}


    public static void main(String[] args) {
		launch();
    }

}
