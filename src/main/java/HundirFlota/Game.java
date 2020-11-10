package HundirFlota;

import java.awt.List;

public class Game {
	private Player players[];
	private Player winner;
	public Game() {}
	
	public void crearJugadores(Player listP[]) {
		Player[] players=new Player[2];
		for(int i=0; i<listP.length;i++) {
			players[i] =new Player();
			players[i].setNombre(listP[i].getNombre());
			players[i].setTurno(listP[i].getTurno());
		}
	}
	public void play() {
		
	}

}
