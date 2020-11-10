package HundirFlota;

public class Player {
	private String Nombre;
	private int turno;
	private Board tablero;
	private String [][] tableroInfo;

	
	public Player() {
		this.iniciarTableroInfo();
		this.tablero=new Board();

	}
	public Board getTablero() {
		return this.tablero;
	}
	public void setNombre(String nombre) {
		this.Nombre=nombre;
	}
	public String getNombre() {
		return this.Nombre;
	}
	public void setTurno(int turno) {
		this.turno=turno;
	}
	public int getTurno() {
		return this.turno;
	}
	public String [][] getTableroInfo() {
		return this.tableroInfo;
	}
	
	public void iniciarTableroInfo() {
		tableroInfo=new String[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				tableroInfo[i][j]="[-]";
			}
		}
	}
	
	public boolean disparar(Board tablero,int fila,int columna) {
		boolean hit=false;
		if(fila>tablero.getFilas() || columna>tablero.getColumnas()){
			hit=false;
			System.out.println("WRONG COORDS: "+fila+" "+columna);
			
		}else if(tablero.getPosicion(fila, columna) == 1) {
			hit=true;
			System.out.println("HIT SHOOT on: "+fila+" "+columna);
			this.tableroInfo[fila][columna]="[X]";
			
		}else {
			hit=false;
			System.out.println("MISSED SHOOT on "+fila+" "+columna);
			this.tableroInfo[fila][columna]="[O]";
		}
		return hit;
	}

}
