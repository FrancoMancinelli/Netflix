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
     * Envia un email de Bienvenida junto a su código de verificación
     * @param email Email al cual enviar el correo
     * @param name Nombre del usuario
     * @param codigo El código de verificación
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
            message.setSubject("Código de Verificación - Netflix");
            message.setText("Bienvenid@ a Netflix "+name
            				+"\n\nA continuación encontraras tu nuevo código de verificación. Introducelo en la pagina de Netflix para continuar"
            				+"\n\nCódigo: "+codigo);

            Transport.send(message);

            System.out.println("Codigo de verificación enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Envia un correo con el nuevo código de verificación
	 * @param email Email al cual enviar el correo
	 * @param codigo Nuevo código de verificación
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
            message.setSubject("Código de Verificación - Netflix");
            message.setText("Parece que tu cuenta aún no ha sido verificada."
            				+"\n\nA continuación encontraras tu nuevo código de verificación. Introducelo en la pagina de Netflix para continuar"
            				+"\n\nCódigo: "+codigo);

            Transport.send(message);

            System.out.println("Codigo de verificación enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Envia un correo por haber olvidado tu contraseña
	 * @param email Email al cual enviar el correo
	 * @param codigo Código de validación para confirmar el cambio de contraseña
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
            message.setSubject("Código de Verificación - Netflix");
            message.setText("Alerta por intento de cambio de contraseña, si no has sido tu ignora este correo."
            				+"\n\nPara cambiar tu contraseña es necesario introduzcas el código de verificación"
            				+ "\nA continuación encontraras tu nuevo código de verificación. Introducelo en la pagina de Netflix para continuar"
            				+"\n\nCódigo: "+codigo);

            Transport.send(message);

            System.out.println("Codigo de verificación enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
}
