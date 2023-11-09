package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Jugador;
import Modelo.PanelNumero;
import Modelo.Paneles;
import Modelo.Pregunta;
import Vista.VistaOca;

public class ControladorOca implements ActionListener {

	VistaOca vista = new VistaOca();
	DefaultListModel modelo = new DefaultListModel<>();
	ArrayList<String> jugadorestr = new ArrayList<>();
	ArrayList<Jugador> jugadores = new ArrayList<>();
	ArrayList<Pregunta> preguntas = rellenarPreguntasLlados();
	Pregunta pregunta = new Pregunta();
	int turno = 0;
	ArrayList<PanelNumero> numPanel = new ArrayList<>();
	Map <Integer,Integer> getOcas = rellenarOcas();
	Paneles paneles;
	
	

	//contructor
	public ControladorOca(VistaOca frame) {
		this.vista = frame;
		this.vista.btnAniadirJugador.addActionListener(this);
		this.vista.btnJugar.addActionListener(this);
		this.vista.btnTirarDados.addActionListener(this);
		this.vista.btnMostrarPregunta.addActionListener(this);
		this.vista.radiobtnRespuesta1.addActionListener(this);
		this.vista.radiobtnRespuesta2.addActionListener(this);
		this.vista.radiobtnRespuesta3.addActionListener(this);
		this.vista.btnMostrarPregunta.addActionListener(this);
		this.vista.btnResponder.addActionListener(this);
		this.vista.btnImprimir.addActionListener(this);
		
		//rellenarCasillas(frame);
		paneles = new Paneles(frame);
	}
	
	
	
		
	

	
	

	//FUNCIONALIDAD DE LOS BUTTONS
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * String seleccion = vista.comboBox.getSelectedItem().toString();
		 * JOptionPane.showMessageDialog(vista, seleccion);
		 */
		
		//FUNCIONES EXTRA

		/*
		if (vista.radiobtnRespuesta1.isSelected()) {
			vista.radiobtnRespuesta2.setSelected(false);
			vista.radiobtnRespuesta3.setSelected(false);
		}
		if (vista.radiobtnRespuesta2.isSelected()) {
			vista.radiobtnRespuesta1.setSelected(false);
			vista.radiobtnRespuesta3.setSelected(false);
		}
		if (vista.radiobtnRespuesta3.isSelected()) {
			vista.radiobtnRespuesta1.setSelected(false);
			vista.radiobtnRespuesta2.setSelected(false);
		
			
			
			
			
			
		}
		*/
		
		if(e.getSource() == vista.btnImprimir) {
			String resultado = "";
			//numPanel = rellenarCasillas(vista);
			
			numPanel.add(new PanelNumero(1,vista.panelCasilla1));
			numPanel.add(new PanelNumero(2,vista.panelCasilla2));
			numPanel.add(new PanelNumero(3,vista.panelCasilla3));
			numPanel.add(new PanelNumero(4,vista.panelCasilla4));
			numPanel.add(new PanelNumero(5,vista.panelCasilla5));
			
			if(paneles.getPaneles() == null) {
				vista.lblRetroalimentacionJuego.setText("Es null");
			}
			if(!paneles.getPaneles().isEmpty()) {
				for (PanelNumero numPanel : numPanel) {
					resultado += numPanel.getCasilla() +":"+numPanel.getPanel().getName();
				}
				vista.lblRetroalimentacionJuego.setText(resultado);
			}else {
				vista.lblRetroalimentacionJuego.setText("Vacio");
			}
			
		}
		//mostrar una pregunta aleatoria del arraylist de Pregunta
		if (e.getSource() == vista.btnMostrarPregunta) {
			
			int preguntaRandom = (int) (Math.random() * preguntas.size());
			pregunta = preguntas.get(preguntaRandom);

			vista.lblPregunta.setText(pregunta.getPregunta());
			vista.radiobtnRespuesta1.setText(pregunta.getRespuestas().get(0));
			vista.radiobtnRespuesta2.setText(pregunta.getRespuestas().get(1));
			vista.radiobtnRespuesta3.setText(pregunta.getRespuestas().get(2));
			
			
			if (!vista.panelPreguntas.isVisible() && vista.panelPrincipal.isVisible()) {
				vista.panelPreguntas.setVisible(true);
				vista.panelPrincipal.setVisible(false);
			}

		}
		//responder a la pregunta y si la has respondido correctamente o no
		if (e.getSource() == vista.btnResponder) {

			if (vista.radiobtnRespuesta1.isSelected()) {
				if (vista.radiobtnRespuesta1.getText().equalsIgnoreCase(pregunta.getCorrecta())) {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.green);
					vista.lblRetroalimentacionJuego.setText("Respuesta correcta");
					vista.panelPreguntas.setVisible(false);
					vista.panelPrincipal.setVisible(true);
					vista.radiobtnRespuesta1.setSelected(false);
					
				} else {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.red);
					vista.lblRetroalimentacionJuego.setText("Respuesta incorrecta");
					vista.panelPreguntas.setVisible(false);
					vista.panelPrincipal.setVisible(true);
					//vista.radiobtnRespuesta1.setSelected(false);
				}
			} else if (vista.radiobtnRespuesta2.isSelected()) {
				if (vista.radiobtnRespuesta2.getText().equalsIgnoreCase(pregunta.getCorrecta())) {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.green);
					vista.lblRetroalimentacionJuego.setText("Respuesta correcta");
					vista.panelPreguntas.setVisible(false);
					vista.panelPrincipal.setVisible(true);
					vista.radiobtnRespuesta2.setSelected(false);
					//vista.radiobtnRespuesta2.setSelected(false);
				} else {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.red);
					vista.lblRetroalimentacionJuego.setText("Respuesta incorrecta");
					vista.panelPreguntas.setVisible(false);
					vista.panelPrincipal.setVisible(true);
					//vista.radiobtnRespuesta2.setSelected(false);
				}
			} else if (vista.radiobtnRespuesta3.isSelected()) {
				if (vista.radiobtnRespuesta3.getText().equalsIgnoreCase(pregunta.getCorrecta())) {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.green);
					vista.lblRetroalimentacionJuego.setText("Respuesta correcta");
					vista.panelPreguntas.setVisible(false);
					vista.panelPrincipal.setVisible(true);
					vista.radiobtnRespuesta1.setSelected(false);
					//vista.radiobtnRespuesta2.setSelected(false);
				} else {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.red);
					vista.lblRetroalimentacionJuego.setText("Respuesta incorrecta");
					vista.panelPreguntas.setVisible(false);
					vista.panelPrincipal.setVisible(true);
					//vista.radiobtnRespuesta2.setSelected(false);
				}
			}
			vista.radiobtnRespuesta2.setSelected(false);

		}

		//toda la funcionalidad de elegir un personaje
		if (e.getSource() == vista.btnAniadirJugador) {
			vista.lblRetroalimentacion.setText("");
			String nombre = vista.textPaneNombres.getText().toString(); //convierto a String el nombre que introduce el usuario
			String personaje = vista.comboBox.getSelectedItem().toString(); //convierto a String el personaje que elige el usuario
			boolean jugadorRepite = false;
			boolean nombreRepite = false;
			
			
			//comprobar si se repite el nombre del usuario o el personaje
			for (Jugador jugador : jugadores) {
				if (jugador.getPersonaje().equalsIgnoreCase(personaje)) {
					jugadorRepite = true;
				}
				if (jugador.getNombre().equals(nombre)) {
					nombreRepite = true;
				}
			}

			//hacer funcionalidad siempre que no haya nada vacio y que no se repita
			if (!nombre.isEmpty() && !personaje.isEmpty()) {

				if (!jugadorRepite && !nombreRepite) {
					//te deja registrarte como jugador siempre que no haya 4 jugadores
					if (jugadores.size() <= 4) {
						Jugador jugador = new Jugador();
						jugadorestr.add(nombre);

						jugador.setNombre(nombre);
						jugador.setPersonaje(personaje);
						aniadirLblFichas(jugador);
						
						
						jugador.setActivo(true);
						jugador.setCasilla(1);

						jugadores.add(jugador);

						try {
							elegirFicha(vista, personaje);
						} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
							e1.printStackTrace();
						}

						//rellenamos el modelo, primero eliminamos todos los elementos y despues lo rellenamos con lo que hay en el ArrayList
						modelo.removeAllElements();

						for (int i = 0; i < jugadores.size(); i++) {
							modelo.addElement(jugadores.get(i).getNombre() + " | " + jugadores.get(i).getPersonaje());
						}

						//agregamos el modelo a la vista y ponemos en blanco el espacio de nombres
						vista.listaJugadores.setModel(modelo);
						vista.textPaneNombres.setText("");
						
						//hacer visible e boton de jugar siempre que haya 2 o mas jugadores registrados
						if(modelo.size() >= 2) {
							vista.btnJugar.setVisible(true);
						}
							

						/*
						 * for (int i = 0; i < vista.colores.size(); i++) { String colorEliminar =
						 * vista.colores.get(i); if(personaje.equalsIgnoreCase(colorEliminar)) {
						 * vista.colores.remove(i); }
						 * 
						 * } vista.comboBox.removeAllItems(); for (int i = 0; i < vista.colores.size();
						 * i++) { vista.comboBox.addItem(vista.colores.get(i)); }
						 */

						//elses por si no cuplen con lo anterior que nos ponga un mensaje de retroalimentacion
					} else {
						vista.lblRetroalimentacion.setText("");
						vista.lblRetroalimentacion.setText("Solo se permite jugar a 4 jugadores");
					}

				} else {
					vista.lblRetroalimentacion.setText("");
					vista.lblRetroalimentacion.setText("El nombre o el personaje esta repetido");
				}

			} else {
				vista.lblRetroalimentacion.setText("");
				vista.lblRetroalimentacion.setText("Completa todos los campos");

			}

		}

		//button de jugar para que me cambie de panel inicio al panel principal que es donde vamos a jugar
		if (e.getSource() == vista.btnJugar) {
			if (jugadores.size() >= 2 && jugadores.size() <= 4) {
				repartirFichas(jugadores, vista);

				vista.panelInicio.setVisible(false);
				vista.panelPrincipal.setVisible(true);
				vista.panelDados.setVisible(true);
				
				
				 
				

			} else {
				vista.lblRetroalimentacion.setText("");
				vista.lblRetroalimentacion.setText("Se necesitan al menos 2 jugadores");
			}
		}
		//toda la funcionalidad de tirar los dados y de mover la ficha
		if (e.getSource() == vista.btnTirarDados) {
			rellenarCasillas(vista);
			int totalDados = tirarDados(vista);
			
				//vista.lblRetroalimentacionJuego.setText(paneles.getPaneles().get(2).getPanel().getName());
			
			
			//vista.lblRetroalimentacionJuego.setText("");
			//vista.lblRetroalimentacionJuego.setText("Turno de " +jugadores.get(turno).getNombre() +" con " +jugadores.get(turno).getTurnosRestantes() +" y "+jugadores.get(turno).isActivo());
		
			/*
			SI EL JUGADOR QUE ESTA EN LA VARIABLE TURNO(Para determinar a que jugador le toca),
			HACE UN GET DE TURNOS RESTANTES, QUE AUMENTARA SI SE QUEDA EN LA CARCEL POR EJEMPLO
			Y ESTA ACTIVO ES DECIR QUE NO HA LLEGADO A LA CASILLA FINAL Y HA DEJADO DE JUGAR
			*/
				if(jugadores.get(turno).getTurnosRestantes() == 0 && jugadores.get(turno).isActivo()) {
					//vista.lblRetroalimentacion.setText("");
					//DETERMINAR CUAL ES LA CASILLA A LA QUE SE VA A MOVER EL USUARIO
					int casillaMovimiento = jugadores.get(turno).getCasilla()+totalDados;
					//vista.lblRetroalimentacionJuego.setText(jugadores.get(turno).getNombre()+" ha sacado " +totalDados+" se mueve a  " +casillaMovimiento);
					
					int posicionAntigua = jugadores.get(turno).getCasilla();
					int posicionNueva = casillaMovimiento;
					
					//vista.lblRetroalimentacionJuego.setText("antigua:" +posicionAntigua+" nueva:" +posicionNueva);

					
					if(numPanel.get(posicionAntigua) != null) {
						//LE PASO LA VISTA PARA PONER MENSAJES,EL PANEL DE LA POSICION ANTIGUA,EL JUGADOR,Y las nuevas posiciones,
						//PD:No me acuerdo por que le paso 2 iguales
						actualizarPosicion(vista,numPanel.get(posicionAntigua).getPanel(),jugadores.get(turno),casillaMovimiento,posicionNueva);
						
					}else {
						vista.lblRetroalimentacionJuego.setText("");
						vista.lblRetroalimentacionJuego.setText("El panel es null");
					}
					
					if(turno == jugadores.size()) {
						turno = 0;
					}else {
						turno++;
					}
					
					//SI EL JUGADOR NO PUEDE JUGAR EN EL TURNO, POR EJEMPLO SI ESTA EN LA CARCEL
				}else if(jugadores.get(turno).getTurnosRestantes() >0 && jugadores.get(turno).isActivo()) {
					jugadores.get(turno).setTurnosRestantes(jugadores.get(turno).getTurnosRestantes()-1);
					
				}
				
			}
		}
		

	
	//agregar al objeto jugador el label de la ficha que le corresponde
	public void aniadirLblFichas(Jugador jugador) {
		if(jugador.getPersonaje().equalsIgnoreCase("llados")) {
			jugador.setLable(vista.lblFichaLlados);
		}else if(jugador.getPersonaje().equalsIgnoreCase("xokas")) {
			jugador.setLable(vista.lblFichaXokas);
		}
		
	}

	//actualizar las posicion de la ficha segun lo que le ha salido en los dados
	public void actualizarPosicion(VistaOca vista, JPanel panel, Jugador jugador, int casillaMovimiento, int posicionNueva) {
	    
		//Aqui es donde se me complica
		//
		//del panel en el que estaba la pieza antes elimino la ficha
		panel.remove(jugador.getLable());
		
		//le pongo la nueva casilla a la que se va a mover
	    jugador.setCasilla(casillaMovimiento);
	    
	    //compruebo que la nueva posicion sea valida
	    if (posicionNueva >= 0 && posicionNueva < numPanel.size()) {
	       // JPanel destinoPanel = numPanel.get(posicionNueva).getPanel();

	    	//si en el arraylist de numeros/paneles existe la nueva posicion y en el label tengo una ficha registrada
	        if ( numPanel.get(posicionNueva).getPanel() != null && jugador.getLable() != null) {
	        	//pongo un mensaje
	        	vista.lblRetroalimentacionJuego.setText("nombre panel: " + numPanel.get(posicionNueva).getPanel().getName());	
	        	 //añado en el panel nuevo la ficha de mi jugador
	        	numPanel.get(posicionNueva).getPanel().add(jugador.getLable());
	           
	           
	        } else {
	            vista.lblRetroalimentacionJuego.setText("El panel de destino es nulo o jugador.getLable() es nulo");
	        }
	    } else {
	        vista.lblRetroalimentacionJuego.setText("Posición nueva fuera de rango");
	    }
	    //actualizo lo realizado
	    vista.revalidate();
        vista.repaint();
	}



	//tiramos los dados de forma aleatoria y retornamos el resultado de la suma entre estos 2 dados
	public int tirarDados(VistaOca vista) {

		/*
		int dado1 = (int) (1 + Math.random() * 6);
		int dado2 = (int) (1 + Math.random() * 6);
		*/
		int dado1 = 1;
		int dado2 = 1;

		cambiarImagenes(vista, dado1, 1);
		cambiarImagenes(vista, dado2, 2);
		
		return dado1+dado2;

	}

	//cambiar la imagen del dado segun el numero que salga y el dado que se pretenda de cambiar
	public void cambiarImagenes(VistaOca vista, int dadoRandom, int cualDado) {

		switch (dadoRandom) {
		case 1:
			if (cualDado == 1) {
				vista.lblDado1.setIcon(new ImageIcon("Imagenes/dados/dado1Bueno.png"));
			} else {
				vista.lblDado2.setIcon(new ImageIcon("Imagenes/dados/dado1Bueno.png"));
			}

			break;
		case 2:
			if (cualDado == 1) {
				vista.lblDado1.setIcon(new ImageIcon("Imagenes/dados/dado2Bueno.png"));
			} else {
				vista.lblDado2.setIcon(new ImageIcon("Imagenes/dados/dado2Bueno.png"));
			}
			break;
		case 3:
			if (cualDado == 1) {
				vista.lblDado1.setIcon(new ImageIcon("Imagenes/dados/dado3Bueno.png"));
			} else {
				vista.lblDado2.setIcon(new ImageIcon("Imagenes/dados/dado3Bueno.png"));
			}

			break;
		case 4:
			if (cualDado == 1) {
				vista.lblDado1.setIcon(new ImageIcon("Imagenes/dados/dado4Bueno.png"));
			} else {
				vista.lblDado2.setIcon(new ImageIcon("Imagenes/dados/dado4Bueno.png"));
			}

			break;

		case 5:
			if (cualDado == 1) {
				vista.lblDado1.setIcon(new ImageIcon("Imagenes/dados/dado5Bueno.png"));
			} else {
				vista.lblDado2.setIcon(new ImageIcon("Imagenes/dados/dado5Bueno.png"));
			}
			break;
		case 6:
			if (cualDado == 1) {
				vista.lblDado1.setIcon(new ImageIcon("Imagenes/dados/dado6Bueno.png"));
			} else {
				vista.lblDado2.setIcon(new ImageIcon("Imagenes/dados/dado6Bueno.png"));
			}

			break;

		}
	}
	//relleno preguntas para poner en el panel de preguntas con e objeto pregunta y lo guardo en un arraylist
	public ArrayList<Pregunta> rellenarPreguntasLlados() {
		ArrayList<Pregunta> preguntas = new ArrayList<>();
		Pregunta pregunta = null;

		pregunta = new Pregunta("¿Cual es el Lamborghini de los pobres según Llados?",
				new ArrayList<String>(
						Arrays.asList("Lamborghini Aventador", "Lamborghini Huracan", "Lamborghini Urus")),
				"Lamborghini Huracan");
		preguntas.add(pregunta);

		pregunta = new Pregunta("¿De que raza es el perro de llados?",
				new ArrayList<String>(Arrays.asList("Doberman", "Pastor Aleman", "Chiguagua")), "Chiguagua");
		preguntas.add(pregunta);

		return preguntas;
	}

	//darle un sonido segun el personaje que sea elegido
	public void elegirFicha(VistaOca vista, String personaje)
			throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		Clip sonido = AudioSystem.getClip();

		if (personaje.equalsIgnoreCase("llados")) { //sonido llados
			vista.ImagenFicha.setIcon(new ImageIcon("Imagenes/lladosbuena.png"));
			sonido.open(AudioSystem.getAudioInputStream(new File("audios/panzapanza.wav")));
			sonido.start();
		} else if (personaje.equalsIgnoreCase("elxokas")) { //sonido xokas
			vista.ImagenFicha.setIcon(new ImageIcon("Imagenes/xokasBuena.png"));
			sonido.open(AudioSystem.getAudioInputStream(new File("audios/noesunjuego.wav")));
			sonido.start();
		}

	}

	//Hacer visibles las fichas que se han elegido para jugar
	public void repartirFichas(ArrayList<Jugador> jugadores, VistaOca vista) {

		for (Jugador jugador : jugadores) {
			if (jugador.getPersonaje().equalsIgnoreCase("llados")) {

				/*
				vista.panelCasilla1.remove(vista.lblFichaLlados);
				vista.panelCasilla2.add(vista.lblFichaLlados);
				*/
				
				vista.lblFichaLlados.setVisible(true);

			}
			if (jugador.getPersonaje().equalsIgnoreCase("elxokas")) {

				/*
				vista.panelCasilla1.remove(vista.lblFichaXokas);
				vista.panelCasilla2.add(vista.lblFichaXokas);
				*/

				vista.lblFichaXokas.setVisible(true);
			}

			/*
			vista.revalidate();
			vista.repaint();
			*/

		}
		

	}
	
	//rellenar las relacciones entre numero de casilla y Jpanel que le corresponde
	public ArrayList<PanelNumero> rellenarCasillas(VistaOca vista){
		ArrayList <PanelNumero> casillas = new ArrayList<>();
		
		casillas.add(new PanelNumero(1,vista.panelCasilla1));
		casillas.add(new PanelNumero(2,vista.panelCasilla2));
		casillas.add(new PanelNumero(3,vista.panelCasilla3));
		casillas.add(new PanelNumero(4,vista.panelCasilla4));
		casillas.add(new PanelNumero(5,vista.panelCasilla5));
		
		return casillas;
	}
	
	//rellenar las casillas que contienen ocas
	public Map<Integer,Integer> rellenarOcas (){
		Map<Integer,Integer> ocas = new HashMap<>();
		
		ocas.put(5, 9);		ocas.put(32,36);
		ocas.put(9,14);		ocas.put(36,41);
		ocas.put(14,18);	ocas.put(41,45);
		ocas.put(18,23);	ocas.put(45,50);
		ocas.put(23,27);	ocas.put(50,54);
		ocas.put(27,32);	ocas.put(54,59);
		
		return ocas;
	}

}
