package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CalculatorController {

	@FXML
	private Button ac, ce, one, two, three, four, five, six, seven, eight, nine, zero, dot, equal, add, miuns, multi, 
		divide, backspace, e, π, turn, radButton, leftBracket, rightBracket, si, co, ta, upsidedown;
	@FXML
	private Label answer, entry, deg, arc;
	private String enter = "";
	int leftNumber = 0, rightNumber = 0;
	public void k1() {
		enter+="1";
		entry.setText(enter);
	}
	
	public void k2() {
		enter+="2";
		entry.setText(enter);
	}
	
	public void k3() {
		enter+="3";
		entry.setText(enter);
	}
	
	public void k4() {
		enter+="4";
		entry.setText(enter);
	}
	
	public void k5() {
		enter+="5";
		entry.setText(enter);
	}
	
	public void k6() {
		enter+="6";
		entry.setText(enter);
	}
	
	public void k7() {
		enter+="7";
		entry.setText(enter);
	}
	
	public void k8() {
		enter+="8";
		entry.setText(enter);
	}
	
	public void k9() {
		enter+="9";
		entry.setText(enter);
	}
	
	public void k0() {
		enter+="0";
		entry.setText(enter);
	}
	
	public void kDot() {
		enter+=".";
		entry.setText(enter);
	}
	
	public void kCe() {
		String [] arrEntry = enter.split("");
		String arrCalculator = "";
		String theLastElement = arrEntry[arrEntry.length-1];
		if (theLastElement.equals("+") || theLastElement.equals("-") || theLastElement.equals("*") || theLastElement.equals("/")) {
			;
		} else {
			enter = "";
			for (int i = 0; i < arrEntry.length; i++) {
				if (arrEntry[i].equals("+") || arrEntry[i].equals("-") || arrEntry[i].equals("*") || arrEntry[i].equals("/")) {
					arrCalculator += ("," + arrEntry[i] + ",");
				}else {
					arrCalculator += arrEntry[i];
				}
			}
			String [] calculator = arrCalculator.split(",");
			calculator[calculator.length-1] = "";
			for (int i = 0; i < (calculator.length-1); i++) {
				enter += calculator[i];
			}
		}
		entry.setText(enter);
	}
	
	public void kAdd() {
		enter += "+";
		entry.setText(enter);
	}
	public void kMinus() {
		enter += "-";
		entry.setText(enter);
	}
	
	public void kMulti() {
		enter += "*";
		entry.setText(enter);
	}
	
	public void kDivide() {
		enter += "/";
		entry.setText(enter);
	}
	
	public void kBackspace() {
		String [] arrEntry = enter.split("");
		enter="";
		for(int i = 0; i < (arrEntry.length-1); i++) {
			enter += arrEntry[i];
		}
		entry.setText(enter);
	}
	public void kEqual() {
		answer.setText(equ(enter));
	}
	
	public void kAc() {
		enter = "";
		entry.setText(enter);
		answer.setText(enter);
	}
	
	public void e() {
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		if (arrEntry[lastElement].equals("1") || arrEntry[lastElement].equals("2") || arrEntry[lastElement].equals("3") || arrEntry[lastElement].equals("4")
				|| arrEntry[lastElement].equals("5") || arrEntry[lastElement].equals("6") || arrEntry[lastElement].equals("7")
				|| arrEntry[lastElement].equals("8") || arrEntry[lastElement].equals("9") || arrEntry[lastElement].equals("0")){
			enter += "*";
		}
		enter += "e";
		entry.setText(enter);
	}
	
	public void π() {
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		if (arrEntry[lastElement].equals("1") || arrEntry[lastElement].equals("2") || arrEntry[lastElement].equals("3") || arrEntry[lastElement].equals("4")
				|| arrEntry[lastElement].equals("5") || arrEntry[lastElement].equals("6") || arrEntry[lastElement].equals("7")
				|| arrEntry[lastElement].equals("8") || arrEntry[lastElement].equals("9") || arrEntry[lastElement].equals("0")){
			enter += "*";
		}
		enter += "π";
		entry.setText(enter);
	}
	
	public void turn() throws IOException{
		Parent root = FXMLLoader.load(this.getClass().getResource("Menu.fxml"));
		Stage stage = (Stage) turn.getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void rad() {
		if (deg.getText().equals("Deg")) {
			deg.setText("Rad");
			radButton.setText("Deg");
		} else {
			deg.setText("Deg");
			radButton.setText("Rad");
		}
	}
	
	//sin
	public void si() {
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		//自動補上*
		if ((!(arrEntry[lastElement].equals("+") || arrEntry[lastElement].equals("-") || arrEntry[lastElement].equals("*") || arrEntry[lastElement].equals("/")
				|| arrEntry[lastElement].equals("("))) && arrEntry[0] != "") {
			enter += "*";
		}
		if (arc.getText().equals("arc"))
			enter+="arcsin(";
		else
			enter += "sin(";
		entry.setText(enter);
	}
	
	public void co() {
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		if ((!(arrEntry[lastElement].equals("+") || arrEntry[lastElement].equals("-") || arrEntry[lastElement].equals("*") || arrEntry[lastElement].equals("/")
				|| arrEntry[lastElement].equals("("))) && arrEntry[0] != "") {
			enter += "*";
		}
		if (arc.getText().equals("arc"))
			enter+="arccos(";
		else
			enter += "cos(";
		entry.setText(enter);
	}
	
	public void ta() {
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		if ((!(arrEntry[lastElement].equals("+") || arrEntry[lastElement].equals("-") || arrEntry[lastElement].equals("*") || arrEntry[lastElement].equals("/")
				|| arrEntry[lastElement].equals("("))) && arrEntry[0] != "") {
			enter += "*";
		}
		if (arc.getText().equals("arc"))
			enter+="arctan(";
		else
			enter += "tan(";
		entry.setText(enter);
	}
	
	public void left() {
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		if (arrEntry[lastElement].equals("1") || arrEntry[lastElement].equals("2") || arrEntry[lastElement].equals("3") || arrEntry[lastElement].equals("4")
				|| arrEntry[lastElement].equals("5") || arrEntry[lastElement].equals("6") || arrEntry[lastElement].equals("7")
				|| arrEntry[lastElement].equals("8") || arrEntry[lastElement].equals("9") || arrEntry[lastElement].equals("0")
				|| arrEntry[lastElement].equals("e") || arrEntry[lastElement].equals("π")){
			enter += "*";
		}
		enter += "(";
		entry.setText(enter);
	}
	
	public void right() {
		String [] arrEntry = enter.split("");
		for (int i = 0; i < arrEntry.length; i++) {
			if (arrEntry[i].equals("("))
				leftNumber++;
			else if (arrEntry[i].equals(")"))
				rightNumber++;
		}
		if (leftNumber > rightNumber)
			enter += ")";
		entry.setText(enter);
	}
	
	public void deSpuare(){
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		if ((!(arrEntry[lastElement].equals("+") || arrEntry[lastElement].equals("-") || arrEntry[lastElement].equals("*") || arrEntry[lastElement].equals("/")
				|| arrEntry[lastElement].equals("("))) && arrEntry[0] != "") {
			enter += "*";
		}
		enter += "√(";
		entry.setText(enter);
	}
	
	//連積
	public void level() {
		enter += "!";
		entry.setText(enter);
	}
	
	//次方
	public void power() {
		enter += "^(";
		entry.setText(enter);
	}
	
	//絕對值
	public void absolutelyWorthIt() {
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		if ((!(arrEntry[lastElement].equals("+") || arrEntry[lastElement].equals("-") || arrEntry[lastElement].equals("*") || arrEntry[lastElement].equals("/")
				|| arrEntry[lastElement].equals("("))) && arrEntry[0] != "") {
			enter += "*";
		}
		enter += "abs(";
		entry.setText(enter);
	}
	
	//對數
	public void ln() {
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		if ((!(arrEntry[lastElement].equals("+") || arrEntry[lastElement].equals("-") || arrEntry[lastElement].equals("*") || arrEntry[lastElement].equals("/")
				|| arrEntry[lastElement].equals("("))) && arrEntry[0] != "") {
			enter += "*";
		}
		enter += "ln(";
		entry.setText(enter);
	}
	
	//洛哥
	public void brotherLow() {
		String [] arrEntry = enter.split("");
		int lastElement = arrEntry.length-1;
		if ((!(arrEntry[lastElement].equals("+") || arrEntry[lastElement].equals("-") || arrEntry[lastElement].equals("*") || arrEntry[lastElement].equals("/")
				|| arrEntry[lastElement].equals("("))) && arrEntry[0] != "") {
			enter += "*";
		}
		enter += "log(";
		entry.setText(enter);
	}
	
	//反函數
	public void pa() {
		if (arc.getText().equals("arc")) {
			arc.setText("");
		}else {
			arc.setText("arc");
		}
	}
	
	//運算
	public String equ(String enter) {
		try {
			String [] arrEntry = enter.split("");
			String arrCalculator = "";
			int leftLocation = 0, rightLocation = 0;
			String backetContent = "";
			
			//括號數量處理
			leftNumber = 0;
			rightNumber = 0;
			for (int i = 0; i < arrEntry.length; i++) {
				if (arrEntry[i].equals("("))
					leftNumber++;
				else if (arrEntry[i].equals(")"))
					rightNumber++;
			}
			if (leftNumber != rightNumber)
				return "Error.";
			
			//分離數字與符號
			for (int i = 0; i < arrEntry.length; i++) {
				if (arrEntry[i].equals("+") || arrEntry[i].equals("-") || arrEntry[i].equals("*") || arrEntry[i].equals("/")
						|| arrEntry[i].equals("(") || arrEntry[i].equals(")") || arrEntry[i].equals("!") || arrEntry[i].equals("^")) {
					//負號合併數字
					if ((arrEntry[i].equals("-")) && ((i > 0 && (!(arrEntry[i-1].equals("1") || arrEntry[i-1].equals("2") || arrEntry[i-1].equals("3") 
								|| arrEntry[i-1].equals("4") || arrEntry[i-1].equals("5") || arrEntry[i-1].equals("6") || arrEntry[i-1].equals("7") 
								|| arrEntry[i-1].equals("8") || arrEntry[i-1].equals("9") || arrEntry[i-1].equals("0")))) || i==0)) {
						arrCalculator += arrEntry[i];
					}else {
						if ((i == (arrEntry.length-1)) ||  arrEntry[i].equals("!") || arrEntry[i].equals("^") || arrEntry[i+1].equals("(") || arrEntry[i+1].equals(")"))
							arrCalculator += ("," + arrEntry[i]);
						else if (i == 0)
							arrCalculator += (arrEntry[i] + ",");
						else
							arrCalculator += ("," + arrEntry[i] + ",");
					}
				}else {
					arrCalculator += arrEntry[i];
				}
			}
			System.out.println(arrCalculator);
			String [] calculator = arrCalculator.split(",");
			
			
			//符號處理
			for (int i = 0; i < (calculator.length); i++) {
				if (calculator[i].equals("e")) {
					calculator[i] = "2.7183";
				} else if (calculator[i].equals("π")) {
					calculator[i] = "3.1416";
				} else if (calculator[i].equals("(")) {				//括號
					leftLocation = i;
					for (int j = (i+1), count = 0; j < (calculator.length); j++) {
						
						if (calculator[j].equals("(")) {
							count++;
						}else if (calculator[j].equals(")")) {
							if (count == 0) {
								rightLocation = j;
								break;
							}else {
								count--;
							}
						}
					}
					for (int k = (++leftLocation); k < rightLocation; k++) {
						backetContent += calculator[k];
					}
					
					//sin值
					if (leftLocation>=2) {
						if (calculator[leftLocation-2].equals("sin")) {
							if (deg.getText().equals("Deg")) {
								calculator[leftLocation-2] = Double.toString(Math.sin(Math.toRadians(Float.valueOf(equ(backetContent)).floatValue())));
							} else {
								calculator[leftLocation-2] = Double.toString(Math.sin(Float.valueOf(equ(backetContent)).floatValue()));
							}
							for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
								calculator[j] = "";
							}
							//cos值
						} else if (calculator[leftLocation-2].equals("cos")){
							if (deg.getText().equals("Deg")) {
								calculator[leftLocation-2] = Double.toString(Math.cos(Math.toRadians(Float.valueOf(equ(backetContent)).floatValue())));
							} else {
								calculator[leftLocation-2] = Double.toString(Math.cos(Float.valueOf(equ(backetContent)).floatValue()));
							}
							for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
								calculator[j] = "";
							}
							//tan
						} else if (calculator[leftLocation-2].equals("tan")) {
							if (deg.getText().equals("Deg")) {
								calculator[leftLocation-2] = Double.toString(Math.tan(Math.toRadians(Float.valueOf(equ(backetContent)).floatValue())));
							} else {
								calculator[leftLocation-2] = Double.toString(Math.tan(Float.valueOf(equ(backetContent)).floatValue()));
							}
							for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
								calculator[j] = "";
							}
							//根號
						} else if (calculator[leftLocation-2].equals("√")) {
							if (Float.valueOf(equ(backetContent)).floatValue() < 0)
								return "Error.";
							else {
								calculator[leftLocation-2] = Double.toString(Math.sqrt(Float.valueOf(equ(backetContent)).floatValue()));
								for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
									calculator[j] = "";
								}
							}
							//絕對值
						} else if (calculator[leftLocation-2].equals("abs")) {
							if (Float.valueOf(equ(backetContent)).floatValue() < 0)
								calculator[leftLocation-2] = Double.toString(Float.valueOf(equ(backetContent)).floatValue()*(-1));
							else {
								calculator[leftLocation-2] = Double.toString(Float.valueOf(equ(backetContent)).floatValue());
							}
							for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
								calculator[j] = "";
							}
							//對數
						} else if (calculator[leftLocation-2].equals("ln")){
							if (Float.valueOf(equ(backetContent)).floatValue() <= 0)
								return "Error.";
							else {
								calculator[leftLocation-2] = Double.toString(Math.log(Float.valueOf(equ(backetContent)).floatValue()));
								for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
									calculator[j] = "";
								}
							}
							//洛哥
						} else if (calculator[leftLocation-2].equals("log")) {
							if (Float.valueOf(equ(backetContent)).floatValue() <= 0)
								return "Error.";
							else {
								calculator[leftLocation-2] = Double.toString(Logarithm.loga(Double.valueOf(equ(backetContent)).doubleValue(), 10));
								for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
									calculator[j] = "";
								}
							}
							//arcsin
						} else if(calculator[leftLocation-2].equals("arcsin")) {
							if (deg.getText().equals("Deg")) {
								calculator[leftLocation-2] = Double.toString(Math.toDegrees(Math.asin(Math.toRadians(Float.valueOf(equ(backetContent)).floatValue()))));
							} else {
								calculator[leftLocation-2] = Double.toString(Math.asin(Float.valueOf(equ(backetContent)).floatValue()));
							}
							for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
								calculator[j] = "";
							}
						}else if (calculator[leftLocation-2].equals("arccos")){
							if (deg.getText().equals("Deg")) {
								calculator[leftLocation-2] = Double.toString(Math.toDegrees(Math.acos(Math.toRadians(Float.valueOf(equ(backetContent)).floatValue()))));
							} else {
								calculator[leftLocation-2] = Double.toString(Math.acos(Float.valueOf(equ(backetContent)).floatValue()));
							}
							for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
								calculator[j] = "";
							}
						}else if (calculator[leftLocation-2].equals("arctan")) {
							if (deg.getText().equals("Deg")) {
								calculator[leftLocation-2] = Double.toString(Math.toDegrees(Math.atan(Math.toRadians(Float.valueOf(equ(backetContent)).floatValue()))));
							} else {
								calculator[leftLocation-2] = Double.toString(Math.atan(Float.valueOf(equ(backetContent)).floatValue()));
							}
							for (int j = (leftLocation-1); j < (rightLocation+1); j++) {
								calculator[j] = "";
							}
						} else {
							calculator[leftLocation-1] = equ(backetContent);
							for (int j = leftLocation; j < (rightLocation+1); j++) {
								calculator[j] = "";
							}
						}
					} else {
						calculator[leftLocation-1] = equ(backetContent);
						for (int j = leftLocation; j < (rightLocation+1); j++) {
							calculator[j] = "";
						}
					}
					for (int j = 0; j < calculator.length; j++) {
						System.out.println(calculator[j]);
					}
					//連積號
				} else if (calculator[i].equals("!")) {
					int levelNumber = 1;
					if (Integer.valueOf(calculator[i-1]) == 0)
						levelNumber = 0;
					else {
						for (int j = 2; j <= Integer.valueOf(calculator[i-1]); j++) {
							levelNumber *= j;
						}
					}
					calculator[i-1] = Integer.toString(levelNumber);
					calculator[i] = "";
					//反函數
				} else if (calculator[i].equals("%")){
					calculator[i-1] = Float.toString(Float.valueOf(calculator[i-1]).floatValue() / 100);
					calculator[i]="";
				}
				backetContent = "";
			}
			
			//重整數列
			String answer3 = "";
			for (int j = 0; j < calculator.length; j++) {
				if (!(calculator[j].equals(""))) {
					answer3 += (calculator[j] + ",");
				}
			}
			calculator = answer3.split(",");
			
			//先乘除
			for (int i = 1; i < (calculator.length-1); i+=2) {
				if (calculator[i].equals("*")) {
					calculator[i+1] = Float.toString(Float.valueOf(calculator[i-1]).floatValue()*Float.valueOf(calculator[i+1]).floatValue());
					calculator[i]="";
					calculator[i-1]="";
				}else if (calculator[i].equals("/")) {
					if (calculator[i+1].equals("0"))
						return "Error.";
					else {
						calculator[i+1] = Float.toString(Float.valueOf(calculator[i-1]).floatValue()/Float.valueOf(calculator[i+1]).floatValue());
						calculator[i]="";
						calculator[i-1]="";
					}
				}else if (calculator[i].equals("^")) {
					calculator[i+1] = Double.toString(Math.pow(Float.valueOf(calculator[i-1]).floatValue(), Float.valueOf(calculator[i+1]).floatValue()));
					calculator[i]="";
					calculator[i-1]="";
				}
			}
			
			//重整數列
			String answer1="";
			for (int i = 0; i < calculator.length; i++) {
				if (calculator[i].equals("")) {
					continue;
				}else if (calculator[i].equals("+") || calculator[i].equals("-")){
					answer1 += (","+calculator[i]+",");
				}else {
					answer1 += calculator[i];
				}
			}
			
			//後加減
			String [] answer2 = answer1.split(",");
			for (int i = 1; i < (answer2.length-1); i+=2) {
				if (answer2[i].equals("+")) {
					answer2[i+1] = Float.toString(Float.valueOf(answer2[i-1]).floatValue()+Float.valueOf(answer2[i+1]).floatValue());
					answer2[i]="";
					answer2[i-1]="";
				}else if (answer2[i].equals("-")) {
					answer2[i+1] = Float.toString(Float.valueOf(answer2[i-1]).floatValue()-Float.valueOf(answer2[i+1]).floatValue());
					answer2[i]="";
					answer2[i-1]="";
				}
			}
			//四捨五入至小數第一位
			String ans = Double.toString(Math.round(Float.valueOf(answer2[answer2.length-1]).floatValue() * 10.0) / 10.0);
			return ans;
		}
		catch (Exception e) {
			return "Error.";
		}
	}
	
	public void one(ActionEvent event) {
		k1();
	}
	
	public void two(ActionEvent event) {
		k2();
	}
	
	public void three(ActionEvent event) {
		k3();
	}
	
	public void four(ActionEvent event) {
		k4();
	}
	
	public void five(ActionEvent event) {
		k5();
	}
	
	public void six(ActionEvent event) {
		k6();
	}
	
	public void seven(ActionEvent event) {
		k7();
	}
	
	public void eight(ActionEvent event) {
		k8();
	}
	
	public void nine(ActionEvent event) {
		k9();
	}
	
	public void zero(ActionEvent event) {
		k0();
	}
	
	public void dot(ActionEvent event) {
		kDot();
	}
	
	public void ce(ActionEvent event) {
		kCe();
	}
	
	public void add(ActionEvent event) {
		kAdd();
	}
	
	public void minus(ActionEvent event) {
		kMinus();
	}
	
	public void mutli(ActionEvent event) {
		kMulti();
	}
	
	public void divide(ActionEvent event) {
		kDivide();
	}
	
	public void backspace(ActionEvent event) {
		kBackspace();
	}
	
	public void equal(ActionEvent event) {
		kEqual();
	}
	
	public void ac(ActionEvent event) {
		kAc();
	}
}
