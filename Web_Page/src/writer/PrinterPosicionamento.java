package writer;

import arvoreSolucao.DirecaoConteiner;
import arvoreSolucao.Node;
import instancia.Solucao;
import classes.Modelo;

public class PrinterPosicionamento 


{
	  public static StringBuffer executa(Node arvore, Modelo modelo) {
		  StringBuffer buffer = new StringBuffer();
		  
		//  buffer.append("<div " + "style='float:left; width:" + arvore.getConteiner().getTamanho() + "'" + ">");
		  
		  executaFolhas(arvore, modelo, buffer);
		//  buffer.append("</div>");
		  return buffer;
	  }

	private static void executaFolhas(Node arvore, Modelo modelo,
			StringBuffer buffer) {
		
		for (Node child : arvore.getLeafs()) {
			 
			 if(child.getConteiner() != null){
				String style;
				if(child.contemElemento()){
					style = "style='float:left; width:" + child.getConteiner().getLargura() + "; heigth:" + child.getConteiner().getAltura() +  "'";		
				} else {
					style = "style='float:left;'";	
				}
				
				buffer.append("<div " + style + ">");
				buffer.append(executa(child, modelo));	
			 } else{
				String nomeArquivo = child.getElemento().geraNome(modelo);
				buffer.append("<img src='C:/Users/Casimiro/git/WebResponsive/Web_Page/componentes_food_sense/"+ nomeArquivo + ".PNG'>");	
			 } 
		  }
		  buffer.append("</div>");
	
	}

}