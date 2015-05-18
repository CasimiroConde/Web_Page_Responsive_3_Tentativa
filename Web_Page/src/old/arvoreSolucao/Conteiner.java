package old.arvoreSolucao;

import lombok.Data;

public @Data class Conteiner {

	private String indice;
	private int direcao;// 0 vertical, 1 horizontal	
	private int tamanho;

	public Conteiner(String i ,int dir) {
		this.indice = i;
		this.direcao = dir;
		this.tamanho = 0;
	}
	
	public Conteiner(Conteiner c) {
		this.indice = c.getIndice();
		this.direcao = c.getDirecao();
		this.tamanho = c.getTamanho();
	}
}
