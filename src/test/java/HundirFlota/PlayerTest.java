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

}
