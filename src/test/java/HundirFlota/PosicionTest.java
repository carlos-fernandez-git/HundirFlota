package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class PosicionTest {

	@Test
	public void test() {
		Posicion b=new Posicion();
		String res_0 = "Hola"; 
		assertEquals(res_0,b.getPosicion()); 
	}

}
