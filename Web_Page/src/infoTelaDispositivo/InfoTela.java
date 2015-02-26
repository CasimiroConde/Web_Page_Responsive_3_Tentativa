package infoTelaDispositivo;

import java.awt.Dimension;
import java.awt.Toolkit;

import lombok.Data;

public @Data class InfoTela {

	Dimension d;
	
	public Dimension pegaDimensoesTela(){
		Toolkit tk = Toolkit.getDefaultToolkit();  
	    this.d = tk.getScreenSize();  
	    return d;
	}
	
	public double pegaAlturaTela(){
		return d.getHeight();
	}
	
	public double pegaLarguraTela(){
		return d.getWidth();
	}	
}
