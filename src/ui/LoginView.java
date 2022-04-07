package ui;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView {

	private JFrame frmNetflixLogin;
	private JPanel loginPanel;
	private JLabel imgFondo;
	private JPanel datosPanel;
	private JLabel lblIniciarSesion;
	private JLabel imgLogo;
	private JTextField txtEmail;
	private JPasswordField pwPass;
	private JButton btnIniciarSesion;
	private JButton btnForgottenPss;

	

	/**
	 * Create the application.
	 */
	public LoginView() {
		setUIComponents();
		setListeners();
		frmNetflixLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void setUIComponents() {
		frmNetflixLogin = new JFrame();
		frmNetflixLogin.setTitle("Netflix - Login");
		frmNetflixLogin.getContentPane().setBackground(Color.BLACK);
		frmNetflixLogin.setBounds(100, 100, 650, 565);
		frmNetflixLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetflixLogin.getContentPane().setLayout(null);
		
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.BLACK);
		loginPanel.setBounds(0, 0, 634, 526);
		frmNetflixLogin.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);

		datosPanel = new JPanel();
		datosPanel.setBackground(Color.BLACK);
		datosPanel.setBounds(157, 94, 301, 404);
		loginPanel.add(datosPanel);
		datosPanel.setBackground(new Color(0,0,0,220));
		datosPanel.setLayout(null);
		
		lblIniciarSesion = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesion.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setBounds(35, 23, 182, 45);
		datosPanel.add(lblIniciarSesion);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(128, 140, 140));
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setText("  Email");
		txtEmail.setBackground(new Color(51,51,51));
		txtEmail.setBounds(35, 87, 228, 45);
		datosPanel.add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		
		pwPass = new JPasswordField();
		pwPass.setForeground(new Color(128, 140, 140));
		pwPass.setBackground(new Color(51,51,51));
		pwPass.setBounds(35, 143, 228, 45);
		datosPanel.add(pwPass);
		pwPass.setBorder(null);
		
		btnIniciarSesion = new JButton("Iniciar sesi\u00F3n");

		btnIniciarSesion.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnIniciarSesion.setBackground(new Color(229, 9, 20));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setBounds(35, 224, 228, 45);
		datosPanel.add(btnIniciarSesion);
		btnIniciarSesion.setBorder(null);
		
		btnForgottenPss = new JButton("<HTML><U>¿Contraseña olvidada?</U></HTML>");
		btnForgottenPss.setHorizontalAlignment(SwingConstants.RIGHT);
		btnForgottenPss.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnForgottenPss.setBackground(new Color(0,0,0,220));
		btnForgottenPss.setForeground(Color.WHITE);
		btnForgottenPss.setBounds(140, 279, 123, 23);
		datosPanel.add(btnForgottenPss);
		btnForgottenPss.setBorder(null);
		
		imgLogo = new JLabel("");
		imgLogo.setBounds(10, 11, 209, 54);
		loginPanel.add(imgLogo);
		imgLogo.setIcon(new ImageIcon(LoginView.class.getResource("/assets/logo.PNG")));
		
		imgFondo = new JLabel("");
		imgFondo.setBounds(0, -28, 767, 619);
		loginPanel.add(imgFondo);
		imgFondo.setIcon(new ImageIcon(LoginView.class.getResource("/assets/fondo.PNG")));
		
		ejecutar_sonido("/E:\\DAM1\\PROG\\Netflix\\src\\assets\\tutumsound.wav");
	}
	
	private void setListeners() {
		btnIniciarSesion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	}
	
	private void ejecutar_sonido(String url) {
		try {
			Clip sonido = AudioSystem.getClip();
			
			File f = new File(url);
			sonido.open(AudioSystem.getAudioInputStream(f));
			sonido.start();
		} catch (Exception e) {
			System.out.println("" + e);
		}
	}	
}
