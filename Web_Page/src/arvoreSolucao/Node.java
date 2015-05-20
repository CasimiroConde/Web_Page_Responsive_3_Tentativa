package arvoreSolucao;

import java.util.ArrayList;

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
}