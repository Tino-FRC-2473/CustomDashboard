package sample;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Data {
    public static String getData() {
        String returner = "";
        try (Socket s = new Socket("RoboRIO-2473-FRC.local", 2005)) {
            InputStream in = s.getInputStream();
            Scanner scan = new Scanner(in);

                System.out.print("connected");

                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine()); //Testing
                    returner += scan.nextLine();
                }


            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
            return returner;
    }
}