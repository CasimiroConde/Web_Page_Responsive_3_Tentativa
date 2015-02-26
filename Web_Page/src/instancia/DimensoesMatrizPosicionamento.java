package instancia;

import classes.Modelo;

public class DimensoesMatrizPosicionamento {

	public static int executaAltura(MatrizPosicionamento matrix, Solucao solucao, Modelo modelo)
	{
		int alturaTotal = 0;
		int alturaLinha = 0;
	
		
		for(int i = 0 ; i < matrix.getLinhas() ; i++){
			for(int j = 0 ; j < matrix.getColunas() ; j++){
				if(matrix.getCelula(i, j) >= 0){
					if(solucao.pegaUnidadeSolucaoIndice(matrix.getCelula(i, j)).pegaAlturaComponente(modelo.pegaComponenteIndice(matrix.getCelula(i, j))) > alturaLinha){
						alturaLinha = solucao.pegaUnidadeSolucaoIndice(matrix.getCelula(i, j)).pegaAlturaComponente(modelo.pegaComponenteIndice(matrix.getCelula(i, j)));
					}
				}
			}
			alturaTotal += alturaLinha;
			alturaLinha = 0;
		}

		return alturaTotal;
	}

	
	public static int executaLargura(MatrizPosicionamento matrix, Solucao solucao, Modelo modelo)
	{
		int larguraTotal = 0;
		int larguraLinha = 0;
	
		
		for(int i = 0 ; i < matrix.getLinhas() ; i++){
			for(int j = 0 ; j < matrix.getColunas() ; j++){
				if(matrix.getCelula(i, j) >= 0){
						larguraLinha += solucao.pegaUnidadeSolucaoIndice(matrix.getCelula(i, j)).pegaLarguraComponente(modelo.pegaComponenteIndice(matrix.getCelula(i, j)));
				}
			}
			if(larguraLinha > larguraTotal)
				larguraTotal = larguraLinha;	
			larguraLinha = 0;
		}
		return larguraTotal;	
	}

		
}
