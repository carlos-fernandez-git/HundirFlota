package HundirFlota;

import java.util.ArrayList;

class Barco {
	/*FIRST VERSION OF CLASS Boat, we decied to make few changes.
	private String[][] Barcos; //PORTAVIONES BUQUE LANCHA
	//private int NumeroBarcos;	//2 3 5  5 4 1
	int fila;
	int col;
	public Barco() {
		fila=3;
		col=3;
		Barcos=new String[fila][col];
		Barcos[0][0]="Porta-aviones";		//Nombre
		Barcos[0][1]="2";					//Cantidad a colocar
		Barcos[1][0]="Buque";
		Barcos[1][1]="3";
		Barcos[2][0]="Lancha";
		Barcos[2][1]="5";					//Casillas que ocupa
		Barcos[0][2]="5";
		Barcos[1][2]="4";
		Barcos[2][2]="1";
	}
	public String[][] getBarco() {
		return Barcos;
	}*/
	private String typeOfBoat;
	private int length;
	private ArrayList<int[]> positions = new ArrayList<int[]>();
	private boolean sunk=false;
	
	public Barco(ArrayList<int[]> list,int l) {
		
		this.length=l;
		this.typeOfBoat=checkTypeOfBoat();
		positions=list;
		this.sunk=false;
		
	}
	public ArrayList<int[]> getPositions(){
		return positions;
	}
	public String getTypeOfBoat() {
		return this.typeOfBoat;
	}
	public int getLength() {
		return this.length;
	}
	public String checkTypeOfBoat(){
		if(this.length==5) {
			return "Air Craft Carrier";
		}else if(this.length==4) {
			return "Vessel";
		}else{
			return "Motor Boat";
		}
	}
	public void ifHit(int row, int col) {
		for(int i=0; i<positions.size();i++) {
			if(positions.get(i)[0]==row && positions.get(i)[1]==col) {
					positions.get(i)[2] = 1;
			}
		}
	}	
	public boolean isSunk() {
		for(int i=0; i<positions.size();i++) {
			if(positions.get(i)[2] == 0) {
				return false;
			}
		}
		this.sunk=true;
		return sunk;
	}

	
}
