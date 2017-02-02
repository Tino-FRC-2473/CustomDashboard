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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Map;

public class Controller {
    Scene scene;
    Map<String, String> map;
    final Color RED;
    final Color GREEN;

    //Test Values
    double percentage_test;
    double gyro_direction;

    ArrayList<String> sensors;
    ArrayList<String> motors;
    ArrayList<String> subsystems;

    public Controller(Scene r, Map map) {
        sensors = new ArrayList<String>();
        motors = new ArrayList<String>();
        subsystems = new ArrayList<String>();
        scene = r;
        this.map = map;
        RED = Color.web("#FF0000");
        GREEN = Color.web("#1DFF2A");
        percentage_test = 1.00;
        gyro_direction = 0;
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
        ImageView gyro = (ImageView)(scene.lookup("#gyro"));
        gyro.setRotate(deg);
    }

    public void updateColor(Color c) {
        Rectangle battery_small = (Rectangle)(scene.lookup("#battery_small"));
        Rectangle battery_large = (Rectangle)(scene).lookup(("#battery_large"));
        battery_small.setFill(c);
        battery_large.setFill(c);
    }

    public Color chooseColor(double percentage) {
        if(percentage < 0) {
            percentage = 0;
        }
        if(percentage > 1.00) {
            percentage = 1.00;
        }
        double hue = RED.getHue() + Math.abs(RED.getHue() - GREEN.getHue())*percentage;
        return Color.hsb(hue,1.0,1.0);
    }

    public double getPercent(double voltage) {
        return voltage/12.0;
    }

    public void changeValues() {
        gyro_direction++;
        if(percentage_test == 0) {
            percentage_test = 1.00;
        } else {
            percentage_test -= 0.001;
        }
        System.out.println(gyro_direction);
        System.out.println(percentage_test);
    }

    public void addSensorData(String id, String name, String val) {
        if(sensors.indexOf(id) != -1) {
            updateSensorData(id,name,val);
        } else {
            VBox box = (VBox)(scene.lookup("#sensors_list"));
            sensors.add(id);
            DeviceListRow item = new DeviceListRow(id, name, val);
            box.getChildren().add(item);
        }
    }

    public void updateSensorData(String id, String name, String val) {
        VBox box = (VBox)(scene.lookup("#sensors_list"));
        id = "#" + id;
        DeviceListRow sensor = (DeviceListRow)(box.lookup(id));
        if(sensor != null) {
            sensor.update(name, val);
        } else {
            throw new NullPointerException("Sensor not found");
        }
    }

    public void addMotorData(String id, String name, String val) {
        if(motors.indexOf(id) != -1) {
            updateMotorData(id,name,val);
        } else {
            VBox box = (VBox)(scene.lookup("#motors_list"));
            motors.add(id);
            DeviceListRow item = new DeviceListRow(id, name, val);
            System.out.println(item.getId());
            box.getChildren().add(item);
        }
    }

    public void updateMotorData(String id, String name, String val) {
        VBox box = (VBox)(scene.lookup("#motors_list"));
        id = "#" + id;
        DeviceListRow motor = (DeviceListRow)(box.lookup(id));
        if(motor != null) {
            motor.update(name, val);
        } else {
            throw new NullPointerException("Motor not found");
        }
    }

    public void addSubsystem(String id, String subsystem, String command) {
        if(subsystems.indexOf(id) != -1) {
            updateSystemCommand(id,command);
        } else {
            VBox box = (VBox)(scene.lookup("#table_2"));
            subsystems.add(id);
            StatusRow system = new StatusRow(id, subsystem, command);
            box.getChildren().add(system);
        }
    }

    public void updateSystemCommand(String id, String command) {
        VBox box = (VBox)(scene.lookup("#table_2"));
        id = "#" + id;
        StatusRow system = (StatusRow)(box.lookup(id));
        if(system != null) {
            system.updateCommand(command);
        } else {
            throw new NullPointerException("Subsystem not found");
        }
    }

    public void update() {
        changeValues();
        rotate(gyro_direction);
        updateColor(chooseColor(percentage_test));
        synchronized (map) {
            for(Map.Entry<String, String> i : map.entrySet()) {
                String key = i.getKey();
                String value = i.getValue();
                if(key.indexOf("SENSORS") != -1) {
                    String id = key.substring(key.indexOf("-") + 1);
                    updateSensorData(id,id,value);
                } else if(key.indexOf("BATTERY") != -1) {
                    String id = key.substring(key.indexOf("-") + 1);
                    updateColor(chooseColor(getPercent(Double.parseDouble(value))));
                } else if(key.indexOf("MOTORS") != -1) {
                    String id = key.substring(key.indexOf("-") + 1);
                    updateMotorData(id,id,value);
                } else if(key.indexOf("COMMANDS") != -1) {
                    String id = key.substring(key.indexOf("-") + 1);
                    if(value != null) {
                        updateSystemCommand(id,id);
                    }
                }
            }
        }
    }
}