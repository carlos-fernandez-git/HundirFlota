package HundirFlota;

import java.awt.List;
import java.util.Scanner;

public class Game {
	private Player players[];
	private boolean winner;
	private int Turn;
	public Game() {
		players=new Player[2];
		winner=false;
		Turn=1;
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
	public boolean getWinner() {
		return winner;
	}
	public int getTurn() {
		return Turn;
	}
	public void play() {
		//Put boats on the board
		insertAirCraft(0);
		insertVessel(0);
		insertMotorBoat(0);
		insertAirCraft(1);
		insertVessel(1);
		insertMotorBoat(1);
		while(!winner) {
			if(players[0].getTurno()==Turn) {
				System.out.println("Shoot turn for "+players[0].getNombre());
				
				Turn=2;
			}else {
				System.out.println("Shoot turn for "+players[0].getNombre());
				
				Turn=1;
			}
			
		}
	}
	public void insertAirCraft(int player) {
		System.out.println("Proceed to put 2 aircraft carriers");
		System.out.println("The length of aircraft carrier is 5");
		boolean correctValue=false;
		boolean correctValueTwo=false;
		for(int i=0; i<2; i++) {
			while(!correctValue) {
				System.out.println("Enter the row where you want to put the first coordinate of aircraft carrier");
				Scanner fila= new Scanner(System.in);
				int initialFila=fila.nextInt();
				System.out.println("Enter the column where you want to put the first coordinate of the aircraft carrier");
				Scanner col= new Scanner(System.in);
				int initialcol=fila.nextInt();
				if(players[player].getTablero().insertBoatfirstpos(initialFila, initialcol, 5)==true) {
					while(!correctValueTwo) {
						System.out.println("Enter the row where you want to put the last coordinate of aircraft carrier");
						Scanner fila2= new Scanner(System.in);
						int initialFila2=fila.nextInt();
						System.out.println("Enter the column where you want to put the last coordinate of the aircraft carrier");
						Scanner col2= new Scanner(System.in);
						int initialcol2=fila.nextInt();
						if(players[player].getTablero().insertBoatLastPosition(initialFila, initialcol, initialFila2, initialcol2, 5)==true) {
							System.out.println("Boat correctly inserted");
							correctValueTwo=true;
						}else {
							System.out.println("The position choosed is not valid, try another one");
						}
					}
				correctValue=true;
				}
				else {
					System.out.println("The position choosed is not valid, try another one");
				}
			}
			System.out.println(players[0].getTablero().mostrarTablero());
		}
	}
	public void insertVessel(int player) {
		System.out.println("Proceed to put 3 vessels");
		System.out.println("The length of a vessel is 4");
		boolean correctValue=false;
		boolean correctValueTwo=false;
		for(int i=0; i<3; i++) {
			while(!correctValue) {
				System.out.println("Enter the row where you want to put the first coordinate of vessel");
				Scanner fila= new Scanner(System.in);
				int initialFila=fila.nextInt();
				System.out.println("Enter the column where you want to put the first coordinate of vessel");
				Scanner col= new Scanner(System.in);
				int initialcol=fila.nextInt();
				if(players[player].getTablero().insertBoatfirstpos(initialFila, initialcol, 4)==true) {
					while(!correctValueTwo) {
						System.out.println("Enter the row where you want to put the last coordinate of veseel");
						Scanner fila2= new Scanner(System.in);
						int initialFila2=fila.nextInt();
						System.out.println("Enter the column where you want to put the last coordinate of vessel");
						Scanner col2= new Scanner(System.in);
						int initialcol2=fila.nextInt();
						if(players[player].getTablero().insertBoatLastPosition(initialFila, initialcol, initialFila2, initialcol2, 4)==true) {
							System.out.println("Boat correctly inserted");
							correctValueTwo=true;
						}else {
							System.out.println("The position choosed is not valid, try another one");
						}
					}
				correctValue=true;
				}
				else {
					System.out.println("The position choosed is not valid, try another one");
				}
			}
			System.out.println(players[0].getTablero().mostrarTablero());
		}
	}
	public void insertMotorBoat(int player) {
		System.out.println("Proceed to put 5 MotorBoat");
		System.out.println("The length of a MotorBoat is 1");
		boolean correctValue=false;
		for(int i=0; i<5; i++) {
			while(!correctValue) {
				System.out.println("Enter the row where you want to put the first coordinate of MotorBoat");
				Scanner fila= new Scanner(System.in);
				int initialFila=fila.nextInt();
				System.out.println("Enter the column where you want to put the first coordinate of MotorBoat");
				Scanner col= new Scanner(System.in);
				int initialcol=fila.nextInt();
				if(players[player].getTablero().insertBoatfirstpos(initialFila, initialcol, 1)==true) {
					System.out.println("Boat correctly inserted");
					correctValue=true;
				}
				else {
					System.out.println("The position choosed is not valid, try another one");
				}
			}
			System.out.println(players[0].getTablero().mostrarTablero());
		}
		
	}
	
	


}
