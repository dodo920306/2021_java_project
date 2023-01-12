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
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class EditController implements Initializable{
	
	@FXML
	private ChoiceBox<String> choose;
	CreateNewAccountController cnac = new CreateNewAccountController();
	String name = cnac.accountName;
	
	File noteFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\" + EditExpenditureController.noteYear + "\\"
			+ EditExpenditureController.noteMonth + "\\" + EditExpenditureController.noteDay);
	
	public void initialize(URL arg0, ResourceBundle arg1){
		String chooseString = "";
		File expenditure1 = new File(noteFile + "\\" + "1.txt");
		File expenditure2 = new File(noteFile + "\\" + "2.txt");
		File expenditure3 = new File(noteFile + "\\" + "3.txt");
		File expenditure4 = new File(noteFile + "\\" + "4.txt");
		File expenditure5 = new File(noteFile + "\\" + "5.txt");
		File expenditure6 = new File(noteFile + "\\" + "6.txt");
		File expenditure7 = new File(noteFile + "\\" + "7.txt");
		File expenditure8 = new File(noteFile + "\\" + "8.txt");
		if (expenditure1.exists())
			chooseString += "First one.,";
		if (expenditure2.exists())
			chooseString += "Second one.,";
		if (expenditure3.exists())
			chooseString += "Third one.,";
		if (expenditure4.exists())
			chooseString += "Fourth one.,";
		if (expenditure5.exists())
			chooseString += "Fifth one.,";
		if (expenditure6.exists())
			chooseString += "Sixth one.,";
		if (expenditure7.exists())
			chooseString += "Seventh one.,";
		if (expenditure8.exists())
			chooseString += "Eighth one.,";
		String [] a = chooseString.split(",");
		choose.getItems().addAll(a);
	}
	
	public void chooseOne(ActionEvent event) throws IOException {
		switch (choose.getValue()) {
			case "First one.":
				NoteExpenditureController.i = 0;
				break;
			case "Second one.":
				NoteExpenditureController.i = 1;
				break;
			case "Third one.":
				NoteExpenditureController.i = 2;
				break;
			case "Fourth one.":
				NoteExpenditureController.i = 3;
				break;
			case "Fifth one.":
				NoteExpenditureController.i = 4;
				break;
			case "Sixth one.":
				NoteExpenditureController.i = 5;
				break;
			case "Seventh one.":
				NoteExpenditureController.i = 6;
				break;
			case "Eighth one.":
				NoteExpenditureController.i = 7;
				break;
			default:
				break;
		}
		Parent root = FXMLLoader.load(this.getClass().getResource("EditExpenditure.fxml"));
		Stage stage = (Stage) choose.getScene().getWindow();
		stage.close();
		Stage stage1 = new Stage();
		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();
	}

	public void cancel() {
		try {
			Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
			Stage stage = (Stage) choose.getScene().getWindow();
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
