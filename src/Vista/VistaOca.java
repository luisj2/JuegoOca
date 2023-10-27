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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VistaOca extends JFrame {

	private JPanel contentPane;
	public JPanel panelInicio;
	public JTextPane textPaneNombres;
	public JList <String> listaJugadores;
	public JButton btnJugar;
	public JPanel panelPrincipal;
	private JLabel lblSeleccionaElColor;
	public ArrayList <String> colores = new ArrayList<>(Arrays.asList("Rojo","Amarillo","Azul","Verde"));
	public JComboBox <String> comboBox;
	public JLabel lblRetroalimentacion;
	public JButton btnAniadirJugador;

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
		panelInicio.setBackground(new Color(255, 128, 0));
		panelInicio.setBounds(0, 0, 888, 706);
		contentPane.add(panelInicio);
		panelInicio.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce el nombre del jugador");
		lblNewLabel.setBounds(292, 55, 221, 23);
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
		panelInicio.add(btnJugar);
		
		lblSeleccionaElColor = new JLabel("Selecciona el color que quieres");
		lblSeleccionaElColor.setBounds(341, 146, 216, 23);
		panelInicio.add(lblSeleccionaElColor);
		
		comboBox = new JComboBox();
		comboBox.setBounds(397, 190, 69, 21);
		panelInicio.add(comboBox);
		for (int i = 0; i < colores.size(); i++) {
			comboBox.addItem(colores.get(i));
		}
		
		lblRetroalimentacion = new JLabel("");
		lblRetroalimentacion.setForeground(new Color(255, 0, 0));
		lblRetroalimentacion.setBounds(264, 353, 340, 192);
		panelInicio.add(lblRetroalimentacion);
		
		btnAniadirJugador = new JButton("A\u00F1adir Jugador");
		btnAniadirJugador.setBounds(365, 260, 148, 21);
		panelInicio.add(btnAniadirJugador);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 888, 706);
		contentPane.add(panelPrincipal);
		
		
	}
}
