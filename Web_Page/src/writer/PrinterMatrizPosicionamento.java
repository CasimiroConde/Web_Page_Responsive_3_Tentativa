package writer;

import instancia.MatrizPosicionamento;
import instancia.Solucao;
import classes.Modelo;

public class PrinterMatrizPosicionamento 
{
	public static StringBuffer executa(MatrizPosicionamento matriz, Solucao solucao, Modelo modelo)
	{
		StringBuffer buffer = new StringBuffer();
	
		//buffer.append("<div style='display: table'>");
		buffer.append("<div>");
		for(int i = 0 ; i < matriz.getLinhas() ; i++){
			//buffer.append("<div style='display: table-row'>");
			buffer.append("<div>");
			for(int j = 0 ; j < matriz.getColunas() ; j++){
				if(matriz.getCelula(i, j) != -1){
					//buffer.append("<div style='display: table-cell'>");
					String nomeArquivo = solucao.pegaUnidadeSolucaoIndice(matriz.getCelula(i, j)).geraNomeFonte(modelo.pegaComponenteIndice(matriz.getCelula(i, j)));
					buffer.append("<img src='C:/Users/Casimiro/git/Web_Responsive/Web_Page/componentes_food_sense/"+ nomeArquivo + ".PNG'>");	
					//buffer.append("</div>");
				}
			}
			buffer.append("</div>");
		}
		buffer.append("</div>");		

		return buffer;
	}
}