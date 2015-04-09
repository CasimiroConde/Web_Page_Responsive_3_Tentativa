package instancia;

import classes.Modelo;

public class DimensoesPosicionamento {

	public static int executaAltura(Solucao solucao, Modelo modelo)
	{
		Solucao ordenadaAltura = solucao.copy();
		ordenadaAltura.ordenaAltura();
		int alturaTotal = 0;
		
		for(int i = 0 ; i < ordenadaAltura.tamanhoSolucao(); i++){
			if((ordenadaAltura.pegaUnidadeSolucaoIndice(i).getY() + ordenadaAltura.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente()) > alturaTotal){
				alturaTotal = ordenadaAltura.pegaUnidadeSolucaoIndice(i).getY() + ordenadaAltura.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente();
			}
		}
		
		return alturaTotal;
	}

	
	public static int executaLargura(Solucao solucao, Modelo modelo)
	{
		Solucao ordenadaLargura = solucao.copy();
		ordenadaLargura.ordenaLargura();
		int larguraTotal = 0;
		
		for(int i = 0 ; i < ordenadaLargura.tamanhoSolucao(); i++){
			if((ordenadaLargura.pegaUnidadeSolucaoIndice(i).getX() + ordenadaLargura.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente()) > larguraTotal){
				larguraTotal = ordenadaLargura.pegaUnidadeSolucaoIndice(i).getX() + ordenadaLargura.pegaUnidadeSolucaoIndice(i).pegaAlturaComponente();
			}
		}

		return larguraTotal;
	}

		
}
