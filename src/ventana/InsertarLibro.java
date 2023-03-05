package ventana;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorBBDD;
import clases.Libro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InsertarLibro extends JFrame {

	private JPanel introducirLibro;
	private JTextField tituloTxt;
	private JTextField autorTxt;
	private JTextField numPagtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		            // start application
		           
					InsertarLibro frame = new InsertarLibro();
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
	public InsertarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		introducirLibro = new JPanel();
		introducirLibro.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(introducirLibro);
		introducirLibro.setLayout(null);

		JLabel titulo = new JLabel("Titulo");
		titulo.setBounds(98, 93, 46, 14);
		introducirLibro.add(titulo);

		tituloTxt = new JTextField();
		tituloTxt.setBounds(154, 90, 86, 20);
		introducirLibro.add(tituloTxt);
		tituloTxt.setColumns(10);

		JLabel autor = new JLabel("Autor");
		autor.setBounds(96, 124, 46, 14);
		introducirLibro.add(autor);

		autorTxt = new JTextField();
		autorTxt.setBounds(153, 121, 86, 20);
		introducirLibro.add(autorTxt);
		autorTxt.setColumns(10);

		JLabel numPag = new JLabel("NºPag");
		numPag.setBounds(96, 158, 46, 14);
		introducirLibro.add(numPag);

		numPagtxt = new JTextField();
		numPagtxt.setBounds(153, 152, 86, 20);
		introducirLibro.add(numPagtxt);
		numPagtxt.setColumns(10);

		JButton GuardarNL = new JButton("Guardar");
		GuardarNL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tituloL = tituloTxt.getText();
				String autorL = autorTxt.getText();
				int numPagL = Integer.parseInt(numPagtxt.getText());

				GestorBBDD ggbdd = new GestorBBDD();
				Libro libro = new Libro();
				libro.setTitulo(tituloL);
				libro.setAutor(autorL);
				libro.setNumPag(numPagL);
				
				try {
					ggbdd.insertarLibro(libro);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		GuardarNL.setBounds(143, 190, 89, 23);
		introducirLibro.add(GuardarNL);
		
		JLabel insertar = new JLabel("INSERTAR LIBRO");
		insertar.setBounds(150, 48, 128, 14);
		introducirLibro.add(insertar);
		
		JButton otrasOpciones = new JButton("OTRAS OPCIONES");
		otrasOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamadaHijo();
			
			}
		});
		otrasOpciones.setBounds(277, 124, 147, 23);
		introducirLibro.add(otrasOpciones);
		

	}
	
	public void llamadaHijo () {
		OtrasOpcionesLibro dialog = new OtrasOpcionesLibro(this);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	
}
