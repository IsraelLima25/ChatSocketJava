package br.com.chat.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server {

	private int porta;
	private List<Socket> clientes;
	

	public Server(int porta) throws IOException {
		this.porta = porta;
		this.clientes = new ArrayList<Socket>();		
	}

	public void executa() throws IOException {
		ServerSocket servidor = new ServerSocket(this.porta);
		System.out.println("Porta 12345 aberta!");

		while (true) {
			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

			this.clientes.add(cliente);

			TrataCliente tc = new TrataCliente(cliente, this);
			new Thread(tc, "Thread Servidora").start();
		}
	}

	public void distribuiMensagem(Socket remetente, String msg) throws IOException {

		for (int i = 0; i < clientes.size(); i++) {
			if (!clientes.get(i).equals(remetente)) {
				PrintStream ps;
				try {
					ps = new PrintStream(clientes.get(i).getOutputStream());
					ps.println(msg);
				} catch (Exception e) {
					System.out.println("Contato Off-Line");
					remover(i);
				}
			}
		}

	}

	private void remover(int index) {		
		this.clientes.remove(index);	
	}


}
