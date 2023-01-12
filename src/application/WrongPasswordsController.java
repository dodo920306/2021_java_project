package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WrongPasswordsController {
	@FXML
	private Stage stage;
	@FXML
	Button tryAgain;
	
	public void returnToLogIn() throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("LogIn.fxml"));
		Stage stage = (Stage) tryAgain.getScene().getWindow();
		stage.setY(100);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
