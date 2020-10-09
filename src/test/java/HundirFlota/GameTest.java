package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void test() {
		Game b=new Game();
		String res_0 = "Hola"; 
		assertEquals(res_0,b.getGame()); 
	}

}
