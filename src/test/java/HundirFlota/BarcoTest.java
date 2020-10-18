package HundirFlota;

import static org.junit.Assert.*;


import org.junit.Test;

public class BarcoTest {

	@Test
	public void testgetBarco() {
		Barco b=new Barco();
		String res_0 = "Hola"; 
		assertEquals(res_0,b.getBarco()); 
	}
	@Test
	public void testsetBarco() {
		Barco b=new Barco();
		String res_0 = "Hola"; 
		b.setBarco(res_0);
		assertEquals(res_0,b.getBarco()); 
	}
	public void testconstructorBarco() {
		Barco b=new Barco();
	}

}
