package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

	@Test
	public void testget() {
		Board b=new Board();
		String res_0 = "Hola"; 
		assertEquals(res_0,b.getBoard()); 
	}

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

	public void testcrear() {
		Board b=new Board();
		b.CrearBarcos();
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
	



}
