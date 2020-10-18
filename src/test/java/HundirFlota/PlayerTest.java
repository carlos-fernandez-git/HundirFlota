package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testconstructor() {
		Player b=new Player();
	}
	@Test
	public void testgetNombre() {
		Player b=new Player("Adri");
		String res_0 ="Adri";
		assertEquals(res_0,b.getNombre());
	}
	@Test
	public void testsetNombre() {
		Player b=new Player();
		b.setNombre("Arnau");
		String res_0 = "Arnau";
		assertEquals(res_0,b.getNombre());
	}

	@Test
	public void testsetygetTurno() {
		Player b=new Player();
		b.setTurno(2);
		int res_0 = 2;
		assertEquals(res_0,b.getTurno());
	}



}
