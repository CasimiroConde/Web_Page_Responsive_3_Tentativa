package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Componente;
import classes.Configuracao;
import classes.Modelo;
import enums.Direcao;
import enums.TipoRelacao;

/**
 * 
 * 
 * @author Casimiro
 */
public class Reader {
	
	final static int NUMERO_TOKEN_RELACAO = 5;
	final static int NUMERO_TOKEN_COMPONENTE = 3;
	final static int NUMERO_TOKEN_CONFIGURACAO = 5;
	

	/**
	 * Executa a leitura do arquivo, testando cada uma das tags para identificar 
	 * qual o tipo de informação que erá lida.
	 */
	public Modelo execute(String arquivo) throws FileNotFoundException {
		Modelo modelo = new Modelo();
		Scanner file = new Scanner(new BufferedReader(new FileReader(arquivo)));

		while (file.hasNext()) {
			String linha = file.nextLine();

			if (linha.startsWith("C"))
				carregaConfiguracao(modelo, linha);

			else if (linha.startsWith("I"))
				carregaComponente(modelo, linha);
			
			else if (linha.startsWith("R"))
				carregaRelacao(modelo, linha);
		}
		
		return modelo;
	}

	/**
	 * Responsável por carregar as relações definidas no arquivo de entrada
	 */
	private void carregaRelacao(Modelo modelo, String linha) {
		String[] tokens = linha.split(";");
		
		if(tokens.length==NUMERO_TOKEN_RELACAO){
			String comp_1 = tokens[1].trim();
			String comp_2 = tokens[2].trim();
			String t_relac = tokens[3].trim();
			String rel = tokens[4].trim();
	
			ArrayList<Direcao> relac = new ArrayList<Direcao>();
			TipoRelacao tipo_relac = TipoRelacao.get(t_relac);
			
			readerDirecoes(rel, relac);
			
			Componente c_1 = modelo.pegaComponenteNome(comp_1);
			Componente c_2 = modelo.pegaComponenteNome(comp_2);		
			modelo.adicionaRelacao(c_1, c_2, tipo_relac, relac);
		}
	}

	/**
	 * Responsável por armazenar as relacoes definidas no arquivo.
	 * @param rel
	 * @param relac
	 */
	private void readerDirecoes(String rel, ArrayList<Direcao> relac) {
		if(verificaRelacaoVazia(rel)){
			pegaDirecoes("empty", relac);
		}
		else
		{
		rel = retirarParenteses(rel);
		pegaDirecoes(rel, relac);
		}
	}

	/**
	 * Responsável pela tradução da informação contida no arquivo para o ENUM.
	 * Nesse são definidas todas as possíveis relações.
	 * @param rel
	 * @param relac
	 */
	private void pegaDirecoes(String rel, ArrayList<Direcao> relac) {
		String[] tokens_relac = rel.split(",");
			for(String c : tokens_relac){
				relac.add(Direcao.get(c.trim()));
			}
	}

	/**
	 * Responsável por retirar os "(" e ")" possívelmente existentes no texto das relações.
	 * @param rel
	 * @return
	 */
	private String retirarParenteses(String rel) {
		if(rel.startsWith("(")){
			rel = rel.substring(1, rel.length()-1);
		}
		return rel;
	}

	/**
	 * Responsável por verificar se a relação existente não comtém informação de direção.
	 * @param rel
	 * @return
	 */
	private boolean verificaRelacaoVazia(String rel) {
		if(rel.isEmpty()){
			return true;
		}
		return false;
	}

	/**
	 * Responsável por carregar os componetes definidos no arquivo de carga.
	 */
	private void carregaComponente(Modelo modelo, String linha) {
		String[] tokens = linha.split(";");
		
		if(tokens.length==NUMERO_TOKEN_COMPONENTE){
			String nome = tokens[1].trim();
			String tipo = tokens[2].trim();
			Configuracao configuracao = modelo.pegaConfiguracaoNome(tipo);
			modelo.adicionaComponente(nome, configuracao);
		}
	}

	/**
	 * Responsável por carrega as configurações possíveis. 
	 * Essas serão utilizadas pelos componentes.
	 */
	private void carregaConfiguracao(Modelo modelo, String linha) {
		String[] tokens = linha.split(";");
		
		if(tokens.length==NUMERO_TOKEN_CONFIGURACAO){
			String name = tokens[1].trim();
			String larg = tokens[2].trim();
			String alt = tokens[3].trim();
			String coef_inf = tokens[4].trim();
	
			double coeficienteInformacao = Double.parseDouble(coef_inf) / 100;
			modelo.adicionaConfiguracao(name, larg, alt, coeficienteInformacao);
		}
	}
}