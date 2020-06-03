package br.com.chat.client;

public abstract class Client {
	
	protected String host;
	protected int porta;
	protected String nick;
	
	public Client(String host, int porta, String nick) {
		this.host = host;
		this.porta = porta;
		this.nick = nick;
	}
}
