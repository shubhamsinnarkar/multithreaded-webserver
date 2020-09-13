

import java.awt.Font;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class HTTPWebServer {

	private final ServerSocket server;

	int Count = 0;
	int RequestedID = 0;
	private int Port = 8080;

	public static void main(String[] args) {

		try {
			new HTTPWebServer(args);
		} catch (IOException e) {
			System.out.println("ERROR!!!!!!!! TRY AGAIN!!!!");
		}
	}

	public HTTPWebServer(String[] args) throws IOException {

		if (args.length > 0) {
			try {
				Port = Integer.parseInt(args[0].trim());
			} catch (NumberFormatException e) {
				log("Error in reading server port. Defaulting to 8080");
			}
		} else {
			System.out.println("\t \t \n \n*********      Welcome to the Project 1 of Computer Networks    ************ ");
			log("\t \t \n *********      Listening to Port: \t" + Port);
		}

		server = new ServerSocket(Port);


		Runtime.getRuntime().addShutdownHook(new Thread());


		try {
			Socket incomingSocket = null;

			while (true) {
				try {
					incomingSocket = server.accept();

					++RequestedID;

					HTTPRequest request = new HTTPRequest(incomingSocket, RequestedID);
					Thread requestThread = new Thread(request);
					requestThread.start();

					++Count;
				} catch (Exception e) {
					log("Exception : " + e);
				}
			}
		} finally {

			server.close();
		}
	}



		static void log(String msg) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.printf(dtf.format(now), msg);
			Calendar c = Calendar.getInstance();

		}



}