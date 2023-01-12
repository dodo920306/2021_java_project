package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChordListController {

	@FXML
	Button c;
	
	static String chord;
	
	public void returnMenu() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("Menu.fxml"));
		Stage stage = (Stage) c.getScene().getWindow();
		stage.setResizable(false);
		stage.setX(540);
		stage.setY(60);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void next() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("Chord.fxml"));
		Stage stage = (Stage) c.getScene().getWindow();
		stage.setResizable(false);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void c() throws IOException {
		chord = "c";
		next();
	}
	
	public void d() throws IOException {
		chord = "d";
		next();
	}
	
	public void e() throws IOException {
		chord = "e";
		next();
	}
	
	public void f() throws IOException {
		chord = "f";
		next();
	}
	
	public void g() throws IOException {
		chord = "g";
		next();
	}
	
	public void a() throws IOException {
		chord = "a";
		next();
	}
	
	public void b() throws IOException {
		chord = "b";
		next();
	}
}
