module com.example.onscreenkeyboards {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires  jfxtras.common;
    requires  com.jfoenix;
    requires de.jensd.fx.glyphs.fontawesome;
    requires org.controlsfx.controls;
    requires org.apache.commons.lang3;
    requires com.google.common;
    requires org.fxmisc.richtext;
    requires commons.math3;


    exports com.example.onscreenkeyboards;
    opens com.example.onscreenkeyboards to javafx.fxml;
}