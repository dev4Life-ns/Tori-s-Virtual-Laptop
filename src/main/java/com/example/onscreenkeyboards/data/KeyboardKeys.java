package com.example.onscreenkeyboards.data;

import javafx.fxml.FXML;

import java.util.List;

public class KeyboardKeys {


 //----   Methods----------------------------------------------------------------

  @FXML
 public List<String> shiftedKeysList() {
   return List.of("~","!","@","#","$","%",
           "^","&","*","(",")","_","+","{","}","|",
           ":","''","<",">","?");
  }


 // arraylist stores none shifted keys
 public List<String> unshiftedKeysList() {
  return List.of("`", "1", "2", "3", "4", "5", "6", "7",
          "8", "9", "0", "-", "=", " [", " ]", "\\",";","'", ",",
          " .", " /");
 }

 }









