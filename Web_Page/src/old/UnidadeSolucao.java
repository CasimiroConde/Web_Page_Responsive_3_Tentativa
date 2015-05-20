package old;

import lombok.Data;
import classes.Componente;
import classes.Modelo;

public @Data class UnidadeSolucao {

	private int x;
	private int y;
	private int fatorTamanho;
	private Componente componente;

	/**
	 * Construtor responsável por gerar uma Unidade de Solução dentro de uma Solução.
	 * @param linha
	 * @param prioridade
	 * @param componente
	 */
	public UnidadeSolucao(Componente comp, Modelo modelo) {
		super();
		this.componente = comp;
		int indice = (int) (Math.random() * (this.getComponente().getConfiguracao().pegaNumeroCaracteristicas() - 0));
		this.x = (int) (Math.random() * (/*(725 - this.pegaLarguraComponente())*/ modelo.pegaSomaMaximaLargura() - 0));
		this.y = (int) (Math.random() * (modelo.pegaSomaMaximaAltura() - 0));

		if(indice >= this.getComponente().getConfiguracao().pegaNumeroCaracteristicas())
			this.fatorTamanho = this.getComponente().getConfiguracao().pegaNumeroCaracteristicas() - 1;
		else
			this.fatorTamanho = indice;
		
		this.componente = comp;
		
	}


	public UnidadeSolucao(int x,int y, int fatorTamanho2, Componente comp) {
		this.x = x;
		this.y = y;
		this.fatorTamanho = fatorTamanho2;
		this.componente = comp;
	}

	/**
	 * Responsável por imprimir as informações de uma unidade de solução.
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
	 * @return Coeficiente de Informação da característica escolhida pra o componente.
	 */
	public double pegaCoeficienteComponente(Componente componente){
		int indice = this.getFatorTamanho();
		return this.getComponente().getConfiguracao().pegaCaracteristicaIndice(indice).getCoeficienteInformacao();
}

	/**
	 * Sobe a linha de uma unidade de Solução.
	 * Não é possível gera uma linha negativa
	 */
	public void sobeLinha(UnidadeSolucao uSolucao) {
		this.y = this.y - (this.pegaAlturaComponente() + 
							uSolucao.pegaAlturaComponente());
		if (this.y < 0){
			this.y = 0;
		}
	}

	/**
	 * Desce linha da Unidade de Solução.
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
	 * Seleciona uma nova configuração para uma Unidade de Solução. 
	 */
	public void geraFatorTamanho() {
		int tamanho = (int) (Math.random() * ((this.getComponente().getConfiguracao().pegaNumeroCaracteristicas() - 0)));
		
		if(tamanho >= this.getComponente().getConfiguracao().pegaNumeroCaracteristicas())
			this.fatorTamanho = tamanho - 1;
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
	 * @return Nome da Unidade de Solução, acrescido do indice da característica.
	 * Utilizada para a geração do arquivo HTML.
	 */
	public String geraNomeFonte(){
		return this.getComponente().getNome() + "_" + this.pegaCaracteristicaIndiceImagem();		
	}
	
	public UnidadeSolucao copy() {
		UnidadeSolucao copied = new UnidadeSolucao(this.getX(), this.getY(), this.getFatorTamanho(), this.getComponente());
		return copied;
	}

	
}