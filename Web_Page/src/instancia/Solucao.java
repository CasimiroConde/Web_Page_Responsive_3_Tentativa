package instancia;

import java.util.ArrayList;
import java.util.List;

import validacao.Validacao;
import lombok.Data;
import classes.Componente;
import classes.Modelo;

/*    1/8 | 2/8 | 3/8
 * 	  4/8 | xxx | 5/8
 * 	  6/8 | 7/8 |  1	
 */

public @Data class Solucao{

	private static double FATOR = 0.5; 
	private static double LARGURATELA = 724;

	//InfoTela informacaoTela;
	private Modelo modelo;
	private String[] nomesFontes;
	private UnidadeSolucao[] solucao;
	private MatrizPosicionamento matriz =  new MatrizPosicionamento();
	private boolean construcaoCompleta;
	/**
	 * Construtor de uma Solu��o Vazia 
	 */
	public Solucao(Modelo modelo){
		this.modelo = modelo;
//		this.solucao = new UnidadeSolucao[0];	
		this.solucao = new UnidadeSolucao[modelo.pegaNumeroComponentes()];

		for (int i = 0; i < modelo.pegaNumeroComponentes(); i++) {
			this.solucao[i] = new UnidadeSolucao();
		}
		matriz = ConstrutorMatrizPosicionamento.executa(this, modelo);
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
			alturaTotal += this.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente(modelo.pegaComponenteIndice(i));
		}
		return alturaTotal;
	}
	
	/**
	 * @return Altura real da solu��o.
	 * Considerando Unidades de Solu��o na mesma linha.
	 */
	public int calculaAlturaRealSolucao(){
		
		
		/*ArrayList<Integer> alturaLinha = new ArrayList<Integer>();
		int alturaTotal = 0;
		int cont = 0;
		int maxCont = 0;
		for(int i = 0 ; i < this.tamanhoSolucao() ; i++){
			
			
			if(i == 0){
			alturaLinha.add(this.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente(modelo.pegaComponenteIndice(i)));
			}else if(this.pegaUnidadeSolucaoIndice(i).getFatorPosicao() > 0.625){
				cont++;
				if(cont > maxCont){
					alturaLinha.add(this.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente(modelo.pegaComponenteIndice(i)));
					maxCont++;
				}
			}else if(this.pegaUnidadeSolucaoIndice(i).getFatorPosicao() < 0.5){
				if(cont != 0)
					cont--;
			}else {
				if(this.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente(modelo.pegaComponenteIndice(i)) > alturaLinha.get(cont))
					alturaLinha.add(cont, this.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente(modelo.pegaComponenteIndice(i)));
			}
		}
		
		for(int i : alturaLinha){
			alturaTotal += i;
		}
		*/
		return DimensoesMatrizPosicionamento.executaAltura(matriz, this, modelo);
	}
	
	/** 
	 * @return Largura da Solu��o.
	 * Ou seja, o tamanhao da maior linha.
	 */
	public Integer calculaLarguraRealSolucao(){
		/*List<Integer> larguraLinhas = new ArrayList<Integer>();
		int largura = 0;
		int j = 0;
		
		larguraLinhas.add(0);
		
		for(int i = 0 ; i < this.solucao.length ; i++){
			if(i == 0){
				larguraLinhas.add(j, larguraLinhas.get(j) + this.pegaUnidadeSolucaoIndice(i).pegaLarguraComponente(modelo.pegaComponenteIndice(i)));		
			}else if (this.pegaUnidadeSolucaoIndice(i).getFatorPosicao() > 0.625){
				larguraLinhas.add(j + 1, larguraLinhas.get(j + 1) + this.pegaUnidadeSolucaoIndice(i).pegaLarguraComponente(modelo.pegaComponenteIndice(i)));	
				j++;
			}else if ((this.pegaUnidadeSolucaoIndice(i).getFatorPosicao() >= 0.5 && this.pegaUnidadeSolucaoIndice(i).getFatorPosicao() <= 0.625) || j == 0){
				larguraLinhas.add(j, larguraLinhas.get(j) + this.pegaUnidadeSolucaoIndice(i).pegaLarguraComponente(modelo.pegaComponenteIndice(i)));	
			}else if (this.pegaUnidadeSolucaoIndice(i).getFatorPosicao() < 0.5){
				larguraLinhas.add(j - 1, larguraLinhas.get(j - 1) + this.pegaUnidadeSolucaoIndice(i).pegaLarguraComponente(modelo.pegaComponenteIndice(i)));	
				j--;
			}
		}
		
		for(int i : larguraLinhas){
			if(i > largura){
				largura = i;
			}
		}*/
		
		return DimensoesMatrizPosicionamento.executaLargura(matriz, this, modelo);
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
		return Validacao.executa(this, LARGURATELA, modelo, construcaoCompleta);
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
		this.pegaUnidadeSolucaoIndice(i).sobeLinha();		
	}

	/**
	 * Desce linha da Unidade de Solu��o do indice i
	 * @param i
	 */
	public void vizinhoDesceLinha(int i) {
		this.pegaUnidadeSolucaoIndice(i).desceLinha();
	}
			
 // func�o para andar para esquerda
 // fun��o para andar para direita

	/**
	 * Busca uma nova configura��o para a Unidade Solu��o do indice i.
	 * @param i
	 */
	public void vizinhoBuscaConfiguracao(int i) {
		this.pegaUnidadeSolucaoIndice(i).geraFatorTamanho();
	}

	public Solucao copy() {
		Solucao copied = new Solucao(modelo);
		
		for (int i = 0; i < modelo.pegaNumeroComponentes(); i++) {
			UnidadeSolucao item = this.solucao[i];
			copied.solucao[i] = new UnidadeSolucao(item.getFatorPosicao(), item.getFatorTamanho());
		}
		return copied;
	}

	public void mudaFatorPosicaoIndice(int i) {
		this.pegaUnidadeSolucaoIndice(i).geraFatorPosicao();
	}
}