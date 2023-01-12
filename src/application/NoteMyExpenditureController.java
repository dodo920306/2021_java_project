package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NoteMyExpenditureController implements Initializable{

	static boolean open = false;
	static String detail = "", detailDetail = ""; 
	String [] budgetPerDayString;
	@FXML
	Label myLabel = new Label();
	@FXML
	Label myLabel1, myLabel11, myLabel111, myLabel112, myLabel113, myLabel114, myLabel115, budgetPerDay, youHaveSpent, left = new Label();
	@FXML
	Button myButton;
	@FXML
	private AnchorPane an = new AnchorPane();
	@FXML
	private DatePicker calendar = new DatePicker();
	CreateNewAccountController cnac = new CreateNewAccountController();
	String name = cnac.accountName;
	File bpd = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\budgetPerDay.txt");
	LocalDate d = LocalDate.now();
	static LocalDate note;
	static boolean changeDay = false;
	
	
	
	//Bug:應先選datepicker在寫入，將code全部轉為datepicker下
	//6/19更新：已解決
	public void initialize(URL arg0, ResourceBundle arg1){
		
		System.out.println("aaaadsdsdsdsdsdsdaaaa");
		
		//如果未變天，用今天
		if (!(changeDay)) 
			calendar.setValue(d);
		else
			calendar.setValue(note);
		
		//創檔
		int noteYear = calendar.getValue().getYear();
		int noteMonth = calendar.getValue().getMonthValue();
		int noteDay = calendar.getValue().getDayOfMonth();
		EditExpenditureController.noteYear = noteYear;
		EditExpenditureController.noteMonth = noteMonth;
		EditExpenditureController.noteDay = noteDay;
		System.out.println(noteDay);
		File noteFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\" + noteYear + "\\"
				+ noteMonth + "\\" + noteDay);
		
		if (!noteFile.exists()  && !noteFile.isDirectory()) {
			noteFile.mkdirs();
		}
		
		File expenditure1 = new File(noteFile + "\\" + "1.txt");
		File expenditure2 = new File(noteFile + "\\" + "2.txt");
		File expenditure3 = new File(noteFile + "\\" + "3.txt");
		File expenditure4 = new File(noteFile + "\\" + "4.txt");
		File expenditure5 = new File(noteFile + "\\" + "5.txt");
		File expenditure6 = new File(noteFile + "\\" + "6.txt");
		File expenditure7 = new File(noteFile + "\\" + "7.txt");
		File expenditure8 = new File(noteFile + "\\" + "8.txt");
		
		//複寫要出現在第幾項
		if (open) {
			switch (NoteExpenditureController.i) {
				case 1:
					myLabel.setText(detail);
					try {
						BufferedWriter output = new BufferedWriter(new FileWriter(expenditure1));
						if (!(expenditure1.exists()))
							expenditure1.createNewFile();
						output.write(detail + "\n");
						output.write(detailDetail);
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				case 2:
					myLabel1.setText(detail);
					try {
						BufferedWriter output = new BufferedWriter(new FileWriter(expenditure2));
						if (!(expenditure2.exists()))
							expenditure2.createNewFile();
						output.write(detail + "\n");
						output.write(detailDetail);
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;
				case 3:
					myLabel11.setText(detail);
					try {
						BufferedWriter output = new BufferedWriter(new FileWriter(expenditure3));
						if (!(expenditure3.exists()))
							expenditure3.createNewFile();
						output.write(detail + "\n");
						output.write(detailDetail);
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;
				case 4:
					myLabel111.setText(detail);
					try {
						BufferedWriter output = new BufferedWriter(new FileWriter(expenditure4));
						if (!(expenditure4.exists()))
							expenditure4.createNewFile();
						output.write(detail + "\n");
						output.write(detailDetail);
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;
				case 5:
					myLabel112.setText(detail);
					try {
						BufferedWriter output = new BufferedWriter(new FileWriter(expenditure5));
						if (!(expenditure5.exists()))
							expenditure5.createNewFile();
						output.write(detail + "\n");
						output.write(detailDetail);
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;
				case 6:
					myLabel113.setText(detail);
					try {
						BufferedWriter output = new BufferedWriter(new FileWriter(expenditure6));
						if (!(expenditure6.exists()))
							expenditure6.createNewFile();
						output.write(detail + "\n");
						output.write(detailDetail);
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;
				case 7:
					myLabel114.setText(detail);
					try {
						BufferedWriter output = new BufferedWriter(new FileWriter(expenditure7));
						if (!(expenditure7.exists()))
							expenditure7.createNewFile();
						output.write(detail + "\n");
						output.write(detailDetail);
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;
				case 8:
					myLabel115.setText(detail);
					try {
						BufferedWriter output = new BufferedWriter(new FileWriter(expenditure8));
						if (!(expenditure8.exists()))
							expenditure8.createNewFile();
						output.write(detail + "\n");
						output.write(detailDetail);
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					break;
				default:
					break;
			}
			
		}
		
		//讀入已寫入細項
		if (expenditure1.exists())
			inputValue(myLabel, expenditure1);
		if (expenditure2.exists())
			inputValue(myLabel1, expenditure2);
		if (expenditure3.exists())
			inputValue(myLabel11, expenditure3);
		if (expenditure4.exists())
			inputValue(myLabel111, expenditure4);
		if (expenditure5.exists())
			inputValue(myLabel112, expenditure5);
		if (expenditure6.exists())
			inputValue(myLabel113, expenditure6);
		if (expenditure7.exists())
			inputValue(myLabel114, expenditure7);
		if (expenditure8.exists())
			inputValue(myLabel115, expenditure8);
		
		if (expenditure1.exists()) {
			NoteExpenditureController.i = 1;
			if (expenditure2.exists()) {
				NoteExpenditureController.i = 2;
				if (expenditure3.exists()) {
					NoteExpenditureController.i = 3;
					if (expenditure4.exists()) {
						NoteExpenditureController.i = 4;
						if(expenditure5.exists()) {
							NoteExpenditureController.i = 5;
							if (expenditure6.exists()) {
								NoteExpenditureController.i = 6;
								if (expenditure7.exists()) {
									NoteExpenditureController.i = 7;
									if (expenditure8.exists()) {
										NoteExpenditureController.i = 8;
									}
								}
							}
						}
					}
				}
			}
		}else
			NoteExpenditureController.i = 0;
		
		//寫入每日預算
		BufferedReader input = null;
		boolean set = false;
		String budget = null;
		try {
			input = new BufferedReader(new FileReader(bpd));
			
			try {
				budget = input.readLine();
				input.close();
				budgetPerDayString = budget.split("\\$");
				budgetPerDay.setText(budget);
				set = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			budget = "You need to set your \nbudget first \nto get this part of analysis.";
			budgetPerDay.setText(budget);
			budgetPerDay.toFront();
		}
		open = false;
		if (set) {
			int total = 0;
			total += (amount(expenditure1) + amount(expenditure2) + amount(expenditure3) + amount(expenditure4) + amount(expenditure5) +
					amount(expenditure6) + amount(expenditure7) + amount(expenditure8));
			youHaveSpent.setText("");
			youHaveSpent.setText("$" + Integer.toString(total));
			
			left.setText("$" + Float.toString(Float.parseFloat(budgetPerDayString[1]) - total));
		}
		
	}
	
	//讀入該日花費細項
	public void inputValue(Label myLabel, File expenditure) {
		try {
			BufferedReader input = new BufferedReader(new FileReader(expenditure));
			myLabel.setText(input.readLine());
			input.close();
		} catch (FileNotFoundException e) {
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int amount(File expenditure) {
		try {
			BufferedReader input = new BufferedReader(new FileReader(expenditure));
			String [] k = input.readLine().split("----\\$");
			int i = Integer.parseInt(k[1]);
			input.close();
			
			return i;
		} catch (FileNotFoundException e) {
			
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	//
	public void handleDay(ActionEvent event) throws IOException {
		changeDay = true;
		note = calendar.getValue();
		System.out.println("ssasa");
		//再創檔
		int noteYear = calendar.getValue().getYear();
		int noteMonth = calendar.getValue().getMonthValue();
		int noteDay = calendar.getValue().getDayOfMonth();
		System.out.println(noteDay);
		File noteFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\" + noteYear + "\\"
				+ noteMonth + "\\" + noteDay);
		if (!noteFile.exists()  && !noteFile.isDirectory()) {
			noteFile.mkdirs();
		}
		File expenditure1 = new File(noteFile + "\\1.txt");
		File expenditure2 = new File(noteFile + "\\2.txt");
		File expenditure3 = new File(noteFile + "\\3.txt");
		File expenditure4 = new File(noteFile + "\\4.txt");
		File expenditure5 = new File(noteFile + "\\5.txt");
		File expenditure6 = new File(noteFile + "\\6.txt");
		File expenditure7 = new File(noteFile + "\\7.txt");
		File expenditure8 = new File(noteFile + "\\8.txt");
		
		if (expenditure1.exists()) {
			inputValue(myLabel, expenditure1);
		}
		else
			myLabel.setText("");
		if (expenditure2.exists())
			inputValue(myLabel1, expenditure2);
		else
			myLabel1.setText("");
		if (expenditure3.exists())
			inputValue(myLabel11, expenditure3);
		else
			myLabel11.setText("");
		if (expenditure4.exists())
			inputValue(myLabel111, expenditure4);
		else
			myLabel111.setText("");
		if (expenditure5.exists())
			inputValue(myLabel112, expenditure5);
		else
			myLabel112.setText("");
		if (expenditure6.exists())
			inputValue(myLabel113, expenditure6);
		else
			myLabel113.setText("");
		if (expenditure7.exists())
			inputValue(myLabel114, expenditure7);
		else
			myLabel114.setText("");
		if (expenditure8.exists())
			inputValue(myLabel115, expenditure8);
		else
			myLabel115.setText("");
		note = calendar.getValue();
		Parent root = FXMLLoader.load(this.getClass().getResource("NoteMyExpenditure.fxml"));
		Stage stage = (Stage) myButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void create() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("NoteExpenditure.fxml"));
		Stage stage = (Stage) myButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void returnMenu() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("FinancialManagement.fxml"));
		Stage stage = (Stage) myButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void edit() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("ChooseEdit.fxml"));
		Stage stage = (Stage) myButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void add() throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("KindManagement.fxml"));
		Stage stage = (Stage) myButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void delete() throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("DeleteKind.fxml"));
		Stage stage = (Stage) myButton.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
}
