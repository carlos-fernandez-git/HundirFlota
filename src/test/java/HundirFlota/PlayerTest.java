package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test() {
		Player b=new Player();
		String res_0 = "Hola"; 
		assertEquals(res_0,b.getNombre()); 
	}
	@Test
	public void testconstructor() {
		Player b=new Player();
	}
	@Test
	public void testsetNombre() {
		Player b=new Player();
	}

	@Test
	public void testsetTurno() {
		Player b=new Player();
	}
	@Test
	public void testgetTurno() {
		Player b=new Player();
	}


}
