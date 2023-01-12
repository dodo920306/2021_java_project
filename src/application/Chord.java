package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Chord {

	@FXML
	Button major;
	static String chord;
	
	public void returnToMenu() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("ChordList.fxml"));
		Stage stage = (Stage) major.getScene().getWindow();
		stage.setResizable(false);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void next() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("ChordPicture.fxml"));
		Stage stage = (Stage) major.getScene().getWindow();
		stage.setY(50);
		stage.setX(400);
		stage.setResizable(false);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void major() throws IOException {
		chord = "major";
		next();
	}
	public void major7() throws IOException {
		chord = "major7";
		next();
	}
	public void minor() throws IOException {
		chord = "minor";
		next();
	}
	public void minor7() throws IOException {
		chord = "minor7";
		next();
	}
	public void seven() throws IOException {
		chord = "seven";
		next();
	}
	public void sus4() throws IOException {
		chord = "sus4";
		next();
	}
	public void add9() throws IOException {
		chord = "add9";
		next();
	}
	
}
