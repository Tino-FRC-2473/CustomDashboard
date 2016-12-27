import javafx.collections.ObservableMap;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by sethideep23 on 12/27/16.
 */
public class NetworkingThread extends Thread {
    int port_number;
    Map<String, String> map;

    public NetworkingThread(int port_number, Map<String, String> map) {
        this.port_number = port_number;
        this.map = map;
    }

    @Override
    public void run() {
        try (Socket s = new Socket("RoboRIO-2473-FRC.local", port_number);
             InputStream in = s.getInputStream();
             Scanner scan = new Scanner(in)) {

            System.out.print("connected");

            //Gets values from the robot and puts it into a map
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.contains("THROTTLE")) {
                    map.put("THROTTLE", (line.substring(line.lastIndexOf(":") + 1)));
                } else if (line.contains("GYRO")) {
                    map.put("GYRO", (line.substring(line.lastIndexOf(":") + 1)));
                } else if (line.contains("LEFT_ENC")) {
                    map.put("LEFT_ENCODER", (line.substring(line.lastIndexOf(":") + 1)));
                } else if (line.contains("RIGHT_ENC")) {
                    map.put("RIGHT_ENCODER", (line.substring(line.lastIndexOf(":") + 1)));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}