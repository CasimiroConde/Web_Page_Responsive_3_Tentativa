package instancia;

import old.MatrizPosicionamento;
import lombok.Data;
import validacao.Validacao;
import classes.Modelo;

/*    1/8 | 2/8 | 3/8
 * 	  4/8 | xxx | 5/8
 * 	  6/8 | 7/8 |  1	
 */

public @Data class Solucao{

	private static double FATOR = 0.5; 
	private static double LARGURATELA = 725;

	//InfoTela informacaoTela;
	private Modelo modelo;
	private String[] nomesFontes;
	private UnidadeSolucao[] solucao;
	/**
	 * Construtor de uma Solu��o  
	 */
	public Solucao(Modelo modelo){
		this.modelo = modelo;
//		this.solucao = new UnidadeSolucao[0];	
		this.solucao = new UnidadeSolucao[modelo.pegaNumeroComponentes()];

		for (int i = 0; i < modelo.pegaNumeroComponentes(); i++) {
			this.solucao[i] = new UnidadeSolucao(modelo.pegaComponenteIndice(i), modelo);
		}
	}
	
	/** 
	 * @return quantidade de Unidades de Solu��o contidas na Solu��o.
	 */
	public int tamanhoSolucao(){
		return this.getSolucao().length;
	}
	
	/**
	 * @return Altura m�xima da solu��o
	 * Somando a altura de todas Unidades de Solu��o como se estivessem uma embaixo da outra.
	 */
	public int calculaAlturaMaximaSolucao(){
		int alturaTotal = 0;
		for(int i = 0 ; i < this.tamanhoSolucao() ; i++ ){
			alturaTotal += this.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente();
		}
		return alturaTotal;
	}
	
	/**
	 * @return Altura real da solu��o.
	 * Considerando Unidades de Solu��o na mesma linha.
	 */
	public int calculaAlturaRealSolucao(){
		return DimensoesPosicionamento.executaAltura(this, modelo);
	}
	
	/** 
	 * @return Largura da Solu��o.
	 * Ou seja, o tamanhao da maior linha.
	 */
	public Integer calculaLarguraRealSolucao(){
		return DimensoesPosicionamento.executaLargura(this, modelo);
	}
	
	/**
	 * @return Coeficiente de Informa��o da Solu��o.
	 */
	public double calculaCoeficienteSolucao(){
		return this.calculaSomaCoeficiente() / this.solucao.length;	
	}

	/**
	 * @return Soma dos Coeficientes de Informa��o das Unidades de Solu��o.
	 */
	private double calculaSomaCoeficiente() {
		double coeficienteTotal = 0.0;
		for(int i = 0 ; i < this.tamanhoSolucao() ; i++ ){
			coeficienteTotal += this.pegaUnidadeSolucaoIndice(i).pegaCoeficienteComponente(modelo.pegaComponenteIndice(i));
		}
		return coeficienteTotal;
	}
	
	/**
	 * Verifica se a Solu��o � v�lida, considerando os testes feitos pela Classe de Valida��o.
	 * @param modelo
	 * @return 
	 */
	public boolean validaSolucao(Modelo modelo){
		return Validacao.executa(this, LARGURATELA, modelo);
	}
	
	/**
	 * @return fitness function da solu��o.
	 */
	public double fitnessFunction(){
		return FATOR * this.calculaFatorVertical() + (1 - FATOR) * (1 - this.calculaCoeficienteSolucao());
	}
	
	/**
	 * @return Fator Vertival.
	 * Utilizado para calcular a fitness function.
	 */
	public double calculaFatorVertical(){
		return this.calculaAlturaRealSolucao() / this.calculaAlturaMaximaSolucao();
	}
	
	/**
	 * Imprime as informa��es completas de uma solu��o. 
	 */
	public void print(){
		/*for(UnidadeSolucao u : this.solucao){
			u.print();
		}*/
		System.out.println("Altura M�xima: " + this.calculaAlturaMaximaSolucao());
		System.out.println("Altura Total: " + this.calculaAlturaRealSolucao());
		System.out.println("Media Coeficiente de Informa��o: " + this.calculaCoeficienteSolucao());
		System.out.println("Fitness Function: " + this.fitnessFunction());
		System.out.println("Largura Solu��o: " + this.calculaLarguraRealSolucao());
		System.out.println("Largura Tela: " + LARGURATELA);
	}
	
	/**
	 * @param i
	 * @return Unidade de Solu��o do indice i
	 */
	public UnidadeSolucao pegaUnidadeSolucaoIndice(int i){
		if(i < 0)
			return null;
		
		return this.solucao[i];
	}

	/**
	 * Sobe a linha  da unidade de solu��o do indice i
	 * @param i
	 */
	public void vizinhoSobeLinha(int i) {
		this.pegaUnidadeSolucaoIndice(i).sobeLinha(this.pegaUnidadeSolucaoIndice(i - 1));		
	}

	/**
	 * Desce linha da Unidade de Solu��o do indice i
	 * @param i
	 */
	public void vizinhoDesceLinha(int i) {
		this.pegaUnidadeSolucaoIndice(i).desceLinha(this.pegaUnidadeSolucaoIndice(i - 1));
	}
			
 // func�o para andar para esquerda
 // fun��o para andar para direita

	/**
	 * Busca uma nova configura��o para a Unidade Solu��o do indice i.
	 * @param i
	 */

	public Solucao copy() {
		Solucao copied = new Solucao(modelo);
		
		for (int i = 0; i < modelo.pegaNumeroComponentes(); i++) {
			UnidadeSolucao item = this.solucao[i];
			copied.solucao[i] = new UnidadeSolucao(item.getX(), item.getY(), item.getFatorTamanho(), item.getComponente());
		}
		return copied;
	}
	
	public void ordenaAltura(){
		UnidadeSolucao aux = null;
		
		for(int i = 0 ; i < this.tamanhoSolucao() ; i++){
			for(int j = 0 ; j < this.tamanhoSolucao() - 1 ; j++){
				if(this.pegaUnidadeSolucaoIndice(j).getY() > this.pegaUnidadeSolucaoIndice(j + 1).getY()){
					aux = this.pegaUnidadeSolucaoIndice(j);
					this.solucao[j] = this.pegaUnidadeSolucaoIndice(j + 1);
					this.solucao[j + 1] = aux;
				}
			}
		}
	}

	public void ordenaLargura() {
		UnidadeSolucao aux = null;
		
		for(int i = 0 ; i < this.tamanhoSolucao() ; i++){
			for(int j = 0 ; j < this.tamanhoSolucao() - 1 ; j++){
				if(this.pegaUnidadeSolucaoIndice(j).getX() > this.pegaUnidadeSolucaoIndice(j + 1).getX()){
					aux = this.pegaUnidadeSolucaoIndice(j);
					this.solucao[j] = this.pegaUnidadeSolucaoIndice(j + 1);
					this.solucao[j + 1] = aux;
				}
			}
		}
	}

}