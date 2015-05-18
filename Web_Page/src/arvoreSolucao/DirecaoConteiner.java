package arvoreSolucao;

import lombok.Getter;

public enum DirecaoConteiner {
	Vertical("v"),
	Horizontal("h");
	
	private @Getter String codigo;
	
	private DirecaoConteiner(String codigo)
	{
		this.codigo = codigo;
	}
	
	public static DirecaoConteiner get(String codigo)
	{
		for (DirecaoConteiner d : values())
			if (d.getCodigo().compareTo(codigo) == 0)
				return d;
		
		return null;
	}
}