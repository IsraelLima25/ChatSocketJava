package br.com.chat.client;

public class RunClientA {

	public static void main(String[] args) {
		ClientA run = new ClientA("127.0.0.1", 12345,"Israel");
		try {
			run.executa();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
