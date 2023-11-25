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
import javax.swing.JDesktopPane;

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
	public JLabel lblRetroalimentacion, ImagenFicha;
	public JButton btnAniadirJugador;
	public JPanel panelDados;
	public JLabel lblDado1;
	public JLabel lblDado2;
	public JButton btnTirarDados;
	public JLabel lblRetroalimentacionJuego;
//	public JPanel panelPreguntas;
	public JLabel lblPregunta;
	public JRadioButton radioBtn1Dado;
	public JRadioButton radioBtn2Dado;
	public JRadioButton radiobtnRespuesta1;
	public JRadioButton radiobtnRespuesta2;
	public JRadioButton radiobtnRespuesta3;
	public JButton btnMostrarPregunta;
	public JButton btnResponder;
	public JLabel lblFichaLlados;
	public JLabel lblFichaXokas;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JButton btnCasilla2;
	private JLabel lblNewLabel_2;
	private ButtonGroup grupoButtons;
	private ButtonGroup grupoButtonsDados;
	public JButton btnImprimir;
	public JLabel lblCasilla1;
	public JLabel lblCasilla2;
	public JLabel lblCasilla3;
	public JLabel lblCasilla6_Puente;
	public JLabel lblCasilla7;
	public JLabel lblCasilla8;
	public JLabel lblCasilla9_Oca;
	public JLabel lblCasilla11;
	public JLabel lblCasilla12_Puente;
	public JLabel lblCasilla14_Oca;
	public JLabel lblCasilla13;
	public JLabel lblCasilla15;
	public JLabel lblCasilla16;
	public JLabel lblCasilla17;
	public JLabel lblCasilla18_Oca;
	private JLabel lblCasilla19_Posada;
	private JLabel lblCasilla20;
	private JLabel lblCasilla21;
	private JLabel lblCasilla22;
	private JLabel lblCasilla23_Oca;
	private JLabel lblCasilla24;
	private JLabel lblCasilla25;
	private JLabel lblCasilla26_Dados;
	private JLabel lblCasilla27_Oca;
	private JLabel lblCasilla28;
	private JLabel lblCasilla29;
	private JLabel lblCasilla30;
	private JLabel lblCasilla31_Pozo;
	private JLabel lblCasilla32_Oca;

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
																								
																										radioBtn1Dado = new JRadioButton("Jugar con 1 dado");
																										radioBtn1Dado.setBackground(new Color(128, 0, 255));
																										radioBtn1Dado.setBounds(302, 333, 125, 21);
																										panelInicio.add(radioBtn1Dado);
																										
																												radioBtn2Dado = new JRadioButton("Jugar con 2 dados");
																												radioBtn2Dado.setBackground(new Color(128, 0, 255));
																												radioBtn2Dado.setBounds(501, 333, 140, 21);
																												panelInicio.add(radioBtn2Dado);
																												grupoButtonsDados.add(radioBtn2Dado);
																												grupoButtonsDados.add(radioBtn1Dado);
		
				panelDados = new JPanel();
				panelDados.setBounds(691, 10, 187, 246);
				contentPane.add(panelDados);
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

		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 888, 740);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelJuego = new JPanel();
		panelJuego.setBounds(10, 10, 671, 686);
		panelJuego.setLayout(null); // Establece un layout nulo para el panel

		// Agrega el panel al panelPrincipal
		panelPrincipal.add(panelJuego);

		lblFichaXokas = new JLabel("");
		lblFichaXokas.setIcon(new ImageIcon(
				"C:\\Users\\Luis Jesus\\Desktop\\2\u00BADAM\\Interfaces\\Ejercicios_Interfaces\\Oca\\Imagenes\\xokasficha.png"));
		lblFichaXokas.setBounds(42, 630, 26, 35);
		panelJuego.add(lblFichaXokas);

		lblFichaLlados = new JLabel("");
		lblFichaLlados.setIcon(new ImageIcon(
				"C:\\Users\\Luis Jesus\\Desktop\\2\u00BADAM\\Interfaces\\Ejercicios_Interfaces\\Oca\\Imagenes\\lladosficha.png"));
		lblFichaLlados.setBounds(42, 504, 26, 35);
		panelJuego.add(lblFichaLlados);

		lblCasilla1 = new JLabel("");
		lblCasilla1.setBackground(new Color(0, 64, 64));
		lblCasilla1.setOpaque(true);
		lblCasilla1.setBounds(0, 612, 115, 74);
		panelJuego.add(lblCasilla1);

		lblCasilla2 = new JLabel("");
		lblCasilla2.setBackground(new Color(0, 255, 64));
		lblCasilla2.setOpaque(true);
		lblCasilla2.setBounds(113, 612, 56, 74);
		panelJuego.add(lblCasilla2);

		lblCasilla3 = new JLabel("");
		lblCasilla3.setOpaque(true);
		lblCasilla3.setBackground(new Color(0, 128, 0));
		lblCasilla3.setBounds(169, 612, 56, 74);
		panelJuego.add(lblCasilla3);

		JLabel lblCasilla4 = new JLabel("");
		lblCasilla4.setOpaque(true);
		lblCasilla4.setBackground(new Color(0, 255, 64));
		lblCasilla4.setBounds(224, 612, 56, 74);
		panelJuego.add(lblCasilla4);

		JLabel lblCasilla5_Oca = new JLabel("");
		lblCasilla5_Oca.setOpaque(true);
		lblCasilla5_Oca.setBackground(Color.BLUE);
		lblCasilla5_Oca.setBounds(280, 612, 56, 74);
		panelJuego.add(lblCasilla5_Oca);

		lblCasilla6_Puente = new JLabel("");
		lblCasilla6_Puente.setOpaque(true);
		lblCasilla6_Puente.setBackground(new Color(255, 255, 0));
		lblCasilla6_Puente.setBounds(335, 612, 56, 74);
		panelJuego.add(lblCasilla6_Puente);

		lblCasilla7 = new JLabel("");
		lblCasilla7.setOpaque(true);
		lblCasilla7.setBackground(new Color(0, 255, 64));
		lblCasilla7.setBounds(390, 612, 56, 74);
		panelJuego.add(lblCasilla7);

		lblCasilla8 = new JLabel("");
		lblCasilla8.setOpaque(true);
		lblCasilla8.setBackground(new Color(0, 128, 0));
		lblCasilla8.setBounds(446, 612, 56, 74);
		panelJuego.add(lblCasilla8);

		lblCasilla9_Oca = new JLabel("");
		lblCasilla9_Oca.setOpaque(true);
		lblCasilla9_Oca.setBackground(Color.BLUE);
		lblCasilla9_Oca.setBounds(501, 612, 56, 74);
		panelJuego.add(lblCasilla9_Oca);

		JLabel lblCasilla10 = new JLabel("");
		lblCasilla10.setOpaque(true);
		lblCasilla10.setBackground(new Color(0, 128, 0));
		lblCasilla10.setBounds(557, 573, 114, 113);
		panelJuego.add(lblCasilla10);

		btnMostrarPregunta = new JButton("Mostrar pregunta");
		btnMostrarPregunta.setBounds(169, 154, 142, 21);
		panelJuego.add(btnMostrarPregunta);

		lblCasilla11 = new JLabel("");
		lblCasilla11.setOpaque(true);
		lblCasilla11.setBackground(new Color(0, 255, 64));
		lblCasilla11.setBounds(597, 520, 74, 56);
		panelJuego.add(lblCasilla11);

		lblCasilla12_Puente = new JLabel("");
		lblCasilla12_Puente.setOpaque(true);
		lblCasilla12_Puente.setBackground(new Color(255, 255, 0));
		lblCasilla12_Puente.setBounds(597, 459, 74, 61);
		panelJuego.add(lblCasilla12_Puente);

		lblCasilla13 = new JLabel("");
		lblCasilla13.setOpaque(true);
		lblCasilla13.setBackground(new Color(0, 255, 64));
		lblCasilla13.setBounds(597, 398, 74, 62);
		panelJuego.add(lblCasilla13);

		lblCasilla14_Oca = new JLabel("");
		lblCasilla14_Oca.setOpaque(true);
		lblCasilla14_Oca.setBackground(Color.BLUE);
		lblCasilla14_Oca.setBounds(597, 332, 74, 67);
		panelJuego.add(lblCasilla14_Oca);

		lblCasilla15 = new JLabel("");
		lblCasilla15.setOpaque(true);
		lblCasilla15.setBackground(new Color(0, 255, 64));
		lblCasilla15.setBounds(597, 278, 74, 56);
		panelJuego.add(lblCasilla15);

		lblCasilla16 = new JLabel("");
		lblCasilla16.setOpaque(true);
		lblCasilla16.setBackground(new Color(0, 128, 0));
		lblCasilla16.setBounds(597, 223, 74, 56);
		panelJuego.add(lblCasilla16);

		lblCasilla17 = new JLabel("");
		lblCasilla17.setOpaque(true);
		lblCasilla17.setBackground(new Color(0, 255, 64));
		lblCasilla17.setBounds(597, 168, 74, 56);
		panelJuego.add(lblCasilla17);

		lblCasilla18_Oca = new JLabel("");
		lblCasilla18_Oca.setOpaque(true);
		lblCasilla18_Oca.setBackground(new Color(0, 0, 255));
		lblCasilla18_Oca.setBounds(597, 112, 74, 56);
		panelJuego.add(lblCasilla18_Oca);

		lblCasilla19_Posada = new JLabel("");
		lblCasilla19_Posada.setOpaque(true);
		lblCasilla19_Posada.setBackground(new Color(255, 0, 0));
		lblCasilla19_Posada.setBounds(557, 0, 114, 113);
		panelJuego.add(lblCasilla19_Posada);

		lblCasilla20 = new JLabel("");
		lblCasilla20.setOpaque(true);
		lblCasilla20.setBackground(new Color(0, 128, 0));
		lblCasilla20.setBounds(501, 0, 56, 74);
		panelJuego.add(lblCasilla20);

		lblCasilla21 = new JLabel("");
		lblCasilla21.setOpaque(true);
		lblCasilla21.setBackground(new Color(0, 255, 64));
		lblCasilla21.setBounds(446, 0, 56, 74);
		panelJuego.add(lblCasilla21);

		lblCasilla22 = new JLabel("");
		lblCasilla22.setOpaque(true);
		lblCasilla22.setBackground(new Color(0, 128, 0));
		lblCasilla22.setBounds(390, 0, 56, 74);
		panelJuego.add(lblCasilla22);

		lblCasilla23_Oca = new JLabel("");
		lblCasilla23_Oca.setOpaque(true);
		lblCasilla23_Oca.setBackground(Color.BLUE);
		lblCasilla23_Oca.setBounds(335, 0, 56, 74);
		panelJuego.add(lblCasilla23_Oca);

		lblCasilla24 = new JLabel("");
		lblCasilla24.setOpaque(true);
		lblCasilla24.setBackground(new Color(0, 255, 64));
		lblCasilla24.setBounds(280, 0, 56, 74);
		panelJuego.add(lblCasilla24);

		lblCasilla25 = new JLabel("");
		lblCasilla25.setOpaque(true);
		lblCasilla25.setBackground(new Color(0, 128, 0));
		lblCasilla25.setBounds(224, 0, 56, 74);
		panelJuego.add(lblCasilla25);

		lblCasilla26_Dados = new JLabel("");
		lblCasilla26_Dados.setOpaque(true);
		lblCasilla26_Dados.setBackground(new Color(255, 0, 128));
		lblCasilla26_Dados.setBounds(169, 0, 56, 74);
		panelJuego.add(lblCasilla26_Dados);

		lblCasilla27_Oca = new JLabel("");
		lblCasilla27_Oca.setOpaque(true);
		lblCasilla27_Oca.setBackground(Color.BLUE);
		lblCasilla27_Oca.setBounds(113, 0, 56, 74);
		panelJuego.add(lblCasilla27_Oca);

		lblCasilla28 = new JLabel("");
		lblCasilla28.setOpaque(true);
		lblCasilla28.setBackground(new Color(0, 128, 0));
		lblCasilla28.setBounds(0, 0, 115, 113);
		panelJuego.add(lblCasilla28);

		lblCasilla29 = new JLabel("");
		lblCasilla29.setOpaque(true);
		lblCasilla29.setBackground(new Color(0, 255, 64));
		lblCasilla29.setBounds(0, 112, 74, 56);
		panelJuego.add(lblCasilla29);

		lblCasilla30 = new JLabel("");
		lblCasilla30.setOpaque(true);
		lblCasilla30.setBackground(new Color(0, 128, 0));
		lblCasilla30.setBounds(0, 168, 74, 56);
		panelJuego.add(lblCasilla30);

		lblCasilla31_Pozo = new JLabel("");
		lblCasilla31_Pozo.setOpaque(true);
		lblCasilla31_Pozo.setBackground(new Color(255, 128, 64));
		lblCasilla31_Pozo.setBounds(0, 224, 74, 56);
		panelJuego.add(lblCasilla31_Pozo);

		lblCasilla32_Oca = new JLabel("");
		lblCasilla32_Oca.setOpaque(true);
		lblCasilla32_Oca.setBackground(Color.BLUE);
		lblCasilla32_Oca.setBounds(0, 279, 74, 56);
		panelJuego.add(lblCasilla32_Oca);

		JLabel lblCasilla33 = new JLabel("");
		lblCasilla33.setOpaque(true);
		lblCasilla33.setBackground(new Color(0, 255, 64));
		lblCasilla33.setBounds(0, 335, 74, 56);
		panelJuego.add(lblCasilla33);

		JLabel lblCasilla34 = new JLabel("");
		lblCasilla34.setOpaque(true);
		lblCasilla34.setBackground(new Color(0, 128, 0));
		lblCasilla34.setBounds(0, 391, 74, 56);
		panelJuego.add(lblCasilla34);

		JLabel lblCasilla35 = new JLabel("");
		lblCasilla35.setOpaque(true);
		lblCasilla35.setBackground(new Color(0, 255, 64));
		lblCasilla35.setBounds(0, 448, 74, 56);
		panelJuego.add(lblCasilla35);

		JLabel lblCasilla36_Oca = new JLabel("");
		lblCasilla36_Oca.setOpaque(true);
		lblCasilla36_Oca.setBackground(new Color(0, 0, 255));
		lblCasilla36_Oca.setBounds(0, 504, 115, 108);
		panelJuego.add(lblCasilla36_Oca);

		lblRetroalimentacionJuego = new JLabel("");
		lblRetroalimentacionJuego.setBounds(691, 293, 187, 269);
		panelPrincipal.add(lblRetroalimentacionJuego);

		grupoButtonsDados = new ButtonGroup();
		// btnCasilla1.setVisible(false);

		lblNewLabel_3 = new JLabel("");
		// lblFichaLlados.add(panelJuego);
		lblNewLabel_3.setBounds(48, 10, 26, 35);
		lblNewLabel_3.setVisible(false);

		lblNewLabel_4 = new JLabel("");
		// lblNewLabel_4.add(panelJuego);
		lblNewLabel_4.setBounds(10, 10, 26, 35);
		lblNewLabel_4.setVisible(false);

		/*
		 * panelPreguntas = new JPanel(); panelPreguntas.setBounds(232, 105, 349, 374);
		 * // Establece las coordenadas y el tama�o contentPane.add(panelPreguntas);
		 * panelPreguntas.setLayout(null); panelPreguntas.setVisible(false);
		 */

		/*
		 * lblPregunta = new JLabel(""); lblPregunta.setBounds(10, 5, 329, 94);
		 * panelPreguntas.add(lblPregunta);
		 * 
		 * grupoButtons = new ButtonGroup();
		 * 
		 * radiobtnRespuesta1 = new JRadioButton(""); radiobtnRespuesta1.setBounds(10,
		 * 105, 276, 20); // Establece las coordenadas y el tama�o
		 * panelPreguntas.add(radiobtnRespuesta1); grupoButtons.add(radiobtnRespuesta1);
		 * 
		 * radiobtnRespuesta2 = new JRadioButton(""); radiobtnRespuesta2.setBounds(10,
		 * 135, 276, 20); panelPreguntas.add(radiobtnRespuesta2);
		 * grupoButtons.add(radiobtnRespuesta2);
		 * 
		 * radiobtnRespuesta3 = new JRadioButton(""); radiobtnRespuesta3.setBounds(10,
		 * 165, 276, 20); panelPreguntas.add(radiobtnRespuesta3);
		 * grupoButtons.add(radiobtnRespuesta3);
		 * 
		 * btnResponder = new JButton("Responder"); btnResponder.setBounds(26, 254, 276,
		 * 30); // Ajusta las coordenadas y el tama�o seg�n tus necesidades
		 * panelPreguntas.add(btnResponder);
		 */

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