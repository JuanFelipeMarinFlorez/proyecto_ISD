package eps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarEps extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField fieldNombre;
	private JTextField fieldContrasena;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JTextField textField_2;
	 byte[] iv = new byte[16];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seguridad secure= new Seguridad();
					RegistrarEps frame = new RegistrarEps(secure);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public RegistrarEps(Seguridad security) {
		
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
		
		fieldContrasena = new JTextField();
		fieldContrasena.setColumns(10);
		fieldContrasena.setBounds(250, 128, 162, 26);
		contentPane.add(fieldContrasena);
		
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(249, 185, 162, 26);
		contentPane.add(textField_3);
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldNombre.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "El campo de usuario no debe de estar vacio");
				}
				else if(fieldNombre.getText().length()!=16) {
					JOptionPane.showMessageDialog(null, "El campo de usuario no es valido (16 caracteres)");
				}else if(fieldContrasena.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "El campo de contrasena  no debe de estar vacio");
				}
				
				else if( security.buscarUsuario(fieldNombre.getText())) {
					JOptionPane.showMessageDialog(null, "Ya existe el usuario ");
				}
				else {
					security.encriptar(fieldNombre.getText(), iv,fieldContrasena.getText());
				}
				
				
			}});
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
