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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NoteExpenditureController implements Initializable{
	@FXML
	private TextField expenditure, detailTextField;
	@FXML
	private ChoiceBox<String> kind, place;
	
	static String [] kindString, placeString;
	static int i = 0;
	
	public void initialize(URL arg0, ResourceBundle arg1){
		File kindFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + CreateNewAccountController.accountName + "\\Budget kind.txt");
		File placeFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + CreateNewAccountController.accountName + "\\Budget place.txt");
		try {
			BufferedReader input = new BufferedReader(new FileReader(kindFile));
			kindString = input.readLine().split(", ");
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BufferedReader input = new BufferedReader(new FileReader(placeFile));
			placeString = input.readLine().split(", ");
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kind.getItems().addAll(kindString);
		place.getItems().addAll(placeString);
		
	}
	
	public void submit() throws IOException {
		
		try {
			NoteMyExpenditureController.open = true;
			int test = Integer.parseInt(expenditure.getText());
			i++;
			if (kind.getValue() == null)
				kind.setValue("");
			if(place.getValue() == null)
				place.setValue("");
			NoteMyExpenditureController.detail = kind.getValue() + "," +place.getValue() + "----" + "$" + expenditure.getText();
			
			NoteMyExpenditureController.detailDetail = detailTextField.getText();
			Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
			
			System.out.println(NoteMyExpenditureController.detail);
			
			System.out.println(i);
			Stage stage = (Stage) expenditure.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();
			Scene scene = new Scene(root);
			stage1.setScene(scene);
			stage1.show();
		}catch (NumberFormatException e){
			expenditure.setText("Only number please.");
		}
	}
	
	public void another() throws IOException {
		try {
			NoteMyExpenditureController.open = true;
			int test = Integer.parseInt(expenditure.getText());
			i++;
			if (kind.getValue() == null)
				kind.setValue("");
			if(place.getValue() == null)
				place.setValue("");
			NoteMyExpenditureController.detail = kind.getValue() + "," +place.getValue() + "----" + "$" + expenditure.getText();
			Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
			
			System.out.println(NoteMyExpenditureController.detail);
			System.out.println(NoteMyExpenditureController.open);
			
			System.out.println(i);
			
			root = FXMLLoader.load(this.getClass().getResource("NoteExpenditure.fxml"));
			Stage stage = (Stage) expenditure.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}catch (NumberFormatException e){
			expenditure.setText("Only number please.");
		}
	}
	
	public void cancel() {
		try {
			Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
			Stage stage = (Stage) expenditure.getScene().getWindow();
			stage.close();
			Stage stage1 = new Stage();
			Scene scene = new Scene(root);
			stage1.setScene(scene);
			stage1.show();
		}catch (Exception e){
				e.printStackTrace();
		}
	}
}
