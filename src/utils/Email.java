package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	final String username = "netflixpicassodam";
    final String password = "#P4ssw0rd";
	
    /**
     * Envia un email de Bienvenida junto a su c�digo de verificaci�n
     * @param email Email al cual enviar el correo
     * @param name Nombre del usuario
     * @param codigo El c�digo de verificaci�n
     */
	public void sendEmailBienvenida(String email, String name, int codigo) {

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "*");
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("netflixpicassodam@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("C�digo de Verificaci�n - Netflix");
            message.setText("Bienvenid@ a Netflix "+name
            				+"\n\nA continuaci�n encontraras tu nuevo c�digo de verificaci�n. Introducelo en la pagina de Netflix para continuar"
            				+"\n\nC�digo: "+codigo);

            Transport.send(message);

            System.out.println("Codigo de verificaci�n enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Envia un correo con el nuevo c�digo de verificaci�n
	 * @param email Email al cual enviar el correo
	 * @param codigo Nuevo c�digo de verificaci�n
	 */
	public void sendEmailNewCode (String email, int codigo) {

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "*");
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("netflixpicassodam@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("C�digo de Verificaci�n - Netflix");
            message.setText("Parece que tu cuenta a�n no ha sido verificada."
            				+"\n\nA continuaci�n encontraras tu nuevo c�digo de verificaci�n. Introducelo en la pagina de Netflix para continuar"
            				+"\n\nC�digo: "+codigo);

            Transport.send(message);

            System.out.println("Codigo de verificaci�n enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Envia un correo por haber olvidado tu contrase�a
	 * @param email Email al cual enviar el correo
	 * @param codigo C�digo de validaci�n para confirmar el cambio de contrase�a
	 */
	public void sendEmailForgotPw (String email, int codigo) {

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "*");
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("netflixpicassodam@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("C�digo de Verificaci�n - Netflix");
            message.setText("Alerta por intento de cambio de contrase�a, si no has sido tu ignora este correo."
            				+"\n\nPara cambiar tu contrase�a es necesario introduzcas el c�digo de verificaci�n"
            				+ "\nA continuaci�n encontraras tu nuevo c�digo de verificaci�n. Introducelo en la pagina de Netflix para continuar"
            				+"\n\nC�digo: "+codigo);

            Transport.send(message);

            System.out.println("Codigo de verificaci�n enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
}
