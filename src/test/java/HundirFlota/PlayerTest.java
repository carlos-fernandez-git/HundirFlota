package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testconstructor() {
		Player p1 = new Player("Arnau");
		assertNotNull(p1.tablero);
		assertEquals("Arnau",p1.getNombre());
		assertEquals(0,p1.getTurno());
		
		Player p2 = new Player("Adri");
		assertNotNull(p2.tablero);
		assertEquals("Arnau",p2.getNombre());
		assertEquals(0,p2.getTurno());
	}
	@Test
	public void iniciarTableroInfo() {
		Player b = new Player("Arnau");
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
		Player p = new Player("Arnau");
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
		
	}
	@Test
	public void testsetygetNombre() {
		Player b = new Player("Adri");
		b.setNombre("Arnau");
		String res_0 = "Arnau";
		assertEquals(res_0,b.getNombre());
	}

	@Test
	public void testsetygetTurno() {
		Player b = new Player("Adri");
		b.setTurno(1);
		int res_0 = 1;
		assertEquals(res_0,b.getTurno());
	}



}
