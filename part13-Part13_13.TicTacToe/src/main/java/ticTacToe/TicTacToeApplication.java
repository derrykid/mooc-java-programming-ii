package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {

	@Override
	public void start(Stage window) {
	
		UserInterface ui = new UserInterface();
		Scene scene = new Scene(ui.getView());

		window.setScene(scene);
		window.show();
	
	}


    public static void main(String[] args) {
		launch(TicTacToeApplication.class);
    }

}
