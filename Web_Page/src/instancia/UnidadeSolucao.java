package instancia;

import classes.Componente;
import lombok.Data;

public @Data class UnidadeSolucao {

	private double fatorPosicao;
	private double fatorTamanho;

	/**
	 * Construtor respons�vel por gerar uma Unidade de Solu��o dentro de uma Solu��o.
	 * @param linha
	 * @param prioridade
	 * @param componente
	 */
	public UnidadeSolucao() {
		super();
		this.fatorPosicao = (double) (Math.random() * ((1 - 0)));
		this.fatorTamanho = (double) (Math.random() * ((1 - 0)));
	}

	public UnidadeSolucao(double fatorPosicao2, double fatorTamanho2) {
		this.fatorPosicao = fatorPosicao2;
		this.fatorTamanho = fatorTamanho2;
	}

	/**
	 * Respons�vel por imprimir as informa��es de uma unidade de solu��o.
	 */
	public void print(){
		System.out.println(this.getFatorPosicao() + " ; " + 
							this.getFatorTamanho() + " ; ");
		System.out.println("--------------------");
	}
	
	/**
	 * @return altura do componente
	 */
	public int pegaAlturaComponente(Componente componente){
		int indice = this.pegaCaracteristicaIndice(componente);
		return Integer.parseInt(componente.getConfiguracao().pegaCaracteristicaIndice(indice).getAltura());
	}
	
	/**
	 * @return Largura do Componente
	 */
	public int pegaLarguraComponente(Componente componente){
		int indice = this.pegaCaracteristicaIndice(componente);
		return Integer.parseInt(componente.getConfiguracao().pegaCaracteristicaIndice(indice).getLargura());
	}
	
	/**
	 * @return Coeficiente de Informa��o da caracter�stica escolhida pra o componente.
	 */
	public double pegaCoeficienteComponente(Componente componente){
		int indice = this.pegaCaracteristicaIndice(componente);
		return componente.getConfiguracao().pegaCaracteristicaIndice(indice).getCoeficienteInformacao();
	}

	/**
	 * Sobe a linha de uma unidade de Solu��o.
	 * N�o � poss�vel gera uma linha negativa
	 */
	public void sobeLinha() {
			this.setFatorPosicao((double) (Math.random() * ((3/8) - 0)));
	}

	/**
	 * Desce linha da Unidade de Solu��o.
	 */
	public void desceLinha() {
		this.setFatorPosicao((double) (Math.random() * ((1 - (6/8)))));	
	}

	/**
	 * Seleciona uma nova configura��o para uma Unidade de Solu��o. 
	 */
	public void geraFatorTamanho() {
		this.fatorTamanho = (double) (Math.random() * ((1 - 0)));
	}
	
	public void geraFatorPosicao() {
		this.fatorPosicao = (double) (Math.random() * ((1 - 0)));
	}
	
	public int pegaCaracteristicaIndice(Componente componente){
		int indice = (int) Math.round(componente.getConfiguracao().pegaNumeroCaracteristicas() * this.getFatorTamanho());
		if(indice  == componente.getConfiguracao().pegaNumeroCaracteristicas())
			return indice - 1;
		
		return indice;
	
	}
	
	public int pegaCaracteristicaIndiceImagem(Componente componente){
		int indice = (int) Math.round(componente.getConfiguracao().pegaNumeroCaracteristicas() * this.getFatorTamanho());
	
		if(indice == 0)
			return 1;
		else
			return indice;
	}
	
	/**
	 * @return Nome da Unidade de Solu��o, acrescido do indice da caracter�stica.
	 * Utilizada para a gera��o do arquivo HTML.
	 */
	public String geraNomeFonte(Componente componente){
		return componente.getNome() + "_" + this.pegaCaracteristicaIndiceImagem(componente);		
	}
	
	public UnidadeSolucao copy() {
		UnidadeSolucao copied = new UnidadeSolucao(this.getFatorPosicao(), this.getFatorTamanho());
		return copied;
	}

	
}