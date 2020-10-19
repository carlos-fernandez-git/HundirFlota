package HundirFlota;

import java.util.Scanner;

public class Board {
	private Barco barcos;
	private int filas;
	private int columnas;
	private int[][] Tablero;
	public Board() {
		this.IniciarTablero();
	}
	public void IniciarTablero() {
		this.filas=10;
		this.columnas=10;
		Tablero=new int[filas][columnas];
		for(int i=0;i<filas;i++) {
			for(int j=0;j<columnas;j++) {
				Tablero[i][j]=0;
			}
		}
	}
	public void BuscarPosicion() {
		
	}

	public void CrearBarcos() {
		//Donde se establezca un barco hay que decirle a traves de la clase posicion que tipo de barco contiene
		String barcos[][];
		Barco b=new Barco();
		barcos=b.getBarco();
		for(int i=0; i<barcos.length;i++) {
			for(int j=0;j<barcos[0].length;j++){
				if(j==0) {
					System.out.println("Se procede a colocar el tipo de barco "+ barcos[i][j]+"\n");
				}else if(j==1) {
					System.out.println("Debe colocar "+ barcos[i][j]+" barcos\n");
				}else {
					System.out.println("Este tipo de barco ocupa "+ barcos[i][j]+" posiciones\n");
						if(barcos[i][j].equals("1")) {
							int repeticion=0;
							int numeros=Integer.parseInt(barcos[i][1]);
							while(repeticion<numeros) {
							System.out.println("En que posicion desea colocar las coordenadas?");
							System.out.println("Seleccione fila");
							int fila=0;
							Scanner filaa= new Scanner(System.in);
							fila=filaa.nextInt();
							System.out.println("Seleccione columna");
							int columna=0;
							Scanner columnaa= new Scanner(System.in);
							columna=columnaa.nextInt();
							int numero=Integer.parseInt(barcos[i][j]);
							if(fila<10 & columna<10 ) {
								if(Tablero[fila][columna]==0) {
								if(Tablero[fila+1][columna]!=1 && Tablero[fila+-1][columna]!=1 && Tablero[fila][columna+1]!=1 && Tablero[fila][columna-1]!=1) {
									Tablero[fila][columna]=1;
								}
								}
							}
							repeticion++;
							}
						}else {
							int repeticion=0;
							int numeros=Integer.parseInt(barcos[i][1]);
							while(repeticion<numeros) {
							System.out.println("En que posicion desea colocar la primera coordenada?");
							System.out.println("Seleccione fila");
							int fila=0;
							Scanner filaa= new Scanner(System.in);
							fila=filaa.nextInt();
							System.out.println("Seleccione columna");
							int columna=0;
							Scanner columnaa= new Scanner(System.in);
							columna=columnaa.nextInt();
							int numero=Integer.parseInt(barcos[i][j]);
							if(fila<10 & columna<10 ) {
								if(Tablero[fila][columna]==0) {
								if(fila+numero<10 || fila-numero>0 || columna+numero<10 || columna-numero>0) {
									Tablero[fila][columna]=1;
								}
								}
							}
							System.out.println("En que posicion desea colocar la ultima coordenada?");
							if(fila+numero<10) {
								if(Tablero[fila+numero][columna]==0) {
									int numm=fila+numero;
									System.out.println("Posicion "+numm+" "+columna);
								}
							}
							if(fila-numero>0) {
								if(Tablero[fila-numero][columna]==0) {
									int numm=fila-numero;
									System.out.println("Posicion "+numm+" "+columna);
								}
							}
							if(columna+numero<10) {
								if(Tablero[fila][columna+numero]==0) {
									int numm=columna+numero;
									System.out.println("Posicion "+fila+" "+numm);
								}
							}
							if(columna-numero>0) {
								if(Tablero[fila][columna-numero]==0) {
									int numm=columna-numero;
									System.out.println("Posicion "+fila+" "+numm);
								}
							}
							System.out.println("Seleccione fila");
							int fila2=0;
							Scanner filaa2= new Scanner(System.in);
							fila2=filaa2.nextInt();
							System.out.println("Seleccione columna");
							int columna2=0;
							Scanner columnaa2= new Scanner(System.in);
							columna2=columnaa2.nextInt();
							if(fila==fila2) {
								if(columna2>columna) {
									for(int z=columna;z<columna+numero;z++) {
										Tablero[fila2][z]=1;
									}
								}else {
									for(int z=columna2;z<columna2+numero;z++) {
										Tablero[fila2][z]=1;
									}
								}
							}if(columna2==columna) {
								if(fila2>fila) {
									for(int z=fila;z<fila+numero;z++) {
										Tablero[z][columna2]=1;
									}
								}else {
									for(int z=fila2;z<fila2+numero;z++) {
										Tablero[z][columna2]=1;
									}
							}
						}
					
							repeticion++;}
						}
				}
			}
		}
	}
	public String getBoard() {
		return "Hola";
	}
	public int[][] getTablero() {
		return Tablero;
	}

	public int posicionesOcupadas() {
		int pos=0;
		for(int i=0;i<filas;i++) {
			for(int j=0;j<columnas;j++) {
				if(Tablero[i][j]!=0) {
					pos++;
				}
			}
		}
		return pos;
	}

	
	
}
