package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import utils.HashPassword;
import utils.JTextFieldLimit;

public class LoginView {

	//Componentes Frame general
	private JFrame frmLogin;
	private JPanel basePanel;
	private JLabel imgFondo;
	
	//Componentes Panel Login
	private JPanel panelLogin;
	private JLabel lblIniciarSesion;
	private JTextField txfEmailLogin;
	private JPasswordField pwPassLogin;
	private JButton btnIniciarSesion;
	private JButton btnForgottenPss;
	private JButton btnRegistrarse;
	private JLabel lblContraseña;
	private JLabel lblCorreo;
	
	//Componentes Panel Registro
	private JPanel panelRegist;
	private JLabel lblRegistrarse;
	private JTextField txfEmailRegist;
	private JTextField txfName;
	private JPasswordField pwPassword1;
	private JPasswordField pwPassword2;
	private JButton btnEnviar;
	private JButton btnVolver;
	private JLabel lblNameReg;
	private JLabel lblEmailReg;
	private JLabel lblPass1;
	private JLabel lblPass2;
	
	//Componentes Panel Verificación
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
	
	//Componentes de utilidad general
	private UsuarioDAO uDAO;
	private String emailVerificacion;
	private String username;

	

	/**
	 * Crea la aplicación
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Inicializa el contenido del frame
	 */
	private void initialize() {
		setUIComponents();
		setListeners();
    	uDAO = new UsuarioDAO();
		frmLogin.setVisible(true);
	}

	/**
	 * Construye los diferentes componentes generales del Frame
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
		imgFondo.setIcon(new ImageIcon("assets/fondo.PNG"));
		
		frmLogin.setVisible(true);
		changeVisibility(1);
	}
	
	/**
	 * Construye los componentes del Panel Login
	 */
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
		txfEmailLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		txfEmailLogin.setText("");
		txfEmailLogin.setBackground(new Color(51,51,51));
		txfEmailLogin.setBounds(35, 87, 228, 45);
		panelLogin.add(txfEmailLogin);
		txfEmailLogin.setColumns(10);
		txfEmailLogin.setBorder(null);
		
		pwPassLogin = new JPasswordField();
		pwPassLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pwPassLogin.setForeground(new Color(128, 140, 140));
		pwPassLogin.setBackground(new Color(51,51,51));
		pwPassLogin.setBounds(35, 155, 228, 45);
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
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setBounds(35, 70, 73, 14);
		panelLogin.add(lblCorreo);
		
		lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContraseña.setBounds(35, 140, 105, 14);
		panelLogin.add(lblContraseña);
	}
	
	/**
	 * Construye los componentes del Panel Regist
	 */
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
		txfEmailRegist.setText("");
		txfEmailRegist.setForeground(new Color(128, 140, 140));
		txfEmailRegist.setFont(new Font("Dialog", Font.PLAIN, 14));
		txfEmailRegist.setColumns(10);
		txfEmailRegist.setBorder(null);
		txfEmailRegist.setBackground(new Color(51, 51, 51));
		txfEmailRegist.setBounds(35, 150, 228, 30);
		panelRegist.add(txfEmailRegist);
		
		txfName = new JTextField();
		txfName.setForeground(new Color(128, 140, 140));
		txfName.setFont(new Font("Dialog", Font.PLAIN, 14));
		txfName.setColumns(10);
		txfName.setBorder(null);
		txfName.setBackground(new Color(51, 51, 51));
		txfName.setBounds(35, 95, 228, 30);
		panelRegist.add(txfName);
		
		pwPassword1 = new JPasswordField();
		pwPassword1.setFont(new Font("Dialog", Font.PLAIN, 14));
		pwPassword1.setForeground(new Color(128, 140, 140));
		pwPassword1.setBorder(null);
		pwPassword1.setBackground(new Color(51, 51, 51));
		pwPassword1.setBounds(35, 205, 228, 30);
		panelRegist.add(pwPassword1);
		
		pwPassword2 = new JPasswordField();
		pwPassword2.setFont(new Font("Dialog", Font.PLAIN, 14));
		pwPassword2.setForeground(new Color(128, 140, 140));
		pwPassword2.setBorder(null);
		pwPassword2.setBackground(new Color(51, 51, 51));
		pwPassword2.setBounds(35, 260, 228, 30);
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
		btnVolver.setIcon(new ImageIcon("assets/nada.PNG"));
		btnVolver.setBackground(new Color(0,0,0));
		btnVolver.setHorizontalAlignment(SwingConstants.RIGHT);
		btnVolver.setBorder(null);
		btnVolver.setBounds(241, 11, 50, 23);
		panelRegist.add(btnVolver);
		
		lblNameReg = new JLabel("Nombre:");
		lblNameReg.setForeground(Color.WHITE);
		lblNameReg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNameReg.setBounds(35, 80, 77, 14);
		panelRegist.add(lblNameReg);
		
		lblEmailReg = new JLabel("Correo:");
		lblEmailReg.setForeground(Color.WHITE);
		lblEmailReg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailReg.setBounds(35, 135, 77, 14);
		panelRegist.add(lblEmailReg);
		
		lblPass1 = new JLabel("Contrase\u00F1a:");
		lblPass1.setForeground(Color.WHITE);
		lblPass1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPass1.setBounds(35, 190, 115, 14);
		panelRegist.add(lblPass1);
		
		lblPass2 = new JLabel("Repita contrase\u00F1a:");
		lblPass2.setForeground(Color.WHITE);
		lblPass2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPass2.setBounds(35, 245, 136, 14);
		panelRegist.add(lblPass2);
	}
	
	/**
	 * Construye los componentes del Panel Verify
	 */
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
		lblCodInfo2.setBounds(35, 92, 245, 78);
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
	
	/**
	 * Configura los diferentes Listeners
	 */
	private void setListeners() {
		btnIniciarSesion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				realizarLogin();
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
				realizarRegistro();
			}
		});
			
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnForgottenPss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ForgotPssView(frmLogin);
				frmLogin.setVisible(false);
			}
		});
		
		pwPassLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					realizarLogin();
				}
		});
		
		pwPassword2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					realizarRegistro();
				}
		});
		
		txfCod1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
					if(!txfCod1.getText().isEmpty())
						txfCod2.requestFocus();
				}
			}
		});
		
		txfCod2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
					if(!txfCod2.getText().isEmpty())
						txfCod3.requestFocus();
				}
			}
		});
		
		txfCod3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
					if(!txfCod3.getText().isEmpty())
						txfCod4.requestFocus();
				}
			}
		});

		txfCod4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					realizarVerificacion();
			}
		});

	}
	
	/**
	 * Realiza la logistica necesaria para logearse
	 */
	private void realizarLogin() {
		if(loginValido()) {
			username = uDAO.getUsername(txfEmailLogin.getText());
			new NetflixView(frmLogin, username);
			frmLogin.setVisible(false);
		}
	}
	
	/**
	 * Realiza la logistica necesaria para realizar un registro
	 */
	private void realizarRegistro() {
		if(registroValido(txfEmailRegist.getText(), new String (pwPassword1.getPassword()), new String (pwPassword2.getPassword()))) {
			registrarEnBD(txfName.getText(), txfEmailRegist.getText(), new String (pwPassword1.getPassword()));
			changeVisibility(3);
		}
	}
	
	/**
	 * Realiza la logistica necesaria para validar un código
	 */
	private void realizarVerificacion() {
		if(checkVerification(emailVerificacion)) {
			uDAO.validateCode(emailVerificacion);
			username = uDAO.getUsername(emailVerificacion);
			new NetflixView(frmLogin, username);
			frmLogin.setVisible(false);
			changeVisibility(1);
		}
	}
	
	/**
	 * Cambia la visibilidad de los paneles
	 * @param modo Número para identificar que panel mostrar
	 */
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
				txfCod1.requestFocus();
				break;
		}
	}

	/**
	 * Comprueba si es posible realizar un Registro
	 * @param email Email a ser registrado
	 * @param pw1 Contraseña
	 * @param pw2 Repite contraseña
	 * @return True en caso de poder realizar el registro | False en caso contrario
	 */
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
	
	/**
	 * Comprueba si la estructura de un email es "correcta"
	 * @param email Email a comprobar
	 * @return True en caso de que sea valido | False en caso contrario
	 */
    public boolean emailValido (String email) {
    	final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                
        Pattern pat = Pattern.compile(regex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    

    /**
     * Comprueba si dos contraseñas coinciden entre ellas y si no son null
     * @param pw1 Contraseña 1
     * @param pw2 Contraseña 2
     * @return True en caso de que sean iguales | False en caso contrario
     */
    public boolean passwordMatch(String pw1, String pw2) {
    	if(pw1 != null && pw2 != null)
    		if(pw1.equals(pw2))
    			return true;
		return false;
    	
    }
    
    /**
     * Comprueba si las cajas de texto del panel de registro estan vacias
     * @return True en caso de haber alguna vacia | False en caso contrario
     */
    public boolean checkVaciosRegist () {
    	
		final String passwd1 = new String (pwPassword1.getPassword());
		final String passwd2 = new String (pwPassword2.getPassword());
		
    	return txfEmailRegist.getText().isEmpty() || txfName.getText().isEmpty() || passwd1.isEmpty() || passwd2.isEmpty();
    }
    
    /**
     * Realiza un Hash a una contraseña
     * @param passwordToHash La contraseña a aplicar el hash
     * @param salt Salt pre-definido para aumentar la seguridad de la clave
     * @return La contraseña hasheada
     */
    public String hashPassword(String passwordToHash, String salt){
    	return new HashPassword().hashPassword(passwordToHash, salt);
    }
    
    /**
     * Registra un nuevo usuario en la base de datos
     * @param name Nombre del usuario
     * @param email Email del usuario
     * @param password Contraseña del usuario (previamente hasheada)
     */
    public void registrarEnBD(String name, String email, String password) {
    	int codigo = generateValidationCode();
      	uDAO.registro(new Usuario(name, email, hashPassword(password, "abc123"), codigo));
    	new Email().sendEmailBienvenida(email, name, codigo);
    	emailVerificacion = email;
    }
    
    /**
     * Genera un número aleatorio de 4 digitos entre 1000 y 9999
     * @return Número de 4 digitos generado
     */
    public int generateValidationCode() {
		return (int) (1000 + Math.random() * 9000);
    }
    
    /**
     * Valida el código introducido en el Panel Verify
     * @param email Email del usuario a quien verificar el código
     * @return True en caso de que el código sea valido | Falso en caso contrario
     */
    public boolean validarCodigo(String email) {
    	int codigo = Integer.valueOf(txfCod1.getText()+txfCod2.getText()+txfCod3.getText()+txfCod4.getText());
    	return codigo == uDAO.getCode(email);
    }
    
    /**
     * Evita que se puedan introducir caracteres que no sean numericos.
     * De haberlo, lo eliminará y lo remplazará por un texto vacio.
     */
    public void onlyNumbers() {

    	if (!txfCod4.getText().matches("[0-9]+")) {
    		txfCod4.setText(""); 
			txfCod4.requestFocus();
    	}
    	if (!txfCod3.getText().matches("[0-9]+")) {
    		txfCod3.setText(""); 
			txfCod3.requestFocus();
    	}
    	if (!txfCod2.getText().matches("[0-9]+")) {
    		txfCod2.setText(""); 
			txfCod2.requestFocus();
    	}	
    	if (!txfCod1.getText().matches("[0-9]+")) {
    		txfCod1.setText(""); 
			txfCod1.requestFocus();
    	}
    }
    
    /**
     * Comprueba si alguna casilla esta vacia en el Panel Verify
     * @return True en caso de que haya alguna casilla vacia | False en caso contrario
     */
    public boolean checkVaciosCodigo() {
    	return txfCod1.getText().isEmpty() || txfCod2.getText().isEmpty() || txfCod3.getText().isEmpty() ||txfCod4.getText().isEmpty();
    }
    
    /**
     * Comprueba que se cumplan todos los requisitos para realizar la verificación de código
     * @param email Email del usuario a realizar la validación
     * @return True en caso de ser posible realizar la verificación | False en caso contrario
     */
    public boolean checkVerification(String email) {
		onlyNumbers();

    	if(checkVaciosCodigo()) {
    		JOptionPane.showMessageDialog(btnVerificar, "ERR0R! -  Rellena todos los campos");
			return false;
    	}
    	
    	if(!validarCodigo(email)) {
    		txfCod1.setText("");
    		txfCod2.setText("");
    		txfCod3.setText("");
    		txfCod4.setText("");
			JOptionPane.showMessageDialog(btnVerificar, "ERR0R! -  Código invalido, vuelve a intentarlo");
			txfCod1.requestFocus();
			return false;
    	}
    	return true;
    }
    
    /**
     * Comprueba si hay cajas de texto vacias en el Panel Login
     * @return True en caso de haber alguna caja vacia | False en caso contrario
     */
    public boolean checkVaciosLogin() {
    	return txfEmailLogin.getText().isEmpty() || new String (pwPassLogin.getPassword()).isEmpty();
    }
    
    /**
     * Comprueba que se cumplan todos los requisitos para realizar la verificación de código
     * @return True en caso de ser posible | False en caso contrario
     */
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

    /**
     * Genera un nuevo código de verificación y envia un mail al usuario con su nuevo código
     */
	public void generateNewVerificationCode() {
		int codigo = generateValidationCode();
		new Email().sendEmailNewCode(txfEmailLogin.getText(), codigo);
		uDAO.changeCode(txfEmailLogin.getText(), codigo);
		changeVisibility(3);
	}
    
	/**
	 * Comprueba si la cuenta ya esta verificada
	 * @return True en caso de estarlo | False en caso contrario
	 */
    public boolean cuentaVerificada() {
    	return uDAO.checkVerified(txfEmailLogin.getText()) == 1;
    }
    
    /**
     * Comprueba si los datos introducidos en el Login son validos
     * @return True en caso de ser validos | False en caso contrario
     */
    public boolean datosLoginCorrectos() {
    	return uDAO.login(txfEmailLogin.getText(), hashPassword(new String (pwPassLogin.getPassword()), "abc123"));
    }
}
