package validacao;

import static org.junit.Assert.*;
import validacao.Validacao;
import org.junit.Test;

public class TestValidacao {

	@Test
	public void testValidaAlturaTrue() {
		assertEquals(true, Validacao.validaLargura(50 , 100));
	}
	
	@Test
	public void testValidaAlturaFalse() {
		assertEquals(false, Validacao.validaLargura(150 , 100));
	}

}
