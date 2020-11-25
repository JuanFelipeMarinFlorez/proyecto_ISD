package eps;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class InterfaceEps extends JFrame {

	private JPanel contentPane;
	private JTextField txtSistemaDeVacunas;
	private JTextField txtUsername;
	private JTextField txtContrasea;
	private JTextField fieldUsername;
	private JPasswordField textContrasena;
	private byte[] iv = new byte[16];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceEps frame = new InterfaceEps();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceEps() {
		Seguridad security= new Seguridad();
		GeneradorSolicitudes sol = new GeneradorSolicitudes();
		sol.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSistemaDeVacunas = new JTextField();
		txtSistemaDeVacunas.setEditable(false);
		txtSistemaDeVacunas.setText("Sistema de vacunas");
		txtSistemaDeVacunas.setBounds(149, 6, 154, 26);
		contentPane.add(txtSistemaDeVacunas);
		txtSistemaDeVacunas.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setEditable(false);
		txtUsername.setText("Nombre de usuario");
		txtUsername.setBounds(41, 78, 130, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtContrasea = new JTextField();
		txtContrasea.setText("Contraseña");
		txtContrasea.setEditable(false);
		txtContrasea.setBounds(41, 158, 130, 26);
		contentPane.add(txtContrasea);
		txtContrasea.setColumns(10);
		
		fieldUsername = new JTextField();
		fieldUsername.setBounds(244, 78, 162, 26);
		contentPane.add(fieldUsername);
		fieldUsername.setColumns(10);
		
		textContrasena = new JPasswordField();
		textContrasena.setColumns(10);
		textContrasena.setBounds(244, 158, 162, 26);
		contentPane.add(textContrasena);
		
		JButton btnNewButton = new JButton("Iniciar sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldUsername.getText().length() ==0) {
					JOptionPane.showMessageDialog(null, "El campo de usuario no debe de estar vacio");
				}
				else if(fieldUsername.getText().length() != 16) {
					JOptionPane.showMessageDialog(null, "El campo de usuario no es valido (16 caracteres)");
				}
				else if(textContrasena.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "El campo de contrasena no debe de estar vacio");
				}
				else if(security.buscarUsuario(fieldUsername.getText(),iv,textContrasena.getText())) {
					BuscarSolicitudes iniciarSesion = new BuscarSolicitudes(security);
					iniciarSesion.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario o contrasena no validos");
					
				}
				
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(289, 229, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEps registrarse = new RegistrarEps(security);
				registrarse.setVisible(true);
			}
		});
		btnRegistrarse.setBackground(Color.GRAY);
		btnRegistrarse.setBounds(41, 229, 117, 29);
		contentPane.add(btnRegistrarse);
	}
}
