package sample;

import javafx.collections.FXCollections;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class Data {
    private static Map<String, Double> values = FXCollections.observableHashMap();

    public static void connect() {
        values.put("THROTTLE", null);
        values.put("GYRO", null);
        values.put("LEFT_ENCODER", null);
        values.put("RIGHT_ENCODER", null);

        try (Socket s = new Socket("RoboRIO-2473-FRC.local", 2005);
             InputStream in = s.getInputStream();
             Scanner scan = new Scanner(in)) {

            System.out.println("connected");

            //Gets values from the robot and puts it into a map
            while (scan.hasNextLine()) {
//                String line = scan.nextLine();
//                if (line.contains("THROTTLE")) {
//                    values.put("THROTTLE", Double.parseDouble(line.substring(line.lastIndexOf(":") + 1)));
//                } else if (line.contains("GYRO")) {
//                    values.put("GYRO", Double.parseDouble(line.substring(line.lastIndexOf(":") + 1)));
//                } else if (line.contains("LEFT_ENC")) {
//                    values.put("LEFT_ENCODER", Double.parseDouble(line.substring(line.lastIndexOf(":") + 1)));
//                } else if (line.contains("RIGHT_ENC")) {
//                    values.put("RIGHT_ENCODER", Double.parseDouble(line.substring(line.lastIndexOf(":") + 1)));
//                }
                System.out.println(scan.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void clear() {
        values.clear();
    }

    public static Map<String, Double> getValues() {
        return values;
    }
}