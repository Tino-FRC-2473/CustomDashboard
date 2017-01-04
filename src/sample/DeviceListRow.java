package sample;

import javafx.scene.layout.HBox;

/**
 * Created by sethideep23 on 1/3/17.
 */
public class DeviceListRow extends HBox {
    DeviceListItem name;
    DeviceListItem val;

    public DeviceListRow(String id, String name, String val) {
        style();
        setId(id);
        this.name = new DeviceListItem(name);
        this.val = new DeviceListItem(val);
        getChildren().addAll(this.name, this.val);
    }

    public void style() {
        setPrefHeight(40);
        setPrefWidth(176);
    }

    public void update(String name, String val) {
        this.name.setText(name);
        this.val.setText(val);
    }
}
