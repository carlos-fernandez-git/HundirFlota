package HundirFlota;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void testsetPlayers() {
		Player[] players=new Player[2];
		players[0] =new Player();
		players[0].setNombre("One");
		players[0].setTurno(1);
		players[1] =new Player();
		players[1].setNombre("Two");
		players[1].setNombre("Two");
		players[1].setTurno(2);
		Game g=new Game();
		g.crearJugadores(players);
		assertEquals(players[0].getNombre(), "One");
		assertEquals(players[0].getTurno(), 1);
		assertEquals(players[1].getNombre(), "Two");
		assertEquals(players[1].getTurno(), 2);
		assertEquals(g.getPlayer(0).getNombre(), "One");
		
		//Test with Mock Object
		MockUpPlayer p=new MockUpPlayer();
		g.crearJugadores(p.getPlayers());
		
		assertEquals(g.getPlayers()[0].getNombre(), "Adri");
		assertEquals(g.getPlayers()[0].getTurno(), 1);
		assertEquals(g.getPlayers()[1].getNombre(), "Arnau");
		assertEquals(g.getPlayers()[1].getTurno(), 2);
	}

	@Test
	public void testconstructor() {
		Game b=new Game();
		assertEquals(b.getPlayers().length, 2);
		assertFalse(b.getWinner());
		assertEquals(b.getTurn(), 1);
	}
	
	@Test
	public void BasictestPlay() {
		Game g=new Game();
		Player[] players=new Player[2];
		players[0] =new Player();
		players[0].setNombre("One");
		players[0].setTurno(1);
		players[1] =new Player();
		players[1].setNombre("Two");
		players[1].setNombre("Two");
		players[1].setTurno(2);
		g.crearJugadores(players);
		//g.play();
		//assertTrue(g.getWinner());
	}
}
