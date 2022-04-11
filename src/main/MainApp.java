package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import models.Show;
import ui.LoginView;

public class MainApp {

	public static void main(String[] args) {

		new LoginView();
		ejecutar_sonido("D:\\DAM1\\PROG\\Netflix\\assets\\tutumsound.wav");

//		LeerFichero();

//		SendEmail("manchiwolf312@gmail.com");
	}

	public static void LeerFichero() {
		String filename = "D:\\DAM1\\PROG\\Netflix\\assets\\netflix_titles.csv";
		Scanner sc = null;
		ArrayList<Show> shows = new ArrayList<Show>();
		boolean isString = false;
		String trozoString = "";
		String lineaCompleta = "";
		int count = 0;
		int fila = 0;
		try {
			sc = new Scanner(new File(filename), "UTF-8");
			sc.nextLine();//cabecera
			while (sc.hasNextLine()) {
				count = 0;
				String s = sc.nextLine();
				//var trozos = s.split(",");
				//Omite las cadenas internas ""
				var trozos = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				for(String trozo : trozos) {
					if(trozo.startsWith("\"")) {
						trozo = trozo.substring(1, trozo.length());
						trozo = trozo.replaceAll("\"\"","'");
						isString = true;
					}
					if(trozo.endsWith("\"") ) {
						isString = false;
						trozo = trozo.replaceAll("\"\"","'");
						trozoString += trozo;
						trozo = trozoString;
						trozo = trozo.substring(0, trozo.length()-1);
						trozoString = "";
					}
					if(!isString) {
						count++;
						lineaCompleta = trozo;
					}
					else
						trozoString += trozo + ",";		
				}
				shows.add(new Show(trozos[0],trozos[1],trozos[2],trozos[3],trozos[4],trozos[5],
				trozos[6],trozos[7],trozos[8],trozos[9],trozos[10],trozos[11]));
				fila++;
				System.out.println(shows.get(fila-1));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Algo salio mal");
			e.printStackTrace();
		}
		sc.close();		
		System.out.println("\n"+shows.size());		
		System.out.println(shows.get(4361));
		System.out.println(shows.get(7549));
	}
	
	public static void SendEmail(String receptor) {
		final String username = "netflixpicassodam";
        final String password = "#P4ssw0rd";

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
                    InternetAddress.parse(receptor)
            );
            message.setSubject("Welcome to Netflix");
            message.setText("Dear Mail Crawler," + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	
	private static void ejecutar_sonido(String url) {
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

