package HundirFlota;

import static org.junit.Assert.*;


import org.junit.Test;

public class BarcoTest {

	@Test
	public void test() {
		Barco b=new Barco();
		String res_0 = "Hola"; 
		assertEquals(res_0,b.getBarco()); 
	}

}
