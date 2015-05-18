package arvoreSolucao;

import lombok.Data;

public @Data class Conteiner {

	private int indice;
	private DirecaoConteiner direcao;	
	private int tamanho;

	public Conteiner(int i, DirecaoConteiner direcao) {
		this.indice = i;
		this.direcao = direcao;
		this.tamanho = 0;
	}
}