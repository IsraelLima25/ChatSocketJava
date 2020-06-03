package br.com.chat.server;

import java.io.IOException;

public class RunServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(12345);
		try {
			server.executa();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
