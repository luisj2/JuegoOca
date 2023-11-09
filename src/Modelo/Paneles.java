package Modelo;

import java.util.ArrayList;

import Vista.VistaOca;

public class Paneles {

	ArrayList <PanelNumero> paneles;
	VistaOca vista;

	public Paneles(VistaOca vista) {
		//super();
		
		this.paneles = new ArrayList <PanelNumero>();
		
		paneles.add(new PanelNumero(1,vista.panelCasilla1));
		paneles.add(new PanelNumero(2,vista.panelCasilla2));
		paneles.add(new PanelNumero(3,vista.panelCasilla3));
		paneles.add(new PanelNumero(4,vista.panelCasilla4));
		paneles.add(new PanelNumero(5,vista.panelCasilla5));
	}

	public ArrayList<PanelNumero> getPaneles() {
		return paneles;
	}

	public void setPaneles(ArrayList<PanelNumero> paneles) {
		this.paneles = paneles;
	}

	@Override
	public String toString() {
		return "Paneles [paneles=" + paneles + "]";
	}
	
	
}
