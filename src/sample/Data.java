package sample;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    public static void data() {
        ArrayList<Double> values = new ArrayList<>();
        try (Socket s = new Socket("RoboRIO-2473-FRC.local", 2005)) {
            values.clear();
            InputStream in = s.getInputStream();
            Scanner scan = new Scanner(in);

            System.out.print("connected");

            //Put values into an ArrayList of Doubles
            while (scan.hasNextLine()) {
                String input = scan.nextLine();
                double val = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (Character.isDigit(input.charAt(i))) {
                        val += Character.getNumericValue(input.charAt(i));
                    }
                }
                values.add(val);
                System.out.println(values);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}