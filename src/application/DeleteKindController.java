package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DeleteKindController implements Initializable{

	@FXML
	public Label presentKind = new Label();
	@FXML
	public Label pressntPlace = new Label();
	@FXML
	public ChoiceBox<String> deletedKind, deletedPlace;
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
		deletedKind.getItems().addAll(NoteExpenditureController.kindString);
		deletedPlace.getItems().addAll(NoteExpenditureController.placeString);
	}
	
	public void confirm() throws IOException {
		List<String> kindlist = new ArrayList<>(Arrays.asList(NoteExpenditureController.kindString));
		List<String> placelist = new ArrayList<>(Arrays.asList(NoteExpenditureController.placeString));
		kindlist.remove(deletedKind.getValue());
		placelist.remove(deletedPlace.getValue());
		NoteExpenditureController.kindString = kindlist.toArray(new String[kindlist.size()]);
		NoteExpenditureController.placeString = placelist.toArray(new String[placelist.size()]);
		String name = CreateNewAccountController.accountName;
		File kindFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\Budget kind.txt");
		File placeFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\Budget place.txt");
		BufferedWriter output = new BufferedWriter(new FileWriter(kindFile));
		kind = "";
		place = "";
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
		output.write(kind);
		output.close();
		output = new BufferedWriter(new FileWriter(placeFile));
		output.write(place);
		output.close();
		cancel();
	}
	
	public void cancel() {
		try {
			Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
			Stage stage = (Stage) presentKind.getScene().getWindow();
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
