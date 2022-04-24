package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
import utils.Email;
import utils.JTextFieldLimit;

public class ForgotPssView {

	private JFrame frmFgtPw;
	private JPanel basePanel;
	private JLabel imgFondo;

	private JPanel panelEmail;
	private JTextField txfEmail;
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
	private UsuarioDAO uDAO = new UsuarioDAO();
	


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
				
		frmFgtPw = new JFrame();
		frmFgtPw.setBounds(100, 100, 650, 565);
		frmFgtPw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFgtPw.getContentPane().setLayout(null);

		basePanel = new JPanel();
		basePanel.setBounds(0, 0, 634, 526);
		basePanel.setForeground(new Color(0,0,0,0));
		frmFgtPw.getContentPane().add(basePanel);
		basePanel.setLayout(null);
		
		setUIPanelEmail();
		setUIPanelVerify();
		setUIPanelPassword();
	
		imgFondo = new JLabel("");
		imgFondo.setBounds(0, -28, 767, 619);
		basePanel.add(imgFondo);
		imgFondo.setIcon(new ImageIcon("assets/fondo.PNG"));
		
		frmFgtPw.setVisible(true);
		changeVisibility(1);
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
		
		txfEmail = new JTextField();
		txfEmail.setForeground(new Color(128, 140, 140));
		txfEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txfEmail.setBackground(new Color(51,51,51));
		txfEmail.setBounds(35, 210, 228, 45);
		panelEmail.add(txfEmail);
		txfEmail.setColumns(10);
		txfEmail.setBorder(null);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnContinuar.setBackground(new Color(229, 9, 20));
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setBounds(35, 293, 228, 45);
		panelEmail.add(btnContinuar);
		btnContinuar.setBorder(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setIcon(new ImageIcon("assets/nada.PNG"));
		btnVolver.setBackground(new Color(0,0,0));
		btnVolver.setHorizontalAlignment(SwingConstants.RIGHT);
		btnVolver.setBorder(null);
		btnVolver.setBounds(241, 11, 50, 23);
		panelEmail.add(btnVolver);
		
		lblEmailInfo = new JLabel("<HTML>Para recuperar su contrase\u00F1a, es necesario que introduzca a continuaci\u00F3n, el email con el que se ha registrado</HTML>");
		lblEmailInfo.setForeground(Color.WHITE);
		lblEmailInfo.setBounds(35, 90, 228, 67);
		panelEmail.add(lblEmailInfo);
		
		lblRefEmail = new JLabel("Email:");
		lblRefEmail.setVerticalAlignment(SwingConstants.TOP);
		lblRefEmail.setFont(new Font("Corbel", Font.BOLD, 14));
		lblRefEmail.setForeground(Color.WHITE);
		lblRefEmail.setBounds(35, 190, 56, 14);
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
		txfCod1.setBounds(45, 210, 45, 45);
		txfCod1.setBorder(null);
		txfCod1.setColumns(10);
		txfCod1.setDocument(new JTextFieldLimit(1));
		panelVerify.add(txfCod1);

		txfCod2 = new JTextField();
		txfCod2.setHorizontalAlignment(SwingConstants.CENTER);
		txfCod2.setFont(new Font("Verdana", Font.BOLD, 18));
		txfCod2.setColumns(10);
		txfCod2.setBounds(100, 210, 45, 45);
		txfCod2.setBorder(null);
		txfCod2.setDocument(new JTextFieldLimit(1));
		panelVerify.add(txfCod2);
		
		txfCod3 = new JTextField();
		txfCod3.setHorizontalAlignment(SwingConstants.CENTER);
		txfCod3.setFont(new Font("Verdana", Font.BOLD, 18));
		txfCod3.setColumns(10);
		txfCod3.setBounds(155, 210, 45, 45);
		txfCod3.setBorder(null);
		txfCod3.setDocument(new JTextFieldLimit(1));
		panelVerify.add(txfCod3);
		
		txfCod4 = new JTextField();
		txfCod4.setHorizontalAlignment(SwingConstants.CENTER);
		txfCod4.setFont(new Font("Verdana", Font.BOLD, 18));
		txfCod4.setColumns(10);
		txfCod4.setBounds(210, 210, 45, 45);
		txfCod4.setBorder(null);
		txfCod4.setDocument(new JTextFieldLimit(1));
		panelVerify.add(txfCod4);
		
		lblCodInfo2 = new JLabel("<HTML>Hemos enviado un <U>NUEVO</U> c\u00F3digo de verificaci\u00F3n a tu email."
								+" Revisa tu bandeja de entrada y la carpeta de spam.</HTML>");
		lblCodInfo2.setForeground(Color.WHITE);
		lblCodInfo2.setBounds(35, 110, 245, 60);
		panelVerify.add(lblCodInfo2);
		
		lblCodInfo1 = new JLabel("<HTML>Para continuar es necesario comprobar que tienes acceso al email indicado.</HTML>");
		lblCodInfo1.setForeground(Color.WHITE);
		lblCodInfo1.setBounds(35, 75, 220, 33);
		panelVerify.add(lblCodInfo1);
		
		lblCodInfo3 = new JLabel("Inserta el c\u00F3digo aqu\u00ED:");
		lblCodInfo3.setForeground(Color.WHITE);
		lblCodInfo3.setBounds(35, 185, 220, 22);
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
		btnConfirmar.setBounds(35, 304, 228, 45);
		panelPassword.add(btnConfirmar);
		btnConfirmar.setBorder(null);
		
		lblNuevaPwInfo = new JLabel("<HTML>A continuación indique su nueva contraseña.</HTML>");
		lblNuevaPwInfo.setForeground(Color.WHITE);
		lblNuevaPwInfo.setBounds(35, 80, 228, 45);
		panelPassword.add(lblNuevaPwInfo);
		
		lblRefPw1 = new JLabel("Contrase\u00F1a:");
		lblRefPw1.setVerticalAlignment(SwingConstants.TOP);
		lblRefPw1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRefPw1.setForeground(Color.WHITE);
		lblRefPw1.setBounds(35, 135, 91, 14);
		panelPassword.add(lblRefPw1);
		
		pwPassword1 = new JPasswordField();
		pwPassword1.setForeground(new Color(128, 140, 140));
		pwPassword1.setBackground(new Color(51,51,51));
		pwPassword1.setBounds(35, 155, 228, 45);
		pwPassword1.setBorder(null);
		panelPassword.add(pwPassword1);
		
		pwPassword2 = new JPasswordField();
		pwPassword2.setForeground(new Color(128, 140, 140));
		pwPassword2.setBackground(new Color(51,51,51));
		pwPassword2.setBounds(35, 235, 228, 45);
		pwPassword2.setBorder(null);
		panelPassword.add(pwPassword2);
		
		lblRefPw2 = new JLabel("Repite Contrase\u00F1a:");
		lblRefPw2.setVerticalAlignment(SwingConstants.TOP);
		lblRefPw2.setForeground(Color.WHITE);
		lblRefPw2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRefPw2.setBounds(35, 215, 142, 14);
		panelPassword.add(lblRefPw2);
	}

	private void setListeners() {
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFgtPw.dispose();
				initialView.setVisible(true);
			}
		});
		
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidEmail(txfEmail.getText())) 
					generateNewVerificationCode();
			}
		});
		
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkVerification(txfEmail.getText()))
					changeVisibility(3);
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmChangePassword();
			}
		});
	}
	
	public void changeVisibility (int modo) {
		switch (modo) {
			case 1:
				panelEmail.setVisible(true);
				panelPassword.setVisible(false);
				panelVerify.setVisible(false);
				break;
			case 2:
				panelEmail.setVisible(false);
				panelPassword.setVisible(false);
				panelVerify.setVisible(true);
				break;
			case 3:
				panelEmail.setVisible(false);
				panelPassword.setVisible(true);
				panelVerify.setVisible(false);
				break;
			default:
				panelEmail.setVisible(true);
				panelPassword.setVisible(false);
				panelVerify.setVisible(false);
		}
	}

	private boolean emailVacio() {
		return txfEmail.getText().isEmpty();
	}
	
	private boolean emailExist(String email) {
		return !uDAO.emailExist(email);
	}
	
	private boolean checkValidEmail(String email) {
		if(emailVacio()) {
			JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  Rellena todos los campos");
			return false;
		}
		
		if(emailExist(email)) {
			JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  El email indicado no se encuentra registrado");
			return false;
		}
		
		return true;
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
		deleteLetters();
		
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
			return false;
    	}
    	return true;
    }
    
    public void generateNewVerificationCode() {
		int codigo = generateValidationCode();
		Email e = new Email();
		e.sendEmailForgotPw(txfEmail.getText(), codigo);
		uDAO.changeCode(txfEmail.getText(), codigo);
		changeVisibility(2);
	}
    
    /**
     * Genera un número aleatorio de 4 digitos entre 1000 y 9999
     * @return Número de 4 digitos generado
     */
    public int generateValidationCode() {
		return (int) (1000 + Math.random() * 9000);
    }
    
    private boolean checkEmptyPasswords() {
    	if(new String (pwPassword1.getPassword()).isEmpty() ||
    	   new String (pwPassword2.getPassword()).isEmpty())
    		return true;
    	return false;
    }
    
    private boolean samePasswords() {
    	return new String (pwPassword1.getPassword()).equals(new String (pwPassword2.getPassword()));
    }

    private boolean validateChange() {
    	if(checkEmptyPasswords()) {
			JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  Rellena todos los campos");
    		return false;
    	}
    	
    	if(!samePasswords()) {
			JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  Las contraseñas no coinciden");
    		return false;
    	}
    	return true;
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
    
    private void confirmChangePassword() {
    	if(validateChange()) {
    		String hashPass = hashPassword(new String(pwPassword1.getPassword()), "abc123");
    		uDAO.changePassword(txfEmail.getText(), hashPass);
    		initialView.setVisible(true);
    		frmFgtPw.dispose();
    	}		
    }
}

