package application;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class AnalysisController implements Initializable{

	@FXML
	private LineChart<?, ?> lineChart;
	@FXML
	private PieChart pieChart;
	LocalDate d = LocalDate.now();
	int noteYear = d.getYear();
	String notedMonthString = "";
	@FXML
	private ChoiceBox<String> chooseMonth;
	
	public void initialize(URL arg0, ResourceBundle arg1){
		File year = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + CreateNewAccountController.accountName +
				"\\" + noteYear);
		File month;
		for (int i = 1; i < 13; i++) {
			String stringI = Integer.toString(i);
			month = new File(year + "\\" + stringI);
			if (month.exists()) {
				notedMonthString += Integer.toString(noteYear)+ "/" + stringI + ",";
			}
		}
		chooseMonth.getItems().addAll(notedMonthString.split(","));
	}
	
	
	public void iniLineChart(ActionEvent event) throws IOException {
		XYChart.Series series = new XYChart.Series<>();
		String choosedMonth = chooseMonth.getValue().split("/")[1];
		
		File month = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + CreateNewAccountController.accountName +
				"\\" + noteYear + "\\" + choosedMonth);
		File day;
		int total = 0;
		Parent root = FXMLLoader.load(this.getClass().getResource("NoteExpenditure.fxml"));
		int[] kindNumber = new int[NoteExpenditureController.kindString.length];
		String kind = "";
		String inputString;
		int nullKind = 0;
		
		for (int i = 0; i < kindNumber.length; i++) {
			kindNumber[i] = 0;
		}		
		
		for (int i = 1; i < 32; i++) {
			String stringI = Integer.toString(i);
			day = new File(month + "\\" + stringI);
			if (day.exists()) {
				System.out.println(stringI);
				File label;
				for (int j = 1; j < 9; j++) {
					label = new File(day + "\\" + Integer.toString(j) + ".txt");
					if (label.exists()) {
						BufferedReader input = new BufferedReader(new FileReader(label));
						inputString = input.readLine();
						total += Integer.parseInt(inputString.split("----\\$")[1]);
						System.out.println(inputString);
						if (!(inputString.split("----\\$")[0].split("")[0].equals(","))){
							
							kind = inputString.split("----\\$")[0].split(",")[0];
							System.out.println(kind);
							for (int k = 0; k < kindNumber.length; k++) {
								if (kind.equals(NoteExpenditureController.kindString[k])) {
									kindNumber[k] += Integer.parseInt(inputString.split("----\\$")[1]);
									System.out.println(kindNumber[k]);
									break;
								}
							}
						}else {
							nullKind += Integer.parseInt(inputString.split("----\\$")[1]);
						}
						input.close();
					}
				}
			}
			series.getData().add(new XYChart.Data<>((choosedMonth + "/" + stringI), total));
			total = 0;
		}
		lineChart.getData().addAll(series);
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		for (int i = 0; i < kindNumber.length; i++) {
			pieChartData.addAll(
				new PieChart.Data(NoteExpenditureController.kindString[i], kindNumber[i])
			);
			
		}
		
		pieChartData.addAll(new PieChart.Data("others", nullKind));
		pieChart.setData(pieChartData);
	}
	
	public void returnToMenu() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("FinancialManagement.fxml"));
		Stage stage = (Stage) lineChart.getScene().getWindow();
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
	}
}
