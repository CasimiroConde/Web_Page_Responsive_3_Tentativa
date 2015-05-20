package arvoreSolucao;

import lombok.Data;

public @Data class Conteiner {

	private int indice;
	private DirecaoConteiner direcao;	
	private int largura;
	private int altura;

	public Conteiner(int i, DirecaoConteiner direcao) {
		this.indice = i;
		this.direcao = direcao;
		this.largura = 0;
		this.altura = 0;
	}

	public void definirDimensoes(int alturaElemento, int larguraElemento) {
	
		if(this.direcao.equals(DirecaoConteiner.Horizontal)){
			this.largura += larguraElemento;
			if(this.altura < alturaElemento)
				this.altura = alturaElemento;
		} else {
			this.altura += alturaElemento;
			if(this.largura< larguraElemento)
				this.largura = larguraElemento;
		}
		
	}
}