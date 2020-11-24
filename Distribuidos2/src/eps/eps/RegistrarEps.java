package eps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class RegistrarEps extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField fieldNombre;
	private JTextField fieldContraseña;
	private JTextField txtVerificarContrasea;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEps frame = new RegistrarEps();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public RegistrarEps() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("Nombre de usuario");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(30, 73, 138, 26);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Contraseña");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(31, 127, 130, 26);
		contentPane.add(textField_1);
		
		fieldNombre = new JTextField();
		fieldNombre.setColumns(10);
		fieldNombre.setBounds(249, 77, 162, 26);
		contentPane.add(fieldNombre);
		
		fieldContraseña = new JTextField();
		fieldContraseña.setColumns(10);
		fieldContraseña.setBounds(250, 128, 162, 26);
		contentPane.add(fieldContraseña);
		
		txtVerificarContrasea = new JTextField();
		txtVerificarContrasea.setText("Verificar contraseña");
		txtVerificarContrasea.setEditable(false);
		txtVerificarContrasea.setColumns(10);
		txtVerificarContrasea.setBounds(30, 185, 152, 26);
		contentPane.add(txtVerificarContrasea);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(249, 185, 162, 26);
		contentPane.add(textField_3);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(310, 232, 117, 29);
		contentPane.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setText("Sistema de vacunas");
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(147, 18, 154, 26);
		contentPane.add(textField_2);
	}
}
