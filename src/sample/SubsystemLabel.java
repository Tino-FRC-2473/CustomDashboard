package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Created by sethideep23 on 1/4/17.
 */
public class SubsystemLabel extends Label {
    public SubsystemLabel(String text) {
        style();
        setText(text);
    }

    public void style() {
        setFont(new Font("Menlo Regular", 13));
        setAlignment(Pos.CENTER_RIGHT);
        setTextFill(Color.web("#1dff2a"));
        setPadding(new Insets(5,0,5,0));
        setPrefHeight(26);
        setPrefWidth(171);
    }
}
