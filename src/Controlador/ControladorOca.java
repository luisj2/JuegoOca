package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;

import Vista.VistaOca;

public class ControladorOca implements ActionListener{

	VistaOca vista = new VistaOca();
	DefaultListModel modelo = new DefaultListModel<>();
	ArrayList <String> jugadores = new ArrayList <>();
	
	
	public ControladorOca(VistaOca frame) {
		this.vista = frame;
		this.vista.btnAniadirJugador.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vista.btnAniadirJugador) {
			vista.lblRetroalimentacion.setText("");
			String nombre = vista.textPaneNombres.getText().toString();
			String color = vista.comboBox.getSelectedItem().toString();
			
			if(!nombre.isEmpty() && !color.isEmpty()) {
				
				if(jugadores.size() <=4) {
					jugadores.add(nombre);
					
					modelo.removeAllElements();
					
					for (int i = 0; i < jugadores.size(); i++) {
						modelo.addElement(jugadores.get(i));
					}
					
					vista.listaJugadores.setModel(modelo);
					vista.textPaneNombres.setText("");
					
					for (int i = 0; i < vista.colores.size(); i++) {
						String colorEliminar = vista.colores.get(i);
						if(color.equalsIgnoreCase(colorEliminar)) {
							vista.colores.remove(i);
						}
					}
					vista.comboBox.removeAllItems();
						for (int i = 0; i < vista.colores.size(); i++) {
							vista.comboBox.addItem(vista.colores.get(i));
						}
					
					
					
				}else {
					vista.lblRetroalimentacion.setText("");
					vista.lblRetroalimentacion.setText("Solo se permite jugar a 4 jugadores");
				}
				
				
				
			
				
			}else {
				vista.lblRetroalimentacion.setText("");
				vista.lblRetroalimentacion.setText("Completa todos los campos");
				
			}
			
		}
		
	}

}
