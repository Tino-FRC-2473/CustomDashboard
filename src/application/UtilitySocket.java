package application;

import java.io.*;
import java.net.Socket;

/**
 * Socket with built in BufferedReader and PrintStream for convenience.
 * @author JosephM
 * @author mvoodarla
 * @author wang.patrick57@gmail.com
 */
public class UtilitySocket extends Socket {
	BufferedReader reader;
	PrintStream stream;
	
	/**
	 * Creates the socket and initializes the BufferedReader and PrintStream.
	 * @param host The IP the connection is occurring on.
	 * @param port The port the connection on this IP is occurring on.
	 * @throws IOException If an I/O error occurs when creating the socket.
	 */
	public UtilitySocket(String host, int port) throws IOException {
		super(host, port);
		reader = new BufferedReader(new InputStreamReader(getInputStream()));
		stream = new PrintStream(getOutputStream());
	}
	
	/**
	 * Sends a string, with a newline appended at the end, to the other connection.
	 * @param s the string to send
	 */
	public void sendLine(String s) {
		stream.print(s + "\n");
	}
	
	/**
	 * Obtains a string, or null if nothing was sent, that the other side of the connection sent
	 * @return that string to obtain
	 */
	public String getLine() {
		try {
			if(reader.ready()) {
				return reader.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		
		return null;
	}
}