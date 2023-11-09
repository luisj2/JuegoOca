package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorOca;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class VistaOca extends JFrame {

	private JPanel contentPane;
	public JPanel panelInicio;
	public JTextPane textPaneNombres;
	public JList<String> listaJugadores;
	public JButton btnJugar;
	public JPanel panelPrincipal;
	private JLabel lblSeleccionaElColor;
	public ArrayList<String> personajes = new ArrayList<>(Arrays.asList("Llados", "elxokas"));
	public JComboBox<String> comboBox;
	public JLabel lblRetroalimentacion;
	public JButton btnAniadirJugador;
	public JLabel ImagenFicha;
	public JPanel panelDados;
	public JLabel lblDado1;
	public JLabel lblDado2;
	public JButton btnTirarDados;
	public JLabel lblRetroalimentacionJuego;
	public JPanel panelPreguntas;
	public JLabel lblPregunta;
	public JRadioButton radiobtnRespuesta1;
	public JRadioButton radiobtnRespuesta2;
	public JRadioButton radiobtnRespuesta3;
	public JButton btnMostrarPregunta;
	public JButton btnResponder;
	public JLabel lblFichaLlados;
	public JLabel lblFichaXokas;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JPanel panelCasilla1;
	public JPanel panelCasilla2;
	public JButton btnCasilla2;
	private JLabel lblNewLabel_2;
	private ButtonGroup grupoButtons;
	public JPanel panelCasilla3;
	public JPanel panelCasilla4;
	public JPanel panelCasilla5;
	public JButton btnImprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaOca frame = new VistaOca();
					ControladorOca controlador = new ControladorOca(frame);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaOca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
						panelInicio = new JPanel();
						panelInicio.setBackground(new Color(128, 0, 255));
						panelInicio.setBounds(0, 0, 888, 706);
						contentPane.add(panelInicio);
						panelInicio.setLayout(null);
						
								JLabel lblNewLabel = new JLabel("Introduce el nombre del jugador");
								lblNewLabel.setBounds(292, 55, 245, 23);
								panelInicio.add(lblNewLabel);
								
										textPaneNombres = new JTextPane();
										textPaneNombres.setBounds(292, 88, 265, 19);
										panelInicio.add(textPaneNombres);
										
												listaJugadores = new JList();
												listaJugadores.setBounds(10, 59, 200, 200);
												panelInicio.add(listaJugadores);
												
														JLabel lblJugadores = new JLabel("Jugadores");
														lblJugadores.setBounds(62, 26, 134, 23);
														panelInicio.add(lblJugadores);
														
																btnJugar = new JButton("");
																btnJugar.setIcon(new ImageIcon("Imagenes/FlechaJugarBuena.png"));
																btnJugar.setBounds(729, 567, 100, 88);
																btnJugar.setVisible(false);
																panelInicio.add(btnJugar);
																
																		lblSeleccionaElColor = new JLabel("Selecciona el personaje que quieres ser:");
																		lblSeleccionaElColor.setBounds(341, 146, 216, 23);
																		panelInicio.add(lblSeleccionaElColor);
																		
																				comboBox = new JComboBox();
																				comboBox.setBounds(397, 190, 69, 21);
																				panelInicio.add(comboBox);
																				
																						lblRetroalimentacion = new JLabel("");
																						lblRetroalimentacion.setForeground(new Color(255, 0, 0));
																						lblRetroalimentacion.setBounds(264, 353, 340, 192);
																						panelInicio.add(lblRetroalimentacion);
																						
																								btnAniadirJugador = new JButton("A\u00F1adir Jugador");
																								btnAniadirJugador.setBounds(365, 260, 148, 21);
																								panelInicio.add(btnAniadirJugador);
																								
																										ImagenFicha = new JLabel("");
																										ImagenFicha.setIcon(new ImageIcon("Imagenes/lladosbuena.png"));
																										ImagenFicha.setBounds(567, 164, 100, 91);
																										panelInicio.add(ImagenFicha);
		
				panelPrincipal = new JPanel();
				panelPrincipal.setBounds(0, 0, 888, 740);
				contentPane.add(panelPrincipal);
				panelPrincipal.setLayout(null);
				
						JPanel panelJuego = new JPanel();
						panelJuego.setBounds(10, 10, 671, 686);
						panelJuego.setLayout(null); // Establece un layout nulo para el panel
						
								// Agrega el panel al panelPrincipal
								panelPrincipal.add(panelJuego);
								
										btnMostrarPregunta = new JButton("Mostrar pregunta");
										btnMostrarPregunta.setBounds(309, 501, 142, 21);
										panelJuego.add(btnMostrarPregunta);
										
												panelCasilla1 = new JPanel();
												panelCasilla1.setBorder(new LineBorder(new Color(0, 0, 0)));
												panelCasilla1.setBackground(Color.YELLOW);
												panelCasilla1.setBounds(0, 612, 152, 74);
												panelJuego.add(panelCasilla1);
												panelCasilla1.setLayout(null);
												// btnCasilla1.setVisible(false);

												lblFichaXokas = new JLabel("");
												lblFichaXokas.setBounds(83, 10, 26, 35);
												lblFichaXokas.setIcon(new ImageIcon("Imagenes/xokasficha.png"));
												panelCasilla1.add(lblFichaXokas);
												lblFichaXokas.setVisible(false);
												
														lblFichaLlados = new JLabel("");
														lblFichaLlados.setBounds(116, 10, 26, 35);
														lblFichaLlados.setIcon(new ImageIcon("Imagenes/lladosficha.png"));
														panelCasilla1.add(lblFichaLlados);
														lblFichaLlados.setVisible(false);
														
																lblNewLabel_3 = new JLabel("");
																lblNewLabel_3.setBounds(48, 10, 26, 35);
																panelCasilla1.add(lblNewLabel_3);
																lblNewLabel_3.setVisible(false);
																
																		lblNewLabel_4 = new JLabel("");
																		lblNewLabel_4.setBounds(10, 10, 26, 35);
																		panelCasilla1.add(lblNewLabel_4);
																		lblNewLabel_4.setVisible(false);
																		
																				panelCasilla2 = new JPanel();
																				panelCasilla2.setBorder(new LineBorder(new Color(0, 0, 0)));
																				panelCasilla2.setBackground(Color.ORANGE);
																				panelCasilla2.setBounds(152, 612, 75, 74);
																				panelJuego.add(panelCasilla2);
																				panelCasilla2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
																				
																						panelCasilla3 = new JPanel();
																						panelCasilla3.setBorder(new LineBorder(new Color(0, 0, 0)));
																						panelCasilla3.setBackground(Color.ORANGE);
																						panelCasilla3.setBounds(226, 612, 75, 74);
																						panelJuego.add(panelCasilla3);
																						
																								panelCasilla4 = new JPanel();
																								panelCasilla4.setBorder(new LineBorder(new Color(0, 0, 0)));
																								panelCasilla4.setBackground(Color.ORANGE);
																								panelCasilla4.setBounds(295, 612, 75, 74);
																								panelJuego.add(panelCasilla4);
																								
																										panelCasilla5 = new JPanel();
																										panelCasilla5.setBorder(new LineBorder(new Color(0, 0, 0)));
																										panelCasilla5.setBackground(Color.ORANGE);
																										panelCasilla5.setBounds(363, 612, 75, 74);
																										panelJuego.add(panelCasilla5);
																										
																												btnImprimir = new JButton("ImprimirPreguntas");
																												btnImprimir.setBounds(20, 163, 85, 21);
																												panelJuego.add(btnImprimir);
																												panelCasilla2.setVisible(true);
																												
																														panelDados = new JPanel();
																														panelDados.setBounds(691, 10, 187, 246);
																														panelPrincipal.add(panelDados);
																														panelDados.setLayout(null);
																														panelDados.setVisible(false);
																														
																																lblDado1 = new JLabel("");
																																lblDado1.setBounds(10, 24, 84, 106);
																																panelDados.add(lblDado1);
																																
																																		lblDado2 = new JLabel("");
																																		lblDado2.setBounds(103, 24, 84, 106);
																																		panelDados.add(lblDado2);
																																		
																																				btnTirarDados = new JButton("Tirar dados");
																																				btnTirarDados.setBounds(25, 189, 152, 21);
																																				panelDados.add(btnTirarDados);
																																				
																																						lblRetroalimentacionJuego = new JLabel("");
																																						lblRetroalimentacionJuego.setBounds(691, 293, 187, 269);
																																						panelPrincipal.add(lblRetroalimentacionJuego);

		panelPreguntas = new JPanel();
		panelPreguntas.setBounds(232, 105, 349, 374); // Establece las coordenadas y el tama�o
		contentPane.add(panelPreguntas);
		panelPreguntas.setLayout(null);
		panelPreguntas.setVisible(false);

		lblPregunta = new JLabel("");
		lblPregunta.setBounds(10, 5, 329, 94);
		panelPreguntas.add(lblPregunta);

		grupoButtons = new ButtonGroup();

		radiobtnRespuesta1 = new JRadioButton("");
		radiobtnRespuesta1.setBounds(10, 105, 276, 20); // Establece las coordenadas y el tama�o
		panelPreguntas.add(radiobtnRespuesta1);
		grupoButtons.add(radiobtnRespuesta1);

		radiobtnRespuesta2 = new JRadioButton("");
		radiobtnRespuesta2.setBounds(10, 135, 276, 20);
		panelPreguntas.add(radiobtnRespuesta2);
		grupoButtons.add(radiobtnRespuesta2);

		radiobtnRespuesta3 = new JRadioButton("");
		radiobtnRespuesta3.setBounds(10, 165, 276, 20);
		panelPreguntas.add(radiobtnRespuesta3);
		grupoButtons.add(radiobtnRespuesta3);

		btnResponder = new JButton("Responder");
		btnResponder.setBounds(26, 254, 276, 30); // Ajusta las coordenadas y el tama�o seg�n tus necesidades
		panelPreguntas.add(btnResponder);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(152, 0, 75, 74);
		/*
		 * JLabel lblFondoInicio = new JLabel(""); lblFondoInicio.setIcon(new
		 * ImageIcon("C:\\Users\\Luis Jesus\\Desktop\\2\u00BADAM\\Interfaces\\Ejercicios_Interfaces\\Oca\\Imagenes\\Fondo.jfif"
		 * )); lblFondoInicio.setBounds(0, 0, 888, 706);
		 * panelInicio.add(lblFondoInicio);
		 */

		for (int i = 0; i < personajes.size(); i++) {
			comboBox.addItem(personajes.get(i));
		}

	}
}
