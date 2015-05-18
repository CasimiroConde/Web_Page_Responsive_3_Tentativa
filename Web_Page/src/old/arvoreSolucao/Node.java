package old.arvoreSolucao;

import lombok.Data;

public @Data class Node {
	
	private int tipo; // 0 elemento; 1 conteiner
	private Conteiner conteiner;
	private Element elemento;
	
	public Node(int tipo, String[] info){
		this.tipo = tipo;
		if(tipo == 0){
			int componenteIndice = Integer.parseInt(info[0]);
			int caractIndice = Integer.parseInt(info[1]);
			this.elemento = new Element(componenteIndice, caractIndice);
		} else if(tipo == 1){
			if(info[1].equals("v")){
				this.conteiner = new Conteiner(info[0],0);;}
			else{
				this.conteiner = new Conteiner(info[0],1);;}
			
		}	
	}
	
	public Node(Node no){
		this.tipo = no.getTipo();
		if(tipo == 0){
			this.elemento = new Element(no.getElemento());
		} else if(tipo == 1){
			this.conteiner = new Conteiner(no.getConteiner());
		}	
	}
	

}
