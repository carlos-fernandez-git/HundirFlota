package HundirFlota;

public class Player {
	private String Nombre;
	private int turno;
	
	public Player() {
		
	}
	public Player(String nom) {
		this.Nombre=nom;
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
	

}
