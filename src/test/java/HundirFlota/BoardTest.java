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
		boolean value=b.checkSpace(0, 5, 5);  //vertical space from first line true (nearest to another boat)
		assertTrue(value);
		boolean value5=b.checkSpace(0, 6, 5);	//vertical space from first line true
		assertTrue(value5);
		boolean value6=b.checkSpace(0, 7, 5);	//vertical space from first line (with another boat at the same direction in the right column)
		assertFalse(value6);
		boolean value2=b.checkSpace(1, 0, 5);		//horizontal space false (another boat at the same direction in a line updown)
		assertFalse(value2);
		boolean val=b.checkSpace(1, 1, 5);		//horizontal space true (another boat at the same direction in a line updown)
		assertTrue(val);
		//At this point we discover that the checkSpaceTest has to be called from the insert
		//boatFirstPosition to tell the user if the boat can be landed there although the 
		//firstPosition is empty
		//Knowing that, we can reduce the test to values inside the limits of the board, the other values
		//are checked in the function InsertBoatFirstPosition
		
		//Testing the coverage of the board class at this point we can see that this function is coverage
		//at 55 per cent, so we have to add more sentences to complete the full coverage
		
		//vertical space left false
		boolean value7=b.checkSpace(0, 9, 5);
		assertFalse(value7);
		
		//vertical space from last line true
		boolean value8=b.checkSpace(9, 0, 5);
		assertTrue(value8);
		
		//vertical space from a middle line true
		boolean value9=b.checkSpace(9, 4, 5);
		assertTrue(value9);
		
		//Horizontal space from last line true
		boolean value10=b.checkSpace(9, 9, 5);
		assertTrue(value10);
		
		////Horizontal space from middle line left true
		boolean value11=b.checkSpace(7, 6, 5);
		assertTrue(value11);
		
		//New board to test the other cases
		Board b2=new Board();
		MockOb mock2=new MockOb();
		int[][] a2=mock2.getTablero(4);
		b2.setTablero(a2);
		System.out.println(b2.mostrarTablero());
		
		//Horizontal space left line false up
		boolean value12=b2.checkSpace(3, 9, 5);
		assertFalse(value12);
				
		////Horizontal space left line down false
		boolean value13=b2.checkSpace(5, 9, 5);
		assertFalse(value13);
		
		//vertical space left false from down
		boolean value14=b2.checkSpace(8, 0, 5);
		assertFalse(value14);
				
		//vertical space right from down false
		boolean value15=b2.checkSpace(8, 2, 5);
		assertFalse(value15);
				
		//horizontal space up right false
		boolean value16=b2.checkSpace(1, 1, 5);
		assertFalse(value16);
		
		//at this point we need to check the true cases at the conditions
		
		//Horizontal space left line true up
		boolean value17=b2.checkSpace(3, 8, 5);
		assertTrue(value17);
				
		//Horizontal space left line down true
		boolean value18=b2.checkSpace(5, 8, 5);
		assertTrue(value18);
		
		//vertical space left true from true
		boolean value19=b2.checkSpace(7, 0, 5);
		assertTrue(value19);
				
		//vertical space right from down true
		boolean value20=b2.checkSpace(7, 2, 5);
		assertTrue(value20);
				
		//horizontal space up right true
		boolean value21=b2.checkSpace(0, 1, 5);
		assertTrue(value21);

		boolean value22=b2.checkSpace(5, 0, 5);
		assertTrue(value22);

		boolean value23=b2.checkSpace(5, 2, 5);
		assertTrue(value23);
		
		
		//Horizontal space right line true up
		boolean value24=b2.checkSpace(3, 4, 5);
		assertTrue(value24);
				
		//Horizontal space right line down true
		boolean value25=b2.checkSpace(5, 4, 5);
		assertTrue(value25);
		
		//So after adding more cases to get full coverage, we need to check for the other tipes of boats
		
	}
	@Test
	public void testCheckSpace2() {
		//The user can not put boats together in the same direction
		Board b=new Board();
		MockOb mock=new MockOb();
		int[][] a=mock.getTablero(5);
		b.setTablero(a);
		System.out.println(b.mostrarTablero());
		//Buque (4 positions)
		boolean value=b.checkSpace(0, 5, 4);  //vertical space from first line true (nearest to another boat)
		assertTrue(value);
		boolean value5=b.checkSpace(0, 6, 4);	//vertical space from first line true
		assertTrue(value5);
		boolean value6=b.checkSpace(0, 7, 4);	//vertical space from first line (with another boat at the same direction in the right column)
		assertFalse(value6);
		boolean value2=b.checkSpace(1, 0, 4);		//horizontal space false (another boat at the same direction in a line updown)
		assertFalse(value2);
		boolean val=b.checkSpace(1, 1, 4);		//horizontal space true (another boat at the same direction in a line updown)
		assertTrue(val);
		
		//vertical space left false
		boolean value7=b.checkSpace(0, 9, 4);
		assertFalse(value7);
		
		//vertical space from last line true
		boolean value8=b.checkSpace(9, 0, 4);
		assertTrue(value8);
		
		//vertical space from a middle line true
		boolean value9=b.checkSpace(9, 4, 4);
		assertTrue(value9);
		
		//Horizontal space from last line true
		boolean value10=b.checkSpace(9, 9, 4);
		assertTrue(value10);
		
		////Horizontal space from middle line left true
		boolean value11=b.checkSpace(7, 6, 4);
		assertTrue(value11);
		
		//New board to test the other cases
		Board b2=new Board();
		MockOb mock2=new MockOb();
		int[][] a2=mock2.getTablero(6);
		b2.setTablero(a2);
		System.out.println(b2.mostrarTablero());
		
		//Horizontal space left line false up
		boolean value12=b2.checkSpace(3, 8, 4);
		assertFalse(value12);
				
		////Horizontal space left line down false
		boolean value13=b2.checkSpace(5, 8, 4);
		assertFalse(value13);
		
		//vertical space left false from down
		boolean value14=b2.checkSpace(7, 0, 4);
		assertFalse(value14);
				
		//vertical space right from down false
		boolean value15=b2.checkSpace(7, 2, 4);
		assertFalse(value15);
				
		//horizontal space up right false
		boolean value16=b2.checkSpace(1, 1, 4);
		assertFalse(value16);
		
		//Horizontal space left line true up
		boolean value17=b2.checkSpace(3, 9, 4);
		assertTrue(value17);
				
		//Horizontal space left line down true
		boolean value18=b2.checkSpace(5, 9, 4);
		assertTrue(value18);
		
		//vertical space left true from true
		boolean value19=b2.checkSpace(8, 0, 4);
		assertTrue(value19);
				
		//vertical space right from down true
		boolean value20=b2.checkSpace(8, 2, 4);
		assertTrue(value20);
				
		//horizontal space up right true
		boolean value21=b2.checkSpace(0, 1, 4);
		assertTrue(value21);

		boolean value22=b2.checkSpace(5, 2, 4);
		assertTrue(value22);

		boolean value23=b2.checkSpace(5, 0, 4);
		assertTrue(value23);
		
		
		//Horizontal space right line true up
		boolean value24=b2.checkSpace(3, 4, 4);
		assertTrue(value24);
				
		//Horizontal space right line down true
		boolean value25=b2.checkSpace(5, 4, 4);
		assertTrue(value25);
		
	}
	

}
