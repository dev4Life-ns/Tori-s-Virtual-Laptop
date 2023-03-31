package com.example.onscreenkeyboards.interfaces;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public interface Features {

	void deleteKey(TextArea tempScreen);


   //optional methods
   default void ACKey(){}
   default void backspaceKey(TextArea tempScreen){}
   default void highlightTextKey(TextArea tempScreen, Label tempLabel){}
   default void copyAndInsertText(TextArea tempScreen, Label tempLabel){}
   default void abbreviateText(TextArea tempScreen, Label tempLabel){}
   default void reverseText(TextArea tempScreen, Label tempLabel){}
   default void formatDisplayScreen(TextArea tempScreen){}

}
