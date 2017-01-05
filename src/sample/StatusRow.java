package sample;

import javafx.scene.layout.HBox;

/**
 * Created by sethideep23 on 1/3/17.
 */
public class StatusRow extends HBox {
    SubsystemLabel system;
    CommandLabel command;

    public StatusRow(String id, String system, String command) {
        style();
        setId(id);
        this.system = new SubsystemLabel(system);
        this.command = new CommandLabel(command);
        getChildren().addAll(this.system, this.command);
    }

    public void style() {
        setPrefHeight(34);
        setPrefWidth(171);
    }

    public void update(String system, String command) {
        this.system.setText(system);
        this.command.setText(command);
    }

    public void updateCommand(String command) {
        this.command.setText(command);
    }
}
