package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		Main b=new Main();
		String res_0 = "Hola"; 
		assertEquals(res_0,b.getNombre()); 
	}

}
