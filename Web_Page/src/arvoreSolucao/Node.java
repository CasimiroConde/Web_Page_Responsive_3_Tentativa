package arvoreSolucao;

import java.util.ArrayList;

import lombok.Getter;

public class Node {

	private @Getter Conteiner conteiner = null;
	private @Getter Element elemento = null;
	private ArrayList<Node> leafs;
	private @Getter Node parent = null;

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