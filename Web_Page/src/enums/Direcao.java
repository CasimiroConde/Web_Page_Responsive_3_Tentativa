package enums;

import lombok.Getter;

public enum Direcao {
	RIGHT("right"), LEFT("left"), ABOVE("above"), UNDER("under"), EMPTY("empty");

	private @Getter String nome;

	private Direcao(String nome) {
		this.nome = nome;
	}

	public static Direcao get(String nome) {
		for (Direcao d : values())
			if (d.getNome().compareToIgnoreCase(nome) == 0)
				return d;

		return null;
	}
}