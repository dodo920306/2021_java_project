package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MenuController implements Initializable{
	
	
	@FXML
	private AnchorPane anchor;
	@FXML
	private Button financial, time, smaug, chord, calculator, link;
	@FXML
	private Stage stage;
	@FXML
	private Label welcome;
	@FXML
	ImageView menuImageView, googleImageView;
	final WebView browser = new WebView();
	final WebEngine webEngine = browser.getEngine();
	static File f = new File("relax.mp3");
	
	static Media _media;
    static MediaPlayer _mediaPlayer;
    boolean turn = true;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image background = new Image(getClass().getResourceAsStream("volcano.jpg"));
		menuImageView.setImage(background);
		Image google = new Image(getClass().getResourceAsStream("google.jpg"));
		googleImageView.setImage(google);
		welcome.setText("Welcome, " + LogController.a + ".");
		
	}
	
	static void getMp3() {
   	 	_media = new Media(f.toURI().toString());
        _mediaPlayer = new MediaPlayer(_media);
	}
	
	public void turnUp() {
		System.out.println("party");
		if (turn) {
			_mediaPlayer.stop();
			turn = false;
		}else {
			openMp3();
			turn = true;
		}
	}
	
	static void openMp3() {
		_mediaPlayer.play();
	}
	
	public void calculator(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("Calculator.fxml"));
		stage = (Stage) calculator.getScene().getWindow();
		stage.setResizable(false);
		stage.setX(450);
		stage.setY(150);
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("calculator.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void link(ActionEvent event) throws IOException {
		webEngine.load("https://www.youtube.com/watch?v=PppkNH3bKV4&t=2s");
		VBox vBox = new VBox(browser);
		stage = new Stage();
		Scene scene = new Scene(vBox);
		stage.setScene(scene);
		stage.show();
	}
	
	public void google(ActionEvent event) throws IOException {
		webEngine.load("https://www.google.com.tw/");
		VBox vBox = new VBox(browser);
		stage = new Stage();
		Scene scene = new Scene(vBox);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToFinancial() throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("FinancialManagement.fxml"));
		stage = (Stage) financial.getScene().getWindow();
		System.out.println(stage.getX());
		System.out.println(stage.getY());
		stage.setResizable(false);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void log() throws IOException {
		_mediaPlayer.stop();
		turn = false;
		Parent root = FXMLLoader.load(this.getClass().getResource("LogIn.fxml"));
		
		stage = (Stage) financial.getScene().getWindow();
		stage.setResizable(false);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void sorry() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("Sorry.fxml"));
		stage = (Stage) financial.getScene().getWindow();
		stage.setX(250);
		stage.setY(100);
		stage.setResizable(false);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void chord() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("ChordList.fxml"));
		stage = (Stage) financial.getScene().getWindow();
		stage.setX(450);
		stage.setY(150);
		stage.setResizable(false);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
} 