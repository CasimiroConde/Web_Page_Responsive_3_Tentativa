package hillClimbing;

import lombok.Data;
import instancia.Solucao;
import classes.Modelo;

public @Data class HillClimbing {
	
	static private int INTERACOES = 500;
	private Solucao solucao; // fator de otimização
	private int totalNOK = 0;
	private int totalOK = 0;

	public void executa(Modelo modelo) {
		this.solucao = new Solucao(modelo);
		Solucao solucaoTeste = solucao.copy();
		
		for(int j = 0; j < INTERACOES; j++){
			if(solucaoTeste.validaSolucao(modelo)) {
				for (int i = 0; i < modelo.pegaNumeroComponentes(); i++) {
					if (testeVizinho(i, solucaoTeste)) {
						solucao = solucaoTeste.copy(); //new Solucao(solucaoTeste);
						break;
					}
				}
				totalOK++;
				System.out.println("OK" + j);
			}
			else {
				solucaoTeste = new Solucao(modelo);
				totalNOK++;
				System.out.println("NOK" + j);
			}
		}
		System.out.println("Total OK: " + totalOK );
		System.out.println("Total NOK: " + totalNOK );
		solucao.print();
		//WebPageWriter.geraPaginaWeb(solucao);
	}

	private boolean testeVizinho(int numeroComponente, Solucao solucaoTeste) {
		//Como retornar assim que encontrar a primeira combinação melhor?
		//Sobe uma Linha
		solucaoTeste.vizinhoSobeLinha(numeroComponente);

		if(solucaoTeste.fitnessFunction() < solucao.fitnessFunction())
			return true;
		
		//Desde uma Linha
		solucaoTeste.vizinhoDesceLinha(numeroComponente);

		if(solucaoTeste.fitnessFunction() < solucao.fitnessFunction())
			return true;
		
		//esquerda


		//Direita


		//Busca comfiguracao semelhante
		solucaoTeste.vizinhoBuscaConfiguracao(numeroComponente);

		if(solucaoTeste.fitnessFunction() < solucao.fitnessFunction())
			return true;
		
		return false;
	}
}