package montagemEstatica;

import classes.Modelo;
import instancia.Solucao;

public class Montagem {
	
	public static Solucao montagemUm(Modelo modelo){
		
		Solucao solucao = new Solucao(modelo);
		
		//Um
		solucao.pegaUnidadeSolucaoIndice(0).setX(0);
		solucao.pegaUnidadeSolucaoIndice(0).setY(0);
		solucao.pegaUnidadeSolucaoIndice(0).setFatorTamanho(0);

		//Dois
		solucao.pegaUnidadeSolucaoIndice(1).setX(0);
		solucao.pegaUnidadeSolucaoIndice(1).setY(120);
		solucao.pegaUnidadeSolucaoIndice(1).setFatorTamanho(0);

		//Tres
		solucao.pegaUnidadeSolucaoIndice(2).setX(160);
		solucao.pegaUnidadeSolucaoIndice(2).setY(0);
		solucao.pegaUnidadeSolucaoIndice(2).setFatorTamanho(0);
		
		//Quatro
		solucao.pegaUnidadeSolucaoIndice(3).setX(160);
		solucao.pegaUnidadeSolucaoIndice(3).setY(446);
		solucao.pegaUnidadeSolucaoIndice(3).setFatorTamanho(0);
		
		//Cinco
		solucao.pegaUnidadeSolucaoIndice(4).setX(384);
		solucao.pegaUnidadeSolucaoIndice(4).setY(446);
		solucao.pegaUnidadeSolucaoIndice(4).setFatorTamanho(0);
		
		//Seis
		solucao.pegaUnidadeSolucaoIndice(5).setX(608);
		solucao.pegaUnidadeSolucaoIndice(5).setY(446);
		solucao.pegaUnidadeSolucaoIndice(5).setFatorTamanho(0);
		
		//Sete
		solucao.pegaUnidadeSolucaoIndice(6).setX(832);
		solucao.pegaUnidadeSolucaoIndice(6).setY(446);
		solucao.pegaUnidadeSolucaoIndice(6).setFatorTamanho(0);
		
		//Oito
		solucao.pegaUnidadeSolucaoIndice(7).setX(160);
		solucao.pegaUnidadeSolucaoIndice(7).setY(531);
		solucao.pegaUnidadeSolucaoIndice(7).setFatorTamanho(0);
		
		//Nove
		solucao.pegaUnidadeSolucaoIndice(8).setX(160);
		solucao.pegaUnidadeSolucaoIndice(8).setY(582);
		solucao.pegaUnidadeSolucaoIndice(8).setFatorTamanho(0);
		
		//Dez
		solucao.pegaUnidadeSolucaoIndice(9).setX(380);
		solucao.pegaUnidadeSolucaoIndice(9).setY(582);
		solucao.pegaUnidadeSolucaoIndice(9).setFatorTamanho(0);
		
		//Onze
		solucao.pegaUnidadeSolucaoIndice(10).setX(600);
		solucao.pegaUnidadeSolucaoIndice(10).setY(582);
		solucao.pegaUnidadeSolucaoIndice(10).setFatorTamanho(0);
		
		//Doze
		solucao.pegaUnidadeSolucaoIndice(11).setX(820);
		solucao.pegaUnidadeSolucaoIndice(11).setY(582);
		solucao.pegaUnidadeSolucaoIndice(11).setFatorTamanho(0);
		
		//Treze
		solucao.pegaUnidadeSolucaoIndice(12).setX(0);
		solucao.pegaUnidadeSolucaoIndice(12).setY(446);
		solucao.pegaUnidadeSolucaoIndice(12).setFatorTamanho(0);
		
		//Quatorze
		solucao.pegaUnidadeSolucaoIndice(13).setX(0);
		solucao.pegaUnidadeSolucaoIndice(13).setY(563);
		solucao.pegaUnidadeSolucaoIndice(13).setFatorTamanho(0);
		
		//Quinze
		solucao.pegaUnidadeSolucaoIndice(14).setX(0);
		solucao.pegaUnidadeSolucaoIndice(14).setY(950);
		solucao.pegaUnidadeSolucaoIndice(14).setFatorTamanho(0);

		
		return solucao;
		
		
	}
	
}
