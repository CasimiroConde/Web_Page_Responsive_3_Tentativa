package writer;

import arvoreSolucao.ArvoreSolucao;
import arvoreSolucao.Node;
import instancia.Solucao;
import classes.Modelo;

public class PrinterPosicionamento 


{
	  public static StringBuffer executa(ArvoreSolucao<Node> arvore, Modelo modelo) {
		  StringBuffer buffer = new StringBuffer();
		  
		  for (ArvoreSolucao<Node> child : arvore.getLeafs()) {
			 
			 if(child.getHead().getTipo() == 1){
				String style;
				 	if(child.getHead().getConteiner().getDirecao() == 1){
				 		style = "style='float:left;'";
					 }else{
						 style = "style='float:left; width:" +child.getHead().getConteiner().getTamanho() + "'";
					 }
				buffer.append("<div " + style + ">");
				buffer.append(executa(child, modelo));	
			 } else if(child.getHead().getTipo() == 0){
				String nomeArquivo = child.getHead().getElemento().geraNome(modelo);
				buffer.append("<img src='C:/Users/Casimiro/git/WebResponsive/Web_Page/componentes_food_sense/"+ nomeArquivo + ".PNG'>");	
			 } 
		  }
		  buffer.append("</div>");
		  return buffer;
	  }

}