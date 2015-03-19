package instancia;

import lombok.Data;
import classes.Componente;

public @Data class UnidadeSolucao {

	private int fatorPosicao;
	private int fatorTamanho;

	/**
	 * Construtor responsável por gerar uma Unidade de Solução dentro de uma Solução.
	 * @param linha
	 * @param prioridade
	 * @param componente
	 */
	public UnidadeSolucao(Componente componente) {
		super();
		int tamanho = (int) (Math.random() * (componente.getConfiguracao().pegaNumeroCaracteristicas() - 0));
		this.fatorPosicao = (int) (Math.random() * ((8 - 0)));
		
		if(tamanho == componente.getConfiguracao().pegaNumeroCaracteristicas())
			this.fatorTamanho = tamanho -1;
		else
			this.fatorTamanho = tamanho;
	}


	public UnidadeSolucao(int fatorPosicao2, int fatorTamanho2) {
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
	 * @return Coeficiente de Informação da característica escolhida pra o componente.
	 */
	public double pegaCoeficienteComponente(Componente componente){
		int indice = this.getFatorTamanho();
		return componente.getConfiguracao().pegaCaracteristicaIndice(indice).getCoeficienteInformacao();
	}

	/**
	 * Sobe a linha de uma unidade de Solução.
	 * Não é possível gera uma linha negativa
	 */
	public void sobeLinha() {
			this.setFatorPosicao((int) (Math.random() * (3 - 0)));
	}

	/**
	 * Desce linha da Unidade de Solução.
	 */
	public void desceLinha() {
		this.setFatorPosicao((int) (Math.random() * ((8 - 6))));	
	}

	/**
	 * Seleciona uma nova configuração para uma Unidade de Solução. 
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
	 * @return Nome da Unidade de Solução, acrescido do indice da característica.
	 * Utilizada para a geração do arquivo HTML.
	 */
	public String geraNomeFonte(Componente componente){
		return componente.getNome() + "_" + this.pegaCaracteristicaIndiceImagem();		
	}
	
	public UnidadeSolucao copy() {
		UnidadeSolucao copied = new UnidadeSolucao(this.getFatorPosicao(), this.getFatorTamanho());
		return copied;
	}

	
}