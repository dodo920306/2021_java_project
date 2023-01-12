package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FinancialMenuController implements Initializable{
	private Stage stage;
	@FXML
	private Button bud;
	@FXML
	Image background = new Image(getClass().getResourceAsStream("volcano.jpg"));
	@FXML
	ImageView backgroundImageView;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		backgroundImageView.setImage(background);
		
	}
	
	public void budget() throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("BudgetSetting.fxml"));
		stage = (Stage) bud.getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("budgetSetCss.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void returnMenu() throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("Menu.fxml"));
		Stage stage = (Stage) bud.getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void note() throws IOException{
		
		try {
		Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
		Stage stage = (Stage) bud.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void analysis() throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("AnalysisBudget.fxml"));
		Stage stage = (Stage) bud.getScene().getWindow();
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
}
