package ventana;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorBBDD;
import clases.GestorLibros;
import clases.Libro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OtrasOpcionesLibro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IDLibroTxt;
	private JTextField tituloTxt;
	private JTextField autorTxt;
	private JTextField numPaginasTxt;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ModificarLibro dialog = new ModificarLibro();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public OtrasOpcionesLibro(JFrame padreJF) {
		super(padreJF,true);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel otrasOpciones = new JLabel("OTRAS OPCIONES LIBRO");
			otrasOpciones.setBounds(146, 10, 144, 14);
			contentPanel.add(otrasOpciones);
		}
		{
			JLabel IDLibro = new JLabel("ID_LIBRO");
			IDLibro.setBounds(53, 57, 74, 14);
			contentPanel.add(IDLibro);
		}
		{
			IDLibroTxt = new JTextField();
			IDLibroTxt.setBounds(151, 54, 86, 20);
			contentPanel.add(IDLibroTxt);
			IDLibroTxt.setColumns(10);
		}
		{
			JButton Cargar = new JButton("CARGAR");
			Cargar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    int id  = Integer.parseInt(IDLibroTxt.getText());
				    
				    GestorBBDD ggbdd = new GestorBBDD();
					ggbdd.conectar();
					Libro libro = ggbdd.getLibro(id);
					
					tituloTxt.setText(libro.getTitulo());
					autorTxt.setText(libro.getAutor());
					numPaginasTxt.setText(String.valueOf(libro.getNumPag()));
					
					try {
						ggbdd.cerrar();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			Cargar.setBounds(291, 53, 89, 23);
			contentPanel.add(Cargar);
		}
		{
			JButton borrar = new JButton("BORRAR");
			borrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 int id  = Integer.parseInt(IDLibroTxt.getText());
					    
						GestorBBDD ggbdd = new GestorBBDD();
						ggbdd.conectar();
						try {
							ggbdd.eliminarLibro(id);
							ggbdd.cerrar();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			borrar.setBounds(291, 103, 89, 23);
			contentPanel.add(borrar);
		}
		
		{
			JButton modificar = new JButton("MODIFICAR");
			modificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  int id  = Integer.parseInt(IDLibroTxt.getText());
					    
						GestorBBDD ggbdd = new GestorBBDD();
						ggbdd.conectar();
						Libro libro = ggbdd.getLibro(id);
						
						String tituloLM = tituloTxt.getText();
						String autorLM = autorTxt.getText();
						int numPagLM = Integer.parseInt(numPaginasTxt.getText());
						
						libro.setTitulo(tituloLM);
						libro.setAutor(autorLM);
						libro.setNumPag(numPagLM);
						
						ggbdd.modificarLibro(libro);
						try {
							ggbdd.cerrar();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			modificar.setBounds(291, 156, 109, 23);
			contentPanel.add(modificar);
		}
		{
			JLabel titulo = new JLabel("TITULO");
			titulo.setBounds(53, 90, 46, 14);
			contentPanel.add(titulo);
		}
		{
			tituloTxt = new JTextField();
			tituloTxt.setBounds(151, 85, 86, 20);
			contentPanel.add(tituloTxt);
			tituloTxt.setColumns(10);
		}
		{
			JLabel autor = new JLabel("AUTOR");
			autor.setBounds(53, 122, 46, 14);
			contentPanel.add(autor);
		}
		{
			autorTxt = new JTextField();
			autorTxt.setBounds(151, 118, 86, 20);
			contentPanel.add(autorTxt);
			autorTxt.setColumns(10);
		}
		{
			JLabel numPag = new JLabel("NºPaginas");
			numPag.setBounds(53, 160, 74, 14);
			contentPanel.add(numPag);
		}
		{
			numPaginasTxt = new JTextField();
			numPaginasTxt.setBounds(151, 157, 86, 20);
			contentPanel.add(numPaginasTxt);
			numPaginasTxt.setColumns(10);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	

}
