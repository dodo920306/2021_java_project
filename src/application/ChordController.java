package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ChordController implements Initializable{

	@FXML
	ImageView chordPicture;
	@FXML
	Label compose = new Label();
	Image picture;

	public void initialize(URL arg0, ResourceBundle arg1) {
		String require = ChordListController.chord + Chord.chord;
		picture = new Image(getClass().getResourceAsStream(ChordListController.chord + Chord.chord + ".jpg"));
		chordPicture.setImage(picture);
		switch (require){
			case "cmajor":
				compose.setText("C  E  G");
				break;
			case "cmajor7":
				compose.setText("C  E  G  B");
				break;
			case "cminor":
				compose.setText("C  Eb  G");
				break;
			case "cseven":
				compose.setText("C  E  G  Bb");
				break;
			case "cminor7":
				compose.setText("C  Eb  G  Bb");
				break;
			case "csus4":
				compose.setText("C  F  G");
				break;
			case "cadd9":
				compose.setText("C  E  G  D");
				break;
			case "dmajor":
				compose.setText("D  F#  A");
				break;
			case "dmajor7":
				compose.setText("D  F#  A  C#");
				break;
			case "dminor":
				compose.setText("D  F  A");
				break;
			case "dminor7":
				compose.setText("D  F  A  C");
				break;
			case "dseven":
				compose.setText("D  F#  A  C");
				break;
			case "dsus4":
				compose.setText("D  G  A");
				break;
			case "dadd9":
				compose.setText("D  F#  A  E");
				break;
			case "emajor":
				compose.setText("E  G#  B");
				break;
			case "emajor7":
				compose.setText("E  G#  B  D#");
				break;
			case "eminor":
				compose.setText("E  G  B");
				break;
			case "eminor7":
				compose.setText("E  G  B  D");
				break;
			case "eseven":
				compose.setText("E  G#  B  D");
				break;
			case "esus4":
				compose.setText("E  A  B");
				break;
			case "eadd9":
				compose.setText("E  G#  B  F#");
				break;
			case "fmajor":
				compose.setText("F  A  C");
				break;
			case "fmajor7":
				compose.setText("F  A  C  E");
				break;
			case "fminor":
				compose.setText("F  Ab  C");
				break;
			case "fminor7":
				compose.setText("F  Ab  C  Eb");
				break;
			case "fseven":
				compose.setText("F  A  C  Eb");
				break;
			case "fsus4":
				compose.setText("F  A#  C");
				break;
			case "fadd9":
				compose.setText("F  A  C  G");
				break;
			case "gmajor":
				compose.setText("G  B  D");
				break;
			case "gmajor7":
				compose.setText("G  B  D  F#");
				break;
			case "gminor":
				compose.setText("G  Bb  D");
				break;
			case "gminor7":
				compose.setText("G  Bb  D  F");
				break;
			case "gseven":
				compose.setText("G  B  D  F");
				break;
			case "gsus4":
				compose.setText("G  C  D");
				break;
			case "gadd9":
				compose.setText("G  B  D  A");
				break;
			case "amajor":
				compose.setText("A  C#  E");
				break;
			case "amajor7":
				compose.setText("A  C#  E  G#");
				break;
			case "aminor":
				compose.setText("A  C  E");
				break;
			case "aminor7":
				compose.setText("A  C  E  G");
				break;
			case "aseven":
				compose.setText("A  C#  E  G");
				break;
			case "asus4":
				compose.setText("A  D  E");
				break;
			case "aadd9":
				compose.setText("A  C#  E  B");
				break;
			case "bmajor":
				compose.setText("B  D#  F#");
				break;
			case "bmajor7":
				compose.setText("B  D#  F#  A#");
				break;
			case "bminor":
				compose.setText("B  D  F#");
				break;
			case "bminor7":
				compose.setText("B  D  F#  A");
				break;
			case "bseven":
				compose.setText("B  A  D#  F#");
				break;
			case "bsus4":
				compose.setText("B  E  F#");
				break;
			case "badd9":
				compose.setText("B  D#  F#  C#");
				break;
			default:
				break;
		}
		
	}
	
	public void back() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("Menu.fxml"));
		Stage stage = (Stage) chordPicture.getScene().getWindow();
		stage.setResizable(false);
		stage.setX(540);
		stage.setY(60);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void more() throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("ChordList.fxml"));
		Stage stage = (Stage) chordPicture.getScene().getWindow();
		stage.setX(430);
		stage.setY(150);
		stage.setResizable(false);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
