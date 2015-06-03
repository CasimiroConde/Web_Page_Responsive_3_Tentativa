package hillClimbing;

import instancia.Solucao;
import lombok.Data;
import classes.Modelo;

public @Data class HillClimbing {
	
	static private int INTERACOES = 1000;
	private Solucao solucao; // fator de otimização
	private int totalNOK = 0;
	private int totalOK = 0;

	/*public void executa(Modelo modelo) {
		this.solucao = new Solucao(modelo);
		Solucao solucaoTeste = solucao.copy();
		
		for(int j = 0; j < INTERACOES; j++){
			if(solucaoTeste.validaSolucao(modelo)) {
				for (int i = 1; i < modelo.pegaNumeroComponentes(); i++) {
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
*/}