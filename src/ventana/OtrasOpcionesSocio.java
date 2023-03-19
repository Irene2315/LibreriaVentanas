package ventana;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GestorBBDD;
import clases.Socio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OtrasOpcionesSocio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField IDTxt;
	private JTextField DNITxt;
	private JTextField nombreTxt;
	private JTextField apellidoTxt;
	private JTextField direccionTxt;
	private JTextField poblacionTxt;
	private JTextField provinciaTxt;
	
	

	/**
	 * Launch the application.
	 */
	
//	public static void main() {
//		try {
//			OtrasOpcionesSocio dialog = new OtrasOpcionesSocio(null);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public OtrasOpcionesSocio(JFrame padreJF) {
		super(padreJF,true);
		setBounds(100, 100, 420, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel ID = new JLabel("ID");
		ID.setBounds(57, 62, 46, 14);
		contentPanel.add(ID);
		
		IDTxt = new JTextField();
		IDTxt.setBounds(128, 59, 86, 20);
		contentPanel.add(IDTxt);
		IDTxt.setColumns(10);
		
		JLabel otrasOpcionesSocio = new JLabel("OTRAS OPCIONES SOCIO");
		otrasOpcionesSocio.setBounds(133, 11, 163, 14);
		contentPanel.add(otrasOpcionesSocio);
		
		JLabel DNI = new JLabel("DNI");
		DNI.setBounds(57, 96, 46, 14);
		contentPanel.add(DNI);
		
		JButton cargar = new JButton("CARGAR");
		cargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int IDS = Integer.parseInt(IDTxt.getText());
				GestorBBDD gbb = new GestorBBDD ();
				gbb.conectar();
				Socio socio = new Socio();
				try {
					socio =gbb.getSocio(IDS);
					
					DNITxt.setText(socio.getDni());
					nombreTxt.setText(socio.getNombre());
					apellidoTxt.setText(socio.getApellido());
					direccionTxt.setText(socio.getDireccion());
					poblacionTxt.setText(socio.getPoblacion());
					provinciaTxt.setText(socio.getProvincia());
					
					gbb.cerrar();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		cargar.setBounds(299, 66, 89, 23);
		contentPanel.add(cargar);
		
		JButton borrar = new JButton("BORRAR");
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorBBDD gdd = new GestorBBDD();
				int IDS = Integer.parseInt(IDTxt.getText());
				
				gdd.conectar();
				try {
					
					gdd.eliminarSocio(IDS);
					gdd.cerrar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		borrar.setBounds(299, 117, 89, 23);
		contentPanel.add(borrar);
		
		JButton modificar = new JButton("MODIFICAR");
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int IDS = Integer.parseInt(IDTxt.getText());
				String DNIS = DNITxt.getText();
				String nombreS = nombreTxt.getText();
				String apellidoS = apellidoTxt.getText();
				String direccionS = direccionTxt.getText();
				String poblacionS = poblacionTxt.getText();
				String provinciaS = provinciaTxt.getText();
				
				GestorBBDD gbb = new GestorBBDD();
				Socio socio = new Socio();
				gbb.conectar();
				
					try {
						socio= gbb.getSocio(IDS);
						
						socio.setDni(DNIS);
						socio.setNombre(nombreS);
						socio.setApellido(apellidoS);
						socio.setDireccion(direccionS);
						socio.setPoblacion(poblacionS);
						socio.setProvincia(provinciaS);
						
					   gbb.modificarSocio(socio);
					   
					   gbb.cerrar();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
			}
		});
		modificar.setBounds(287, 161, 107, 23);
		contentPanel.add(modificar);
		
		DNITxt = new JTextField();
		DNITxt.setBounds(128, 93, 86, 20);
		contentPanel.add(DNITxt);
		DNITxt.setColumns(10);
		
		JLabel nombre = new JLabel("NOMBRE");
		nombre.setBounds(47, 130, 46, 14);
		contentPanel.add(nombre);
		
		nombreTxt = new JTextField();
		nombreTxt.setBounds(128, 124, 86, 20);
		contentPanel.add(nombreTxt);
		nombreTxt.setColumns(10);
		
		JLabel apellido = new JLabel("APELLIDO");
		apellido.setBounds(47, 161, 59, 14);
		contentPanel.add(apellido);
		
		apellidoTxt = new JTextField();
		apellidoTxt.setBounds(128, 155, 86, 20);
		contentPanel.add(apellidoTxt);
		apellidoTxt.setColumns(10);
		
		JLabel direccion = new JLabel("DIRECCION");
		direccion.setBounds(47, 189, 59, 14);
		contentPanel.add(direccion);
		
		direccionTxt = new JTextField();
		direccionTxt.setBounds(128, 186, 86, 20);
		contentPanel.add(direccionTxt);
		direccionTxt.setColumns(10);
		
		JLabel poblacion = new JLabel("POBLACION");
		poblacion.setBounds(47, 220, 59, 14);
		contentPanel.add(poblacion);
		
		poblacionTxt = new JTextField();
		poblacionTxt.setBounds(128, 217, 86, 20);
		contentPanel.add(poblacionTxt);
		poblacionTxt.setColumns(10);
		
		JLabel provincia = new JLabel("PROVINCIA");
		provincia.setBounds(47, 251, 59, 14);
		contentPanel.add(provincia);
		
		provinciaTxt = new JTextField();
		provinciaTxt.setBounds(128, 248, 86, 20);
		contentPanel.add(provinciaTxt);
		provinciaTxt.setColumns(10);
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