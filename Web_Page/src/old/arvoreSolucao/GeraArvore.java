package old.arvoreSolucao;

import java.util.ArrayList;

import classes.Modelo;

public class GeraArvore {
	
	

	public static ArvoreSolucao<Node> executa(String input, Modelo modelo){
		
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
				//adiciona tamanho no conteiner pai desse elemento.
				if(arvore.getTree(listaPai.get(listaPai.size() - 1)).getHead().getConteiner().getTamanho() < Integer.parseInt(modelo.pegaComponenteIndice(no.getElemento().getIndiceComponente()).getConfiguracao().pegaCaracteristicaIndice(no.getElemento().getIndiceCaracteristica()).getLargura())){
					Node novoHead = new Node(arvore.getTree(listaPai.get(listaPai.size() - 1)).getHead());
					novoHead.getConteiner().setTamanho(Integer.parseInt(modelo.pegaComponenteIndice(no.getElemento().getIndiceComponente()).getConfiguracao().pegaCaracteristicaIndice(no.getElemento().getIndiceCaracteristica()).getLargura()));
					arvore.getTree(listaPai.get(listaPai.size() - 1)).setHead(novoHead);
					listaPai.remove(listaPai.size() - 1);
					listaPai.add(novoHead);
				}
				
				
				i = i + 2;
				continue;	
			}
		}
		
			return arvore;
	}
	
}