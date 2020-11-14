package HundirFlota;

import java.util.ArrayList;

public class MockUpPlayer {
	Player listP[] = new Player[2];
	public MockUpPlayer(){
		listP[0] =new Player();
		listP[0].setNombre("Adri");
		listP[0].setTurno(1);
		listP[1] =new Player();
		listP[1].setNombre("Arnau");
		listP[1].setTurno(2);
	}
	public Player[] getPlayers() {
		return listP;
	}
}
