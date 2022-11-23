package de.louis.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer{
	
	private ServerSocket server;
	
	public WebServer(int port) throws IOException {
		this.server = new ServerSocket(port);
	}
	
	public void start() throws IOException {
		Socket connection;
		InputStream input;
		OutputStream output;
		PrintWriter printwriter;
		while(true) {
			connection = this.server.accept();
			connection.setSoTimeout(1000);
			input = connection.getInputStream();
			output = connection.getOutputStream();
			printwriter = new PrintWriter(output);
			
			printwriter.println("HTTP/1.0 200 OK");
			printwriter.println("Content-Type: text/html");
			printwriter.println("Server: Bot");
			printwriter.println("");
			
			printwriter.println("<h3>Deine IP: " + connection.getInetAddress().getHostAddress() + "</h3>");

			
			printwriter.flush();
			printwriter.close();
			input.close();
			output.close();
			connection.close();
		}
	}
}
