package hillClimbing;

import enums.Direcao;
import arvoreSolucao.Node;
import instancia.Solucao;

public class Otimizacao {

	public void executa(Solucao solucao, int indiceElemento){
		
		this.alteraElementoConteiner(solucao.getArvore(), indiceElemento);
			
		this.consolidaConteiner(solucao.getArvore(), indiceElemento);
		
	}
	
	public void alteraElementoConteiner(Node arvore, int indiceElemento){
		for(Node no : arvore.getLeafs()){
			if(no.getElemento() == null){
				alteraElementoConteiner(no, indiceElemento);
				return;
			}
			if(no.getElemento().getIndiceComponente() == indiceElemento){
				incluiElementoEmNovoConteiner(no);
				no.remove();
			}
		}
	}
	
	private void incluiElementoEmNovoConteiner(Node no) {
		Node novoConteiner = no.indicaNovoConteiner(Direcao.LEFT);
		novoConteiner.addLeaf(no);
	}

	public void consolidaConteiner(Node arvore, int indiceElemento){
		Node antigoConteiner =  arvore.pegaNoIndice(indiceElemento);
		for(Node no : antigoConteiner.getLeafs()){
			Node novoConteiner = antigoConteiner.indicaNovoConteiner(Direcao.LEFT);
			novoConteiner.addLeaf(no);
		}
		antigoConteiner.remove();
	}
	
	
	
}
