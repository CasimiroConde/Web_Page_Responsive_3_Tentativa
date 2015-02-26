package classes;

import java.util.ArrayList;

import lombok.Getter;
import enums.Direcao;
import enums.TipoRelacao;

/*Classe que representa o relacionamento entre 2 componentes
 * 
 */
public class Relacao {

	private @Getter Componente comp_1;			
	private @Getter Componente comp_2;			
	private @Getter TipoRelacao tipoRelacao;
	private @Getter ArrayList<Direcao> direcao;

	public Relacao(Componente comp_1, Componente comp_2, TipoRelacao tipoRelacao,
			ArrayList<Direcao> dir) {
		super();
		this.comp_1 = comp_1;
		this.comp_2 = comp_2;
		this.tipoRelacao = tipoRelacao;
		this.direcao = new ArrayList<Direcao>();
		
		for (Direcao d : dir){
			this.direcao.add(d);
		}
		
	}

	public void print() {
		System.out.println(this.comp_1.getNome() + ";" + this.comp_2.getNome() + ";"
				+ this.tipoRelacao + ";" + this.direcao);
	}
}