package arvoreSolucao;

import classes.Modelo;
import lombok.Data;

public @Data class Element {
	
	private int indiceComponente;
	private int indiceCaracteristica;
	
	public Element(int componenteIndice, int caractIndice) {
		this.indiceComponente = componenteIndice;
		this.indiceCaracteristica = caractIndice;
		
	}
	
	public String geraNome(Modelo modelo){
		return modelo.pegaComponenteIndice(indiceComponente).getNome() + "_" + (this.indiceCaracteristica + 1);	
	}

}
