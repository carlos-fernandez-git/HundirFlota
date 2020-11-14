package HundirFlota;

import java.util.Scanner;

public class Main {

	public static void main(String[]args) {
	Player[] players=new Player[2];
	Player p1= new Player();
	p1.setNombre("Player 1");
	System.out.println("xdddd");
	System.out.println(p1.mostrarTableroInfo());
	p1.setTurno(1);
	Player p2=new Player();
	p2.setNombre("Player 2");
	p2.setTurno(2);
	players[0]=p1;
	players[1]=p2;
	Game game= new Game();
	game.crearJugadores(players);
	//Players and Boards initialized
	//Proceed to insert boats at the board of each player
	game.play();
	
	}
}
