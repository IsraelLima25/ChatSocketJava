package br.com.playground;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) throws Exception {
		// Cliente
		Socket s = new Socket("localhost", 12345);
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		Obj obj = new Obj();
		obj.setX(10);
		obj.setY("teste");
		oos.writeObject(obj);
		s.close();
	}
}
