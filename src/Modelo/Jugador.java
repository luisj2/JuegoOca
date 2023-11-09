package Modelo;

import javax.swing.JLabel;

public class Jugador {

	private String nombre;
	private String personaje;
	private int casilla;
	private int turnosRestantes;
	private boolean activo;
	private JLabel lable;
	
	
	public Jugador() {
		super();
	}


	public Jugador(String nombre, String personaje,JLabel label) {
		super();
		this.nombre = nombre;
		this.personaje = personaje;
		this.casilla = 1;
		this.turnosRestantes = 0;
		this.activo = true;
		this.lable = lable;
	}


	public JLabel getLable() {
		return lable;
	}


	public void setLable(JLabel lable) {
		this.lable = lable;
	}


	public int getTurnosRestantes() {
		return turnosRestantes;
	}


	public void setTurnosRestantes(int turnosRestantes) {
		this.turnosRestantes = turnosRestantes;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
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
		return "Jugador [nombre=" + nombre + ", personaje=" + personaje + ", casilla=" + casilla + ", turnosRestantes="
				+ turnosRestantes + ", activo=" + activo + "]";
	}


	
	
	
	
	
	
}
