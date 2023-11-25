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
import java.util.List;
import java.util.Map;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.CasillaPosicion;
import Modelo.Jugador;
import Modelo.Pregunta;
import Vista.VistaOca;

public class ControladorOca implements ActionListener {

	VistaOca vista = new VistaOca();
	DefaultListModel modelo = new DefaultListModel<>();
	ArrayList<Jugador> jugadores = new ArrayList<>();
	ArrayList<Pregunta> preguntas = rellenarPreguntasLlados();
	Pregunta pregunta = new Pregunta();
	int turno;
	boolean modTurno;
	//VARIABLE QUE HACE EL CAMBIO DE LA Y DE UNA FICHA Y OTRA PARA QUE NO ESTEN JUNTAS
	static final int XYCAMBIO = 39;
	
	//VARIABLES DE POSICIONES INICIALES
	static final int XINICLLADOS = 78;
	static final int YINICIAL = 630;
	static final int XINICXOKAS = 42;
	//HASHMAP DE LAS KEYS=OCA,VALUE=A DONDE TE MUEVES DE LA OCA
	Map <Integer,Integer> getOcas = rellenarOcas();
	//REGISTRAR LA X Y LA Y DE CADA CASLILLA DEL TABLERO
	Map <Integer,CasillaPosicion> posiciones = rellenarPosiciones();
	boolean cambiarCasilla;
	boolean personaPozo;
	boolean personaCarcel;
	boolean juegoCon2Dados;

	
	

	//contructor
	public ControladorOca(VistaOca frame) {
		this.vista = frame;
		//
		this.vista.btnAniadirJugador.addActionListener(this);
		this.vista.btnJugar.addActionListener(this);
		this.vista.btnTirarDados.addActionListener(this);
		/*
		this.vista.btnMostrarPregunta.addActionListener(this);
		this.vista.radiobtnRespuesta1.addActionListener(this);
		this.vista.radiobtnRespuesta2.addActionListener(this);
		this.vista.radiobtnRespuesta3.addActionListener(this);
		this.vista.btnMostrarPregunta.addActionListener(this);
		this.vista.btnResponder.addActionListener(this);
		*/
		this.vista.radioBtn1Dado.addActionListener(this);
		this.vista.radioBtn2Dado.addActionListener(this);
		//LOS MUEVO LAS FICHAS A SUS SITIOS INICIALES
		vista.lblFichaLlados.setLocation(XINICLLADOS,YINICIAL);
		vista.lblFichaXokas.setLocation(XINICXOKAS,YINICIAL);
		
		personaPozo = false;
		personaCarcel = false;
		
		
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
		
		
		
		//mostrar una pregunta aleatoria del arraylist de Pregunta
		/*
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
		*/

		//toda la funcionalidad de elegir un personaje
		if(e.getSource() == vista.radioBtn1Dado) {
			juegoCon2Dados = false;
			vista.lblDado2.setVisible(false);
		}
		if(e.getSource() == vista.radioBtn2Dado) {
			juegoCon2Dados = true;
		}
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

						jugador.setNombre(nombre);
						jugador.setPersonaje(personaje);
						
						
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
			if (jugadores.size() >= 2 && jugadores.size() <= 4 && (vista.radioBtn1Dado.isSelected() || vista.radioBtn2Dado.isSelected())) {
				repartirFichas(jugadores, vista);

				vista.panelInicio.setVisible(false);
				vista.panelPrincipal.setVisible(true);
				vista.panelDados.setVisible(true);
				
				
				 
				

			} else {
				vista.lblRetroalimentacion.setText("");
				vista.lblRetroalimentacion.setText("Se necesitan al menos 2 jugadores y alguno de los botones de los dados activados");
				  
		}
			
		}
		//toda la funcionalidad de tirar los dados y de mover la ficha
		if (e.getSource() == vista.btnTirarDados) {
			

			cambiarCasilla = true;
			//rellenarCasillas(vista);
			//System.out.println("El turno es "+turno);
			
			
		
			
				//vista.lblRetroalimentacionJuego.setText(paneles.getPaneles().get(2).getPanel().getName());
			
			
			//vista.lblRetroalimentacionJuego.setText("");
			//vista.lblRetroalimentacionJuego.setText("Turno de " +jugadores.get(turno).getNombre() +" con " +jugadores.get(turno).getTurnosRestantes() +" y "+jugadores.get(turno).isActivo());
		
			/*
			SI EL JUGADOR QUE ESTA EN LA VARIABLE TURNO(Para determinar a que jugador le toca),
			HACE UN GET DE TURNOS RESTANTES, QUE AUMENTARA SI SE QUEDA EN LA CARCEL POR EJEMPLO
			Y ESTA ACTIVO ES DECIR QUE NO HA LLEGADO A LA CASILLA FINAL Y HA DEJADO DE JUGAR
			*/
			
				if(jugadores.get(turno).getTurnosRestantes() == 0 && jugadores.get(turno).isActivo()) {
					int totalDados =0;
				if(juegoCon2Dados) {
					System.out.println("Juego con 2 dados");
					if(jugadores.get(turno).getCasilla()>=60) {
						vista.lblDado2.setVisible(false);
						totalDados = tirarDados(vista,false); 
							
					}else {
						vista.lblDado2.setVisible(true);
						totalDados = tirarDados(vista,true);
						
						
					}
				}else {
					totalDados = tirarDados(vista,false);
					System.out.println("Juego con 1 dado");
				}
					
					
					
					//vista.lblRetroalimentacion.setText("");
					//DETERMINAR CUAL ES LA CASILLA A LA QUE SE VA A MOVER EL USUARIO
					modTurno = true;
					int casillaMovimiento = jugadores.get(turno).getCasilla()+totalDados;
					//vista.lblRetroalimentacionJuego.setText(jugadores.get(turno).getNombre()+" ha sacado " +totalDados+" se mueve a  " +casillaMovimiento);
					int posicionAntigua = jugadores.get(turno).getCasilla();
					System.out.println("Casilla antigua "+posicionAntigua);
					System.out.println("Casilla actu "+casillaMovimiento);
				 
					
					System.out.println("Personaje "+jugadores.get(turno).getPersonaje());
					

					
					//vista.lblRetroalimentacionJuego.setText("Posicion antigua"+posicionAntigua);
					
						//LE PASO LA VISTA PARA PONER MENSAJES,EL PANEL DE LA POSICION ANTIGUA,EL JUGADOR,Y las nuevas posiciones,
						//PD:No me acuerdo por que le paso 2 iguales
						vista.lblRetroalimentacionJuego.setText("antigua:" +posicionAntigua+" nueva:" +casillaMovimiento);
						actualizarPosicion(jugadores.get(turno),casillaMovimiento);
						System.out.println("Antes de actualizar la variable es:"+casillaMovimiento);
					
						if(cambiarCasilla) {
							jugadores.get(turno).setCasilla(casillaMovimiento);
						}
							
						
						
						//actualizamos los turnos
						if(turno == 1 && modTurno) {
							turno = 0;
							
						}else if(turno !=1 && modTurno){
							turno++;
						}
						
						
						
						
					}else if(jugadores.get(turno).getTurnosRestantes() >0 && jugadores.get(turno).isActivo()) {
						jugadores.get(turno).setTurnosRestantes(jugadores.get(turno).getTurnosRestantes()-1);
						vista.lblRetroalimentacionJuego.setText("");
						vista.lblRetroalimentacionJuego.setText("Se ha modificado los turnos del jugador "+jugadores.get(turno).getNombre()+" ahora le quedan "+jugadores.get(turno).getTurnosRestantes()+" turnos");
						
					}
					
					

					
				}
		
				}
				
			
		
		

	
	//agregar al objeto jugador el label de la ficha que le corresponde
	

	//actualizar las posicion de la ficha segun lo que le ha salido en los dados
	public void actualizarPosicion(Jugador jugador, int posicionNueva) {
	    
		ActualizarFicha(posicionNueva,jugador,true);
	
		
		
		
	    //actualizo lo realizado
	    vista.revalidate();
        vista.repaint();
	}



	//METODO PARA CAMBIAR LA POSICION DE LA FICHA EN FUNCION DEL NUMERO QUE HAYA EN LA VARIABLE CASILLAACTUALIZAR
	//Y CONTROLAR LAS OCAS
	private void ActualizarFicha(int casillaActualizar,Jugador jugador,boolean repetirOca) {
		cambiarCasilla = true;
		
			if(casillaActualizar >63) {
				casillaActualizar -= (casillaActualizar-63);
			}
			CasillaPosicion posicion= posiciones.get(casillaActualizar);
			
			mueveFicha(casillaActualizar,posicion,jugador);
			
			if(casillaActualizar == 63) {
				System.out.println("El ganador es "+jugador.getNombre());
			}
			
			//Casilla inicial
			
			 vista.lblFichaLlados.revalidate();
		     vista.lblFichaLlados.repaint();
		     
		     vista.lblFichaXokas.revalidate();
		     vista.lblFichaXokas.repaint();

	
				
			
					//Compruebo si ha habido Oca
					if(getOcas.get(casillaActualizar) != null && repetirOca) {
						
						casillaActualizar = getOcas.get(casillaActualizar);
						modTurno = false;
						System.out.println("De oca a oca y tiras porque te toca \n"+jugador.getNombre()+" avanza hasta la casilla "+casillaActualizar);
						ActualizarFicha(casillaActualizar, jugador,false);
						System.out.println("El numero de casillaActualizar en el metodo Actualizar es:"+casillaActualizar);
						jugadores.get(turno).setCasilla(casillaActualizar);
						cambiarCasilla = false;
					
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						
					}
					//Puentes
					if(casillaActualizar ==6) {
						casillaActualizar = 12;
						posicion = posiciones.get(casillaActualizar);
						mueveFicha(casillaActualizar, posicion, jugador);
						cambiarCasilla = false;
						jugadores.get(turno).setCasilla(casillaActualizar);
						System.out.println("De puente a puente \n el jugador"+jugador.getNombre()+" avanza hasta la casilla 12");
								
					}else if(casillaActualizar == 12) {
						
						casillaActualizar = 19;
						
						
						
						
						
						
					}
					if(casillaActualizar == 19) {
						System.out.println("Avanzas hasta la posada pero pierdes el turno");
						cambiarCasilla = false;
						posicion = posiciones.get(casillaActualizar);
						mueveFicha(casillaActualizar, posicion, jugador);
						jugadores.get(turno).setCasilla(casillaActualizar);
						jugadores.get(turno).setTurnosRestantes(jugadores.get(turno).getTurnosRestantes()+1);
						
					}
					//Dados de la casilla 26
					if(casillaActualizar == 26) {
						System.out.println("El jugador avanza hasta la casilla 53");
						casillaActualizar = 53;
						cambiarCasilla = false;
						posicion = posiciones.get(casillaActualizar);
						jugadores.get(turno).setCasilla(casillaActualizar);
						mueveFicha(casillaActualizar, posicion, jugador);
					}
					//Pozo
					if(casillaActualizar == 31) {
						if(!personaPozo) {
							personaPozo = true;
							jugadores.get(turno).setActivo(false);
							System.out.println("El jugador "+jugador.getNombre()+" se ha quedado encerrado en el pozo, saldra cuando caiga otro jugador");
						}else {
							for (Jugador tmpJugador : jugadores) {
								tmpJugador.setActivo(true);
							}
							System.out.println("No hay nadie encerrado en el pozo ahora");
							personaPozo = false;
						}
						
						
					}
					
					if(casillaActualizar == 42) {
						casillaActualizar = 30;
						cambiarCasilla = false;
						jugadores.get(turno).setCasilla(casillaActualizar);
						posicion = posiciones.get(casillaActualizar);
						mueveFicha(casillaActualizar, posicion, jugador);
					}
					
					if(casillaActualizar == 53) {
						System.out.println("El jugador retrocede a la casilla 26");
						casillaActualizar = 26;
						cambiarCasilla = false;
						posicion = posiciones.get(casillaActualizar);
						jugadores.get(turno).setCasilla(casillaActualizar);
						mueveFicha(casillaActualizar, posicion, jugador);
					}
					if(casillaActualizar == 56) {
						if(!personaCarcel) {
							personaCarcel = true;
							jugadores.get(turno).setActivo(false);
							System.out.println("El jugador "+jugador.getNombre()+" se ha quedado encerrado en el pozo, saldra cuando caiga otro jugador");
						}else {
							for (Jugador tmpJugador : jugadores) {
								tmpJugador.setActivo(true);
							}
							System.out.println("No hay nadie encerrado en la carcel ahora");
							personaPozo = false;
						}
					}
					if(casillaActualizar == 58) {
						cambiarCasilla = false;
						jugadores.get(turno).setCasilla(1);
						mueveFicha(1, null, jugador);
						
					}
					
					 
	
		
		

	}
	
	//Movimiento de la ficha
	
	private void mueveFicha(int casillaActualizar,CasillaPosicion posicion, Jugador jugador) {
		if (casillaActualizar == 1) {
		    if (jugador.getPersonaje().equals("Llados")) {
		        vista.lblFichaLlados.setLocation(XINICLLADOS, YINICIAL);
		    } else if (jugador.getPersonaje().equals("elxokas")) {
		        vista.lblFichaXokas.setLocation(XINICXOKAS, YINICIAL);
		    }
		    //Casillas hacia arriba
		} else if (casillaActualizar >= 2 && casillaActualizar <=10 || casillaActualizar>=19 && casillaActualizar<=28) {
		    if (jugador.getPersonaje().equals("Llados")) {
		        vista.lblFichaLlados.setLocation(posicion.getX(), posicion.getY());
		        
		    } else if (jugador.getPersonaje().equals("elxokas")) {
		        vista.lblFichaXokas.setLocation(posicion.getX(), posicion.getY() + XYCAMBIO);
		    }
		   
		    //casilla hacia el lado
		} else if(casillaActualizar >= 11 && casillaActualizar<=18 || casillaActualizar>=29 && casillaActualizar<=35){
			 if (jugador.getPersonaje().equals("Llados")) {
			        vista.lblFichaLlados.setLocation(posicion.getX(), posicion.getY());
			    } else if (jugador.getPersonaje().equals("elxokas")) {
			        vista.lblFichaXokas.setLocation(posicion.getX()+XYCAMBIO, posicion.getY());
			    }
		}
		 vista.lblFichaLlados.revalidate();
	     vista.lblFichaLlados.repaint();
	     
	     vista.lblFichaXokas.revalidate();
	     vista.lblFichaXokas.repaint();
	
		
	}





 



	//RELLENO UN HASHMAP CON KEY=CASILLA,VALUE=X E Y DE LA CASILLA
	public Map<Integer,CasillaPosicion> rellenarPosiciones() {
		Map <Integer,CasillaPosicion> posiciones = new HashMap<>();
		
		posiciones.put(2,new CasillaPosicion(125,612));
		posiciones.put(3, new CasillaPosicion(188,611));
		posiciones.put(4, new CasillaPosicion(235,612));
		posiciones.put(5, new CasillaPosicion(287,612));
		posiciones.put(6, new CasillaPosicion(354,611));
		posiciones.put(7, new CasillaPosicion(410,612));
		posiciones.put(8, new CasillaPosicion(465,611));
		posiciones.put(9, new CasillaPosicion(512,614));
		posiciones.put(10, new CasillaPosicion(618,580));
		posiciones.put(11, new CasillaPosicion(607,525));
		posiciones.put(12, new CasillaPosicion(607,469));
		posiciones.put(13, new CasillaPosicion(607,410));
		posiciones.put(14, new CasillaPosicion(607,354));
		posiciones.put(15, new CasillaPosicion(607,299));
		posiciones.put(16, new CasillaPosicion(607,243));
		posiciones.put(17, new CasillaPosicion(607,178));
		posiciones.put(18, new CasillaPosicion(607,131));
		posiciones.put(19, new CasillaPosicion(607,0));
		posiciones.put(20, new CasillaPosicion(512,0));
		posiciones.put(21, new CasillaPosicion(456,0));
		posiciones.put(22, new CasillaPosicion(401,0));
		posiciones.put(23, new CasillaPosicion(346,0));
		posiciones.put(24, new CasillaPosicion(290,0));
		posiciones.put(25, new CasillaPosicion(235,0));
		posiciones.put(26, new CasillaPosicion(179,0));
		posiciones.put(27, new CasillaPosicion(125,0));
		posiciones.put(28, new CasillaPosicion(42,0));
		posiciones.put(29, new CasillaPosicion(10,123));
		posiciones.put(30, new CasillaPosicion(10,179));
		posiciones.put(31, new CasillaPosicion(10,234));
		posiciones.put(32, new CasillaPosicion(10,290));
		posiciones.put(33, new CasillaPosicion(10,346));
		posiciones.put(34, new CasillaPosicion(10,403));
		posiciones.put(35, new CasillaPosicion(10,459));
		posiciones.put(36, new CasillaPosicion(42,504));
		
		
		
	
		
		
		
		
		return posiciones;
	}

	








	//tiramos los dados de forma aleatoria y retornamos el resultado de la suma entre estos 2 dados
	//si el jugador esta en una posicion menor de 60 y retorna el dado 1 si el jugador esta en una casilla mayor
	//que 60,de eso se encarga el boolean que se lo paso en funcion de la casilla del jugador
	
	public int tirarDados(VistaOca vista,boolean dosDados) {

	
		
		int dado1 = (int) (1 + Math.random() * 6);
		int dado2 = (int) (1 + Math.random() * 6);
		
		
		
		dado1 = 6;
		dado2 = 5;
	
		
		cambiarImagenes(vista, dado1, 1);
		if(dosDados && juegoCon2Dados) {
			cambiarImagenes(vista, dado2, 2);
			return dado1+dado2;
			
		}else if(!dosDados || !juegoCon2Dados){
			return dado1;
		}else {
			return 0;
		}
	
		
		

		
		
		
		

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
			default:
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
	public void frasesDerrotaLlados(String personaje)
			throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		int random = (int) (1+Math.random() * 3);
		Clip sonido = AudioSystem.getClip();

		if (personaje.equalsIgnoreCase("llados")) { //sonido llados
			if(random == 1){
				sonido.open(AudioSystem.getAudioInputStream(new File("audios/escomofuck.wav")));
			}else if(random == 2) {
				sonido.open(AudioSystem.getAudioInputStream(new File("audios/nopuedoduraraqui.wav")));
			}else {
				
			}
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