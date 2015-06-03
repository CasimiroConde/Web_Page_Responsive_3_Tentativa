package writer;

import instancia.Solucao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import arvoreSolucao.Node;
import classes.Modelo;

/**
 * @author Casimiro
 *
 */
public class WebPageWriter {
	
	private static BufferedWriter out;
	

	/**
	 * Fun��oi que gera a p�gina Web da solu��o.
	 * @param solucao
	 * @throws IOException
	 */
	public static void geraPaginaWeb(Node arvore, Modelo modelo) throws IOException{
	    StringBuilder buffer = new StringBuilder();
	    
	    geraCabecalho(buffer);
	    iniciaBody(buffer, arvore);
	    geraConteudo(arvore, buffer, modelo);
	    encerraBody(buffer);
	    encerraArquivo(buffer);
	    
	    geraArquivoHtml(buffer);
	}

	/**
	 * Fun��o respons�vel por gerar o conte�d da p�gina web da solu��o
	 * @param solucao
	 * @param buffer
	 */
	private static void geraConteudo(Node arvore, StringBuilder buffer, Modelo modelo) {
		
		buffer.append(PrinterPosicionamento.executa(arvore ,modelo));

    }



	/**
	 * Inicia um <div>
	 * @param buffer
	 */
//	private static void encerraDiv(StringBuilder buffer) {
//		buffer.append("</div>");
//	}

	/**
	 * Encerra um <div>
	 * @param buffer
	 */
	private static void iniciaDiv(StringBuilder buffer) {
		buffer.append("<div>");
	}

	/**
	 * Fun��o respons�vel por gerar o arquivo HTML, contendo as informa��es armazenadas em buffer.
	 * @param buffer
	 * @throws IOException
	 */
	private static void geraArquivoHtml(StringBuilder buffer)
			throws IOException {
		FileWriter fstream = new FileWriter("dados_saida/MyHtml.html");
	    out = new BufferedWriter(fstream);
	    out.write(buffer.toString());
	    out.close();
	}

	/**
	 * Encerra a tag <html>
	 * @param buffer
	 */
	private static void encerraArquivo(StringBuilder buffer) {
		buffer.append("</html>");
	}

	/**
	 * Insere os componentes montando uma imagem que ser� exibida na p�gina web.
	 * @param buffer
	 * @param nomeFonte
	 */
	private static void geraImagem(StringBuilder buffer, String nomeFonte) {
		buffer.append("<img src='componentes_food_sense/"+ nomeFonte + ".PNG'>");	
	}

	/**
	 * Encerra a tag <body>
	 * @param buffer
	 */
	private static void encerraBody(StringBuilder buffer) {
		buffer.append("</body>");
	}

	/**
	 * Inicia a tag <body>
	 * @param buffer
	 */
	private static void iniciaBody(StringBuilder buffer, Node arvore) {
		buffer.append("<body style='float:left; width:" + arvore.getConteiner().getLargura() + "; heigth:" + arvore.getConteiner().getAltura() +  "'>");
	}

	/**
	 * Gera o cabe�alho da p�gina web.
	 * @param buffer
	 */
	private static void geraCabecalho(StringBuilder buffer) {
		buffer.append("<html>");
	    buffer.append("<head>");
	    buffer.append("<title>Web P�gina Respons�va</title>");
	    buffer.append("</head>");
	}

}