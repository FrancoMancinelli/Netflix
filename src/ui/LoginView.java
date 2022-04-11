package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UsuarioDAO;
import models.Usuario;
import utils.Email;
import utils.JTextFieldLimit;

public class LoginView {

	private JFrame frmLogin;
	private JPanel basePanel;
	private JLabel imgFondo;
	
	private JPanel panelLogin;
	private JLabel lblIniciarSesion;
	private JTextField txfEmailLogin;
	private JPasswordField pwPassLogin;
	private JButton btnIniciarSesion;
	private JButton btnForgottenPss;
	private JButton btnRegistrarse;
	
	private JPanel panelRegist;
	private JLabel lblRegistrarse;
	private JTextField txfEmailRegist;
	private JTextField txfName;
	private JPasswordField pwPassword1;
	private JPasswordField pwPassword2;
	private JButton btnEnviar;
	private JButton btnVolver;
	
	private JPanel panelVerify;
	private JLabel lblVerifiacion;
	private JTextField txfCod1;
	private JTextField txfCod2;
	private JTextField txfCod3;
	private JTextField txfCod4;
	private JLabel lblCodInfo2;
	private JLabel lblCodInfo1;
	private JLabel lblCodInfo3;
	private JButton btnVerificar;
	
	private UsuarioDAO uDAO;
	private String emailVerificacion;
	

	/**
	 * Create the application.
	 */
	public LoginView() {
		setUIComponents();
		setListeners();
		frmLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void setUIComponents() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Netflix - Login");
		frmLogin.setBounds(100, 100, 650, 565);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		basePanel = new JPanel();
		basePanel.setBounds(0, 0, 634, 526);
		basePanel.setForeground(new Color(0,0,0,0));
		frmLogin.getContentPane().add(basePanel);
		basePanel.setLayout(null);
		
		setUIPanelLogin();
		setUIPanelRegist();
		setUIPanelVerify();
	
		imgFondo = new JLabel("");
		imgFondo.setBounds(0, -28, 767, 619);
		basePanel.add(imgFondo);
		imgFondo.setIcon(new ImageIcon("D:/DAM1/PROG/Netflix/assets/fondo.PNG"));
		
		frmLogin.setVisible(true);
		changeVisibility(1);
	}
	
	private void setUIPanelLogin() {
		panelLogin = new JPanel();
		panelLogin.setBackground(Color.BLACK);
		panelLogin.setBounds(157, 94, 301, 375);
		basePanel.add(panelLogin);
		panelLogin.setBackground(new Color(0,0,0,220));
		panelLogin.setLayout(null);
		
		lblIniciarSesion = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesion.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setBounds(35, 23, 182, 45);
		panelLogin.add(lblIniciarSesion);
		
		txfEmailLogin = new JTextField();
		txfEmailLogin.setForeground(new Color(128, 140, 140));
		txfEmailLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		txfEmailLogin.setText("  Email");
		txfEmailLogin.setBackground(new Color(51,51,51));
		txfEmailLogin.setBounds(35, 87, 228, 45);
		panelLogin.add(txfEmailLogin);
		txfEmailLogin.setColumns(10);
		txfEmailLogin.setBorder(null);
		
		pwPassLogin = new JPasswordField();
		pwPassLogin.setForeground(new Color(128, 140, 140));
		pwPassLogin.setBackground(new Color(51,51,51));
		pwPassLogin.setBounds(35, 143, 228, 45);
		panelLogin.add(pwPassLogin);
		pwPassLogin.setBorder(null);
		
		btnIniciarSesion = new JButton("Iniciar sesi\u00F3n");

		btnIniciarSesion.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnIniciarSesion.setBackground(new Color(229, 9, 20));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setBounds(35, 224, 228, 45);
		panelLogin.add(btnIniciarSesion);
		btnIniciarSesion.setBorder(null);
		
		btnForgottenPss = new JButton("<HTML>¿Contraseña Olvidada? <U>Recuperala aquí</U></HTML>");
		btnForgottenPss.setHorizontalAlignment(SwingConstants.LEFT);
		btnForgottenPss.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnForgottenPss.setBackground(new Color(0,0,0,220));
		btnForgottenPss.setForeground(Color.WHITE);
		btnForgottenPss.setBounds(35, 302, 208, 23);
		panelLogin.add(btnForgottenPss);
		btnForgottenPss.setBorder(null);
		
		btnRegistrarse = new JButton("<HTML>¿No tienes una cuenta? <U>Registrate ahora!</U></HTML>");
		btnRegistrarse.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRegistrarse.setBorder(null);
		btnRegistrarse.setBackground(new Color(0, 0, 0, 220));
		btnRegistrarse.setBounds(35, 280, 208, 23);
		panelLogin.add(btnRegistrarse);
	}
	
	
	private void setUIPanelRegist() {
		panelRegist = new JPanel();
		panelRegist.setBackground(Color.BLACK);
		panelRegist.setBounds(157, 94, 301, 375);
		basePanel.add(panelRegist);
		panelRegist.setBackground(new Color(0,0,0,220));
		panelRegist.setLayout(null);
		
		lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblRegistrarse.setForeground(Color.WHITE);
		lblRegistrarse.setBounds(35, 23, 182, 45);
		panelRegist.add(lblRegistrarse);
		
		txfEmailRegist = new JTextField();
		txfEmailRegist.setText("  Email");
		txfEmailRegist.setForeground(new Color(128, 140, 140));
		txfEmailRegist.setFont(new Font("Arial", Font.PLAIN, 12));
		txfEmailRegist.setColumns(10);
		txfEmailRegist.setBorder(null);
		txfEmailRegist.setBackground(new Color(51, 51, 51));
		txfEmailRegist.setBounds(35, 127, 228, 45);
		panelRegist.add(txfEmailRegist);
		
		txfName = new JTextField();
		txfName.setText("  Nombre");
		txfName.setForeground(new Color(128, 140, 140));
		txfName.setFont(new Font("Arial", Font.PLAIN, 12));
		txfName.setColumns(10);
		txfName.setBorder(null);
		txfName.setBackground(new Color(51, 51, 51));
		txfName.setBounds(35, 71, 228, 45);
		panelRegist.add(txfName);
		
		pwPassword1 = new JPasswordField();
		pwPassword1.setForeground(new Color(128, 140, 140));
		pwPassword1.setBorder(null);
		pwPassword1.setBackground(new Color(51, 51, 51));
		pwPassword1.setBounds(35, 183, 228, 45);
		panelRegist.add(pwPassword1);
		
		pwPassword2 = new JPasswordField();
		pwPassword2.setForeground(new Color(128, 140, 140));
		pwPassword2.setBorder(null);
		pwPassword2.setBackground(new Color(51, 51, 51));
		pwPassword2.setBounds(35, 239, 228, 45);
		panelRegist.add(pwPassword2);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnEnviar.setBorder(null);
		btnEnviar.setBackground(new Color(229, 9, 20));
		btnEnviar.setBounds(35, 305, 228, 45);
		panelRegist.add(btnEnviar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setIcon(new ImageIcon("D:/DAM1/PROG/Netflix/assets/nada.PNG"));
		btnVolver.setBackground(new Color(0,0,0));
		btnVolver.setHorizontalAlignment(SwingConstants.RIGHT);
		btnVolver.setBorder(null);
		btnVolver.setBounds(241, 11, 50, 23);
		panelRegist.add(btnVolver);
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
		lblCodInfo2.setBounds(35, 92, 245, 60);
		panelVerify.add(lblCodInfo2);
		
		lblCodInfo1 = new JLabel("Tu cuenta a\u00FAn no est\u00E1 verificada.");
		lblCodInfo1.setForeground(Color.WHITE);
		lblCodInfo1.setBounds(35, 62, 220, 22);
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
	
	
	private void setListeners() {
		btnIniciarSesion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				if(loginValido()) {
					new NetflixView();
					frmLogin.dispose();
				}
			}
		});
				
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeVisibility(1);
			}
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeVisibility(2);
			}
		});

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(registroValido(txfEmailRegist.getText(), new String (pwPassword1.getPassword()), new String (pwPassword2.getPassword()))) {
					registrarEnBD(txfName.getText(), txfEmailRegist.getText(), new String (pwPassword1.getPassword()));
					changeVisibility(3);
				}
			}
		});
			
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteLetters();
				if(checkVerification(emailVerificacion)) {
					uDAO.validateCode(emailVerificacion);
					new	NetflixView();
					frmLogin.dispose();
				}
			}
		});
		
		btnForgottenPss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ForgotPssView(frmLogin);
				frmLogin.setVisible(false);
			}
		});

	}
	
	
	public void changeVisibility (int modo) {
		switch (modo) {
			case 1:
				panelLogin.setVisible(true);
				panelRegist.setVisible(false);
				panelVerify.setVisible(false);
				break;
			case 2:
				panelLogin.setVisible(false);
				panelRegist.setVisible(true);
				panelVerify.setVisible(false);
				break;
			case 3:
				panelLogin.setVisible(false);
				panelRegist.setVisible(false);
				panelVerify.setVisible(true);
				break;
			default:
				panelLogin.setVisible(true);
				panelRegist.setVisible(false);
				panelVerify.setVisible(false);
		}
	}

	
	public boolean registroValido(String email, String pw1, String pw2) {
		if(checkVaciosRegist()) {
			JOptionPane.showMessageDialog(btnEnviar, "ERR0R! -  Rellena todos los campos");
			return false;
		}
		if(!emailValido(email)) {
			JOptionPane.showMessageDialog(btnEnviar, "ERR0R! -  El email no es valido");
			return false;
		}
		
		if(!passwordMatch(pw1, pw2)) {
			JOptionPane.showMessageDialog(btnEnviar, "ERR0R! -  Las contraseñas no coinciden");
			return false;
		}
		return true;
	}
	
	
    public boolean emailValido (String email) {
    	final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                
        Pattern pat = Pattern.compile(regex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    

    public boolean passwordMatch(String pw1, String pw2) {
    	if(pw1 != null && pw2 != null)
    		if(pw1.equals(pw2))
    			return true;
		return false;
    	
    }
    
    public boolean checkVaciosRegist () {
    	
		final String passwd1 = new String (pwPassword1.getPassword());
		final String passwd2 = new String (pwPassword2.getPassword());
		
    	if(txfEmailRegist.getText().isEmpty() || txfName.getText().isEmpty() || passwd1.isEmpty() || passwd2.isEmpty())
    		return true;
    	return false;
    }
    
    public String hashPassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    public void registrarEnBD(String name, String email, String password) {
    	String pwHashed = hashPassword(password, "abc123");
    	int codigo = generateValidationCode();
    	
    	uDAO = new UsuarioDAO();
    	Usuario u = new Usuario(name, email, pwHashed, codigo);
    	
    	uDAO.registro(u);
    	Email e = new Email();
    	e.sendEmailBienvenida(email, name, codigo);
    	
    	emailVerificacion = email;
    }
    
    /**
     * Genera un número aleatorio de 4 digitos entre 1000 y 9999
     * @return Número de 4 digitos generado
     */
    public int generateValidationCode() {
		return (int) (1000 + Math.random() * 9000);
    }
    
    public boolean validarCodigo(String email) {
    	int codigo = Integer.valueOf(txfCod1.getText()+txfCod2.getText()+txfCod3.getText()+txfCod4.getText());
    	if(codigo != uDAO.getCode(email)) {
    		return false;
    	}
    	return true;
    }
    
    public void deleteLetters() {
    	if (!txfCod1.getText().matches("[0-9]+"))
    		txfCod1.setText("");
    	if (!txfCod2.getText().matches("[0-9]+"))
    		txfCod2.setText("");
    	if (!txfCod3.getText().matches("[0-9]+"))
    		txfCod3.setText("");
    	if (!txfCod4.getText().matches("[0-9]+"))
    		txfCod4.setText("");
    }
    
    public boolean checkVaciosCodigo() {
    	if(txfCod1.getText().isEmpty() ||
    		txfCod2.getText().isEmpty() ||
    		txfCod3.getText().isEmpty() ||
    		txfCod4.getText().isEmpty()) {
    		return true;
    	}
    	return false;
    }
    
    public boolean checkVerification(String email) {
    	if(checkVaciosCodigo()) {
    		JOptionPane.showMessageDialog(btnEnviar, "ERR0R! -  Rellena todos los campos");
			return false;
    	}
    	
    	if(!validarCodigo(email)) {
    		txfCod1.setText("");
    		txfCod2.setText("");
    		txfCod3.setText("");
    		txfCod4.setText("");
			JOptionPane.showMessageDialog(btnVerificar, "ERR0R! -  Código invalido, vuelve a intentarlo");
			return false;
    	}
    	return true;
    }
    
    public boolean checkVaciosLogin() {
    	if(txfEmailLogin.getText().isEmpty() ||
    		new String (pwPassLogin.getPassword()).isEmpty()) {
    		return true;
    	}
    	return false;
    }
    
    public boolean loginValido() {
    	if(checkVaciosLogin()) {
			JOptionPane.showMessageDialog(btnIniciarSesion, "ERR0R! -  Rellena todos los campos");
			return false;
    	}
    	
    	if(!datosLoginCorrectos()) {
			JOptionPane.showMessageDialog(btnIniciarSesion, "ERR0R! - El email o la contraseña no son correctos");
    		return false;
    	}
    	
    	if(!cuentaVerificada()) {
    		emailVerificacion = txfEmailLogin.getText();
        	generateNewVerificationCode();
        	return false;
    	}
		return true;
    }

	public void generateNewVerificationCode() {
		int codigo = generateValidationCode();
		Email e = new Email();
		e.sendEmailNewCode(txfEmailLogin.getText(), codigo);
		uDAO.changeCode(txfEmailLogin.getText(), codigo);
		changeVisibility(3);
	}
    
    public boolean cuentaVerificada() {
    	if(uDAO.checkVerified(txfEmailLogin.getText()) == 0)
    		return false;
    	return true;
    }
    
    
    public boolean datosLoginCorrectos() {
    	final String hashPass = hashPassword(new String (pwPassLogin.getPassword()), "abc123");
    	uDAO = new UsuarioDAO();
    	if(uDAO.login(txfEmailLogin.getText(), hashPass))
    		return true;
    	return false;
    }
}
