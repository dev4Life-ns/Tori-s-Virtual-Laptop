package com.example.onscreenkeyboards.data;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorKeys {

	// method to handle basic keyboard calculations

	public void performKeyboardCalculations( long numericValue1, long numericValue2, String operation,
	                                        TextField display, Label viewLabel) {
		switch (operation) {
			case "+"-> {
				var add = Math.addExact((int)numericValue1, (int)numericValue2);
				display.setText(add + " ");
				viewLabel.setText(viewLabel.getText() + add);
			}
			case "-" -> {
				var subtract = Math.subtractExact((int)numericValue1, (int)numericValue2);
				display.setText(subtract + " ");
				viewLabel.setText(viewLabel.getText() + subtract);
			}
			case "*" -> {
				var multiply = Math.multiplyExact((int)numericValue1, (int)numericValue2);
				display.setText(multiply + " ");
				viewLabel.setText(viewLabel.getText() + multiply);
			}
			case "/" -> {
				var divide = numericValue1 /numericValue2;
			    display.setText(divide + " ");
				viewLabel.setText(viewLabel.getText() + divide);
			}
			case "%" -> {
				var percent = (numericValue1 / numericValue2)*100;
				display.setText(percent + " ");
				viewLabel.setText(viewLabel.getText() + percent);
			}
			default -> throw new IllegalArgumentException("Unexpected value: " + operation);
		}
	}

	//convert positive to negative and vice versa
	 public void plusMinusOperation(long numericValue, TextField display, Label viewLabel){
		var numeric = Long.parseLong(display.getText());
		var negateNumber = StrictMath.negateExact((int) numeric);
		display.setText(negateNumber+ "");
		viewLabel.setText(String.valueOf(negateNumber));
	}

}


