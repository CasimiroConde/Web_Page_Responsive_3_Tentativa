package enums;

import lombok.Getter;

public enum TipoRelacao {
	POSITION("position"), SIZE("size"), SAMESIZE("same size");
	
	private @Getter String nome;

	private TipoRelacao(String nome) {
		this.nome = nome;
	}

	public static TipoRelacao get(String nome) {
		for (TipoRelacao d : values())
			if (d.getNome().compareToIgnoreCase(nome) == 0)
				return d;

		return null;
	}
}
