package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void test() {
		Board b=new Board();
		String res_0 = "Hola"; 
		assertEquals(res_0,b.getBoard()); 
	}

}
