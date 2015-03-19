package montagemEstatica;

import classes.Modelo;
import instancia.ConstrutorMatrizPosicionamento;
import instancia.MatrizPosicionamento;
import instancia.Solucao;

public class Montagem {
	
	public static Solucao montagemUm(Modelo modelo){
		
		Solucao solucao = new Solucao(modelo);
		
		//Um
		solucao.pegaUnidadeSolucaoIndice(0).setFatorPosicao(0);
		solucao.pegaUnidadeSolucaoIndice(0).setFatorTamanho(0);

		//Dois
		solucao.pegaUnidadeSolucaoIndice(1).setFatorPosicao(7);
		solucao.pegaUnidadeSolucaoIndice(1).setFatorTamanho(0);

		//Tres
		solucao.pegaUnidadeSolucaoIndice(2).setFatorPosicao(5);
		solucao.pegaUnidadeSolucaoIndice(2).setFatorTamanho(0);
		
		//Quatro
		solucao.pegaUnidadeSolucaoIndice(3).setFatorPosicao(7);
		solucao.pegaUnidadeSolucaoIndice(3).setFatorTamanho(0);
		
		//Cinco
		solucao.pegaUnidadeSolucaoIndice(4).setFatorPosicao(5);
		solucao.pegaUnidadeSolucaoIndice(4).setFatorTamanho(0);
		
		//Seis
		solucao.pegaUnidadeSolucaoIndice(5).setFatorPosicao(5);
		solucao.pegaUnidadeSolucaoIndice(5).setFatorTamanho(0);
		
		//Sete
		solucao.pegaUnidadeSolucaoIndice(6).setFatorPosicao(5);
		solucao.pegaUnidadeSolucaoIndice(6).setFatorTamanho(0);
		
		//Oito
		solucao.pegaUnidadeSolucaoIndice(7).setFatorPosicao(7);
		solucao.pegaUnidadeSolucaoIndice(7).setFatorTamanho(0);
		
		//Nove
		solucao.pegaUnidadeSolucaoIndice(8).setFatorPosicao(7);
		solucao.pegaUnidadeSolucaoIndice(8).setFatorTamanho(0);
		
		//Dez
		solucao.pegaUnidadeSolucaoIndice(9).setFatorPosicao(5);
		solucao.pegaUnidadeSolucaoIndice(9).setFatorTamanho(0);
		
		//Onze
		solucao.pegaUnidadeSolucaoIndice(10).setFatorPosicao(5);
		solucao.pegaUnidadeSolucaoIndice(10).setFatorTamanho(0);
		
		//Doze
		solucao.pegaUnidadeSolucaoIndice(11).setFatorPosicao(5);
		solucao.pegaUnidadeSolucaoIndice(11).setFatorTamanho(0);
		
		//Treze
		solucao.pegaUnidadeSolucaoIndice(12).setFatorPosicao(4);
		solucao.pegaUnidadeSolucaoIndice(12).setFatorTamanho(0);
		
		//Quatorze
		solucao.pegaUnidadeSolucaoIndice(13).setFatorPosicao(7);
		solucao.pegaUnidadeSolucaoIndice(13).setFatorTamanho(0);
		
		//Quinze
		solucao.pegaUnidadeSolucaoIndice(14).setFatorPosicao(7);
		solucao.pegaUnidadeSolucaoIndice(14).setFatorTamanho(0);

		MatrizPosicionamento matriz = ConstrutorMatrizPosicionamento.executa(solucao, modelo);
		solucao.setMatriz(matriz);
		
		return solucao;
		
		
	}
	
}
