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
	 * Construtor de uma Solução  
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
	 * @return quantidade de Unidades de Solução contidas na Solução.
	 */
	public int tamanhoSolucao(){
		return this.getSolucao().length;
	}
	
	/**
	 * @return Altura máxima da solução
	 * Somando a altura de todas Unidades de Solução como se estivessem uma embaixo da outra.
	 */
	public int calculaAlturaMaximaSolucao(){
		int alturaTotal = 0;
		for(int i = 0 ; i < this.tamanhoSolucao() ; i++ ){
			alturaTotal += this.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente();
		}
		return alturaTotal;
	}
	
	/**
	 * @return Altura real da solução.
	 * Considerando Unidades de Solução na mesma linha.
	 */
	public int calculaAlturaRealSolucao(){
		return DimensoesPosicionamento.executaAltura(this, modelo);
	}
	
	/** 
	 * @return Largura da Solução.
	 * Ou seja, o tamanhao da maior linha.
	 */
	public Integer calculaLarguraRealSolucao(){
		return DimensoesPosicionamento.executaLargura(this, modelo);
	}
	
	/**
	 * @return Coeficiente de Informação da Solução.
	 */
	public double calculaCoeficienteSolucao(){
		return this.calculaSomaCoeficiente() / this.solucao.length;	
	}

	/**
	 * @return Soma dos Coeficientes de Informação das Unidades de Solução.
	 */
	private double calculaSomaCoeficiente() {
		double coeficienteTotal = 0.0;
		for(int i = 0 ; i < this.tamanhoSolucao() ; i++ ){
			coeficienteTotal += this.pegaUnidadeSolucaoIndice(i).pegaCoeficienteComponente(modelo.pegaComponenteIndice(i));
		}
		return coeficienteTotal;
	}
	
	/**
	 * Verifica se a Solução é válida, considerando os testes feitos pela Classe de Validação.
	 * @param modelo
	 * @return 
	 */
	public boolean validaSolucao(Modelo modelo){
		return Validacao.executa(this, LARGURATELA, modelo);
	}
	
	/**
	 * @return fitness function da solução.
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
	 * Imprime as informações completas de uma solução. 
	 */
	public void print(){
		/*for(UnidadeSolucao u : this.solucao){
			u.print();
		}*/
		System.out.println("Altura Máxima: " + this.calculaAlturaMaximaSolucao());
		System.out.println("Altura Total: " + this.calculaAlturaRealSolucao());
		System.out.println("Media Coeficiente de Informação: " + this.calculaCoeficienteSolucao());
		System.out.println("Fitness Function: " + this.fitnessFunction());
		System.out.println("Largura Solução: " + this.calculaLarguraRealSolucao());
		System.out.println("Largura Tela: " + LARGURATELA);
	}
	
	/**
	 * @param i
	 * @return Unidade de Solução do indice i
	 */
	public UnidadeSolucao pegaUnidadeSolucaoIndice(int i){
		if(i < 0)
			return null;
		
		return this.solucao[i];
	}

	/**
	 * Sobe a linha  da unidade de solução do indice i
	 * @param i
	 */
	public void vizinhoSobeLinha(int i) {
		this.pegaUnidadeSolucaoIndice(i).sobeLinha(this.pegaUnidadeSolucaoIndice(i - 1));		
	}

	/**
	 * Desce linha da Unidade de Solução do indice i
	 * @param i
	 */
	public void vizinhoDesceLinha(int i) {
		this.pegaUnidadeSolucaoIndice(i).desceLinha(this.pegaUnidadeSolucaoIndice(i - 1));
	}
			
 // funcão para andar para esquerda
	
	public void vizinhoColocaEsquerda(int i) {
		this.pegaUnidadeSolucaoIndice(i).enviaEsquerda(this.pegaUnidadeSolucaoIndice(i - 1));
	}
 // função para andar para direita
	
	public void vizinhoColocaDireita(int i) {
		this.pegaUnidadeSolucaoIndice(i).enviaDireita(this.pegaUnidadeSolucaoIndice(i - 1));
	}

	/**
	 * Busca uma nova configuração para a Unidade Solução do indice i.
	 * @param i
	 */

	public Solucao copy() {
		Solucao copied = new Solucao(modelo);
		
		for (int i = 0; i < modelo.pegaNumeroComponentes(); i++) {
			copied.solucao[i] = this.solucao[i].copy();
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