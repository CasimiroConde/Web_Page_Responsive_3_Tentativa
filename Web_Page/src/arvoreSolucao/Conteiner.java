package arvoreSolucao;

import lombok.Data;

public @Data class Conteiner {

	private String indice;
	private int direcao; // 0 vertical, 1 horizontal	

	public Conteiner(String i ,int dir) {
		this.indice = i;
		this.direcao = dir;
	}
}
