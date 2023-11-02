package Modelo;

public class Jugador {

	private String nombre;
	private String personaje;
	private int casilla;
	
	
	public Jugador() {
		super();
	}


	public Jugador(String nombre, String personaje) {
		super();
		this.nombre = nombre;
		this.personaje = personaje;
		this.casilla = 1;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	


	public String getPersonaje() {
		return personaje;
	}


	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}


	public int getCasilla() {
		return casilla;
	}


	public void setCasilla(int casilla) {
		this.casilla = casilla;
	}


	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", color=" + personaje + ", casilla=" + casilla + "]";
	}
	
	
	
	
	
}
