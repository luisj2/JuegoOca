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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JDesktopPane;
import java.awt.Font;

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
	public JLabel lblCasilla19_Posada;
	public JLabel lblCasilla20;
	public JLabel lblCasilla21;
	public JLabel lblCasilla22;
	public JLabel lblCasilla23_Oca;
	public JLabel lblCasilla24;
	public JLabel lblCasilla25;
	public JLabel lblCasilla26_Dados;
	public JLabel lblCasilla27_Oca;
	public JLabel lblCasilla28;
	public JLabel lblCasilla29;
	public JLabel lblCasilla30;
	public JLabel lblCasilla31_Pozo;
	public JLabel lblCasilla32_Oca;
	public JLabel lblCasilla37;
	public JLabel lblCasilla38;
	public JLabel lblCasilla39;
	public JLabel lblCasilla40;
	public JLabel lblCasilla41_Oca;
	public JLabel lblCasilla42_Laberinto;
	public JLabel lblCasilla43;
	private JLabel lblCasilla44;
	private JLabel lblCasilla45_Oca;
	private JLabel lblCasilla46;
	private JLabel lblCasilla47;
	private JLabel lblCasilla48;
	private JLabel lblCasilla49;
	private JLabel lblCasilla50_Oca;
	private JLabel lblCasilla52;
	private JLabel lblCasilla53_Dados;
	private JLabel lblCasilla54Oca;
	private JLabel lblCasilla55;
	private JLabel lblCasilla56_Carcel;
	private JLabel lblCasilla58_Muerte;
	private JLabel lblCasilla59_Oca;
	private JLabel lblCasilla60;
	private JLabel lblCasilla61;
	private JLabel lblCasilla62;
	private JLabel lblCasilla51;
	private JLabel lblCasilla57;
	public JPanel panelGanador;
	public JLabel lblGanador;
	public JLabel lblFotoGanador;
	public JButton btnExit;
	public JLabel lblGanadorNombre;
	public JPanel panelAcertijos;
	public JLabel preguntaAcertijo;
	public JTextField textFieldRespuesta;
	public JButton btnResponderAcertijo;
	public JLabel lblRetroalimentacionAcertijo;
	public JTextArea lblRetroalimentacionJuego;

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
		
		grupoButtonsDados = new ButtonGroup();

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

		// btnCasilla1.setVisible(false);

		lblNewLabel_3 = new JLabel("");
		// lblFichaLlados.add(panelJuego);
		lblNewLabel_3.setBounds(48, 10, 26, 35);
		lblNewLabel_3.setVisible(false);

		lblNewLabel_4 = new JLabel("");
		// lblNewLabel_4.add(panelJuego);
		lblNewLabel_4.setBounds(10, 10, 26, 35);
		lblNewLabel_4.setVisible(false);

		panelDados = new JPanel();
		panelDados.setBounds(691, 10, 187, 246);
		contentPane.add(panelDados);
		panelDados.setVisible(false);
		panelDados.setLayout(null);

		lblDado1 = new JLabel("");
		lblDado1.setBounds(10, 28, 84, 106);
		panelDados.add(lblDado1);

		lblDado2 = new JLabel("");
		lblDado2.setBounds(93, 28, 84, 106);
		panelDados.add(lblDado2);

		btnTirarDados = new JButton("Tirar dados");
		btnTirarDados.setBounds(35, 184, 142, 21);
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
				"Imagenes\\xokasficha.png"));
		lblFichaXokas.setBounds(42, 630, 26, 35);
		panelJuego.add(lblFichaXokas);

		lblFichaLlados = new JLabel("");
		lblFichaLlados.setIcon(new ImageIcon(
				"Imagenes\\lladosficha.png"));
		lblFichaLlados.setBounds(319, 326, 26, 35);
		panelJuego.add(lblFichaLlados);

		lblCasilla1 = new JLabel("");
		lblCasilla1.setIcon(new ImageIcon("Imagenes\\inicio.jpg"));
		lblCasilla1.setBackground(new Color(0, 64, 64));
		lblCasilla1.setOpaque(true);
		lblCasilla1.setBounds(0, 612, 115, 74);
		panelJuego.add(lblCasilla1);

		lblCasilla2 = new JLabel("");
		lblCasilla2.setIcon(new ImageIcon("Imagenes\\cocodrilo.jpg"));
		lblCasilla2.setBackground(new Color(0, 255, 64));
		lblCasilla2.setOpaque(true);
		lblCasilla2.setBounds(113, 612, 56, 74);
		panelJuego.add(lblCasilla2);

		lblCasilla3 = new JLabel("");
		lblCasilla3.setIcon(new ImageIcon("Imagenes\\hulk.jpeg"));
		lblCasilla3.setOpaque(true);
		lblCasilla3.setBackground(new Color(0, 128, 0));
		lblCasilla3.setBounds(169, 612, 56, 74);
		panelJuego.add(lblCasilla3);

		JLabel lblCasilla4 = new JLabel("");
		lblCasilla4.setIcon(new ImageIcon("Imagenes\\naruto.jpeg"));
		lblCasilla4.setOpaque(true);
		lblCasilla4.setBackground(new Color(0, 255, 64));
		lblCasilla4.setBounds(224, 612, 56, 74);
		panelJuego.add(lblCasilla4);

		JLabel lblCasilla5_Oca = new JLabel("");
		lblCasilla5_Oca.setIcon(new ImageIcon("Imagenes\\oca2.jpeg"));
		lblCasilla5_Oca.setOpaque(true);
		lblCasilla5_Oca.setBackground(Color.BLUE);
		lblCasilla5_Oca.setBounds(280, 612, 56, 74);
		panelJuego.add(lblCasilla5_Oca);

		lblCasilla6_Puente = new JLabel("");
		lblCasilla6_Puente.setIcon(new ImageIcon("Imagenes\\Puente.png"));
		lblCasilla6_Puente.setOpaque(true);
		lblCasilla6_Puente.setBackground(new Color(255, 255, 0));
		lblCasilla6_Puente.setBounds(335, 612, 56, 74);
		panelJuego.add(lblCasilla6_Puente);

		lblCasilla7 = new JLabel("");
		lblCasilla7.setIcon(new ImageIcon("Imagenes\\shrek.jpeg"));
		lblCasilla7.setOpaque(true);
		lblCasilla7.setBackground(new Color(0, 255, 64));
		lblCasilla7.setBounds(390, 612, 56, 74);
		panelJuego.add(lblCasilla7);

		lblCasilla8 = new JLabel("");
		lblCasilla8.setIcon(new ImageIcon("Imagenes\\dora.jpeg"));
		lblCasilla8.setOpaque(true);
		lblCasilla8.setBackground(new Color(0, 128, 0));
		lblCasilla8.setBounds(446, 612, 56, 74);
		panelJuego.add(lblCasilla8);

		lblCasilla9_Oca = new JLabel("");
		lblCasilla9_Oca.setIcon(new ImageIcon("Imagenes\\oca2.jpeg"));
		lblCasilla9_Oca.setOpaque(true);
		lblCasilla9_Oca.setBackground(Color.BLUE);
		lblCasilla9_Oca.setBounds(501, 612, 56, 74);
		panelJuego.add(lblCasilla9_Oca);

		lblCasilla44 = new JLabel("");
		lblCasilla44.setIcon(new ImageIcon("Imagenes\\torrente.jpg"));
		lblCasilla44.setOpaque(true);
		lblCasilla44.setBackground(new Color(128, 128, 255));
		lblCasilla44.setBounds(501, 510, 95, 101);
		panelJuego.add(lblCasilla44);

		JLabel lblCasilla10 = new JLabel("");
		lblCasilla10.setIcon(new ImageIcon("Imagenes\\pablo.jpg"));
		lblCasilla10.setOpaque(true);
		lblCasilla10.setBackground(new Color(0, 128, 0));
		lblCasilla10.setBounds(557, 573, 114, 113);
		panelJuego.add(lblCasilla10);

		lblCasilla11 = new JLabel("");
		lblCasilla11.setIcon(new ImageIcon("Imagenes\\iconoAcertijo.png"));
		lblCasilla11.setOpaque(true);
		lblCasilla11.setBackground(new Color(0, 255, 64));
		lblCasilla11.setBounds(597, 520, 74, 56);
		panelJuego.add(lblCasilla11);

		lblCasilla12_Puente = new JLabel("");
		lblCasilla12_Puente.setIcon(new ImageIcon("Imagenes\\Puente2.png"));
		lblCasilla12_Puente.setOpaque(true);
		lblCasilla12_Puente.setBackground(new Color(255, 255, 0));
		lblCasilla12_Puente.setBounds(597, 459, 74, 61);
		panelJuego.add(lblCasilla12_Puente);

		lblCasilla13 = new JLabel("");
		lblCasilla13.setIcon(new ImageIcon("Imagenes\\bixo.jpg"));
		lblCasilla13.setOpaque(true);
		lblCasilla13.setBackground(new Color(0, 255, 64));
		lblCasilla13.setBounds(597, 398, 74, 62);
		panelJuego.add(lblCasilla13);

		lblCasilla14_Oca = new JLabel("");
		lblCasilla14_Oca.setIcon(new ImageIcon("Imagenes\\oca4.jpeg"));
		lblCasilla14_Oca.setOpaque(true);
		lblCasilla14_Oca.setBackground(Color.BLUE);
		lblCasilla14_Oca.setBounds(597, 332, 74, 67);
		panelJuego.add(lblCasilla14_Oca);

		lblCasilla15 = new JLabel("");
		lblCasilla15.setIcon(new ImageIcon("Imagenes\\kiko2.jpg"));
		lblCasilla15.setOpaque(true);
		lblCasilla15.setBackground(new Color(0, 255, 64));
		lblCasilla15.setBounds(597, 278, 74, 56);
		panelJuego.add(lblCasilla15);

		lblCasilla16 = new JLabel("");
		lblCasilla16.setIcon(new ImageIcon("Imagenes\\iconoAcertijo.png"));
		lblCasilla16.setOpaque(true);
		lblCasilla16.setBackground(new Color(0, 128, 0));
		lblCasilla16.setBounds(597, 223, 74, 56);
		panelJuego.add(lblCasilla16);

		lblCasilla17 = new JLabel("");
		lblCasilla17.setIcon(new ImageIcon("Imagenes\\harrypotter2.jpeg"));
		lblCasilla17.setOpaque(true);
		lblCasilla17.setBackground(new Color(0, 255, 64));
		lblCasilla17.setBounds(597, 168, 74, 56);
		panelJuego.add(lblCasilla17);

		lblCasilla18_Oca = new JLabel("");
		lblCasilla18_Oca.setIcon(new ImageIcon("Imagenes\\oca4.jpeg"));
		lblCasilla18_Oca.setOpaque(true);
		lblCasilla18_Oca.setBackground(new Color(0, 0, 255));
		lblCasilla18_Oca.setBounds(597, 112, 74, 56);
		panelJuego.add(lblCasilla18_Oca);

		lblCasilla19_Posada = new JLabel("");
		lblCasilla19_Posada.setIcon(new ImageIcon("Imagenes\\posada.jpg"));
		lblCasilla19_Posada.setOpaque(true);
		lblCasilla19_Posada.setBackground(new Color(255, 0, 0));
		lblCasilla19_Posada.setBounds(557, 0, 114, 113);
		panelJuego.add(lblCasilla19_Posada);

		lblCasilla20 = new JLabel("");
		lblCasilla20.setIcon(new ImageIcon("Imagenes\\hulk.jpeg"));
		lblCasilla20.setOpaque(true);
		lblCasilla20.setBackground(new Color(0, 128, 0));
		lblCasilla20.setBounds(501, 0, 56, 74);
		panelJuego.add(lblCasilla20);

		lblCasilla21 = new JLabel("");
		lblCasilla21.setIcon(new ImageIcon("Imagenes\\naruto.jpeg"));
		lblCasilla21.setOpaque(true);
		lblCasilla21.setBackground(new Color(0, 255, 64));
		lblCasilla21.setBounds(446, 0, 56, 74);
		panelJuego.add(lblCasilla21);

		lblCasilla22 = new JLabel("");
		lblCasilla22.setIcon(new ImageIcon("Imagenes\\messichiquito.jpg"));
		lblCasilla22.setOpaque(true);
		lblCasilla22.setBackground(new Color(0, 128, 0));
		lblCasilla22.setBounds(390, 0, 56, 74);
		panelJuego.add(lblCasilla22);

		lblCasilla23_Oca = new JLabel("");
		lblCasilla23_Oca.setIcon(new ImageIcon("Imagenes\\oca2.jpeg"));
		lblCasilla23_Oca.setOpaque(true);
		lblCasilla23_Oca.setBackground(Color.BLUE);
		lblCasilla23_Oca.setBounds(335, 0, 56, 74);
		panelJuego.add(lblCasilla23_Oca);

		lblCasilla24 = new JLabel("");
		lblCasilla24.setIcon(new ImageIcon("Imagenes\\iconoAcertijo2.png"));
		lblCasilla24.setOpaque(true);
		lblCasilla24.setBackground(new Color(0, 255, 64));
		lblCasilla24.setBounds(280, 0, 56, 74);
		panelJuego.add(lblCasilla24);

		lblCasilla25 = new JLabel("");
		lblCasilla25.setIcon(new ImageIcon("Imagenes\\cocodrilo.jpg"));
		lblCasilla25.setOpaque(true);
		lblCasilla25.setBackground(new Color(0, 128, 0));
		lblCasilla25.setBounds(224, 0, 56, 74);
		panelJuego.add(lblCasilla25);

		lblCasilla26_Dados = new JLabel("");
		lblCasilla26_Dados.setIcon(new ImageIcon("Imagenes\\Dados.png"));
		lblCasilla26_Dados.setOpaque(true);
		lblCasilla26_Dados.setBackground(new Color(255, 0, 128));
		lblCasilla26_Dados.setBounds(169, 0, 56, 74);
		panelJuego.add(lblCasilla26_Dados);

		lblCasilla27_Oca = new JLabel("");
		lblCasilla27_Oca.setIcon(new ImageIcon("Imagenes\\oca2.jpeg"));
		lblCasilla27_Oca.setOpaque(true);
		lblCasilla27_Oca.setBackground(Color.BLUE);
		lblCasilla27_Oca.setBounds(113, 0, 56, 74);
		panelJuego.add(lblCasilla27_Oca);

		lblCasilla57 = new JLabel("");
		lblCasilla57.setIcon(new ImageIcon("Imagenes\\padrede.jpg"));
		lblCasilla57.setOpaque(true);
		lblCasilla57.setBackground(Color.GREEN);
		lblCasilla57.setBounds(73, 74, 115, 108);
		panelJuego.add(lblCasilla57);

		lblCasilla28 = new JLabel("");
		lblCasilla28.setIcon(new ImageIcon("Imagenes\\llados.jpg"));
		lblCasilla28.setOpaque(true);
		lblCasilla28.setBackground(new Color(0, 128, 0));
		lblCasilla28.setBounds(0, 0, 115, 113);
		panelJuego.add(lblCasilla28);

		lblCasilla29 = new JLabel("");
		lblCasilla29.setIcon(new ImageIcon("Imagenes\\shrek2.jpeg"));
		lblCasilla29.setOpaque(true);
		lblCasilla29.setBackground(new Color(0, 255, 64));
		lblCasilla29.setBounds(0, 112, 74, 56);
		panelJuego.add(lblCasilla29);

		lblCasilla30 = new JLabel("");
		lblCasilla30.setIcon(new ImageIcon("Imagenes\\messichiquito2.jpg"));
		lblCasilla30.setOpaque(true);
		lblCasilla30.setBackground(new Color(0, 128, 0));
		lblCasilla30.setBounds(0, 168, 74, 56);
		panelJuego.add(lblCasilla30);

		lblCasilla31_Pozo = new JLabel("");
		lblCasilla31_Pozo.setIcon(new ImageIcon("Imagenes\\pozo.jpg"));
		lblCasilla31_Pozo.setOpaque(true);
		lblCasilla31_Pozo.setBackground(new Color(255, 128, 64));
		lblCasilla31_Pozo.setBounds(0, 224, 74, 56);
		panelJuego.add(lblCasilla31_Pozo);

		lblCasilla32_Oca = new JLabel("");
		lblCasilla32_Oca.setIcon(new ImageIcon("Imagenes\\oca3.jpeg"));
		lblCasilla32_Oca.setOpaque(true);
		lblCasilla32_Oca.setBackground(Color.BLUE);
		lblCasilla32_Oca.setBounds(0, 279, 74, 56);
		panelJuego.add(lblCasilla32_Oca);

		JLabel lblCasilla33 = new JLabel("");
		lblCasilla33.setIcon(new ImageIcon("Imagenes\\harrypotter3.jpeg"));
		lblCasilla33.setOpaque(true);
		lblCasilla33.setBackground(new Color(0, 255, 64));
		lblCasilla33.setBounds(0, 335, 74, 56);
		panelJuego.add(lblCasilla33);

		JLabel lblCasilla34 = new JLabel("");
		lblCasilla34.setIcon(new ImageIcon("Imagenes\\iconoAcertijo3.png"));
		lblCasilla34.setOpaque(true);
		lblCasilla34.setBackground(new Color(0, 128, 0));
		lblCasilla34.setBounds(0, 391, 74, 56);
		panelJuego.add(lblCasilla34);

		JLabel lblCasilla35 = new JLabel("");
		lblCasilla35.setIcon(new ImageIcon("Imagenes\\messichiquito2.jpg"));
		lblCasilla35.setOpaque(true);
		lblCasilla35.setBackground(new Color(0, 255, 64));
		lblCasilla35.setBounds(0, 448, 74, 56);
		panelJuego.add(lblCasilla35);

		JLabel lblCasilla36_Oca = new JLabel("");
		lblCasilla36_Oca.setIcon(new ImageIcon("Imagenes\\oca1.jpeg"));
		lblCasilla36_Oca.setOpaque(true);
		lblCasilla36_Oca.setBackground(new Color(0, 0, 255));
		lblCasilla36_Oca.setBounds(0, 504, 115, 108);
		panelJuego.add(lblCasilla36_Oca);

		lblCasilla37 = new JLabel("");
		lblCasilla37.setIcon(new ImageIcon("Imagenes\\dora.jpeg"));
		lblCasilla37.setOpaque(true);
		lblCasilla37.setBackground(new Color(0, 128, 0));
		lblCasilla37.setBounds(113, 538, 56, 74);
		panelJuego.add(lblCasilla37);

		lblCasilla38 = new JLabel("");
		lblCasilla38.setIcon(new ImageIcon("Imagenes\\iconoAcertijo2.png"));
		lblCasilla38.setOpaque(true);
		lblCasilla38.setBackground(new Color(0, 255, 64));
		lblCasilla38.setBounds(169, 538, 56, 74);
		panelJuego.add(lblCasilla38);

		lblCasilla39 = new JLabel("");
		lblCasilla39.setIcon(new ImageIcon("Imagenes\\shrek.jpeg"));
		lblCasilla39.setOpaque(true);
		lblCasilla39.setBackground(new Color(0, 128, 0));
		lblCasilla39.setBounds(224, 538, 56, 74);
		panelJuego.add(lblCasilla39);

		lblCasilla40 = new JLabel("");
		lblCasilla40.setIcon(new ImageIcon("Imagenes\\kiko.jpg"));
		lblCasilla40.setOpaque(true);
		lblCasilla40.setBackground(new Color(0, 255, 64));
		lblCasilla40.setBounds(280, 538, 56, 74);
		panelJuego.add(lblCasilla40);

		lblCasilla41_Oca = new JLabel("");
		lblCasilla41_Oca.setIcon(new ImageIcon("Imagenes\\oca2.jpeg"));
		lblCasilla41_Oca.setOpaque(true);
		lblCasilla41_Oca.setBackground(Color.BLUE);
		lblCasilla41_Oca.setBounds(335, 538, 56, 74);
		panelJuego.add(lblCasilla41_Oca);

		lblCasilla42_Laberinto = new JLabel("");
		lblCasilla42_Laberinto.setIcon(new ImageIcon("Imagenes\\laberinto.png"));
		lblCasilla42_Laberinto.setOpaque(true);
		lblCasilla42_Laberinto.setBackground(new Color(255, 0, 255));
		lblCasilla42_Laberinto.setBounds(390, 538, 56, 74);
		panelJuego.add(lblCasilla42_Laberinto);

		lblCasilla43 = new JLabel("");
		lblCasilla43.setIcon(new ImageIcon("Imagenes\\cocodrilo.jpg"));
		lblCasilla43.setOpaque(true);
		lblCasilla43.setBackground(new Color(0, 255, 64));
		lblCasilla43.setBounds(446, 538, 56, 74);
		panelJuego.add(lblCasilla43);

		lblCasilla45_Oca = new JLabel("");
		lblCasilla45_Oca.setIcon(new ImageIcon("Imagenes\\oca4.jpeg"));
		lblCasilla45_Oca.setOpaque(true);
		lblCasilla45_Oca.setBackground(Color.BLUE);
		lblCasilla45_Oca.setBounds(522, 454, 74, 56);
		panelJuego.add(lblCasilla45_Oca);

		lblCasilla46 = new JLabel("");
		lblCasilla46.setIcon(new ImageIcon("Imagenes\\iconoAcertijo.png"));
		lblCasilla46.setOpaque(true);
		lblCasilla46.setBackground(new Color(0, 128, 0));
		lblCasilla46.setBounds(522, 398, 74, 56);
		panelJuego.add(lblCasilla46);

		lblCasilla47 = new JLabel("");
		lblCasilla47.setIcon(new ImageIcon("Imagenes\\harrypotter2.jpeg"));
		lblCasilla47.setOpaque(true);
		lblCasilla47.setBackground(new Color(0, 255, 0));
		lblCasilla47.setBounds(522, 344, 74, 56);
		panelJuego.add(lblCasilla47);

		lblCasilla48 = new JLabel("");
		lblCasilla48.setIcon(new ImageIcon("Imagenes\\messichiquito3.jpg"));
		lblCasilla48.setOpaque(true);
		lblCasilla48.setBackground(new Color(0, 128, 0));
		lblCasilla48.setBounds(522, 291, 74, 56);
		panelJuego.add(lblCasilla48);

		lblCasilla49 = new JLabel("");
		lblCasilla49.setIcon(new ImageIcon("Imagenes\\kiko2.jpg"));
		lblCasilla49.setOpaque(true);
		lblCasilla49.setBackground(Color.GREEN);
		lblCasilla49.setBounds(522, 234, 74, 56);
		panelJuego.add(lblCasilla49);

		lblCasilla50_Oca = new JLabel("");
		lblCasilla50_Oca.setIcon(new ImageIcon("Imagenes\\oca4.jpeg"));
		lblCasilla50_Oca.setOpaque(true);
		lblCasilla50_Oca.setBackground(Color.BLUE);
		lblCasilla50_Oca.setBounds(522, 177, 74, 56);
		panelJuego.add(lblCasilla50_Oca);

		lblCasilla51 = new JLabel("");
		lblCasilla51.setIcon(new ImageIcon("Imagenes\\kratos.jpeg"));
		lblCasilla51.setOpaque(true);
		lblCasilla51.setBackground(Color.GREEN);
		lblCasilla51.setBounds(466, 74, 130, 108);
		panelJuego.add(lblCasilla51);

		lblCasilla52 = new JLabel("");
		lblCasilla52.setIcon(new ImageIcon("Imagenes\\dora.jpeg"));
		lblCasilla52.setOpaque(true);
		lblCasilla52.setBackground(new Color(0, 128, 0));
		lblCasilla52.setBounds(410, 74, 56, 74);
		panelJuego.add(lblCasilla52);

		lblCasilla53_Dados = new JLabel("");
		lblCasilla53_Dados.setIcon(new ImageIcon("Imagenes\\Dados.png"));
		lblCasilla53_Dados.setOpaque(true);
		lblCasilla53_Dados.setBackground(new Color(255, 0, 128));
		lblCasilla53_Dados.setBounds(356, 71, 56, 74);
		panelJuego.add(lblCasilla53_Dados);

		lblCasilla54Oca = new JLabel("");
		lblCasilla54Oca.setIcon(new ImageIcon("Imagenes\\oca2.jpeg"));
		lblCasilla54Oca.setOpaque(true);
		lblCasilla54Oca.setBackground(Color.BLUE);
		lblCasilla54Oca.setBounds(300, 74, 56, 74);
		panelJuego.add(lblCasilla54Oca);

		lblCasilla55 = new JLabel("");
		lblCasilla55.setIcon(new ImageIcon("Imagenes\\hulk.jpeg"));
		lblCasilla55.setOpaque(true);
		lblCasilla55.setBackground(new Color(0, 128, 0));
		lblCasilla55.setBounds(245, 71, 56, 74);
		panelJuego.add(lblCasilla55);

		lblCasilla56_Carcel = new JLabel("");
		lblCasilla56_Carcel.setIcon(new ImageIcon("Imagenes\\Carcel.jpg"));
		lblCasilla56_Carcel.setOpaque(true);
		lblCasilla56_Carcel.setBackground(new Color(0, 255, 64));
		lblCasilla56_Carcel.setBounds(189, 74, 56, 74);
		panelJuego.add(lblCasilla56_Carcel);

		lblCasilla58_Muerte = new JLabel("");
		lblCasilla58_Muerte.setIcon(new ImageIcon("Imagenes\\muerte.jpg"));
		lblCasilla58_Muerte.setOpaque(true);
		lblCasilla58_Muerte.setBackground(new Color(0, 128, 0));
		lblCasilla58_Muerte.setBounds(73, 178, 74, 56);
		panelJuego.add(lblCasilla58_Muerte);

		lblCasilla59_Oca = new JLabel("");
		lblCasilla59_Oca.setIcon(new ImageIcon("Imagenes\\oca3.jpeg"));
		lblCasilla59_Oca.setOpaque(true);
		lblCasilla59_Oca.setBackground(Color.BLUE);
		lblCasilla59_Oca.setBounds(73, 234, 74, 56);
		panelJuego.add(lblCasilla59_Oca);

		lblCasilla60 = new JLabel("");
		lblCasilla60.setIcon(new ImageIcon("Imagenes\\shrek2.jpeg"));
		lblCasilla60.setOpaque(true);
		lblCasilla60.setBackground(new Color(0, 128, 0));
		lblCasilla60.setBounds(73, 290, 74, 56);
		panelJuego.add(lblCasilla60);

		lblCasilla61 = new JLabel("");
		lblCasilla61.setIcon(new ImageIcon("Imagenes\\messichiquito2.jpg"));
		lblCasilla61.setOpaque(true);
		lblCasilla61.setBackground(new Color(0, 255, 64));
		lblCasilla61.setBounds(73, 345, 74, 55);
		panelJuego.add(lblCasilla61);

		lblCasilla62 = new JLabel("");
		lblCasilla62.setIcon(new ImageIcon("Imagenes\\cocodrilo.jpg"));
		lblCasilla62.setOpaque(true);
		lblCasilla62.setBackground(new Color(0, 128, 0));
		lblCasilla62.setBounds(146, 326, 56, 73);
		panelJuego.add(lblCasilla62);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Imagenes\\juegooca.jpg"));
		lblNewLabel_1.setBackground(new Color(0, 255, 0));
		lblNewLabel_1.setBounds(200, 264, 229, 135);
		panelJuego.add(lblNewLabel_1);

		lblRetroalimentacionJuego = new JTextArea();
		lblRetroalimentacionJuego.setBounds(691, 271, 172, 306);
		panelPrincipal.add(lblRetroalimentacionJuego);
		lblRetroalimentacionJuego.setColumns(10);
		lblRetroalimentacionJuego.setLineWrap(true);
		 lblRetroalimentacionJuego.setEditable(false);

		panelAcertijos = new JPanel();
		panelAcertijos.setBounds(33, 32, 636, 639);
		contentPane.add(panelAcertijos);
		panelAcertijos.setLayout(null);
		panelAcertijos.setVisible(false);

		preguntaAcertijo = new JLabel("");
		preguntaAcertijo.setBounds(24, 5, 590, 87);
		panelAcertijos.add(preguntaAcertijo);

		textFieldRespuesta = new JTextField();
		textFieldRespuesta.setBounds(24, 102, 590, 33);
		panelAcertijos.add(textFieldRespuesta);
		textFieldRespuesta.setColumns(10);

		btnResponderAcertijo = new JButton("Responder");
		btnResponderAcertijo.setBounds(224, 249, 126, 21);
		panelAcertijos.add(btnResponderAcertijo);

		lblRetroalimentacionAcertijo = new JLabel("");
		lblRetroalimentacionAcertijo.setBounds(21, 316, 582, 266);
		panelAcertijos.add(lblRetroalimentacionAcertijo);

		panelGanador = new JPanel();
		panelGanador.setBackground(new Color(255, 255, 0));
		panelGanador.setBounds(10, 10, 671, 415);
		contentPane.add(panelGanador);
		panelGanador.setLayout(null);
		panelGanador.setVisible(false);

		lblGanador = new JLabel("El ganador es: ");
		lblGanador.setBounds(100, 10, 162, 36);
		lblGanador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelGanador.add(lblGanador);

		lblFotoGanador = new JLabel("");
		lblFotoGanador.setBounds(258, 26, 186, 214);
		panelGanador.add(lblFotoGanador);

		btnExit = new JButton("Salir");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(491, 344, 125, 31);
		panelGanador.add(btnExit);

		lblGanadorNombre = new JLabel("");
		lblGanadorNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGanadorNombre.setBounds(62, 56, 186, 31);
		panelGanador.add(lblGanadorNombre);

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