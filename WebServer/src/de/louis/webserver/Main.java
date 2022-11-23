package de.louis.webserver;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebServer s = new WebServer(80);
		s.start();
	}
	
}
