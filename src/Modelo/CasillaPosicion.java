package Modelo;

public class CasillaPosicion {

	private int x;
	private int y;
	private int ocupados;
	
	
	public CasillaPosicion(int x, int y) {

		this.x = x;
		this.y = y;
		this.ocupados = 0;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getOcupados() {
		return ocupados;
	}
	public void setOcupados(int ocupados) {
		this.ocupados = ocupados;
	}
	@Override
	public String toString() {
		return "CasillaPosicion [x=" + x + ", y=" + y + ", ocupados=" + ocupados + "]";
	}
	
	
	
}
