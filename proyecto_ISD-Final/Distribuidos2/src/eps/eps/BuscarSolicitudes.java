package eps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import ips.IpsInterface;
import ips.MailInterface;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.util.Map.Entry;

public class BuscarSolicitudes extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscarSolicitudes;
	private JTextField txtVacuna;
	private JTextField txtVacuna_1;
	private JTextField txtVacuna_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Eps salud;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Seguridad secure= new Seguridad();
					//BuscarSolicitudes frame = new BuscarSolicitudes(secure);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BuscarSolicitudes(Seguridad security, Eps eps) {
		
		this.salud = eps;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 320);
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
		txtBuscarSolicitudes.setBounds(82, 17, 185, 26);
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
		textField.setBounds(175, 81, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(175, 134, 130, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(175, 190, 130, 26);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Pedir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				MailInterface mail = (MailInterface)Naming.lookup("//"+"127.0.0.1"+":"+1500+"/suma");//la ip debe ser del pc que corrio a MainMail.
				IpsInterface misuma = mail.ipsInterface();
				
				for (Entry<String, Integer> pair : salud.getVacunasXpersonas().entrySet()) {
					
						for(int l = 0; l < pair.getValue();l++) {
							
							misuma.pedirVacunas(pair.getKey(), 1);
							System.out.println(l+"\n");
							
						}
						JOptionPane.showMessageDialog(null, "Las vacunas disponibles de "+ pair.getKey() + " es: " + misuma.getVacunasDisponibles());
					
				    //pair.getKey(); 
					//pair.getValue();
				}
				} catch (HeadlessException | RemoteException | MalformedURLException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBounds(22, 243, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBuscarSolicitudes = new JButton("Buscar solicitudes");
		btnBuscarSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					salud = new Eps("Sanitas",20);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//int numero = new Integer(JOptionPane.showInputDialog("vacuna1"));
				
				int []vacunitas=security.buscarsolicitudes();
				
				salud.setVacunasXpersonas("vacuna1",new Integer(vacunitas[0]));
				salud.setVacunasXpersonas("vacuna2",new Integer(vacunitas[1]));
				salud.setVacunasXpersonas("vacuna3",new Integer(vacunitas[2]));
				
				textField.setText(String.valueOf(vacunitas[0]));
				textField_1.setText(String.valueOf(vacunitas[1]));
				textField_2.setText(String.valueOf(vacunitas[2]));
				
			}
		});
		btnBuscarSolicitudes.setBounds(175, 243, 139, 29);
		contentPane.add(btnBuscarSolicitudes);
	}
}
