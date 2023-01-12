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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogController implements Initializable{

	@FXML
	TextField account, password;
	Button submit;
	
	MenuController acco = new MenuController();
	CreateNewAccountController cnac = new CreateNewAccountController();
	public static File accountFile;
	static String a;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		MenuController.getMp3();
		MenuController.openMp3();
	}
	
	public void accountRegister() throws IOException{
		Stage stage = (Stage) account.getScene().getWindow();
		String name = account.getText(); 
		a = name;
		accountFile = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name);
		//³Ð±b¸¹
		if (!accountFile.exists()  && !accountFile.isDirectory())      
		{
			Parent root = FXMLLoader.load(this.getClass().getResource("CreateNewAccount.fxml"));
			Scene scene = new Scene(root);
			cnac.accountName = name;
			cnac.password = this.password.getText();
			cnac.accountFile = accountFile;
			stage.setX(450);
			stage.setY(200);
			stage.setScene(scene);
			stage.show();
			//ÂÂ±b¸¹
		} else {
			File passwords = new File("C:\\Users\\dodo9\\eclipse-workspace\\sample\\src\\application\\accounts\\" + name + "\\passwords.txt");
			BufferedReader input = new BufferedReader(new FileReader(passwords));
			String pass = input.readLine();
			if (pass.equals(password.getText())) {
				try {
					Parent root = FXMLLoader.load(this.getClass().getResource("Menu.fxml"));
					Scene scene = new Scene(root);
					
					cnac.accountName = name;
					
					stage.setScene(scene);
					stage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
				//±K½X¿ù
			}else {
				try {
					Parent root = FXMLLoader.load(this.getClass().getResource("WrongPasswords.fxml"));
					Scene scene = new Scene(root);
					stage.setX(550);
					stage.setY(200);
					stage.setScene(scene);
					stage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			input.close();
		}
    }
}
