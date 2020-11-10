package HundirFlota;

import java.awt.List;

public class Game {
	private Player players[];
	private Player winner;
	public Game() {
		players=new Player[2];
	}
	public Player getPlayer(int num) {
		return players[num];
	}
	public Player[] getPlayers() {
		return players;
	}
	public void crearJugadores(Player listP[]) {
		for(int i=0; i<listP.length;i++) {
			players[i] =new Player();
			players[i].setNombre(listP[i].getNombre());
			players[i].setTurno(listP[i].getTurno());
		}
	}


}
