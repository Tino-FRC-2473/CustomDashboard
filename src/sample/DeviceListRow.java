package sample;

import javafx.scene.layout.HBox;

public class DeviceListRow extends HBox {
    DeviceListItem name;
    DeviceListItem val;

    public DeviceListRow(String id, String name, String val) {
        style();
        setId(id);
        this.name = new DeviceListItem(name);
        this.name.setId("name");
        this.val = new DeviceListItem(val);
        this.val.setId("val");
        getChildren().addAll(this.name, this.val);
    }

    public void style() {
        setPrefHeight(40);
        setPrefWidth(176);
    }

    public void update(String name, String val) {
        getChildren().clear();
        this.name = new DeviceListItem(name);
        this.val = new DeviceListItem(val);
        getChildren().addAll(this.name, this.val);
    }
}