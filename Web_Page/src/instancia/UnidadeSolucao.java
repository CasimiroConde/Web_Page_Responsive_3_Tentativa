package instancia;

import lombok.Data;
import classes.Componente;
import classes.Modelo;

public @Data class UnidadeSolucao {

	private int x;
	private int y;
	private int fatorTamanho;
	private Componente componente;

	/**
	 * Construtor respons�vel por gerar uma Unidade de Solu��o dentro de uma Solu��o.
	 * @param linha
	 * @param prioridade
	 * @param componente
	 */
	public UnidadeSolucao(Componente comp, Modelo modelo) {
		super();
		int tamanho = (int) (Math.random() * (comp.getConfiguracao().pegaNumeroCaracteristicas() - 0));
		this.x = (int) (Math.random() * (modelo.pegaSomaMaximaLargura() - 0));
		this.y = (int) (Math.random() * (modelo.pegaSomaMaximaAltura() - 0));

		if(tamanho == comp.getConfiguracao().pegaNumeroCaracteristicas())
			this.fatorTamanho = tamanho -1;
		else
			this.fatorTamanho = tamanho;
		
		this.componente = comp;
	}


	public UnidadeSolucao(int x,int y, int fatorTamanho2, Componente comp) {
		this.x = x;
		this.y = y;
		this.fatorTamanho = fatorTamanho2;
		this.componente = comp;
	}

	/**
	 * Respons�vel por imprimir as informa��es de uma unidade de solu��o.
	 */
	public void print(){
		System.out.println(	this.getX() + " ; " +
							this.getY() + " ; " +
							this.getComponente().getNome() + " ; " +
							this.getFatorTamanho() + " ; ");
		System.out.println("--------------------");
	}
	
	/**
	 * @return altura do componente
	 */
	public int pegaAlturaComponente(){
		int indice = this.getFatorTamanho();
		return Integer.parseInt(this.getComponente().getConfiguracao().pegaCaracteristicaIndice(indice).getAltura());
	}
	
	/**
	 * @return Largura do Componente
	 */
	public int pegaLarguraComponente(){
		int indice = this.getFatorTamanho();
		return Integer.parseInt(this.getComponente().getConfiguracao().pegaCaracteristicaIndice(indice).getLargura());
	}
	
	/**
	 * @return Coeficiente de Informa��o da caracter�stica escolhida pra o componente.
	 */
	public double pegaCoeficienteComponente(Componente componente){
		int indice = this.getFatorTamanho();
		return this.getComponente().getConfiguracao().pegaCaracteristicaIndice(indice).getCoeficienteInformacao();
}

	/**
	 * Sobe a linha de uma unidade de Solu��o.
	 * N�o � poss�vel gera uma linha negativa
	 */
	public void sobeLinha(UnidadeSolucao uSolucao) {
		this.y = this.y - (this.pegaAlturaComponente() + 
							uSolucao.pegaAlturaComponente());
		if (this.y < 0){
			this.y = 0;
		}
	}

	/**
	 * Desce linha da Unidade de Solu��o.
	 */
	public void desceLinha(UnidadeSolucao uSolucao) {
		this.y = this.y + (this.pegaAlturaComponente() + 
							uSolucao.pegaAlturaComponente());
	}
	
	public void enviaEsquerda(UnidadeSolucao uSolucao) {
		this.x = this.x - (this.pegaLarguraComponente() + 
							uSolucao.pegaLarguraComponente());
		
		if (this.x < 0){
			this.x = 0;
		}
	}
	
	
	public void enviaDireita(UnidadeSolucao uSolucao) {
		this.x = this.x + (this.pegaLarguraComponente() + 
							uSolucao.pegaLarguraComponente());
	}

	/**
	 * Seleciona uma nova configura��o para uma Unidade de Solu��o. 
	 */
	public void geraFatorTamanho() {
		int tamanho = (int) (Math.random() * ((this.getComponente().getConfiguracao().pegaNumeroCaracteristicas() - 0)));
		
		if(tamanho == this.getComponente().getConfiguracao().pegaNumeroCaracteristicas())
			this.fatorTamanho = tamanho -1;
		else
			this.fatorTamanho = tamanho;
	
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
	public String geraNomeFonte(){
		return this.getComponente().getNome() + "_" + this.pegaCaracteristicaIndiceImagem();		
	}
	
	public UnidadeSolucao copy() {
		UnidadeSolucao copied = new UnidadeSolucao(this.getX(), this.getY(), this.getFatorTamanho(), this.getComponente());
		return copied;
	}

	
}