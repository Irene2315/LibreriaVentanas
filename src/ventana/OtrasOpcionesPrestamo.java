package ventana;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorBBDD;
import clases.Prestamo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OtrasOpcionesPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IDLibroTxt;
	private JTextField IDSocioTxt;
	private JTextField fechaTxt;
	private JTextField devueltoTxt;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	try {
	//		OtrasOpcionesPrestamo dialog = new OtrasOpcionesPrestamo();
	//		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//		dialog.setVisible(true);
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//}

	/**
	 * Create the dialog.
	 */
	public OtrasOpcionesPrestamo(JFrame padreJF) {
		setBounds(100, 100, 522, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel OtrasOpciones = new JLabel("OTRAS OPCIONES PRESTAMO");
		OtrasOpciones.setBounds(132, 11, 167, 14);
		contentPanel.add(OtrasOpciones);
		
		JLabel IDLibro = new JLabel("ID LIBRO");
		IDLibro.setBounds(51, 46, 46, 14);
		contentPanel.add(IDLibro);
		
		IDLibroTxt = new JTextField();
		IDLibroTxt.setBounds(158, 43, 86, 20);
		contentPanel.add(IDLibroTxt);
		IDLibroTxt.setColumns(10);
		
		JLabel IDSocio = new JLabel("ID SOCIO");
		IDSocio.setBounds(51, 84, 65, 14);
		contentPanel.add(IDSocio);
		
		IDSocioTxt = new JTextField();
		IDSocioTxt.setBounds(160, 81, 86, 20);
		contentPanel.add(IDSocioTxt);
		IDSocioTxt.setColumns(10);
		
		JLabel fecha = new JLabel("FECHA");
		fecha.setBounds(51, 126, 46, 14);
		contentPanel.add(fecha);
		
		fechaTxt = new JTextField();
		fechaTxt.setBounds(160, 123, 86, 20);
		contentPanel.add(fechaTxt);
		fechaTxt.setColumns(10);
		
		JLabel devuelto = new JLabel("DEVUELTO");
		devuelto.setBounds(51, 158, 65, 14);
		contentPanel.add(devuelto);
		
		devueltoTxt = new JTextField();
		devueltoTxt.setBounds(159, 155, 86, 20);
		contentPanel.add(devueltoTxt);
		devueltoTxt.setColumns(10);
		
		JButton devolverPrestamo = new JButton("DEVOLVER PRESTAMO");
		devolverPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorBBDD gbb = new GestorBBDD();
				int IDLibro = Integer.parseInt(IDLibroTxt.getText());
				gbb.conectar();
				try {
					gbb.devolverLibro(IDLibro);
					gbb.cerrar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		devolverPrestamo.setBounds(280, 42, 143, 23);
		contentPanel.add(devolverPrestamo);
		
		JButton prestamosNoDevueltos = new JButton("PRESTAMOS NO DEVUELTOS");
		prestamosNoDevueltos.setBounds(256, 80, 194, 23);
		contentPanel.add(prestamosNoDevueltos);
		
		JButton prestamosSocio = new JButton("PRESTAMOS DE SOCIO");
		prestamosSocio.setBounds(287, 122, 150, 23);
		contentPanel.add(prestamosSocio);
		
		JButton disponibilidadLibro = new JButton("DISPONIBILIDAD LIBRO");
		disponibilidadLibro.setBounds(276, 154, 174, 23);
		contentPanel.add(disponibilidadLibro);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
