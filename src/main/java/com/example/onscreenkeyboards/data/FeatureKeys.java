package com.example.onscreenkeyboards.data;

import com.example.onscreenkeyboards.interfaces.Features;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Translate;
import org.apache.commons.lang3.StringUtils;

public class FeatureKeys implements Features {

	/* *******  formatting methods *******/
	@FXML
	public void formatDisplayScreen(TextArea tempScreen) {
		tempScreen.setCursor(Cursor.TEXT);
		tempScreen.setFont(Font.font("Roboto", FontWeight.LIGHT, 13));
		tempScreen.setStyle("-fx-text-fill: #152231");
		tempScreen.setWrapText(true);
	}

	@FXML void formatLabelText(Label tempLabel){
		tempLabel.setFont(Font.font("Roboto", FontWeight.EXTRA_LIGHT, 11.5));
		tempLabel.setStyle("-fx-text-fill: lemonchiffon");
	}


	/* edit features */
	@Override
	@FXML public void deleteKey(TextArea tempScreen) {tempScreen.setText(StringUtils.chop(tempScreen.getText()));}

	@Override
	public void backspaceKey(TextArea tempScreen) {
		Features.super.backspaceKey(tempScreen);
		tempScreen.deletePreviousChar();
	}

	/* *******  arrow keys methods *******/

	@FXML
	public void rightArrow(TextArea tempScreen) {
		var moveRight = tempScreen.getCaretPosition();
		tempScreen.extendSelection(moveRight++);

	}

	@FXML public void leftArrow(TextArea tempScreen, Label tempLabel){
		var moveLeft = tempScreen.getCaretPosition()-1;
		tempScreen.extendSelection(moveLeft--);
		tempLabel.setText("Left arrow pressed");



	}


	@FXML public void downArrow(TextArea tempScreen) {
		var move = tempScreen.getCaretPosition();
		Translate translate = new Translate();
		translate.setY(-0.1);
		tempScreen.selectPositionCaret((int) translate.getY());
	}


	@FXML public void upArrow(TextArea tempScreen) {
		var move = tempScreen.getCaretPosition();
		Translate translate = new Translate();
		translate.setY(0.1);
		tempScreen.selectPositionCaret((int) translate.getY());
	}

	/* *******  circle methods *******/

	@FXML public void activateCircle(Circle tempCircle) {tempCircle.setFill(Color.DODGERBLUE);}

	@FXML public void deactivateCircle(Circle tempCircle) {tempCircle.setFill(Color.GREY);}


	/* *******  special features methods *******/

	//---------------------testing variations---------------------------------------------
	public void reverseText(TextArea tempScreen, Label tempLabel) {
		var beginHere = tempScreen.getSelection().getStart();
		var endHere = tempScreen.getSelection().getEnd();
		var reverseResults = StringUtils.reverse(tempScreen.getSelectedText());
		tempScreen.replaceText(beginHere, endHere, reverseResults);
		tempLabel.setText("Reversing Text");
	}

	//---------------------testing variations---------------------------------------------
	@FXML public void abbreviateText(TextArea tempScreen, Label tempLabel){
	    var dots =StringUtils.repeat(".", 3);
		var selectIt = tempScreen.getSelectedText();
		var beginHere = tempScreen.getSelection().getStart();
		var endHere = tempScreen.getSelection().getEnd();
		var results = StringUtils.abbreviate(selectIt, dots,7);
		tempScreen.replaceText(beginHere, endHere,results);
		tempLabel.setText("Abbreviating Text");

	}



	@FXML public void copyAndInsertText(TextArea tempScreen, Label tempLabel){
		var cutText = tempScreen.getSelectedText();
		int insertText = tempScreen.getCaretPosition();
		tempScreen.appendText(" ");
		tempScreen.insertText(insertText, cutText);
		tempLabel.setText("Text copied and inserted");
	}

	@Override
	@FXML public void highlightTextKey(TextArea tempScreen, Label tempLabel){
		tempScreen.selectPreviousWord();
		tempScreen.setStyle("-fx-highlight-fill: steelblue; -fx-highlight-text-fill: crimson");
		tempLabel.setText("Highlighting text");
	}
}
