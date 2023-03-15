package ventana;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorBBDD;
import clases.Prestamo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InsertarPrestamo extends JFrame {

	private JPanel contentPane;
	private JTextField IDLibroTxt;
	private JTextField IDSocioTxt;
	private JTextField fechaTxt;
	private JTextField devueltoTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//insertamos un modelo externo
					UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					InsertarPrestamo frame = new InsertarPrestamo();
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
	public InsertarPrestamo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel insertarPrestamo = new JLabel("INSERTAR PRESTAMO");
		insertarPrestamo.setBounds(144, 11, 134, 14);
		contentPane.add(insertarPrestamo);

		JLabel IDLibro = new JLabel("ID_LIBRO");
		IDLibro.setBounds(84, 51, 61, 14);
		contentPane.add(IDLibro);

		JLabel IDSocio = new JLabel("ID_SOCIO");
		IDSocio.setBounds(84, 98, 61, 14);
		contentPane.add(IDSocio);

		JLabel fecha = new JLabel("FECHA");
		fecha.setBounds(84, 139, 46, 14);
		contentPane.add(fecha);

		JLabel devuelto = new JLabel("DEVUELTO");
		devuelto.setBounds(84, 178, 61, 14);
		contentPane.add(devuelto);

		IDLibroTxt = new JTextField();
		IDLibroTxt.setBounds(155, 51, 86, 20);
		contentPane.add(IDLibroTxt);
		IDLibroTxt.setColumns(10);

		IDSocioTxt = new JTextField();
		IDSocioTxt.setBounds(155, 95, 86, 20);
		contentPane.add(IDSocioTxt);
		IDSocioTxt.setColumns(10);

		fechaTxt = new JTextField();
		fechaTxt.setBounds(155, 136, 86, 20);
		contentPane.add(fechaTxt);
		fechaTxt.setColumns(10);

		devueltoTxt = new JTextField();
		devueltoTxt.setBounds(155, 175, 86, 20);
		contentPane.add(devueltoTxt);
		devueltoTxt.setColumns(10);

		JButton insertar = new JButton("INSERTAR");
		insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  IDLibroP = Integer.parseInt(IDLibroTxt.getText());
				int IDSocioP = Integer.parseInt(IDSocioTxt.getText());
				SimpleDateFormat formatoLecturaFecha = new SimpleDateFormat("dd-MM-yyyy");
				
				Date fechaP;
				try {
					fechaP = formatoLecturaFecha.parse(fechaTxt.getText());
				
				boolean devueltoP = Boolean.parseBoolean
						(devueltoTxt.getText());

				Prestamo prestamo = new Prestamo();

				
					prestamo.setIdLibro(IDLibroP);
					prestamo.setIdSocio(IDSocioP);
					
					prestamo.setFecha(fechaP);
					prestamo.setDevuelto(devueltoP);

					GestorBBDD gbb = new GestorBBDD();
					gbb.conectar();
					try {
						gbb.insertarPrestamo(prestamo);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		insertar.setBounds(152, 216, 101, 23);
		contentPane.add(insertar);
		
		JButton otrasOpciones = new JButton("OTRAS OPCIONES");
		otrasOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		otrasOpciones.setBounds(286, 109, 121, 23);
		contentPane.add(otrasOpciones);
	}
}
