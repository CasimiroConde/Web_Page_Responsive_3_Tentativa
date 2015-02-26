package classes;

import lombok.Data;

/*Classe que representa as características presentes em uma configuração*/
public @Data class Caracteristica {
	private String largura;
	private String altura;
	private double coeficienteInformacao;
	
	public void print(){
		System.out.print("(");
		System.out.print(this.getAltura() + ", " + this.getLargura() + ", " + this.getCoeficienteInformacao());
		System.out.println(")");
	}
}