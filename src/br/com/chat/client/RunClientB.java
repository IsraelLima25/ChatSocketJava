package br.com.chat.client;

public class RunClientB {

	public static void main(String[] args) {
		ClientB run = new ClientB("127.0.0.1", 12345, "Meu Broto");
		try {
			run.executa();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
