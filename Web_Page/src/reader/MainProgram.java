package reader;

import hillClimbing.HillClimbing;
import instancia.DimensoesPosicionamento;
import instancia.Solucao;

import java.io.IOException;

import writer.WebPageWriter;
import classes.Modelo;

public class MainProgram {

	/**
	 * Núcleo o programa.
	 * Esse algoritmo tem como objetivo gerar uma página web responsivel dinâmica, de acordo
	 * com as informações dos componentes definidas pelo WebDesginer.
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
			
		/*
		WebPageWriter.geraPaginaWeb(testeHillClimbing.getSolucao(), modelo);*/
		
		HillClimbing testeHillClimbing = new HillClimbing();
		testeHillClimbing.executa(modelo);
		WebPageWriter.geraPaginaWeb(testeHillClimbing.getSolucao(), modelo);
		
		System.out.println("FIM");
	}
}