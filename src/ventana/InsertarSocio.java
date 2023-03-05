package ventana;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorBBDD;
import clases.Socio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InsertarSocio extends JFrame {

	private JPanel contentPane;
	private JTextField nombreTxt;
	private JTextField apellidoTxt;
	private JTextField direccionTxt;
	private JTextField poblacionTxt;
	private JTextField provinciaTxt;
	private JTextField DNITxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					InsertarSocio frame = new InsertarSocio();
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
	public InsertarSocio() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel insertarSocio = new JLabel("INSERTAR SOCIO");
		insertarSocio.setBounds(141, 11, 117, 33);
		contentPane.add(insertarSocio);

		JLabel nombre = new JLabel("NOMBRE");
		nombre.setBounds(80, 58, 67, 14);
		contentPane.add(nombre);

		JLabel apellido = new JLabel("APELLIDO");
		apellido.setBounds(80, 94, 67, 14);
		contentPane.add(apellido);

		JLabel direccion = new JLabel("DIRECCION");
		direccion.setBounds(80, 136, 67, 14);
		contentPane.add(direccion);

		nombreTxt = new JTextField();
		nombreTxt.setBounds(157, 55, 86, 20);
		contentPane.add(nombreTxt);
		nombreTxt.setColumns(10);

		apellidoTxt = new JTextField();
		apellidoTxt.setBounds(157, 91, 86, 20);
		contentPane.add(apellidoTxt);
		apellidoTxt.setColumns(10);

		direccionTxt = new JTextField();
		direccionTxt.setBounds(157, 133, 86, 20);
		contentPane.add(direccionTxt);
		direccionTxt.setColumns(10);

		JLabel poblacion = new JLabel("POBLACION");
		poblacion.setBounds(80, 175, 78, 14);
		contentPane.add(poblacion);

		poblacionTxt = new JTextField();
		poblacionTxt.setBounds(157, 172, 86, 20);
		contentPane.add(poblacionTxt);
		poblacionTxt.setColumns(10);

		JLabel provincia = new JLabel("PROVINCIA");
		provincia.setBounds(80, 217, 67, 14);
		contentPane.add(provincia);

		provinciaTxt = new JTextField();
		provinciaTxt.setBounds(157, 214, 86, 20);
		contentPane.add(provinciaTxt);
		provinciaTxt.setColumns(10);

		JLabel dni = new JLabel("DNI");
		dni.setBounds(80, 262, 46, 14);
		contentPane.add(dni);

		DNITxt = new JTextField();
		DNITxt.setBounds(157, 259, 86, 20);
		contentPane.add(DNITxt);
		DNITxt.setColumns(10);

		JButton insertar = new JButton("INSERTAR");
		insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreS = nombreTxt.getText();
				String apellidoS = apellidoTxt.getText();
				String direccionS = direccionTxt.getText();
				String poblacionS = poblacionTxt.getText();
				String provinciaS = provinciaTxt.getText();
				String DNIS = DNITxt.getText();

				GestorBBDD gbb = new GestorBBDD();
				Socio socio = new Socio();

				socio.setNombre(nombreS);
				socio.setApellido(apellidoS);
				socio.setDireccion(direccionS);
				socio.setPoblacion(poblacionS);
				socio.setProvincia(provinciaS);
				socio.setDni(DNIS);

				gbb.conectar();
				try {
					gbb.insertarSocio(socio);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		insertar.setBounds(154, 317, 89, 23);
		contentPane.add(insertar);
		
		JButton otrasOpciones = new JButton("OTRAS OPCIONES");
		otrasOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamadaHijo();
				
			}
		});
		otrasOpciones.setBounds(264, 132, 125, 23);
		contentPane.add(otrasOpciones);
	}
	
	public void llamadaHijo () {
		OtrasOpcionesSocio dialog = new OtrasOpcionesSocio(this);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
}
