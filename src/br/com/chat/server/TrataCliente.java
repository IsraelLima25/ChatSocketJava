package br.com.chat.server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TrataCliente implements Runnable {

	private Socket cliente;
	private Server server;

	public TrataCliente(Socket cliente, Server server) {
		this.cliente = cliente;
		this.server = server;
	}

	public void run() {
		// quando chegar uma msg, distribui pra todos
		try (Scanner s = new Scanner(this.cliente.getInputStream())) {
			while (s.hasNextLine()) {
				server.distribuiMensagem(this.cliente, s.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
