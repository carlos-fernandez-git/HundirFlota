package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testconstructor() {
		Player p1 = new Player();
		p1.setNombre("Arnau");
		assertNotNull(p1.getTablero());
		assertEquals("Arnau",p1.getNombre());
		assertEquals(0,p1.getTurno());
	
		Player p2 = new Player();
		p2.setNombre("Arnau");
		assertNotNull(p2.getTablero());
		assertEquals("Arnau",p2.getNombre());
		assertEquals(0,p2.getTurno());
	}
	@Test
	public void testgetTablero() {
		Player p = new Player();
		Board b = new Board();
		assertNotNull(p.getTablero());
		assertEquals(b.getColumnas(),p.getTablero().getColumnas());
		assertEquals(b.getFilas(),p.getTablero().getFilas());
		assertEquals(b.getColumnas(),p.getTablero().getColumnas());
		
	}
	@Test
	public void iniciarTableroInfo() {
		Player b = new Player();
		b.iniciarTableroInfo();
		String [][] tablero=b.getTableroInfo();
		assertEquals("[-]", tablero[0][0]);
		assertEquals("[-]", tablero[0][9]);
		assertEquals("[-]", tablero[9][0]);
		assertEquals("[-]", tablero[9][9]);
		assertEquals("[-]", tablero[5][4]);
	}
	@Test
	public void testDisparar() {
		Board b = new Board();
		Player p = new Player();
		p.iniciarTableroInfo();
		String [][] tablero=p.getTableroInfo();
		p.disparar(b, 0, 0);
		p.disparar(b, 9, 9);
		p.disparar(b, 5, 4);
		p.disparar(b, 13, 3);
		assertEquals("[O]", tablero[0][0]);
		assertEquals("[-]", tablero[0][9]);
		assertEquals("[-]", tablero[9][0]);
		assertEquals("[O]", tablero[9][9]);
		assertEquals("[O]", tablero[5][4]);
		//added new Tests for full coverage
		p.getTablero().insertBoatLastPosition(0, 8, 4, 8, 5);
		
		System.out.println(b.mostrarTablero()+"aaaa");
		p.disparar(p.getTablero(), 0, 8);
		assertEquals("[X]", tablero[0][8]);
		assertFalse(p.disparar(p.getTablero(), 0, 14));
		assertFalse(p.disparar(p.getTablero(), -1, 14));
		assertFalse(p.disparar(p.getTablero(), 0, -9));
		assertFalse(p.disparar(p.getTablero(), -2, -3));
		assertFalse(p.disparar(p.getTablero(), 14, 14));
		p.disparar(p.getTablero(), 0, 8);
		assertFalse(p.disparar(p.getTablero(), 0, 8));
		
		
	}
	@Test
	public void testsetygetNombre() {
		Player b = new Player();
		b.setNombre("Arnau");
		String res_0 = "Arnau";
		assertEquals(res_0,b.getNombre());
	}

	@Test
	public void testsetygetTurno() {
		Player b = new Player();
		b.setTurno(1);
		int res_0 = 1;
		assertEquals(res_0,b.getTurno());
	}



}
