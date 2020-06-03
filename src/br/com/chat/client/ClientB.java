package br.com.chat.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientB extends Client {

	public ClientB(String host, int porta, String nick) {
		super(host, porta,nick);
	}

	public void executa() throws Exception {
		Socket cliente = new Socket(this.host, this.porta);
		System.out.println("O cliente se conectou ao servidor!");

		// thread para receber mensagens do servidor
		Recebedor r = new Recebedor(cliente.getInputStream());
		new Thread(r).start();

		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		while (teclado.hasNextLine()) {
			
			String line = teclado.nextLine();
			
			if(line.trim().equals("")) {
				break;
			}
			
			saida.println(nick + ": " + line);
		}

		saida.close();
		teclado.close();
		cliente.close();

	}
}
