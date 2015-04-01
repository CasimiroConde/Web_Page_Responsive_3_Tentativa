package writer;

import instancia.Solucao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import classes.Modelo;

/**
 * @author Casimiro
 *
 */
public class WebPageWriter {
	
	private static BufferedWriter out;
	

	/**
	 * Funçãoi que gera a página Web da solução.
	 * @param solucao
	 * @throws IOException
	 */
	public static void geraPaginaWeb(Solucao solucao, Modelo modelo) throws IOException{
	    StringBuilder buffer = new StringBuilder();
	    
	    geraCabecalho(buffer);
	    iniciaBody(buffer);
	    geraConteudo(solucao, buffer, modelo);
	    encerraBody(buffer);
	    encerraArquivo(buffer);
	    
	    geraArquivoHtml(buffer);
	}

	/**
	 * Função responsável por gerar o conteúd da página web da solução
	 * @param solucao
	 * @param buffer
	 */
	private static void geraConteudo(Solucao solucao, StringBuilder buffer, Modelo modelo) {
		
		buffer.append(PrinterPosicionamento.executa(solucao,modelo));

    }

	/**
	 * Função responsável pela geraçã das linhas da página Web.
	 * Garante que os componentes localizados na mesma linha serão exibidos dessa forma.
	 * @param solucao
	 * @param buffer
	 * @param indice
	 */
	private static StringBuffer geraLinha(Solucao solucao, int indice, Modelo modelo) {
		StringBuffer sb = new StringBuffer();
		sb.append("<div style='position: absolute; top:" + solucao.pegaUnidadeSolucaoIndice(indice).getX() + "px; left:" + solucao.pegaUnidadeSolucaoIndice(indice).getY() + "px;'>");
		String nomeArquivo = solucao.pegaUnidadeSolucaoIndice(indice).geraNomeFonte();
		sb.append("<img src='componentes_food_sense/"+ nomeArquivo + ".PNG'>");	
		sb.append("</div>");
		return sb;
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
	 * Função responsável por gerar o arquivo HTML, contendo as informações armazenadas em buffer.
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
	 * Insere os componentes montando uma imagem que será exibida na página web.
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
	private static void iniciaBody(StringBuilder buffer) {
		buffer.append("<body>");
	}

	/**
	 * Gera o cabeçalho da página web.
	 * @param buffer
	 */
	private static void geraCabecalho(StringBuilder buffer) {
		buffer.append("<html>");
	    buffer.append("<head>");
	    buffer.append("<title>Web Página Responsíva</title>");
	    buffer.append("</head>");
	}

}