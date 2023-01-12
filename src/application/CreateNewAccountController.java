package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CreateNewAccountController {
	
	@FXML
	Button sure;
	//MenuController acco = new MenuController();
	static String accountName, password;
	static File accountFile;
	

	public void sure() throws IOException {
		accountFile.mkdir();
	    File passwords = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + accountName + "\\passwords.txt");
	    BufferedWriter output = new BufferedWriter(new FileWriter(passwords));
	    output.write(password);
	    output.close();
		Stage stage = (Stage) sure.getScene().getWindow();
		File kindFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + accountName + "\\Budget kind.txt");
		File placeFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + accountName + "\\Budget place.txt");
		kindFile.createNewFile();
		placeFile.createNewFile();
		output = new BufferedWriter(new FileWriter(kindFile));
		
		output.write("Breakfast, Lunch, Dinner");
		output.close();
	
		
		output = new BufferedWriter(new FileWriter(placeFile));
		
		output.write("7-11, StreetYuLet");
		output.close();
		
		
		Parent root = FXMLLoader.load(this.getClass().getResource("Menu.fxml"));
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setX(500);
		stage.setY(50);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	public void nope() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("LogIn.fxml"));
		Stage stage = (Stage) sure.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
