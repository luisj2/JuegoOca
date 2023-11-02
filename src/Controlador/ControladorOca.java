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

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Modelo.Jugador;
import Modelo.PanelNumero;
import Modelo.Pregunta;
import Vista.VistaOca;

public class ControladorOca implements ActionListener {

	VistaOca vista = new VistaOca();
	DefaultListModel modelo = new DefaultListModel<>();
	ArrayList<String> jugadorestr = new ArrayList<>();
	ArrayList<Jugador> jugadores = new ArrayList<>();
	ArrayList<Pregunta> preguntas = rellenarPreguntasLlados();
	Pregunta pregunta = new Pregunta();
	ArrayList<PanelNumero> numPanel = new ArrayList<>();

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * String seleccion = vista.comboBox.getSelectedItem().toString();
		 * JOptionPane.showMessageDialog(vista, seleccion);
		 */

		if (vista.radiobtnRespuesta1.isSelected()) {
			vista.radiobtnRespuesta2.setSelected(false);
			vista.radiobtnRespuesta3.setSelected(false);
		} else if (vista.radiobtnRespuesta2.isSelected()) {
			vista.radiobtnRespuesta1.setSelected(false);
			vista.radiobtnRespuesta3.setSelected(false);
		} else if (vista.radiobtnRespuesta3.isSelected()) {
			vista.radiobtnRespuesta1.setSelected(false);
			vista.radiobtnRespuesta2.setSelected(false);
		}
		if (e.getSource() == vista.btnMostrarPregunta) {
			int preguntaRandom = (int) (Math.random() * preguntas.size());
			pregunta = preguntas.get(preguntaRandom);

			vista.lblPregunta.setText(pregunta.getPregunta());
			vista.radiobtnRespuesta1.setText(pregunta.getRespuestas().get(0));
			vista.radiobtnRespuesta2.setText(pregunta.getRespuestas().get(1));
			vista.radiobtnRespuesta3.setText(pregunta.getRespuestas().get(2));

			if (!vista.panelPreguntas.isVisible()) {
				vista.panelPreguntas.setVisible(true);
			}

		}

		if (e.getSource() == vista.btnResponder) {

			if (vista.radiobtnRespuesta1.isSelected()) {
				if (vista.radiobtnRespuesta1.getText().equalsIgnoreCase(pregunta.getCorrecta())) {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.green);
					vista.lblRetroalimentacionJuego.setText("Respuesta correcta");
					vista.radiobtnRespuesta1.setSelected(false);
				} else {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.red);
					vista.lblRetroalimentacionJuego.setText("Respuesta incorrecta");
					vista.radiobtnRespuesta1.setSelected(false);
				}
			} else if (vista.radiobtnRespuesta2.isSelected()) {
				if (vista.radiobtnRespuesta2.getText().equalsIgnoreCase(pregunta.getCorrecta())) {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.green);
					vista.lblRetroalimentacionJuego.setText("Respuesta correcta");
					vista.radiobtnRespuesta2.setSelected(false);
				} else {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.red);
					vista.lblRetroalimentacionJuego.setText("Respuesta incorrecta");
					vista.radiobtnRespuesta2.setSelected(false);
				}
			} else if (vista.radiobtnRespuesta3.isSelected()) {
				if (vista.radiobtnRespuesta3.getText().equalsIgnoreCase(pregunta.getCorrecta())) {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.green);
					vista.lblRetroalimentacionJuego.setText("Respuesta correcta");
					vista.radiobtnRespuesta1.setSelected(false);
				} else {
					vista.lblRetroalimentacionJuego.setText("");
					vista.lblRetroalimentacionJuego.setForeground(Color.red);
					vista.lblRetroalimentacionJuego.setText("Respuesta incorrecta");
					vista.radiobtnRespuesta2.setSelected(false);
				}
			}

		}

		if (e.getSource() == vista.btnAniadirJugador) {
			vista.lblRetroalimentacion.setText("");
			String nombre = vista.textPaneNombres.getText().toString();
			String personaje = vista.comboBox.getSelectedItem().toString();
			boolean jugadorRepite = false;
			boolean nombreRepite = false;

			for (Jugador jugador : jugadores) {
				if (jugador.getPersonaje().equalsIgnoreCase(personaje)) {
					jugadorRepite = true;
				}
				if (jugador.getNombre().equals(nombre)) {
					nombreRepite = true;
				}
			}

			if (!nombre.isEmpty() && !personaje.isEmpty()) {

				if (!jugadorRepite && !nombreRepite) {
					if (jugadorestr.size() <= 4) {
						Jugador jugador = new Jugador();
						jugadorestr.add(nombre);

						jugador.setNombre(nombre);
						jugador.setPersonaje(personaje);

						jugadores.add(jugador);

						try {
							elegirFicha(vista, personaje);
						} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
							e1.printStackTrace();
						}

						modelo.removeAllElements();

						for (int i = 0; i < jugadores.size(); i++) {
							modelo.addElement(jugadores.get(i).getNombre() + " | " + jugadores.get(i).getPersonaje());
						}

						vista.listaJugadores.setModel(modelo);
						vista.textPaneNombres.setText("");

						/*
						 * for (int i = 0; i < vista.colores.size(); i++) { String colorEliminar =
						 * vista.colores.get(i); if(personaje.equalsIgnoreCase(colorEliminar)) {
						 * vista.colores.remove(i); }
						 * 
						 * } vista.comboBox.removeAllItems(); for (int i = 0; i < vista.colores.size();
						 * i++) { vista.comboBox.addItem(vista.colores.get(i)); }
						 */

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

		if (e.getSource() == vista.btnJugar) {
			if (jugadores.size() >= 2 && jugadores.size() <= 4) {
				repartirFichas(jugadores, vista);

				vista.panelInicio.setVisible(false);
				vista.panelPrincipal.setVisible(true);

			} else {
				vista.lblRetroalimentacion.setText("");
				vista.lblRetroalimentacion.setText("Se necesitan al menos 2 jugadores");
			}
		}
		if (e.getSource() == vista.btnTirarDados) {
			tirarDados(vista);
		}

	}

	public void tirarDados(VistaOca vista) {

		int dado1 = (int) (1 + Math.random() * 6);
		int dado2 = (int) (1 + Math.random() * 6);

		cambiarImagenes(vista, dado1, 1);
		cambiarImagenes(vista, dado2, 2);

	}

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

	public void elegirFicha(VistaOca vista, String personaje)
			throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		Clip sonido = AudioSystem.getClip();

		if (personaje.equalsIgnoreCase("llados")) {
			vista.ImagenFicha.setIcon(new ImageIcon("Imagenes/lladosbuena.png"));
			sonido.open(AudioSystem.getAudioInputStream(new File("audios/panzapanza.wav")));
			sonido.start();
		} else if (personaje.equalsIgnoreCase("elxokas")) {
			vista.ImagenFicha.setIcon(new ImageIcon("Imagenes/xokasBuena.png"));
			sonido.open(AudioSystem.getAudioInputStream(new File("audios/noesunjuego.wav")));
			sonido.start();
		}

	}

	public void repartirFichas(ArrayList<Jugador> jugadores, VistaOca vista) {

		for (Jugador jugador : jugadores) {
			if (jugador.getPersonaje().equalsIgnoreCase("llados")) {

				vista.panelCasilla1.remove(vista.lblFichaLlados);
				vista.panelCasilla2.add(vista.lblFichaLlados);

				vista.lblFichaLlados.setVisible(true);

			}
			if (jugador.getPersonaje().equalsIgnoreCase("elxokas")) {

				vista.panelCasilla1.remove(vista.lblFichaXokas);
				vista.panelCasilla2.add(vista.lblFichaXokas);

				vista.lblFichaXokas.setVisible(true);
			}

			vista.revalidate();
			vista.repaint();

		}

	}

}
