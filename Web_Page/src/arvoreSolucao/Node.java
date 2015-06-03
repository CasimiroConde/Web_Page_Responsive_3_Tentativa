package arvoreSolucao;

import java.util.ArrayList;

import classes.Caracteristica;
import classes.Componente;
import classes.Modelo;
import lombok.Data;
import lombok.Getter;

public @Data class Node {

	private  Conteiner conteiner = null;
	private  Element elemento = null;
	private ArrayList<Node> leafs;
	private  Node parent = null;

	public Node(int indiceComponente, int indiceCaracteristica) {
		this.elemento = new Element(indiceComponente, indiceCaracteristica);
		this.leafs = new ArrayList<Node>();
	}
	
	public Node(int indiceConteiner, DirecaoConteiner direcao) {
		this.conteiner = new Conteiner(indiceConteiner, direcao);
		this.leafs = new ArrayList<Node>();
	}

	public void addLeaf(Node leaf) {
		this.leafs.add(leaf);
		this.leafs.get(this.leafs.size() - 1).setParent(this);
	}
	
	public boolean contemElemento() {
		for(Node n: this.getLeafs()){
			if(n.getElemento() != null)
				return true;
			}
		return false;
	}

	public void remove() {
		parent.removeLeaf(this);
	}
	
	public void removeLeaf(Node leaf)
	{
		leafs.remove(leaf);
	}

	public Iterable<Node> getLeafs() {
		return leafs;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		if (conteiner != null) {
			s += "c," + conteiner.getDirecao().getCodigo() + ",";

			for (Node child : leafs) {
				s += child.toString();
			}
			
			s += "s,";
		}

		if (elemento != null) {
			s += elemento.getIndiceComponente() + "," + elemento.getIndiceCaracteristica() + ",";
		}

		return s;
	}

	public void definirDimensoes(Modelo modelo) {
		if(this.getConteiner() != null){
			definirDimensoesComponente(modelo);	
		}
		
		if(this.parent != null){
			this.getParent().definirDimensoes(modelo);
		}
		
	}

	private void definirDimensoesComponente(Modelo modelo) {
		
		int novaLargura = 0;
		int novaAltura = 0;
		for(Node leaf: this.getLeafs()){
			if(leaf.getConteiner() != null){
				if(this.getConteiner().getDirecao().equals(DirecaoConteiner.Horizontal)){
					novaLargura += leaf.getConteiner().getLargura();
					this.getConteiner().setLargura(novaLargura);
					
					if(this.getConteiner().getAltura() < leaf.getConteiner().getAltura())
						this.getConteiner().setAltura(leaf.getConteiner().getAltura());
				} else {
					novaAltura += leaf.getConteiner().getAltura();
					this.getConteiner().setAltura(novaAltura);
					
					if(this.getConteiner().getLargura() < leaf.getConteiner().getLargura())
						this.getConteiner().setLargura(leaf.getConteiner().getLargura());
				}
			}
			
			if(leaf.getElemento() != null){
				if(this.getConteiner().getDirecao().equals(DirecaoConteiner.Horizontal)){
					int indiceComponente = leaf.getElemento().getIndiceComponente();
					int indiceCaracteristica = leaf.getElemento().getIndiceCaracteristica();
					
					Componente componente = modelo.pegaComponenteIndice(indiceComponente);
					Caracteristica caracteristica = componente.getConfiguracao().pegaCaracteristicaIndice(indiceCaracteristica);
					int larguraElemento = Integer.parseInt(caracteristica.getLargura());
					int alturaElemento = Integer.parseInt(caracteristica.getAltura());
					
					novaLargura += larguraElemento;
					this.getConteiner().setLargura(novaLargura);
					
					if(this.getConteiner().getAltura() < alturaElemento)
						this.getConteiner().setAltura(alturaElemento);
				} else {
					int indiceComponente = leaf.getElemento().getIndiceComponente();
					int indiceCaracteristica = leaf.getElemento().getIndiceCaracteristica();
					
					Componente componente = modelo.pegaComponenteIndice(indiceComponente);
					Caracteristica caracteristica = componente.getConfiguracao().pegaCaracteristicaIndice(indiceCaracteristica);
					int larguraElemento = Integer.parseInt(caracteristica.getLargura());
					int alturaElemento = Integer.parseInt(caracteristica.getAltura());
					
					
					novaAltura += alturaElemento;
					this.getConteiner().setAltura(novaAltura);
					
					if(this.getConteiner().getLargura() < larguraElemento)
						this.getConteiner().setLargura(larguraElemento);
				}
			}
		}
	}
}
