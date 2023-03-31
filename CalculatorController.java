package com.example.onscreenkeyboards;

import com.example.onscreenkeyboards.data.CalculatorKeys;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;

public class CalculatorController extends Thread{

	@FXML private TextField calcDisplay;
	@FXML private Label viewLabel;

	// variables
	long numericValue1 = 0;
	long numericValue2 = 0;
	String keyValue = "";

	CalculatorKeys calculatorKeys = new CalculatorKeys();

	/* -----------------  CLASS METHODS -------------------*/

	//uses action event to grab button text

	@FXML
	private String buttonText(ActionEvent ae) {
		return ((JFXButton) ae.getSource()).getText();
	}


	//display numbers to screen with a max of 11 digits
	@FXML
	private void handleCalculatorDisplay(ActionEvent ae) {
		boolean start = true;
		StringUtils.isEmpty(calcDisplay.getText());
		start = false;

		calcDisplay.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() > 11) {
				calcDisplay.setText("11 digits max");
			}
		});
		calcDisplay.setText(calcDisplay.getText() + buttonText(ae));
		viewLabel.setText(viewLabel.getText() + buttonText(ae));
	}


	//clear display screen and viewlabel
	@FXML
   private void handleACButton() {
		calcDisplay.setText("");
		viewLabel.setText("");
	}


	// method to handle basic calculations
	@FXML
   private void handleCalculationButton(ActionEvent ae) {
		var operation = buttonText(ae);
		if (!operation.equals("=")) {
			if (!keyValue.equals("")) {
				return;
			}

			keyValue = operation;
			numericValue1 = Long.parseLong(calcDisplay.getText());
			calcDisplay.setText("");
			viewLabel.setText(viewLabel.getText() + operation);

		} else {
			if (keyValue.equals("")) {
				return;
			}

			numericValue2 = Long.parseLong(calcDisplay.getText());
			viewLabel.setText(viewLabel.getText() + "=");
			calcDisplay.setText("");
			calculatorKeys.performKeyboardCalculations( numericValue1, numericValue2, keyValue, calcDisplay,viewLabel);
			keyValue = " ";
		}
	}

	//controller method that converts positive to negative and vice versa
	@FXML
	private void handlePlusMinus() {
		calculatorKeys.plusMinusOperation((long) numericValue1, calcDisplay, viewLabel);
	}




	}








