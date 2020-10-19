package HundirFlota;

public class Barco {
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
	}
}
