package arvoreSolucao;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Modelo;
import instancia.Solucao;

public class GeraArvore {
	
	

	public static ArvoreSolucao<Node> executa(String input){
		
		String[] vetorInput = input.split(",");
		String[] infos = new String[2];
		int contConteiner = 0;
		
		infos[0] = Integer.toString(contConteiner);
		infos[1] = vetorInput[1];
		
		Node pai = new Node(1, infos);
		ArvoreSolucao<Node> arvore = new ArvoreSolucao<Node>(pai);
		
		ArrayList<Node> listaPai = new ArrayList<Node>();
		listaPai.add(pai);
		
		contConteiner++;
		int i = 2;
		
		while ( i < vetorInput.length){
		
			if(vetorInput[i].equals("S") || vetorInput[i].equals("s")){
				listaPai.remove(listaPai.size() - 1);
				i++;
				continue;
			}
			if(vetorInput[i].equals("c") || vetorInput[i].equals("C")){
				infos[0] = Integer.toString(contConteiner);
				infos[1] = vetorInput[i + 1];
				Node no = new Node(1, infos);
				arvore.addLeaf(listaPai.get(listaPai.size() - 1), no);
				listaPai.add(no);
				i = i + 2;
				contConteiner++;
				continue;
			} else {
				infos[0] = vetorInput[i];
				infos[1] = vetorInput[i + 1];
				Node no = new Node(0,infos);
				arvore.addLeaf(listaPai.get(listaPai.size() - 1), no);
				i = i + 2;
				continue;
			}
		}
		
			return arvore;
	}
	
}