package br.com.playground;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(12345);
		Socket s = ss.accept();
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		Obj obj = (Obj) ois.readObject();
		System.out.println(obj.getX());
		ss.close();
	}

}
