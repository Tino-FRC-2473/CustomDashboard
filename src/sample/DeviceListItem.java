package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Created by sethideep23 on 1/3/17.
 */
public class DeviceListItem extends Label{
    public DeviceListItem(String str) {
        setText(str);
        style();
    }

    public void style() {
        setFont(new Font("Menlo Regular", 13));
        setAlignment(Pos.CENTER);
        setTextFill(Color.web("#1dff2a"));
        setPadding(new Insets(5,0,5,0));
        setPrefHeight(58);
        setPrefWidth(87);
    }
}
