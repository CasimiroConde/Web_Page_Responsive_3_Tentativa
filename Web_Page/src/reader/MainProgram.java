package reader;

import hillClimbing.HillClimbing;

import java.io.IOException;

import ordenacao.Ordenacao;
import writer.WebPageWriter;
import classes.Modelo;
import classes.Relacao;

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
		Modelo modelo = reader.execute("C:/Users/Casimiro/Documents/Casimiro Conde/Aulas/Mestrado/Estudo Dirigido 2/Diserta��o Responsiva/Arquivos/tudo.txt");

		/*for (Configuracao config : modelo.getConfiguracoes())
			config.print();

		for (Componente comp : modelo.getComponentes())
			comp.print();

		for (Relacao relac : modelo.getRelacoes())
			relac.print();*/
		
		Ordenacao ordenacao = new Ordenacao(modelo);

		ordenacao.executaAbove();
		
		//HillClimbing testeHillClimbing = new HillClimbing();
		//testeHillClimbing.executa(modelo);
		//WebPageWriter.geraPaginaWeb(testeHillClimbing.getSolucao(), modelo);

		System.out.println("FIM");
	}
}