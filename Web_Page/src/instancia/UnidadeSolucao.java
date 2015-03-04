package instancia;

import lombok.Data;
import classes.Componente;

public @Data class UnidadeSolucao {

	private double fatorPosicao;
	private double fatorTamanho;

	/**
	 * Construtor responsável por gerar uma Unidade de Solução dentro de uma Solução.
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
	 * Responsável por imprimir as informações de uma unidade de solução.
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
	 * @return Coeficiente de Informação da característica escolhida pra o componente.
	 */
	public double pegaCoeficienteComponente(Componente componente){
		int indice = this.pegaCaracteristicaIndice(componente);
		return componente.getConfiguracao().pegaCaracteristicaIndice(indice).getCoeficienteInformacao();
	}

	/**
	 * Sobe a linha de uma unidade de Solução.
	 * Não é possível gera uma linha negativa
	 */
	public void sobeLinha() {
			this.setFatorPosicao((double) (Math.random() * ((3/8) - 0)));
	}

	/**
	 * Desce linha da Unidade de Solução.
	 */
	public void desceLinha() {
		this.setFatorPosicao((double) (Math.random() * ((1 - (6/8)))));	
	}

	/**
	 * Seleciona uma nova configuração para uma Unidade de Solução. 
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
	 * @return Nome da Unidade de Solução, acrescido do indice da característica.
	 * Utilizada para a geração do arquivo HTML.
	 */
	public String geraNomeFonte(Componente componente){
		return componente.getNome() + "_" + this.pegaCaracteristicaIndiceImagem(componente);		
	}
	
	public UnidadeSolucao copy() {
		UnidadeSolucao copied = new UnidadeSolucao(this.getFatorPosicao(), this.getFatorTamanho());
		return copied;
	}

	
}