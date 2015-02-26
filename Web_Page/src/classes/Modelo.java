package classes;

import java.util.ArrayList;
import java.util.List;

import enums.Direcao;
import enums.TipoRelacao;

public class Modelo {
	private List<Componente> componentes;
	private List<Configuracao> configuracoes;
	private List<Relacao> relacoes;
	
	public Modelo() {
		componentes = new ArrayList<Componente>();
		configuracoes = new ArrayList<Configuracao>();
		relacoes = new ArrayList<Relacao>();
	}

	public Iterable<Componente> getComponentes() {
		return componentes;
	}

	public Iterable<Configuracao> getConfiguracoes() {
		return configuracoes;
	}

	public Iterable<Relacao> getRelacoes() {
		return relacoes;
	}

	public Configuracao pegaConfiguracaoNome(String name) {
		for (Configuracao c : configuracoes)
			if (c.getNome().compareToIgnoreCase(name) == 0)
				return c;
		
		return null;
	}

	public Configuracao adicionaConfiguracao(String name, String largura, String altura, double coeficienteInformacao) {
		Configuracao config = pegaConfiguracaoNome(name);
		
		if (config == null){
			config = new Configuracao(name);
			configuracoes.add(config);
		}

		config.addCaracteristicas(largura, altura, coeficienteInformacao);
		return config;
	}

	public Componente adicionaComponente(String comp, Configuracao configuracao) {
		Componente componente = new Componente(comp, configuracao);
		componentes.add(componente);
		return componente;
	}

	public Relacao adicionaRelacao(Componente comp_1, Componente comp_2, TipoRelacao tipo_relac, ArrayList<Direcao> relac) {
		Relacao relacao = new Relacao(comp_1, comp_2, tipo_relac, relac);
		relacoes.add(relacao);
		return relacao;
	}

	public Componente pegaComponenteNome(String comp) {
		for (Componente c : componentes)
			if (c.getNome().compareToIgnoreCase(comp) == 0)
				return c;
		
		return null;
	}
	
	public int pegaNumeroComponentes(){
		return this.componentes.size();
	}
	
	public int pegaNumeroRelacoes(){
		return this.relacoes.size();
	}
	
	public Componente pegaComponenteIndice(int indice){
		return this.componentes.get(indice);
	}
	
	public int pegaIndiceComponente(Componente componente){
		for(int i = 0 ; i < this.pegaNumeroComponentes() ; i ++){
			if(this.pegaComponenteIndice(i).equals(componente))
				return i;		
		}
		return 0;
	}
	
	public Relacao pegaRelacaoIndice(int indice){
		return this.relacoes.get(indice);
	}
	
}