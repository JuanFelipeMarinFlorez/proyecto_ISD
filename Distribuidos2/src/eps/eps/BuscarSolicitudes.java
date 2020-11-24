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

public class BuscarSolicitudes extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscarSolicitudes;
	private JTextField txtVacuna;
	private JTextField txtVacuna_1;
	private JTextField txtVacuna_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarSolicitudes frame = new BuscarSolicitudes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BuscarSolicitudes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBuscarSolicitudes = new JTextField();
		txtBuscarSolicitudes.setText("Buscar solicitudes");
		txtBuscarSolicitudes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtBuscarSolicitudes.setEditable(false);
		txtBuscarSolicitudes.setColumns(10);
		txtBuscarSolicitudes.setBounds(144, 18, 185, 26);
		contentPane.add(txtBuscarSolicitudes);
		
		txtVacuna = new JTextField();
		txtVacuna.setEditable(false);
		txtVacuna.setText("Vacuna 1");
		txtVacuna.setBounds(22, 81, 130, 26);
		contentPane.add(txtVacuna);
		txtVacuna.setColumns(10);
		
		txtVacuna_1 = new JTextField();
		txtVacuna_1.setText("Vacuna 2");
		txtVacuna_1.setEditable(false);
		txtVacuna_1.setColumns(10);
		txtVacuna_1.setBounds(22, 134, 130, 26);
		contentPane.add(txtVacuna_1);
		
		txtVacuna_2 = new JTextField();
		txtVacuna_2.setText("Vacuna 3");
		txtVacuna_2.setEditable(false);
		txtVacuna_2.setColumns(10);
		txtVacuna_2.setBounds(22, 190, 130, 26);
		contentPane.add(txtVacuna_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(188, 81, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(188, 134, 130, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(188, 190, 130, 26);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(330, 105, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(330, 157, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}
