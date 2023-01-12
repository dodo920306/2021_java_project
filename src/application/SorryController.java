package application;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class SorryController {

	@FXML
	Button returnMenu;
	final WebView browser = new WebView();
	final WebEngine webEngine = browser.getEngine();
	
	public void returnToMenu() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("Menu.fxml"));
		Stage stage = (Stage) returnMenu.getScene().getWindow();
		stage.setResizable(false);
		stage.setX(540);
		stage.setY(60);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void rick() {
		webEngine.load("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		VBox vBox = new VBox(browser);
		Stage stage = new Stage();
		Scene scene = new Scene(vBox);
		stage.setScene(scene);
		stage.show();
	}
}
