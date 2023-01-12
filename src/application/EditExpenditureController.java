package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
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

public class EditExpenditureController implements Initializable{

	CreateNewAccountController cnac = new CreateNewAccountController();
	String name = cnac.accountName;
	static int noteYear, noteMonth, noteDay;
	File noteFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\" + noteYear + "\\"
			+ noteMonth + "\\" + noteDay);
	@FXML
	private TextField expenditure, detailTextField;
	@FXML
	private ChoiceBox<String> kind, place;
	
	
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
		kind.getItems().addAll(NoteExpenditureController.kindString);
		place.getItems().addAll(NoteExpenditureController.placeString);
		System.out.println(NoteExpenditureController.i);
		System.out.println("haha");
		switch (NoteExpenditureController.i) {
			case 0:
				File edit1 = new File(noteFile + "\\" + "1.txt");
				writeDetail(expenditure, kind, place, detailTextField, edit1);
				break;
			case 1:
				File edit2 = new File(noteFile + "\\" + "2.txt");
				writeDetail(expenditure, kind, place, detailTextField, edit2);
				break;
			case 2:
				File edit3 = new File(noteFile + "\\" + "3.txt");
				writeDetail(expenditure, kind, place, detailTextField, edit3);
				break;
			case 3:
				File edit4 = new File(noteFile + "\\" + "4.txt");
				writeDetail(expenditure, kind, place, detailTextField, edit4);
				break;
			case 4:
				File edit5 = new File(noteFile + "\\" + "5.txt");
				writeDetail(expenditure, kind, place, detailTextField, edit5);
				break;
			case 5:
				File edit6 = new File(noteFile + "\\" + "6.txt");
				writeDetail(expenditure, kind, place, detailTextField, edit6);
				break;
			case 6:
				File edit7 = new File(noteFile + "\\" + "7.txt");
				writeDetail(expenditure, kind, place, detailTextField, edit7);
				break;
			case 7:
				File edit8 = new File(noteFile + "\\" + "8.txt");
				writeDetail(expenditure, kind, place, detailTextField, edit8);
				break;
			default:
				break;
		}
		
	}
	
	public void writeDetail(TextField myLabel, ChoiceBox<String> myChoiceBox1, ChoiceBox<String> myChoiceBox2, TextField myTextField, File expenditure) {
		try {
			BufferedReader input = new BufferedReader(new FileReader(expenditure));
			String [] firstSplit = input.readLine().split("----\\$");
			System.out.println(firstSplit[0]);
			myLabel.setText(firstSplit[1]);
			String [] secondSplit = firstSplit[0].split(",");
			switch (secondSplit.length) {
				case 0:
					break;
				case 1:
					myChoiceBox1.setValue(secondSplit[0]);
					break;
				case 2:
					myChoiceBox1.setValue(secondSplit[0]);
					myChoiceBox2.setValue(secondSplit[1]);
					break;
				default:
						break;
			}
			String detailString = readAppointedLineNumber(expenditure, 2);
			myTextField.setText(detailString);
			input.close();
		} catch (FileNotFoundException e) {
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void submit() throws IOException {
		
		try {
			NoteMyExpenditureController.open = true;
			int test = Integer.parseInt(expenditure.getText());
			NoteExpenditureController.i++;
			if (kind.getValue() == null)
				kind.setValue("");
			if(place.getValue() == null)
				place.setValue("");
			NoteMyExpenditureController.detail = kind.getValue() + "," +place.getValue() + "----" + "$" + expenditure.getText();
			NoteMyExpenditureController.detailDetail = detailTextField.getText();
			Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
			
			System.out.println(NoteMyExpenditureController.detail);
			System.out.println(NoteMyExpenditureController.open);
			
			System.out.println(NoteExpenditureController.i);
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
			NoteExpenditureController.i++;
			if (kind.getValue() == null)
				kind.setValue("");
			if(place.getValue() == null)
				place.setValue("");
			NoteMyExpenditureController.detail = kind.getValue() + "," +place.getValue() + "----" + "$" + expenditure.getText();
			Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
			
			System.out.println(NoteMyExpenditureController.detail);
			System.out.println(NoteMyExpenditureController.open);
			
			System.out.println(NoteExpenditureController.i);
			
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
	
	public void delete() {
		switch (NoteExpenditureController.i) {
		case 0:
			File edit1 = new File(noteFile + "\\" + "1.txt");
			edit1.delete();
			break;
		case 1:
			File edit2 = new File(noteFile + "\\" + "2.txt");
			edit2.delete();
			break;
		case 2:
			File edit3 = new File(noteFile + "\\" + "3.txt");
			edit3.delete();
			break;
		case 3:
			File edit4 = new File(noteFile + "\\" + "4.txt");
			edit4.delete();
			break;
		case 4:
			File edit5 = new File(noteFile + "\\" + "5.txt");
			edit5.delete();
			break;
		case 5:
			File edit6 = new File(noteFile + "\\" + "6.txt");
			edit6.delete();
			break;
		case 6:
			File edit7 = new File(noteFile + "\\" + "7.txt");
			edit7.delete();
			break;
		case 7:
			File edit8 = new File(noteFile + "\\" + "8.txt");
			edit8.delete();
			break;
		default:
			break;
		}
		cancel();
	}
	
	static String readAppointedLineNumber(File sourceFile, int lineNumber) throws IOException {
		FileReader in = new FileReader(sourceFile);
		LineNumberReader reader = new LineNumberReader(in);
		String s = "";
		String returnString = "";
		
		int lines = 0;
		while (s != null) {
			lines++;
			s = reader.readLine();
			if((lines - lineNumber) >= 0) {
				returnString += s;
			}
			if ((lines - getTotalLines(sourceFile)) == 0) {
				break;
			}
		}
		reader.close();
		in.close();
		return returnString;
	}
	
	static int getTotalLines(File file) throws IOException {
		FileReader in = new FileReader(file);
		LineNumberReader reader = new LineNumberReader(in);
		String s = reader.readLine();
		int lines = 0;
		while (s != null) {
			lines++;
			s = reader.readLine();
		}
		reader.close();
		in.close();
		return lines;
	}
}
