package br.com.playground;

import java.util.ArrayList;
import java.util.List;

public class Lista {
public static void main(String[] args) {
	List<String> nomesDosAlunos = new ArrayList<String>();
	// ...  popula lista com strings
	
	nomesDosAlunos.add("nome procurado");
	
	for (String nome : nomesDosAlunos) {
		if (nome.equals("nome procurado")) {
			nomesDosAlunos.remove(nome);
		}
	}
}
}
