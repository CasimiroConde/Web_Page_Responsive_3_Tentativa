package ordenacao;

import lombok.Data;

public @Data class UnidadeOrdenacao {

	private int indice;
	private boolean visitado;
	
	public UnidadeOrdenacao (int i, boolean visitado){
		this.indice = i;
		this.visitado = visitado;
	}
}
