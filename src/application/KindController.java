package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KindController implements Initializable{

	@FXML
	public Label presentKind = new Label();
	@FXML
	public Label pressntPlace = new Label();
	@FXML
	public TextField wantedKind = new TextField();
	@FXML
	public TextField wantedPlace = new TextField();
	@FXML
	public Label same = new Label();
	@FXML
	public Label samePlace = new Label();
	String kind = "";
	String place = "";
	
	public void initialize(URL arg0, ResourceBundle arg1){
		File kindFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + CreateNewAccountController.accountName + "\\Budget kind.txt");
		File placeFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + CreateNewAccountController.accountName + "\\Budget place.txt");
		try {
			BufferedReader input = new BufferedReader(new FileReader(kindFile));
			NoteExpenditureController.kindString = input.readLine().split(", ");
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BufferedReader input = new BufferedReader(new FileReader(placeFile));
			NoteExpenditureController.placeString = input.readLine().split(", ");
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < NoteExpenditureController.kindString.length; i++) {
			
			if (i != (NoteExpenditureController.kindString.length-1)) {
				System.out.println(NoteExpenditureController.kindString[i]);
				kind += NoteExpenditureController.kindString[i] + ", ";
			}
			else
				kind += NoteExpenditureController.kindString[i];
		}
		for (int i = 0; i < NoteExpenditureController.placeString.length; i++) {
			
			if (i != (NoteExpenditureController.placeString.length-1))
				place += NoteExpenditureController.placeString[i] + ", ";
			else
				place += NoteExpenditureController.placeString[i];
		}
		presentKind.setText(kind);
		pressntPlace.setText(place);
	}
	
	public void confirm() throws IOException {
		boolean notSame = true;
		for(int i = 0; i < kind.split(", ").length; i++) {
			if (wantedKind.getText().equals(kind.split(", ")[i])) {
				same.setText("You already have this kind.");
				notSame = false;
				break;
			}
		}
		for (int i = 0; i < place.split(", ").length; i++) {
			if (wantedKind.getText().equals(place.split(", ")[i])) {
				samePlace.setText("You already have this place.");
				notSame = false;
				break;
			}
		}
		
		if (wantedKind.getText() == "" && wantedPlace.getText() == "") {
			notSame = false;
		}
		
		if (notSame) {
			if (wantedKind.getText() != "")
				kind += ", " + wantedKind.getText();
			if (wantedPlace.getText() != "")
				place += ", " + wantedPlace.getText();
			String name = CreateNewAccountController.accountName;
			File kindFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\Budget kind.txt");
			File placeFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\Budget place.txt");
			
			BufferedWriter output = new BufferedWriter(new FileWriter(kindFile));
			output.write(kind);
			output.close();
			output = new BufferedWriter(new FileWriter(placeFile));
			output.write(place);
			output.close();
			
			cancel();
		}
	}
	
	public void cancel() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
		Stage stage = (Stage) wantedPlace.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
