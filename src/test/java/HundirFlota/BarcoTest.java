package HundirFlota;

import static org.junit.Assert.*;


import org.junit.Test;

public class BarcoTest {

	@Test
	public void testgetBarco() {
		Barco b=new Barco();
		String res_0 = "Porta-aviones"; 
		String res_1 = "Buque";
		String res_2 = "Lancha";
		String[][] resultado=b.getBarco();
		assertEquals(res_0,resultado[0][0]); 
		assertEquals(res_1,resultado[1][0]); 
		assertEquals(res_2,resultado[2][0]); 
		assertEquals("2",resultado[0][1]); 
		assertEquals("3",resultado[1][1]);
		assertEquals("5",resultado[2][1]); 
		assertEquals("5",resultado[0][2]); 
		assertEquals("4",resultado[1][2]);
		assertEquals("1",resultado[2][2]); 
	}
	@Test
	
	public void testconstructorBarco() {
		Barco b=new Barco();
		int fila=3;
		int col=3;
		String resultado[][];
		resultado=b.getBarco();
		assertEquals(fila,resultado.length); 
		assertEquals(col,resultado[0].length); 

		
	}

}
