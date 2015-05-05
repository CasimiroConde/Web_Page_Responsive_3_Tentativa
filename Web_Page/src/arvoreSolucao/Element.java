package arvoreSolucao;

import lombok.Data;

public @Data class Element {
	
	private int indiceComponente;
	private int indiceCaracteristica;
	
	public Element(int componenteIndice, int caractIndice) {
		this.indiceComponente = componenteIndice;
		this.indiceCaracteristica = caractIndice;
		
	}

}
