package HundirFlota;

import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

	@Test
	public void testIniciar() {
		Board b=new Board();
		int num_filas=10;
		int num_columnas=10;
		int[][] tablero=b.getTablero();
		assertEquals(num_filas, tablero.length);
		assertEquals(num_columnas, tablero[0].length);
		assertEquals(num_columnas, tablero[9].length);
		assertEquals(num_columnas, tablero[5].length);
		assertEquals(0, tablero[0][0]);
		assertEquals(0, tablero[0][9]);
		assertEquals(0, tablero[9][0]);
		assertEquals(0, tablero[9][9]);
		assertEquals(0, tablero[5][4]);
	}

	
	//First implementation of Create Boats test (After creating this test, we make the full function
	// on Board.java but the test find errors always)
	public void testcrear() {
		Board b=new Board();
		//b.CrearBarcos();
		//Esta funcion debe interactuar por consola con el usuario
		//Como comprobar que el tablero esta correctamente ocupado, necesitamos saber
		//La decision del usuario
		//int[][] tablero=b.getTablero();
		/*
		assertEquals(1, tablero[0][0]);
		assertEquals(1, tablero[0][9]);
		assertEquals(1, tablero[9][0]);
		assertEquals(1, tablero[9][9]);
		assertEquals(1, tablero[5][4]);
		*/
		int pos=b.posicionesOcupadas();
		assertEquals(pos, 27);
	}
	@Test
	public void testMostrarTablero() {
		String res_0="0 0 0 0 0 0 0 0 0 0 \n"
				+  "0 0 0 0 0 0 0 0 0 0 \n"
				+  "0 0 0 0 0 0 0 0 0 0 \n"
				+  "0 0 0 0 0 0 0 0 0 0 \n"
				+  "0 0 0 0 0 0 0 0 0 0 \n"
				+  "0 0 0 0 0 0 0 0 0 0 \n"
				+  "0 0 0 0 0 0 0 0 0 0 \n"
				+  "0 0 0 0 0 0 0 0 0 0 \n"
				+  "0 0 0 0 0 0 0 0 0 0 \n"
				+  "0 0 0 0 0 0 0 0 0 0 \n";
		Board tablero= new Board();
		Assert.assertEquals(tablero.mostrarTablero(), res_0);
		
	}
	@Test
	public void testPosicionesOcupadas() {
		MockOb mock=new MockOb();
		Board b = new Board();
		int[][] a=mock.getTablero(0);
		b.setTablero(a);
		int pos=b.posicionesOcupadas();
		assertEquals(pos,0);
		Board b2 = new Board();
		int[][] c=mock.getTablero(1);
		b2.setTablero(c);
		int pos2=b2.posicionesOcupadas();
		assertEquals(pos2,5);
		Board b3 = new Board();
		int[][] d=mock.getTablero(2);
		b3.setTablero(d);
		int pos3=b3.posicionesOcupadas();
		assertEquals(pos3,10);
		Board b4 = new Board();
		int[][] f=mock.getTablero(3);
		b4.setTablero(f);
		int pos4=b4.posicionesOcupadas();
		assertEquals(pos4,4);
		
	}
	
	@Test
	public void testInsertBoats1() {
		Board b=new Board();
		//When Board is empty
		boolean res=b.insertBoatfirstpos(0, 0);
		assertTrue(res);
		boolean res2=b.insertBoatfirstpos(0, 9);
		assertTrue(res2);
		boolean res3=b.insertBoatfirstpos(9, 0);
		assertTrue(res3);
		boolean res4=b.insertBoatfirstpos(9, 9);
		assertTrue(res4);
		boolean res5=b.insertBoatfirstpos(4, 5);
		assertTrue(res5);
		boolean res6=b.insertBoatfirstpos(-1, 0);
		assertFalse(res6);
		boolean res7=b.insertBoatfirstpos(0, 10);
		assertFalse(res7);
		boolean res8=b.insertBoatfirstpos(10, 0);
		assertFalse(res8);
		boolean res9=b.insertBoatfirstpos(0, 10);
		assertFalse(res9);
		//When the position choosed is occupied
		MockOb mock=new MockOb();
		int[][] a=mock.getTablero(1);
		b.setTablero(a);
		boolean res10=b.insertBoatfirstpos(0, 1);
		assertFalse(res10);
		boolean res11=b.insertBoatfirstpos(0, 4);
		assertFalse(res11);
		boolean res12=b.insertBoatfirstpos(0, 5);
		assertTrue(res12);
		
	}
	@Test
	public void testCheckSpace() {
		//The user can not put boats together in the same direction
		Board b=new Board();
		MockOb mock=new MockOb();
		int[][] a=mock.getTablero(2);
		b.setTablero(a);
		System.out.println(b.mostrarTablero());
		//Portaviones
		boolean value=b.checkSpace(0, 5, 5);
		assertTrue(value);
		boolean value5=b.checkSpace(0, 6, 5);
		assertTrue(value5);
		boolean value6=b.checkSpace(0, 7, 5);
		assertFalse(value6);
		boolean value2=b.checkSpace(1, 0, 5);
		assertFalse(value2);
		//At this point we discover that the checkSpaceTest has to be called from the insert
		//boatFirstPosition to tell the user the if the boat can be landed there although the 
		//firstPosition is empty
		//Knowing that, we can reduce the test to values inside the limits of the board, the other values
		//are checked in the function InsertBoatFirstPosition
		
		
	}



}
