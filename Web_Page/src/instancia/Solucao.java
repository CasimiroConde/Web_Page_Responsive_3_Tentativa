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
	private String solucao;
	
	/**
	 * Construtor de uma Solu��o  
	 */
	public Solucao(Modelo modelo){
		this.modelo = modelo;
//		this.solucao = new UnidadeSolucao[0];	
		this.solucao = new String();

			this.solucao = "c,v,c,h,c,v,0,0,1,0,S,c,h,2,0,S,S,c,h,c,h,12,0,S,c,h,3,0,4,0,5,0,6,0,S,S,c,h,c,v,13,0,S,c,h,c,h,7,0,S,c,h,8,0,9,0,10,0,11,0,S,S,S,c,h,14,0,S,S";
		
	}
	
	/** 
	 * @return quantidade de Unidades de Solu��o contidas na Solu��o.
	 */
	public int tamanhoSolucao(){
		return this.getSolucao().length();
	}
	
	/**
	 * @return Altura m�xima da solu��o
	 * Somando a altura de todas Unidades de Solu��o como se estivessem uma embaixo da outra.
	 */
	/*public int calculaAlturaMaximaSolucao(){
		int alturaTotal = 0;
		for(int i = 0 ; i < this.tamanhoSolucao() ; i++ ){
			alturaTotal += this.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente();
		}
		return alturaTotal;
	}
	
	*//**
	 * @return Altura real da solu��o.
	 * Considerando Unidades de Solu��o na mesma linha.
	 *//*
	public int calculaAlturaRealSolucao(){
		return DimensoesPosicionamento.executaAltura(this, modelo);
	}
	
	*//** 
	 * @return Largura da Solu��o.
	 * Ou seja, o tamanhao da maior linha.
	 *//*
	public Integer calculaLarguraRealSolucao(){
		return DimensoesPosicionamento.executaLargura(this, modelo);
	}
	
	*//**
	 * @return Coeficiente de Informa��o da Solu��o.
	 *//*
	public double calculaCoeficienteSolucao(){
		return this.calculaSomaCoeficiente() / this.modelo.pegaNumeroComponentes();	
	}*/

	/**
	 * @return Soma dos Coeficientes de Informa��o das Unidades de Solu��o.
	 */
	/*private double calculaSomaCoeficiente() {
		double coeficienteTotal = 0.0;
		for(int i = 0 ; i < this.tamanhoSolucao() ; i++ ){
			coeficienteTotal += this.pegaUnidadeSolucaoIndice(i).pegaCoeficienteComponente(modelo.pegaComponenteIndice(i));
		}
		return coeficienteTotal;
	}*/
	
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
	/*public double fitnessFunction(){
		return FATOR * this.calculaFatorVertical() + (1 - FATOR) * (1 - this.calculaCoeficienteSolucao());
	}*/
	
	/**
	 * @return Fator Vertival.
	 * Utilizado para calcular a fitness function.
	 */
/*	public double calculaFatorVertical(){
		return this.calculaAlturaRealSolucao() / this.calculaAlturaMaximaSolucao();
	}
	
	*//**
	 * Imprime as informa��es completas de uma solu��o. 
	 *//*
	public void print(){
		for(UnidadeSolucao u : this.solucao){
			u.print();
		}
		System.out.println("Altura M�xima: " + this.calculaAlturaMaximaSolucao());
		System.out.println("Altura Total: " + this.calculaAlturaRealSolucao());
		System.out.println("Media Coeficiente de Informa��o: " + this.calculaCoeficienteSolucao());
		System.out.println("Fitness Function: " + this.fitnessFunction());
		System.out.println("Largura Solu��o: " + this.calculaLarguraRealSolucao());
		System.out.println("Largura Tela: " + LARGURATELA);
	}*/
	

		public Solucao copy() {
		Solucao copied = new Solucao(modelo);
		
			copied.solucao = this.solucao;
		
		return copied;
	}

}