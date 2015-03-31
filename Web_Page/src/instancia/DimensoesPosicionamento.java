package instancia;

import classes.Modelo;

public class DimensoesPosicionamento {

	public static int executaAltura(Solucao solucao, Modelo modelo)
	{
		Solucao ordenadaAltura = solucao.copy();
		ordenadaAltura.ordenaAltura();
		
		/*for(int i = 0 ; i < ordenadaAltura.tamanhoSolucao(); i++){
			ordenadaAltura.pegaUnidadeSolucaoIndice(i).print();	
		}
		System.out.println("|||||||||||||||||||||||||||||||||");*/
		
		return ordenadaAltura.pegaUnidadeSolucaoIndice(ordenadaAltura.tamanhoSolucao() - 1).getY() + ordenadaAltura.pegaUnidadeSolucaoIndice(ordenadaAltura.tamanhoSolucao() - 1).pegaAlturaComponente();
	}

	
	public static int executaLargura(Solucao solucao, Modelo modelo)
	{
		Solucao ordenadaLargura = solucao.copy();
		ordenadaLargura.ordenaLargura();
		
		/*for(int i = 0 ; i < ordenadaLargura.tamanhoSolucao(); i++){
			ordenadaLargura.pegaUnidadeSolucaoIndice(i).print();
		}
		System.out.println("|||||||||||||||||||||||||||||||||");*/
		return ordenadaLargura.pegaUnidadeSolucaoIndice(ordenadaLargura.tamanhoSolucao() - 1).getX() + ordenadaLargura.pegaUnidadeSolucaoIndice(ordenadaLargura.tamanhoSolucao() - 1).pegaLarguraComponente();
		
	}

		
}
