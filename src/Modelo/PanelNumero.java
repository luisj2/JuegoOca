package Modelo;

import javax.swing.JPanel;

public class PanelNumero {

	private JPanel panel;
	private int casilla;
	public PanelNumero(int casilla,JPanel panel) {
		//super();
		this.panel = panel;
		this.casilla = casilla;
	}
	public PanelNumero() {
		super();
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public int getCasilla() {
		return casilla;
	}
	public void setCasilla(int casilla) {
		this.casilla = casilla;
	}

	
	
	
}
