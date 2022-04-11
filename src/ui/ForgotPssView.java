package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.JTextFieldLimit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPssView {

	private JFrame frmFgtPss;
	private JPanel basePanel;
	private JLabel imgFondo;

	private JPanel panelEmail;
	private JTextField txfEmailLogin;
	private JButton btnVolver;
	private JButton btnContinuar;
	private JLabel lblRecuperarPssw;
	private JLabel lblEmailInfo;
	private JLabel lblRefEmail;

	private JPanel panelVerify;
	private JLabel lblVerifiacion;
	private JTextField txfCod1;
	private JTextField txfCod2;
	private JTextField txfCod3;
	private JTextField txfCod4;
	private JLabel lblCodInfo2;
	private JLabel lblCodInfo1;
	private JLabel lblCodInfo3;
	
	private JPanel panelPassword;
	private JLabel lblNuevaContrasena;
	private JLabel lblNuevaPwInfo;
	private JButton btnConfirmar;
	private JButton btnVerificar;
	private JPasswordField pwPassword1;
	private JPasswordField pwPassword2;
	private JLabel lblRefPw1;
	private JLabel lblRefPw2;
	
	private JFrame initialView;
	


	/**
	 * Create the application.
	 */
	public ForgotPssView(JFrame inicio) {
		this.initialView = inicio;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setUIComponents();
		setListeners();
	}
		
	private void setUIComponents() {
				
		frmFgtPss = new JFrame();
		frmFgtPss.setBounds(100, 100, 650, 565);
		frmFgtPss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFgtPss.getContentPane().setLayout(null);

		basePanel = new JPanel();
		basePanel.setBounds(0, 0, 634, 526);
		basePanel.setForeground(new Color(0,0,0,0));
		frmFgtPss.getContentPane().add(basePanel);
		basePanel.setLayout(null);
		
		setUIPanelEmail();
		setUIPanelVerify();
		setUIPanelPassword();
	
		imgFondo = new JLabel("");
		imgFondo.setBounds(0, -28, 767, 619);
		basePanel.add(imgFondo);
		imgFondo.setIcon(new ImageIcon("D:/DAM1/PROG/Netflix/assets/fondo.PNG"));
		
		frmFgtPss.setVisible(true);
	}
	
	private void setUIPanelEmail() {

		panelEmail = new JPanel();
		panelEmail.setBackground(Color.BLACK);
		panelEmail.setBounds(157, 94, 301, 375);
		basePanel.add(panelEmail);
		panelEmail.setBackground(new Color(0,0,0,220));
		panelEmail.setLayout(null);
		
		lblRecuperarPssw = new JLabel("<HTML>Recuperar Contrase\u00F1a</HTML>");
		lblRecuperarPssw.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblRecuperarPssw.setForeground(Color.WHITE);
		lblRecuperarPssw.setBounds(35, 23, 175, 60);
		panelEmail.add(lblRecuperarPssw);
		
		txfEmailLogin = new JTextField();
		txfEmailLogin.setForeground(new Color(128, 140, 140));
		txfEmailLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		txfEmailLogin.setBackground(new Color(51,51,51));
		txfEmailLogin.setBounds(35, 180, 228, 45);
		panelEmail.add(txfEmailLogin);
		txfEmailLogin.setColumns(10);
		txfEmailLogin.setBorder(null);
		
		btnContinuar = new JButton("Continuar");

		btnContinuar.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnContinuar.setBackground(new Color(229, 9, 20));
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setBounds(35, 265, 228, 45);
		panelEmail.add(btnContinuar);
		btnContinuar.setBorder(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setIcon(new ImageIcon("D:/DAM1/PROG/Netflix/assets/nada.PNG"));
		btnVolver.setBackground(new Color(0,0,0));
		btnVolver.setHorizontalAlignment(SwingConstants.RIGHT);
		btnVolver.setBorder(null);
		btnVolver.setBounds(241, 11, 50, 23);
		panelEmail.add(btnVolver);
		
		lblEmailInfo = new JLabel("<HTML>Para recuperar su contrase\u00F1a, es necesario que introduzca a continuaci\u00F3n, el email con el que se ha registrado</HTML>");
		lblEmailInfo.setForeground(Color.WHITE);
		lblEmailInfo.setBounds(35, 83, 228, 67);
		panelEmail.add(lblEmailInfo);
		
		lblRefEmail = new JLabel("Email:");
		lblRefEmail.setVerticalAlignment(SwingConstants.TOP);
		lblRefEmail.setFont(new Font("Corbel", Font.BOLD, 14));
		lblRefEmail.setForeground(Color.WHITE);
		lblRefEmail.setBounds(35, 161, 56, 14);
		panelEmail.add(lblRefEmail);
	}
	
	private void setUIPanelVerify() {
		panelVerify = new JPanel();
		panelVerify.setBackground(Color.BLACK);
		panelVerify.setBounds(157, 94, 301, 375);
		basePanel.add(panelVerify);
		panelVerify.setBackground(new Color(0,0,0,220));
		panelVerify.setLayout(null);
		
		lblVerifiacion = new JLabel("Verificación");
		lblVerifiacion.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblVerifiacion.setForeground(Color.WHITE);
		lblVerifiacion.setBounds(35, 23, 182, 45);
		panelVerify.add(lblVerifiacion);
		
		txfCod1 = new JTextField(1);
		txfCod1.setHorizontalAlignment(SwingConstants.CENTER);
		txfCod1.setFont(new Font("Verdana", Font.BOLD, 18));
		txfCod1.setBounds(45, 203, 45, 45);
		txfCod1.setBorder(null);
		txfCod1.setColumns(10);
		txfCod1.setDocument(new JTextFieldLimit(1));
		panelVerify.add(txfCod1);

		txfCod2 = new JTextField();
		txfCod2.setHorizontalAlignment(SwingConstants.CENTER);
		txfCod2.setFont(new Font("Verdana", Font.BOLD, 18));
		txfCod2.setColumns(10);
		txfCod2.setBounds(100, 203, 45, 45);
		txfCod2.setBorder(null);
		txfCod2.setDocument(new JTextFieldLimit(1));
		panelVerify.add(txfCod2);
		
		txfCod3 = new JTextField();
		txfCod3.setHorizontalAlignment(SwingConstants.CENTER);
		txfCod3.setFont(new Font("Verdana", Font.BOLD, 18));
		txfCod3.setColumns(10);
		txfCod3.setBounds(155, 203, 45, 45);
		txfCod3.setBorder(null);
		txfCod3.setDocument(new JTextFieldLimit(1));
		panelVerify.add(txfCod3);
		
		txfCod4 = new JTextField();
		txfCod4.setHorizontalAlignment(SwingConstants.CENTER);
		txfCod4.setFont(new Font("Verdana", Font.BOLD, 18));
		txfCod4.setColumns(10);
		txfCod4.setBounds(210, 203, 45, 45);
		txfCod4.setBorder(null);
		txfCod4.setDocument(new JTextFieldLimit(1));
		panelVerify.add(txfCod4);
		
		lblCodInfo2 = new JLabel("<HTML>Hemos enviado un <U>NUEVO</U> c\u00F3digo de verificaci\u00F3n a tu email."
								+" Revisa tu bandeja de entrada y la carpeta de spam.</HTML>");
		lblCodInfo2.setForeground(Color.WHITE);
		lblCodInfo2.setBounds(35, 105, 245, 60);
		panelVerify.add(lblCodInfo2);
		
		lblCodInfo1 = new JLabel("<HTML>Para continuar es necesario comprobar que tienes acceso al email indicado.</HTML>");
		lblCodInfo1.setForeground(Color.WHITE);
		lblCodInfo1.setBounds(35, 70, 220, 33);
		panelVerify.add(lblCodInfo1);
		
		lblCodInfo3 = new JLabel("Inserta el c\u00F3digo aqu\u00ED:");
		lblCodInfo3.setForeground(Color.WHITE);
		lblCodInfo3.setBounds(35, 181, 220, 22);
		panelVerify.add(lblCodInfo3);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.setForeground(Color.WHITE);
		btnVerificar.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnVerificar.setBorder(null);
		btnVerificar.setBackground(new Color(229, 9, 20));
		btnVerificar.setBounds(35, 290, 228, 45);
		panelVerify.add(btnVerificar);
	}

	private void setUIPanelPassword() {

		panelPassword = new JPanel();
		panelPassword.setBackground(Color.BLACK);
		panelPassword.setBounds(157, 94, 301, 375);
		basePanel.add(panelPassword);
		panelPassword.setBackground(new Color(0,0,0,220));
		panelPassword.setLayout(null);
		
		lblNuevaContrasena = new JLabel("<HTML>Nueva Contrase\u00F1a</HTML>");
		lblNuevaContrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNuevaContrasena.setForeground(Color.WHITE);
		lblNuevaContrasena.setBounds(35, 23, 159, 60);
		panelPassword.add(lblNuevaContrasena);
		
		btnConfirmar = new JButton("Confirmar");

		btnConfirmar.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnConfirmar.setBackground(new Color(229, 9, 20));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBounds(35, 295, 228, 45);
		panelPassword.add(btnConfirmar);
		btnConfirmar.setBorder(null);
		
		lblNuevaPwInfo = new JLabel("<HTML>A continuación indique su nueva contraseña.</HTML>");
		lblNuevaPwInfo.setForeground(Color.WHITE);
		lblNuevaPwInfo.setBounds(35, 80, 228, 45);
		panelPassword.add(lblNuevaPwInfo);
		
		lblRefPw1 = new JLabel("Contrase\u00F1a:");
		lblRefPw1.setVerticalAlignment(SwingConstants.TOP);
		lblRefPw1.setFont(new Font("Corbel", Font.BOLD, 14));
		lblRefPw1.setForeground(Color.WHITE);
		lblRefPw1.setBounds(35, 126, 91, 14);
		panelPassword.add(lblRefPw1);
		
		pwPassword1 = new JPasswordField();
		pwPassword1.setForeground(new Color(128, 140, 140));
		pwPassword1.setBackground(new Color(51,51,51));
		pwPassword1.setBounds(35, 146, 228, 45);
		pwPassword1.setBorder(null);
		panelPassword.add(pwPassword1);
		
		pwPassword2 = new JPasswordField();
		pwPassword2.setForeground(new Color(128, 140, 140));
		pwPassword2.setBackground(new Color(51,51,51));
		pwPassword2.setBounds(35, 226, 228, 45);
		pwPassword2.setBorder(null);
		panelPassword.add(pwPassword2);
		
		lblRefPw2 = new JLabel("Repite Contrase\u00F1a:");
		lblRefPw2.setVerticalAlignment(SwingConstants.TOP);
		lblRefPw2.setForeground(Color.WHITE);
		lblRefPw2.setFont(new Font("Corbel", Font.BOLD, 14));
		lblRefPw2.setBounds(35, 206, 142, 14);
		panelPassword.add(lblRefPw2);
	}

	private void setListeners() {
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFgtPss.dispose();
				initialView.setVisible(true);
			}
		});
	}
}
