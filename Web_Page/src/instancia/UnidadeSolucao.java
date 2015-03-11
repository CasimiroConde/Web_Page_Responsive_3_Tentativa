package instancia;

import lombok.Data;
import classes.Componente;

public @Data class UnidadeSolucao {

	private int fatorPosicao;
	private int fatorTamanho;

	/**
	 * Construtor respons�vel por gerar uma Unidade de Solu��o dentro de uma Solu��o.
	 * @param linha
	 * @param prioridade
	 * @param componente
	 */
	public UnidadeSolucao(Componente componente) {
		super();
		int posicao = (int) (Math.random() * (componente.getConfiguracao().pegaNumeroCaracteristicas() - 0));
		this.fatorPosicao = (int) (Math.random() * ((8 - 0)));
		
		if(posicao == componente.getConfiguracao().pegaNumeroCaracteristicas())
			this.fatorTamanho = posicao -1;
		else
			this.fatorPosicao = posicao;
}

	public UnidadeSolucao(int fatorPosicao2, int fatorTamanho2) {
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
		int indice = this.getFatorTamanho();
		return Integer.parseInt(componente.getConfiguracao().pegaCaracteristicaIndice(indice).getAltura());
	}
	
	/**
	 * @return Largura do Componente
	 */
	public int pegaLarguraComponente(Componente componente){
		int indice = this.getFatorTamanho();
		return Integer.parseInt(componente.getConfiguracao().pegaCaracteristicaIndice(indice).getLargura());
	}
	
	/**
	 * @return Coeficiente de Informa��o da caracter�stica escolhida pra o componente.
	 */
	public double pegaCoeficienteComponente(Componente componente){
		int indice = this.getFatorTamanho();
		return componente.getConfiguracao().pegaCaracteristicaIndice(indice).getCoeficienteInformacao();
	}

	/**
	 * Sobe a linha de uma unidade de Solu��o.
	 * N�o � poss�vel gera uma linha negativa
	 */
	public void sobeLinha() {
			this.setFatorPosicao((int) (Math.random() * (3 - 0)));
	}

	/**
	 * Desce linha da Unidade de Solu��o.
	 */
	public void desceLinha() {
		this.setFatorPosicao((int) (Math.random() * ((8 - 6))));	
	}

	/**
	 * Seleciona uma nova configura��o para uma Unidade de Solu��o. 
	 */
	public void geraFatorTamanho(Componente componente) {
		this.fatorTamanho = (int) (Math.random() * ((componente.getConfiguracao().pegaNumeroCaracteristicas() - 0)));
	}
	
	public void geraFatorPosicao() {
		this.fatorPosicao = (int) (Math.random() * ((8 - 0)));
	}
	
	public int pegaCaracteristicaIndiceImagem(){
		if(this.getFatorTamanho() == 0)
			return 1;
		else
			return this.getFatorTamanho();
	}
	
	/**
	 * @return Nome da Unidade de Solu��o, acrescido do indice da caracter�stica.
	 * Utilizada para a gera��o do arquivo HTML.
	 */
	public String geraNomeFonte(Componente componente){
		return componente.getNome() + "_" + this.pegaCaracteristicaIndiceImagem();		
	}
	
	public UnidadeSolucao copy() {
		UnidadeSolucao copied = new UnidadeSolucao(this.getFatorPosicao(), this.getFatorTamanho());
		return copied;
	}

	
}