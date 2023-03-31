package com.example.onscreenkeyboards;

import com.example.onscreenkeyboards.data.FeatureKeys;
import com.example.onscreenkeyboards.data.KeyboardKeys;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.lang3.StringUtils;
import org.fxmisc.richtext.Caret;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VKeyboardController {
    @FXML private TextArea displayScreen;
    @FXML private Label actionStatusLabel;
    @FXML private Circle indicator;
    @FXML private JFXButton capLockBtn, orangeThemeBtn;

    @FXML
    private JFXButton backtickBtn, oneBtn,twoBtn, threeBtn,
            fourBtn, fiveBtn, sixBtn,sevenBtn,
            eightBtn, nineBtn, zeroBtn, minusBtn, equalBtn,
            openBracketBtn, closeBracketBtn, backslashBtn,
            semiColonBtn, singleQuoteBtn, commaBtn, periodBtn,
            forwardSlashBtn;


    //fontawesome icons
    @FXML
    FontAwesomeIconView tildeIcon, exclamationIcon, atIcon, hashtagIcon,
            dollarIcon,percentIcon, upIcon, ampersandIcon, asteriskIcon,
            openbraceIcon, closebraceIcon, underscoreIcon,plusIcon,
            opencurlybraceIcon,closecurlybraceIcon, verticalBarIcon,
            colonIcon, doubleQuoteIcon, lessIcon, greaterIcon,
            questionMarkIcon;

    // boolean variable to initialize textArea.
    boolean start = true;

    KeyboardKeys kBoards = new KeyboardKeys();
    FeatureKeys featureKeys = new FeatureKeys();

    @FXML
    private JFXButton powerBtn,capsLockBtn;

    @FXML
    private JFXButton shiftDownBtn;



    //----- JFXButton Array--------------------------------
    @FXML
    public List<JFXButton> handleButtonKeys() {
      return  List.of(backtickBtn, oneBtn, twoBtn, threeBtn, fourBtn,
                fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn,
                minusBtn, equalBtn,openBracketBtn, closeBracketBtn,
                backslashBtn,semiColonBtn, singleQuoteBtn, commaBtn,
                periodBtn, forwardSlashBtn);
    }


     // Fontawesome icon List for visibility
    @FXML
    public List<FontAwesomeIconView> iconVisibility() {
        return List.of(tildeIcon, exclamationIcon, atIcon, hashtagIcon,
                dollarIcon, percentIcon, upIcon, ampersandIcon,
                asteriskIcon, openbraceIcon, closebraceIcon, underscoreIcon,
                plusIcon, opencurlybraceIcon, closecurlybraceIcon, verticalBarIcon,
                colonIcon, doubleQuoteIcon, lessIcon, greaterIcon, questionMarkIcon);
    }



     //fontawesome icon Map for accessing keys
    public Map<JFXButton, FontAwesomeIconView> searchIcons() {
        Map<JFXButton, FontAwesomeIconView> awesomeIcons = new HashMap<>();
        awesomeIcons.put(backtickBtn, tildeIcon);
        awesomeIcons.put(oneBtn, exclamationIcon);
        awesomeIcons.put(twoBtn, atIcon);
        awesomeIcons.put(threeBtn, hashtagIcon);
        awesomeIcons.put(fourBtn, dollarIcon);
        awesomeIcons.put(fiveBtn, percentIcon);
        awesomeIcons.put(sixBtn, upIcon);
        awesomeIcons.put(sevenBtn, ampersandIcon);
        awesomeIcons.put(eightBtn, asteriskIcon);
        awesomeIcons.put(nineBtn, openbraceIcon);
        awesomeIcons.put(zeroBtn, closebraceIcon);
        awesomeIcons.put(minusBtn, underscoreIcon);
        awesomeIcons.put(equalBtn, plusIcon);
        awesomeIcons.put(openBracketBtn, opencurlybraceIcon);
        awesomeIcons.put(closeBracketBtn, closecurlybraceIcon);
        awesomeIcons.put(backslashBtn, verticalBarIcon);
        awesomeIcons.put(semiColonBtn, colonIcon);
        awesomeIcons.put(singleQuoteBtn, doubleQuoteIcon);
        awesomeIcons.put(commaBtn, lessIcon);
        awesomeIcons.put(periodBtn, greaterIcon);
        awesomeIcons.put(forwardSlashBtn, questionMarkIcon);

        return awesomeIcons;

    }

    //------- Controller Methods----------------------------

    @FXML
    private void handleDisplayScreen(ActionEvent ae) {
        var source = ((JFXButton) ae.getSource()).getText();
        StringUtils.isBlank(displayScreen.getText());
        start = false;
        formatDisplay();
        CaretVisibility();
        displayScreen.setText(displayScreen.getText() + source.toLowerCase());
    }


    @FXML
    private void formatDisplay() {featureKeys.formatDisplayScreen(displayScreen);}


    @FXML
   private  void getIconTextToUpdateButtonText() {
        handleButtonKeys().forEach(button -> { //changes the button text to the icon text
            button.setText(searchIcons().get(button).getText());
        });
    }


    //template method to change icon text
    @FXML
    private void modifyIconText(List<String> tempList) {
        iconVisibility().forEach(icon -> {
                    icon.setText((tempList)
                            .listIterator(iconVisibility().indexOf(icon))
                            .next());
        });

    }
      /* functions to simulate keyboard  keycode  */
    @FXML
    private void handleDeleteAction() {featureKeys.deleteKey(displayScreen);}

    @FXML
    private void handleESCFunction() {
        displayScreen.clear();
        actionStatusLabel.setText(" ");
    }

    @FXML
    private void powerOffKeyboard() {
        actionStatusLabel.setText("Exiting Keyboard");
        Platform.exit();
    }

    @FXML void handleLaunchCalculator() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("calculator.fxml"));
        Parent calculatorRoot = (Parent) loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Tori's Calculator");
        stage.setScene(new Scene(calculatorRoot));
        stage.show();
    }

   /* @FXML // shows popup calculator when clicked
    private void launchCalculator(ActionEvent ae) throws IOException {
      Stage calculatorStage = new Stage();
      calculatorStage.setWidth(283);
      calculatorStage.setHeight(400);
      calculatorStage.setResizable(false);

      Parent calculatorRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("calculator.fxml")));
        calculatorStage.setTitle("Calculator");
        calculatorStage.initModality(Modality.WINDOW_MODAL);
        calculatorStage.initOwner(((Node) ae.getSource()).getScene().getWindow());
        calculatorStage.setScene(new Scene(calculatorRoot));
        calculatorStage.show();
    }
*/

    @FXML
    private void handleTabFunction() {displayScreen.appendText("\t");}

    @FXML
    private void handleEnterButton() {displayScreen.setText(displayScreen.getText() + "\r\n");}

    @FXML
    private  void handleCapsButton() {
       handleCircleIndicator();
       displayScreen.setText(StringUtils.upperCase(displayScreen.getText()));
       actionStatusLabel.setText("CAPS LOCK ON");
    }


    /*
    simulates pressing onscreen shift button
    hiding fontawesome icons and displaying shifted keys
    by iterating through button list, fontawesome list and shifted keys list
    */
    @FXML
    private void handleShiftButton(ActionEvent ae) {
        actionStatusLabel.setText("SHIFT ACTIVATED");
        getIconTextToUpdateButtonText();//sets button text based on fontawesome icons
        modifyIconText(kBoards.unshiftedKeysList()); //changes icon text to unsifted keys

     //---> capitalize letter
        var textLen = displayScreen.getText().length();
        var startPoint = textLen - 1;
        displayScreen.selectRange(startPoint, textLen);
        displayScreen.replaceSelection(StringUtils.capitalize(displayScreen.getSelectedText()));
    }

    //simulates the release of onscreen shift button
    //reactivates fontawesome icons and displays unsifted keys
    //by iterating through their respective lists
    @FXML
    private void handleUnshiftButton() {
        modifyIconText(kBoards.shiftedKeysList());
        handleButtonKeys().forEach(button -> {
            button.setText((kBoards.unshiftedKeysList()
                  .listIterator(handleButtonKeys().indexOf(button))
                  .next()));

        actionStatusLabel.setText("SHIFT RELEASED");

        });
    }


    @FXML
    public void handleSpacebar() {
    var startSpacing = displayScreen.getCaretPosition();
    displayScreen.insertText(startSpacing, " ");
    }


    @FXML
    public void handleCircleIndicator(){
     indicator.addEventHandler(ActionEvent.ACTION, event -> {
        if(capsLockBtn.isPressed())
            featureKeys.activateCircle(indicator);
        else
            featureKeys.deactivateCircle(indicator);
    });
    }

    private void CaretVisibility() {
        Caret.CaretVisibility caretVisibility = Caret.CaretVisibility.ON;
    }


    /* arrow buttonKeys */

    @FXML
    public void handleRightArrowButton() {featureKeys.rightArrow(displayScreen);}


    // selects a character each time user presses the left arrow key.
    @FXML
    private void handleLeftArrowButton() {featureKeys.leftArrow(displayScreen, actionStatusLabel);}


    //highlights previous word each time command button is pressed
    @FXML
    private void highlightText() {featureKeys.highlightTextKey(displayScreen, actionStatusLabel);}

    @FXML
    private void handleUpArrowButton() {featureKeys.upArrow(displayScreen);}

    @FXML
   private void handleDownArrowButton() {featureKeys.downArrow(displayScreen);}

    /* special features */

    @FXML
    private void reverseSelectedText() {featureKeys.reverseText(displayScreen, actionStatusLabel);}

    @FXML
    private void abbreviateText() {featureKeys.abbreviateText(displayScreen, actionStatusLabel);}


    //user must select text before pressing this button to simulate copy and insert
    @FXML
    private void handleCopyAndInsert() {featureKeys.copyAndInsertText(displayScreen, actionStatusLabel);}


}

