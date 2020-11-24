package eps;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceEps extends JFrame {

	private JPanel contentPane;
	private JTextField txtSistemaDeVacunas;
	private JTextField txtUsername;
	private JTextField txtContrasea;
	private JTextField fieldUsername;
	private JTextField textContraseña;

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
		
		textContraseña = new JTextField();
		textContraseña.setColumns(10);
		textContraseña.setBounds(244, 158, 162, 26);
		contentPane.add(textContraseña);
		
		JButton btnNewButton = new JButton("Iniciar sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarSolicitudes iniciarSesion = new BuscarSolicitudes();
				iniciarSesion.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(19, 229, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEps registrarse = new RegistrarEps();
				registrarse.setVisible(true);
			}
		});
		btnRegistrarse.setBackground(Color.GRAY);
		btnRegistrarse.setBounds(308, 229, 117, 29);
		contentPane.add(btnRegistrarse);
	}
}
