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
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BudgetController implements Initializable{
	@FXML
	public Label budgetPerDay;
	@FXML
	public Label toda;
	@FXML
	public Label spent, left;
	@FXML
	public TextField budgetPerMonth;
	static Date date = new Date();
	
	CreateNewAccountController cnac = new CreateNewAccountController();
	String name = cnac.accountName;
	File bpm = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\budgetPerMonth.txt");
	File bpd = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\\\application\\\\accounts\\" + name + "\\budgetPerDay.txt");
	LocalDate d = LocalDate.now();
	String[] dateArray = date.toString().split(" ");
	boolean number = true;
	int spend = 0, leave = 0;
	
	//6/20剩月預算和分析
	public void initialize(URL arg0, ResourceBundle arg1){
		toda.setText(date.toString());
		int noteYear = d.getYear();
		int noteMonth = d.getMonthValue();
		File noteFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\" + noteYear + "\\"
				+ noteMonth);
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(bpm));
		} catch (FileNotFoundException e) {
		}
		if (bpm.exists()) {
			String budget = null;
			try {
				budget = input.readLine();
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			budgetPerMonth.setText(budget);
			year(dateArray, budgetPerDay, budgetPerMonth);
		}
		if (!(noteFile.exists())) {
			spend = 0;
		}else {
			File transitionI;
			for (int i = 1; i < 32; i++) {
				String stringI = Integer.toString(i);
				transitionI = new File(noteFile + "\\" + stringI);
				if (transitionI.exists()) {
					File transitionJ;
					for (int j = 1; j < 9; j++) {
						String stringJ = Integer.toString(j);
						transitionJ =  new File(transitionI+ "\\" + stringJ + ".txt");
						if(transitionJ.exists()) {
							System.out.println(j);
							spend += NoteMyExpenditureController.amount(transitionJ);
						}
					}
				}
			}
		}
		spent.setText("$" + Integer.toString(spend));
		if (bpm.exists())
			left.setText("$" + Integer.toString(Integer.parseInt(budgetPerMonth.getText()) - spend));
	}

	public void submit() throws IOException{
		//判斷閏年與否取得每日預算
		year(dateArray, budgetPerDay, budgetPerMonth);
		if (number) {
			
			//紀錄至帳號
			if (!(bpd.exists())) {
				bpd.createNewFile();
			}
			if (!(bpm.exists())) {
				bpm.createNewFile();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(bpm));
			output.write(budgetPerMonth.getText());
			output.close();
			BufferedWriter output2 = new BufferedWriter(new FileWriter(bpd));
			output2.write(budgetPerDay.getText());
			output2.close();
			//budgetPerDay.setText(budgetPerDay.getText());
		}
		
		Parent root = FXMLLoader.load(this.getClass().getResource("BudgetSetting.fxml"));
		Stage stage = (Stage) budgetPerDay.getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("budgetSetCss.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void returnToMenu() throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("FinancialManagement.fxml"));
		Stage stage = (Stage) toda.getScene().getWindow();
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
	
	public void year(String[] dateArray, Label budgetPerDay, TextField budgetPerMonth) {
		try {
			if (dateArray[1].equals("Jan") || dateArray[1].equals("Mar") || dateArray[1].equals("May") || dateArray[1].equals("Jul")
					|| dateArray[1].equals("Aug") || dateArray[1].equals("Oct") || dateArray[1].equals("Dec")) {
				//四捨五入至小數第一位
				budgetPerDay.setText(Double.toString((Math.round(Float.valueOf(budgetPerMonth.getText()).floatValue() / 31) * 10.0) / 10.0));
			}else if (dateArray[1].equals("Fed")) {
				int year = Integer.valueOf(dateArray[5]);
				if (year % 4 == 0) {
					if (year % 100 == 0) {
						if (year % 400 == 0) {
							budgetPerDay.setText(Double.toString((Math.round(Float.valueOf(budgetPerMonth.getText()).floatValue() / 29) * 10.0) / 10.0));
						}else {
							budgetPerDay.setText(Double.toString((Math.round(Float.valueOf(budgetPerMonth.getText()).floatValue() / 28) * 10.0) / 10.0));
						}
					}else {
						budgetPerDay.setText(Double.toString((Math.round(Float.valueOf(budgetPerMonth.getText()).floatValue() / 29) * 10.0) / 10.0));
					}
				}else {
					budgetPerDay.setText(Double.toString((Math.round(Float.valueOf(budgetPerMonth.getText()).floatValue() / 28) * 10.0) / 10.0));
				}
			}else {
				budgetPerDay.setText("$" + Double.toString((Math.round(Float.valueOf(budgetPerMonth.getText()).floatValue() / 30) * 10.0) / 10.0));
			}
			
		}catch (NumberFormatException e) {
			budgetPerDay.setText("Enter only \nnumber please.");
			number = false;
		}
	}
	
	public void clear() throws IOException {
		if (bpm.exists())
			bpm.delete();
		if (bpd.exists())
			bpd.delete();
		Parent root = FXMLLoader.load(this.getClass().getResource("BudgetSetting.fxml"));
		Stage stage = (Stage) budgetPerDay.getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("budgetSetCss.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
}
