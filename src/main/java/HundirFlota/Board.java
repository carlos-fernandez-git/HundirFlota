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
	public int getPosicion(int fila,int columna) {
		return Tablero[fila][columna];
	}
	public int getFilas() {
		return this.filas;
	}
	public int getColumnas(){
		return this.columnas;
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
	

	//First version of the function Create Boats, This function is so complex and needs so conditional expressions,
	//seeying that the test created for this function always find errors we decide to descompose
	//the function into another functions to controllate better the events and test it at small scale.
	/*
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
	*/

	public int[][] getTablero() {
		return Tablero;
	}
	public String mostrarTablero() {
		String tablero="";
		for(int i=0;i<this.filas;i++) {
			for(int j=0; j<this.columnas;j++) {
				tablero = tablero+Tablero[i][j]+" ";
			}
			tablero=tablero+"\n";
		}
		return tablero;
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
	//To test with custom boards
	public void setTablero(int[][] a) {
		Tablero=a;
	}
	//Check if the user can insert a boat here
	public boolean insertBoatfirstpos(int fila, int columna, int BoatLeng) {
		if(fila<0 || fila>9 || columna<0 || columna>9) {
			return false;
		}else if(this.getPosicion(fila, columna)!=0) {
				return false;
		}else {
			//Call to checkSpace
			boolean FreeSpace=checkSpace(fila, columna, BoatLeng);
			if(FreeSpace==true && BoatLeng==1) {
				Tablero[fila][columna]=1;
			}
			return FreeSpace;
		}
		
	}
	public boolean checkSpace(int fila, int columna, int BoatLeng) {
		if(BoatLeng==5) {
		//Vertical Space
		Boolean find=true;
		if(fila+4<10) {
			if(columna+1<10) {
				if(Tablero[fila][columna+1]!=0 && Tablero[fila+4][columna+1]!=0) {
					find=false;
				}
			}
			if(columna-1>=0) {
				if(Tablero[fila][columna-1]!=0 && Tablero[fila+4][columna-1]!=0) {
					find=false;
				}
			}
		}
		else if(fila-4>=0) {
			if(columna-1>=0){
				if(Tablero[fila][columna-1]!=0 && Tablero[fila-4][columna-1]!=0) {
					find=false;
				}
			}
			if(columna+1<10) {
				if(Tablero[fila][columna+1]!=0 && Tablero[fila-4][columna+1]!=0) {
					find=false;
				}
			}
		}
		//Horizontal Space
		if(columna+4<10) {
			if(fila+1<10) {
				if(Tablero[fila+1][columna]!=0 && Tablero[fila+1][columna+4]!=0) {
					find=false;
				}
			}
			if(fila-1>=0) {
				if(Tablero[fila-1][columna]!=0 && Tablero[fila-1][columna+4]!=0) {
					find=false;
				}
			}
		}
		else if(columna-4>=0) {
			if(fila+1<10){
				if(Tablero[fila+1][columna]!=0 && Tablero[fila+1][columna-4]!=0) {
					find=false;
				}
			}
			if(fila-1>=0) {
				if(Tablero[fila-1][columna]!=0 && Tablero[fila-1][columna-4]!=0) {
					find=false;
				}
			}
		}
		return find;
		}
		else if(BoatLeng==4) {
			//Vertical Space
			Boolean find=true;
			if(fila+3<10) {
				if(columna+1<10) {
					if(Tablero[fila][columna+1]!=0 && Tablero[fila+3][columna+1]!=0) {
						find=false;
					}
				}
				if(columna-1>=0) {
					if(Tablero[fila][columna-1]!=0 && Tablero[fila+3][columna-1]!=0) {
						find=false;
					}
				}
			}
			else if(fila-3>=0) {
				if(columna-1>=0){
					if(Tablero[fila][columna-1]!=0 && Tablero[fila-3][columna-1]!=0) {
						find=false;
					}
				}
				if(columna+1<10) {
					if(Tablero[fila][columna+1]!=0 && Tablero[fila-3][columna+1]!=0) {
						find=false;
					}
				}
			}
			//Horizontal Space
			if(columna+3<10) {
				if(fila+1<10) {
					if(Tablero[fila+1][columna]!=0 && Tablero[fila+1][columna+3]!=0) {
						find=false;
					}
				}
				if(fila-1>=0) {
					if(Tablero[fila-1][columna]!=0 && Tablero[fila-1][columna+3]!=0) {
						find=false;
					}
				}
			}
			else if(columna-3>=0) {
				if(fila+1<10){
					if(Tablero[fila+1][columna]!=0 && Tablero[fila+1][columna-3]!=0) {
						find=false;
					}
				}
				if(fila-1>=0) {
					if(Tablero[fila-1][columna]!=0 && Tablero[fila-1][columna-3]!=0) {
						find=false;
					}
				}
			}
			return find;
		}
		else {	//Lancha
			Boolean find=true;
			if(fila+1<10) {
				if(Tablero[fila+1][columna]!=0) {
						find=false;
				}
			}
			if(fila-1>=0) {
					if(Tablero[fila-1][columna]!=0) {
						find=false;
					}
			}
			if(columna+1<10) {
					if(Tablero[fila][columna+1]!=0) {
						find=false;
					}
			}
			if(columna-1>=0) {
					if(Tablero[fila][columna-1]!=0) {
						find=false;
					}
			}
			return find;	
		}
	}

	public boolean insertBoatLastPosition(int filaIn, int columnaIn, int filaFi, int columnaFi, int BoatLeng) {
		if(filaFi<0 || filaFi>9 || columnaFi<0 || columnaFi>9) {
			return false;
		}else if(this.getPosicion(filaFi, columnaFi)!=0) {
				return false;
		}else {
			if(filaIn!=filaFi && columnaFi!=columnaIn) {
				return false;
			}
			else {
				//Insert right
				if(columnaFi>columnaIn) {
					if(columnaFi-columnaIn!=BoatLeng-1) {
						return false;
					}else {
						boolean occuped=false;
						for(int i=columnaIn; i<=columnaFi; i++) {
							if(Tablero[filaIn][i]==1) {
								occuped=true;
							}
						}
						if(occuped==true) {
							return false;
						}else {
							for(int i=columnaIn; i<=columnaFi; i++) {
								Tablero[filaIn][i]=1;
							}
						}			
					}
				}
				//insert left
				if(columnaFi<columnaIn) {
					if(columnaIn-columnaFi!=BoatLeng-1) {
						return false;
					}else {
						boolean occuped=false;
						for(int i=columnaFi; i<=columnaIn; i++) {
							if(Tablero[filaIn][i]==1) {
								occuped=true;
							}
						}
						if(occuped==true) {
							return false;
						}else {
							for(int i=columnaFi; i<=columnaIn; i++) {
								Tablero[filaIn][i]=1;
							}
						}
						
					}
				}
				//insert down
				if(filaFi>filaIn) {
					if(filaFi-filaIn!=BoatLeng-1) {
						return false;
					}else {
						boolean occuped=false;
						for(int i=filaIn; i<=filaFi; i++) {
							if(Tablero[i][columnaIn]==1) {
								occuped=true;
							}
						}
						if(occuped==true) {
							return false;
						}else {
							for(int i=filaIn; i<=filaFi; i++) {
								Tablero[i][columnaIn]=1;
							}
						}
						
					}
				}
				//insert top
				if(filaIn>filaFi) {
					if(filaIn-filaFi!=BoatLeng-1) {
						return false;
					}else {
						boolean occuped=false;
						for(int i=filaFi; i<=filaIn; i++) {
							if(Tablero[i][columnaIn]==1) {
								occuped=true;
							}
						}
						if(occuped==true) {
							return false;
						}else {
							for(int i=filaFi; i<=filaIn; i++) {
								Tablero[i][columnaIn]=1;
							}
						}
						
					}
				}
				return true;
			}
		}
	}
	
	
}
