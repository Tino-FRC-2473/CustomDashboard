package sample;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Data {
    private Map<String, Double> values = new HashMap<>(4);
    public void refresh() {
        values.put("THROTTLE", null);
        values.put("GYRO", null);
        values.put("LEFT_ENCODER", null);
        values.put("RIGHT_ENCODER", null);

        try (Socket s = new Socket("RoboRIO-2473-FRC.local", 2005);
             InputStream in = s.getInputStream();
             Scanner scan = new Scanner(in)) {

            System.out.print("connected");

            //Gets values from the robot and puts it into a map
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.contains("THROTTLE")) {
                    values.put("THROTTLE", Double.parseDouble(line.substring(line.lastIndexOf(":") + 1)));
                } else if (line.contains("GYRO")) {
                    values.put("GYRO", Double.parseDouble(line.substring(line.lastIndexOf(":") + 1)));
                } else if (line.contains("LEFT_ENC")) {
                    values.put("LEFT_ENCODER", Double.parseDouble(line.substring(line.lastIndexOf(":") + 1)));
                } else if (line.contains("RIGHT_ENC")) {
                    values.put("RIGHT_ENCODER", Double.parseDouble(line.substring(line.lastIndexOf(":") + 1)));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map getAllData() {
        return values;
    }

    public Double getThrottle() {
        return values.get("THROTTLE");
    }

    public Double getGyro() {
        return values.get("GYRO");
    }

    public Double getLeftEncoder() {
        return values.get("LEFT_ENC");
    }

    public Double getRightEncoder() {
        return values.get("RIGHT_ENC");
    }
}