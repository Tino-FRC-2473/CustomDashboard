package sample;

import javafx.collections.ObservableMap;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by sethideep23 on 12/27/16.
 */
public class NetworkingThread extends Thread {
    boolean running;
    int port_number;
    Map<String, String> map;

    public NetworkingThread(int port_number, Map<String, String> map) {
        running = true;
        this.port_number = port_number;
        this.map = map;
    }

    public void quit() {
        running = false;
    }

    public Extract getStart(String line) {
        boolean bool = false;
        String string = "";
        if(line.indexOf("START:") != -1) {
            bool = true;
            string = line.substring(8);
        }
        return new Extract(bool, string);
    }

    public Extract getEnd(String line) {
        boolean bool = false;
        String string = "";
        if(line.indexOf("END:") != -1) {
            bool = true;
            string = line.substring(5);
        }
        return new Extract(bool, string);
    }

    @Override
    public void run() {
        try (Socket s = new Socket("RoboRIO-2473-FRC.local", port_number);
             InputStream in = s.getInputStream();
             Scanner scan = new Scanner(in)) {

            System.out.print("connected");
            String mode = "";

            //Gets values from the robot and puts it into a map
            while (scan.hasNextLine() && running) {
                synchronized (map) {
                    String line = scan.nextLine();
                    Extract start = getStart(line);
                    Extract end = getEnd(line);

                    if(start.getBool()) {
                        mode = start.getString();
                    } else if(end.getBool()) {
                        mode = "";
                    } else {
                        String[] data = line.split(":");
                        map.put((mode + "-" + data[0]), data[1]);
                    }
                }
                try {
                    Thread.sleep(10);
                } catch(InterruptedException e) {

                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}