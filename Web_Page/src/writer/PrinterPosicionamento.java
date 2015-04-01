package writer;

import instancia.Solucao;
import classes.Modelo;

public class PrinterPosicionamento 
{
	public static StringBuffer executa(Solucao solucao, Modelo modelo)
	{
		StringBuffer buffer = new StringBuffer();
		
		for(int i = 0 ; i < solucao.tamanhoSolucao() ; i++){
			buffer.append("<div style='position: absolute; top:" + solucao.pegaUnidadeSolucaoIndice(i).getX() + "px; left:" + solucao.pegaUnidadeSolucaoIndice(i).getY() + "px;'>");
			String nomeArquivo = solucao.pegaUnidadeSolucaoIndice(i).geraNomeFonte();
			buffer.append("<img src='C:/Users/Casimiro/git/WebResponsive/Web_Page/componentes_food_sense/"+ nomeArquivo + ".PNG'>");	
			buffer.append("</div>");
		}
	
		return buffer;
	}
}