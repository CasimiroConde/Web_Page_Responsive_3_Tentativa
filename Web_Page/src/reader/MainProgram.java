package reader;

import static org.junit.Assert.assertEquals;
import hillClimbing.HillClimbing;
import instancia.Solucao;

import java.io.IOException;

import arvoreSolucao.DimensoesPosicionamento;
import arvoreSolucao.GeraArvore;
import arvoreSolucao.Node;
import montagemEstatica.Montagem;
import writer.WebPageWriter;
import classes.Modelo;

public class MainProgram {


	/**
	 * N�cleo o programa.
	 * Esse algoritmo tem como objetivo gerar uma p�gina web responsivel din�mica, de acordo
	 * com as informa��es dos componentes definidas pelo WebDesginer.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		Modelo modelo = reader.execute("Arquivos//tudo.txt");

		/*for (Configuracao config : modelo.getConfiguracoes())
			config.print();

		for (Componente comp : modelo.getComponentes())
			comp.print();

		for (Relacao relac : modelo.getRelacoes())
			relac.print();*/
		
		
		
		Solucao solucao = new Solucao(modelo);
		Node arvore = GeraArvore.executa(solucao.getSolucao(), modelo);
		
		String impressao = arvore.toString();
		
		System.out.println(impressao);
		
		WebPageWriter.geraPaginaWeb(arvore, modelo);

		
		
		
		System.out.println("FIM");
	}
}