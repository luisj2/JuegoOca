package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

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

	Pregunta pregunta = new Pregunta();
	int turno;
	boolean modTurno;
	//VARIABLE QUE HACE EL CAMBIO DE LA X o Y DE UNA FICHA Y OTRA PARA QUE NO ESTEN JUNTAS
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
	Map <String,String> acertijos = rellenarAcertijos();
	int intentosAcertijo;
	String respuestaAcertijo;
	
	Map <String,String> respuestasAcertijos = respuestasAcertijos();
	
	String nombrePersonaPozo ="";
	String nombrePersonaCarcel = "";
	String preguntaAcertijo ="";
	
	Jugador jugadorCambiar = null;

	
	
	

	//contructor
	public ControladorOca(VistaOca frame) {
		this.vista = frame;
		
		this.vista.btnAniadirJugador.addActionListener(this);
		this.vista.btnJugar.addActionListener(this);
		this.vista.btnTirarDados.addActionListener(this);
		this.vista.btnResponderAcertijo.addActionListener(this);
		this.vista.btnExit.addActionListener(this);
		
		this.vista.radioBtn1Dado.addActionListener(this);
		this.vista.radioBtn2Dado.addActionListener(this);
		//LOS MUEVO LAS FICHAS A SUS SITIOS INICIALES
		vista.lblFichaLlados.setLocation(XINICLLADOS,YINICIAL);
		vista.lblFichaXokas.setLocation(XINICXOKAS,YINICIAL);
		
		personaPozo = false;
		personaCarcel = false;
		
		
	}
	
	
	
	
		
	
	  

	
	

	private Map<String, String> rellenarAcertijos() {
		Map<String,String> acertijos = new HashMap<>();
		
		acertijos.put("¿Qué va hacia arriba cuando la lluvia viene hacia abajo?", "sombrilla");
		acertijos.put("¿En qué lugar se encuentran los ríos que no tienen agua?", "mapa");
		acertijos.put("¿Cómo se les llama a los abuelos en China?", "nombre");
		acertijos.put("¿Qué le paso al león luego de haberse tragado a un payaso?", "risa");
		acertijos.put("¿Qué se necesita para encender una vela?", "apagada");
		acertijos.put("¿Cuál es el malestar que tiene el 1+2?", "estres");
		acertijos.put("¿Qué objeto puede tener cara sin poseer cuerpo?", "moneda");
		acertijos.put("¿Cual es el ultimo animal que creo Dios?", "delfin");
		acertijos.put("¿Donde guarda un superheroe su disfraz?", "perchero");
		acertijos.put("¿Tiene 4 letras, empieza por C y termina por O y esta en la parte trasera?", "codo");
		acertijos.put("Si me nombras desaparezco, ¿qué soy?", "silencio");
		return acertijos;
	}
	private Map<String, String> respuestasAcertijos() {
		Map<String,String> acertijos = new HashMap<>();
		
		acertijos.put("¿Qué va hacia arriba cuando la lluvia viene hacia abajo?", "La Sombrilla");
		acertijos.put("¿En qué lugar se encuentran los ríos que no tienen agua?", "en los Mapas");
		acertijos.put("¿Cómo se les llama a los abuelos en China?", "por su Nombre");
		acertijos.put("¿Qué le paso al león luego de haberse tragado a un payaso?", "le dio risa");
		acertijos.put("¿Qué se necesita para encender una vela?", "que este apagada");
		acertijos.put("¿Cuál es el malestar que tiene el 1+2?", "el estres");
		acertijos.put("¿Qué objeto puede tener cara sin poseer cuerpo?", "una moneda");
		acertijos.put("¿Cual es el ultimo animal que creo Dios?", "El delfin");
		acertijos.put("¿Donde guarda un superheroe su disfraz?", "En superchero");
		acertijos.put("Tiene 4 letras, empieza por C y termina por O y esta en la parte trasera", "El codo");
		acertijos.put("Si me nombras desaparezco, ¿qué soy?", "El silencio");
		
			


		

		
		return acertijos;
	}











	public ControladorOca() {
		
	}











	//FUNCIONALIDAD DE LOS BUTTONS
	@Override
	public void actionPerformed(ActionEvent e) {
		
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
			
			if (jugadores.get(turno).getTurnosRestantes() == 0 && jugadores.get(turno).isActivo()) {
			    // El jugador actual no tiene más turnos restantes y está activo

			    int totalDados = 0;

			    // Verificar si el juego utiliza 2 dados
			    if (juegoCon2Dados) {
			        if (jugadores.get(turno).getCasilla() >= 60) {
			            vista.lblDado2.setVisible(false);
			            totalDados = tirarDados(vista, false);
			        } else {
			            vista.lblDado2.setVisible(true);
			            totalDados = tirarDados(vista, true);
			        }
			    } else {
			        totalDados = tirarDados(vista, false);
			    }

			    // Determinar a qué casilla se moverá el jugador
			    modTurno = true;
			    int casillaMovimiento = jugadores.get(turno).getCasilla() + totalDados;

			    // Almacenar la posición antigua del jugador
			    int posicionAntigua = jugadores.get(turno).getCasilla();

			    // Actualizar la ficha del jugador y mostrar mensajes en la vista
			    ActualizarFicha(casillaMovimiento, jugadores.get(turno), true, vista);

			    if (cambiarCasilla) {
			        jugadores.get(turno).setCasilla(casillaMovimiento);
			    }
			} else if (jugadores.get(turno).getTurnosRestantes() > 0 && jugadores.get(turno).isActivo()) {
			    // El jugador tiene turnos restantes y está activo

			    // Reducir un turno restante
			    jugadores.get(turno).setTurnosRestantes(jugadores.get(turno).getTurnosRestantes() - 1);

			    // Establecer las banderas de personaPozo y personaCarcel
			    personaPozo = true;
			    personaCarcel = true;

			    // Mostrar mensajes en la vista según los turnos restantes
			    if (jugadores.get(turno).getTurnosRestantes() == 0) {
			        vista.lblRetroalimentacionJuego.setText("");
			        vista.lblRetroalimentacionJuego.setText(jugadores.get(turno).getNombre() + " no juega en este turno,\n jugara en el siguiente");
			    } else {
			        vista.lblRetroalimentacionJuego.setText("");
			        vista.lblRetroalimentacionJuego.setText(jugadores.get(turno).getNombre() + " no juega este turno,\n le quedan "
			                + jugadores.get(turno).getTurnosRestantes() + " turnos");
			    }
			} else if (!jugadores.get(turno).isActivo() && jugadores.get(turno).getTurnosRestantes() > 0) {
			    // El jugador no está activo y tiene turnos restantes

			    // Reducir un turno restante
			    jugadores.get(turno).setTurnosRestantes(jugadores.get(turno).getTurnosRestantes() - 1);

			    // Activar al jugador si los turnos restantes llegan a cero
			    if (jugadores.get(turno).getTurnosRestantes() == 0) {
			        jugadores.get(turno).setActivo(true);
			    }

			    // Mostrar mensajes en la vista según la situación del jugador
			    if (jugadores.get(turno).getCasilla() == 31) {
			        vista.lblRetroalimentacionJuego.setText("");
			        vista.lblRetroalimentacionJuego.setText(jugadores.get(turno).getNombre() + " está encerrado en el pozo \n"
			                + "Le quedan " + jugadores.get(turno).getTurnosRestantes());
			    } else {
			        vista.lblRetroalimentacionJuego.setText("");
			        vista.lblRetroalimentacionJuego.setText(jugadores.get(turno).getNombre() + " está encerrado en la cárcel \n"
			                + "Le quedan " + jugadores.get(turno).getTurnosRestantes());
			    }
			}

			// Actualizar los turnos
			if (turno == 1 && modTurno) {
			    turno = 0;
			} else if (turno != 1 && modTurno) {
			    turno++;
			}

					

					
				}
		
		if (e.getSource() == vista.btnResponderAcertijo) {
		    // Verificar si el botón presionado es el de responder al acertijo

		    String respuestaUsuario = vista.textFieldRespuesta.getText().toString().toLowerCase();
		    boolean cambiarPanel = false;
		    preguntaAcertijo = vista.preguntaAcertijo.getText().toString();

		    // Comprobar si la respuesta del usuario contiene la respuesta correcta del acertijo
		    if (respuestaUsuario.contains(respuestaAcertijo)) {
		        // La respuesta es correcta

		        vista.lblRetroalimentacionJuego.setText("");
		        vista.lblRetroalimentacionJuego.setText("Respuesta correcta " + jugadorCambiar.getNombre() + " avanzas 1 casilla");

		        // Mover la ficha del jugador y actualizar la casilla de todos los jugadores con el mismo personaje
		        jugadorCambiar.setCasilla(jugadorCambiar.getCasilla() + 1);
		        mueveFicha(jugadorCambiar.getCasilla(), posiciones.get(jugadorCambiar.getCasilla()), jugadorCambiar, vista, false);
		        for (Jugador tmpJugador : jugadores) {
		            if (tmpJugador.getPersonaje().equals(jugadorCambiar.getPersonaje())) {
		                tmpJugador.setCasilla(tmpJugador.getCasilla() + 1);
		            }
		        }

		        cambiarPanel = true;
		    } else {
		        // La respuesta es incorrecta, reducir el número de intentos
		        intentosAcertijo--;
		        if (intentosAcertijo > 1 || intentosAcertijo == 0) {
		            vista.lblRetroalimentacionAcertijo.setText("");
		            vista.lblRetroalimentacionAcertijo.setText("Respuesta incorrecta te quedan " + intentosAcertijo + " intentos");
		        } else {
		            vista.lblRetroalimentacionAcertijo.setText("");
		            vista.lblRetroalimentacionAcertijo.setText("Respuesta incorrecta te queda " + intentosAcertijo + " intento");
		        }
		    }

		    // Verificar si se han agotado los intentos
		    if (intentosAcertijo == 0) {
		        cambiarPanel = true;

		        // Retroceder 1 casilla y mostrar la respuesta correcta
		        jugadorCambiar.setCasilla(jugadorCambiar.getCasilla() - 1);
		        mueveFicha(jugadorCambiar.getCasilla(), posiciones.get(jugadorCambiar.getCasilla()), jugadorCambiar, vista, false);
		        for (Jugador tmpJugador : jugadores) {
		            if (tmpJugador.getPersonaje().equals(jugadorCambiar.getPersonaje())) {
		                tmpJugador.setCasilla(tmpJugador.getCasilla() - 1);
		            }
		        }

		        vista.lblRetroalimentacionJuego.setText("");
		        vista.lblRetroalimentacionJuego.setText("Se te han acabado los intentos retrocedes 1 casilla "
		                + "La respuesta correcta \n es: " + respuestasAcertijos.get(preguntaAcertijo));
		    }

		    // Cambiar paneles según el resultado
		    if (cambiarPanel) {
		        vista.panelAcertijos.setVisible(false);
		        vista.panelDados.setVisible(true);
		        vista.panelPrincipal.setVisible(true);
		        acertijos.remove(preguntaAcertijo);
		    }
		    vista.textFieldRespuesta.setText("");
		}

		
		//salir del programa
		if(e.getSource() == vista.btnExit) {
			System.exit(0);
		}
				}
				
			
		
		

	
	//agregar al objeto jugador el label de la ficha que le corresponde
	

	//actualizar las posicion de la ficha segun lo que le ha salido en los dados
	


	//METODO PARA CAMBIAR LA POSICION DE LA FICHA EN FUNCION DEL NUMERO QUE HAYA EN LA VARIABLE CASILLAACTUALIZAR
	//Y CONTROLAR LAS OCAS
	public void ActualizarFicha(int casillaActualizar, Jugador jugador, boolean repetirOca,VistaOca vista) {
		cambiarCasilla = true;
		
		//booleana para que no se active el if de activar dados si le ha tocado la casilla 26
		boolean TocarDados = false;
	
		boolean moverAlReves = false;

		//compruebo ganador
		if (casillaActualizar > 63) {
			int exceso = casillaActualizar-62;
			casillaActualizar = 63-exceso;
			moverAlReves = true;
		}
		CasillaPosicion posicion = posiciones.get(casillaActualizar);
	
		//vista.lblRetroalimentacionJuego.setText("");
		vista.lblRetroalimentacionJuego.setText(vista.lblRetroalimentacionJuego.getText()+" \n"+jugador.getNombre()+" se mueve hasta la casilla "+casillaActualizar);
		 

		//comprobamos si ha ganado
		if (casillaActualizar == 63) {
		
			
			mostrarPanelGanador(jugador,vista);
			
		}
		//mover la ficha
		mueveFicha(casillaActualizar,posicion,jugador,vista,moverAlReves);

		// Casilla inicial

		vista.lblFichaLlados.revalidate();
		vista.lblFichaLlados.repaint();

		vista.lblFichaXokas.revalidate();
		vista.lblFichaXokas.repaint();

		// Compruebo si ha habido Oca y si hay le doy un turno extra
		if (getOcas.get(casillaActualizar) != null && repetirOca) {

			int nuevaCasilla = casillaActualizar;
			casillaActualizar = getOcas.get(casillaActualizar);
			posicion = posiciones.get(casillaActualizar);
			modTurno = false;
			vista.lblRetroalimentacionJuego.setText("");
			vista.lblRetroalimentacionJuego.setText("De oca a oca y tiras por que te toca, \n"
					);

			//vuevo a ejecutar el metodo pero le paso la booleana false para que no se vueva a meter en la oca
			ActualizarFicha(casillaActualizar, jugador, false,vista);

			
			jugadores.get(turno).setCasilla(casillaActualizar);
			cambiarCasilla = false;

		}
		// Puentes
		//puente 1 te manda a la casilla 12
		if (casillaActualizar == 6) {
			casillaActualizar = 12;
			posicion = posiciones.get(casillaActualizar);
			mueveFicha(casillaActualizar, posicion, jugador, vista,moverAlReves);
			cambiarCasilla = false;
			jugadores.get(turno).setCasilla(casillaActualizar);
			
			vista.lblRetroalimentacionJuego.setText("");
			vista.lblRetroalimentacionJuego.setText("De puente a puente el jugador " + jugador.getNombre() + " avanza hasta la casilla 12");


			//puente 2 te manda a la posada
		} else if (casillaActualizar == 12) {

			vista.lblRetroalimentacionJuego.setText("");
			vista.lblRetroalimentacionJuego.setText("De puente a puente y tiras porque te lleva la corriente \nel jugador " + jugador.getNombre() + " avanza hasta la casilla 12");

			casillaActualizar = 19;

		}
		
		//casillas de acertijos
		if(casillaActualizar ==16 || casillaActualizar == 24 || casillaActualizar == 34
			|| casillaActualizar == 38 || casillaActualizar == 47 || casillaActualizar == 11) {
			
		if(acertijos.size()>0) {
			vista.panelDados.setVisible(false);
			vista.panelPrincipal.setVisible(false);
			vista.panelAcertijos.setVisible(true);
			
			ArrayList <String> preguntasRandom = new ArrayList<>(acertijos.keySet());
			
			String preguntaRandom =preguntasRandom.get((int)(Math.random()*preguntasRandom.size()));
			
			for (Map.Entry<String, String> entry : acertijos.entrySet()) {
				if(entry.getKey().equalsIgnoreCase(preguntaRandom)) {
					vista.preguntaAcertijo.setText(entry.getKey());
					respuestaAcertijo = entry.getValue();
					break;
				}
				
			
				
				
			}
			intentosAcertijo = 3;
			vista.textFieldRespuesta.setText("");
			vista.lblRetroalimentacionAcertijo.setText("");
			jugadorCambiar = jugadores.get(turno);
		}
			
			
			
		
			
			
		}
		//posada
		if (casillaActualizar == 19) {
			vista.lblRetroalimentacionJuego.setText("");
			vista.lblRetroalimentacionJuego.setText(jugador.getNombre()+" avanzas hasta la posada pero pierdes el turno");
			cambiarCasilla = false;
			posicion = posiciones.get(casillaActualizar);
			
			//muevo la ficha y dejo sin jugar un turno al jugador
			mueveFicha(casillaActualizar, posicion, jugador, vista,moverAlReves);
			jugadores.get(turno).setCasilla(casillaActualizar);
			jugadores.get(turno).setTurnosRestantes(jugadores.get(turno).getTurnosRestantes() + 1);

		}
		// Dados de la casilla 26
		if (casillaActualizar == 26) {
			vista.lblRetroalimentacionJuego.setText("");
			vista.lblRetroalimentacionJuego.setText("De dado a dado y tiras porque te ha tocado"+jugador.getNombre()+" avanzas hasta la casilla 53");
			casillaActualizar = 53;
			cambiarCasilla = false;
			posicion = posiciones.get(casillaActualizar);
			jugadores.get(turno).setCasilla(casillaActualizar);
			mueveFicha(casillaActualizar, posicion, jugador, vista,moverAlReves);
			TocarDados = true;
		}
		// Pozo
		if (casillaActualizar == 31) {
			
			if (!personaPozo) {
				nombrePersonaPozo = jugadores.get(turno).getPersonaje();
				personaPozo = true;
				jugadores.get(turno).setActivo(false);
				jugadores.get(turno).setTurnosRestantes(3);
				vista.lblRetroalimentacionJuego.setText("");
				vista.lblRetroalimentacionJuego.setText("El jugador " + jugador.getNombre()
				+ " se ha quedado encerrado en el pozo, \nsaldra cuando caiga otro jugador o pasen 3 turnos");
			} else if(personaPozo && !jugadores.get(turno).getPersonaje().equalsIgnoreCase(nombrePersonaPozo)){
				for (Jugador tmpJugador : jugadores) {
					tmpJugador.setActivo(true);
					tmpJugador.setTurnosRestantes(tmpJugador.getTurnosRestantes()-tmpJugador.getTurnosRestantes());
				}
				vista.lblRetroalimentacionJuego.setText("");
				vista.lblRetroalimentacionJuego.setText("No hay nadie en el pozo ahora");
				personaPozo = false;
			}

		}

		//laberinto
		if (casillaActualizar == 42) {
			casillaActualizar = 30;
			cambiarCasilla = false;
			jugadores.get(turno).setCasilla(casillaActualizar);
			posicion = posiciones.get(casillaActualizar);
			mueveFicha(casillaActualizar, posicion, jugador, vista,moverAlReves);
		}

		//Dados de la casilla 53
		if (casillaActualizar == 53 && !TocarDados) {
			vista.lblRetroalimentacionJuego.setText("");
			vista.lblRetroalimentacionJuego.setText("Mala suerte "+jugador.getNombre()+" De dado a dado retrocede hasta la casilla 26");
			casillaActualizar = 26;
			cambiarCasilla = false;
			posicion = posiciones.get(casillaActualizar);
			jugadores.get(turno).setCasilla(casillaActualizar);
			mueveFicha(casillaActualizar, posicion, jugador, vista,moverAlReves);
		}
		//Carcel
		if (casillaActualizar == 56) {
			if (!personaCarcel) {
				personaCarcel = true;
				nombrePersonaCarcel = jugadores.get(turno).getPersonaje();
				jugadores.get(turno).setActivo(false);
				jugadores.get(turno).setTurnosRestantes(jugadores.get(turno).getTurnosRestantes()+3);
				vista.lblRetroalimentacionJuego.setText("");
				if(jugador.getPersonaje().equalsIgnoreCase("Llados")) {
					vista.lblRetroalimentacionJuego.setText("Han pillado a llados a 200km/h con su lambo estara en la carcel 3 turnos\n a no "
							+ "ser que Xokas pague la fianza");
				}else {
					vista.lblRetroalimentacionJuego.setText("Han pillado a el Xokas insultando a tu madre estara en la carcel\n 3 turnos "
							+ "a no ser que Llados pague la fianza");
				}
			
			} else if(personaCarcel && !jugadores.get(turno).getPersonaje().equalsIgnoreCase(nombrePersonaCarcel)){
				for (Jugador tmpJugador : jugadores) {
					tmpJugador.setActivo(true);
					tmpJugador.setTurnosRestantes(tmpJugador.getTurnosRestantes()-tmpJugador.getTurnosRestantes());
				}
				vista.lblRetroalimentacionJuego.setText("");
				vista.lblRetroalimentacionJuego.setText("No hay nadie en la carcel ahora");
				personaPozo = false;
			}
		}
		//La muerte
		if (casillaActualizar == 58) {
			vista.lblRetroalimentacionJuego.setText("");
			if(jugador.getPersonaje().equalsIgnoreCase("Llados")) {
				
				vista.lblRetroalimentacionJuego.setText("Llados no ha hecho burpees un dia tiene que ncambiar su mindset,retrocede hasta la primera casilla");
			}else {
				vista.lblRetroalimentacionJuego.setText("Xokas ha sido baneado de twitch y tiene que volver a empezar \n"
						+ "retrocede hasta la primera casilla");

			}
			
			cambiarCasilla = false;
			jugadores.get(turno).setCasilla(1);
			mueveFicha(1, null, jugador, vista,moverAlReves);

		}

	}

	//mostrar el panel del ganador con su nombre e imagen
	public void mostrarPanelGanador(Jugador jugador, VistaOca vista2) {
		vista.panelDados.setVisible(false);
		vista.panelPrincipal.setVisible(false);
		vista.panelGanador.setVisible(true);
		vista.lblGanadorNombre.setText(jugador.getNombre());
		
		if(jugador.getPersonaje().equalsIgnoreCase("Llados")) {
			vista.lblFotoGanador.setIcon(new ImageIcon("Imagenes/llados2.jpg"));
		}else {
			vista.lblFotoGanador.setIcon(new ImageIcon("Imagenes/xokas.jpg"));
		}
	}











	//Movimiento de la ficha
	
	public void mueveFicha(int casillaActualizar,CasillaPosicion posicion, Jugador jugador,VistaOca vista,boolean moverAlReves) {
		
		//Actualizo la ficha de los jugadores y la muevo un poco hacia abajo la del xojas o un poco a la derecha segun si la
		//casilla esta en horizontal o en vertical
	
		if (casillaActualizar == 1) {
		    if (jugador.getPersonaje().equals("Llados")) {
		        vista.lblFichaLlados.setLocation(XINICLLADOS, YINICIAL);
		    } else if (jugador.getPersonaje().equals("elxokas")) {
		        vista.lblFichaXokas.setLocation(XINICXOKAS, YINICIAL);
		    }
		    //Casillas hacia arriba
		} else if (casillaActualizar >= 2 && casillaActualizar <=10 || casillaActualizar>=19 && casillaActualizar<=28 
				|| casillaActualizar >=37 && casillaActualizar<=44 || casillaActualizar>=51 && casillaActualizar <=57 || casillaActualizar==62) {
		    if (jugador.getPersonaje().equals("Llados")) {
		        vista.lblFichaLlados.setLocation(posicion.getX(), posicion.getY());
		        
		    } else if (jugador.getPersonaje().equals("elxokas")) {
		        vista.lblFichaXokas.setLocation(posicion.getX(), posicion.getY() + XYCAMBIO);
		    }
		   
		    //casilla hacia el lado
		} else if(casillaActualizar >= 11 && casillaActualizar<=18 || casillaActualizar>=29 && casillaActualizar<=35 
				|| casillaActualizar >=45 && casillaActualizar <= 50 || casillaActualizar>=58 && casillaActualizar<=61){
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
		posiciones.put(37, new CasillaPosicion(125,538));
		posiciones.put(38, new CasillaPosicion(188,538));
		posiciones.put(39, new CasillaPosicion(244,538));
		posiciones.put(40, new CasillaPosicion(299,538));
		posiciones.put(41, new CasillaPosicion(346,538));
		posiciones.put(42, new CasillaPosicion(410,538));
		posiciones.put(43, new CasillaPosicion(453,538));
		posiciones.put(44, new CasillaPosicion(543,515));
		posiciones.put(45, new CasillaPosicion(532,459));
		posiciones.put(46, new CasillaPosicion(532,410));
		posiciones.put(47, new CasillaPosicion(532,344));
		posiciones.put(48, new CasillaPosicion(532,300));
		posiciones.put(49, new CasillaPosicion(532,243));
		posiciones.put(50, new CasillaPosicion(532,189));
		posiciones.put(51, new CasillaPosicion(501,78));
		posiciones.put(52, new CasillaPosicion(420,71));
		posiciones.put(53, new CasillaPosicion(366,71));
		posiciones.put(54, new CasillaPosicion(311,71));
		posiciones.put(55, new CasillaPosicion(255,71));
		posiciones.put(56, new CasillaPosicion(198,71));
		posiciones.put(57, new CasillaPosicion(123,71));
		posiciones.put(58, new CasillaPosicion(84,189));
		posiciones.put(59, new CasillaPosicion(84,244));
		posiciones.put(60, new CasillaPosicion(84,299));
		posiciones.put(61, new CasillaPosicion(84,356));
		posiciones.put(62, new CasillaPosicion(162,326));
		
		
	
		
		
		
		
		return posiciones;
	}

	








	//tiramos los dados de forma aleatoria y retornamos el resultado de la suma entre estos 2 dados
	//si el jugador esta en una posicion menor de 60 y retorna el dado 1 si el jugador esta en una casilla mayor
	//que 60,de eso se encarga el boolean que se lo paso en funcion de la casilla del jugador
	
	public int tirarDados(VistaOca vista,boolean dosDados) {

	
		
		int dado1 = (int) (1 + Math.random() * 6);
		int dado2 = (int) (1 + Math.random() * 6);
		
		
	
	
		
		
		
		
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