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
public class CommandLabel extends Label {
    public CommandLabel(String text) {
        style();
        setText(text);
    }

    public void style() {
        setFont(new Font("Menlo Regular", 13));
        setAlignment(Pos.CENTER);
        setTextFill(Color.web("#1dff2a"));
        setPadding(new Insets(5,10,5,10));
        setBackground(new Background(new BackgroundFill(Color.web("#323232"),null,null)));
        setPrefHeight(26);
        setPrefWidth(130);
    }
}
