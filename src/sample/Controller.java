package sample;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Map;

public class Controller {
    Scene scene;
    Map<String, String> map;

    public Controller(Scene r, Map map) {
        scene = r;
        this.map = map;
    }

    @FXML
    VBox table_2;

    public void addSystem(String s) {
        VBox container = (VBox)(scene.lookup("#table_2"));
        HBox addition = new HBox();
        Label system_label = new Label(s);
        s += "_subsystem";
        s += "_label";
        system_label.setId(s);
        container.getChildren().add(system_label);
    }

    public void rotate(double deg) {
        ImageView gyro = (ImageView)(scene.lookup("#gryo"));
        gyro.setRotate(deg);
    }

    public void update() {
        synchronized (map) {
            System.out.println(map.values());
        }
    }
}