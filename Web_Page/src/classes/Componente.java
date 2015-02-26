package classes;

import lombok.Getter;

/* Componentes existentes em uma p�gina web.
 * Um componente possui uma configura��o.
 */
public class Componente {

	private @Getter String nome;
	private @Getter Configuracao configuracao;

	public Componente(String nome, Configuracao configuracao) {
		this.nome = nome;
		this.configuracao = configuracao;
	}

	public void print() {
		System.out.println(this.nome + ";");
		System.out.print(" ------ ");
		this.configuracao.print();
	}
}