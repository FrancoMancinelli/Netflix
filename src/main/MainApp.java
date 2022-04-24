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

import dao.ShowDAO;
import models.Show;
import ui.LoginView;
import ui.NetflixView;

public class MainApp {

	public static void main(String[] args) {


		new LoginView();
		ejecutar_sonido("assets/tutumsound.wav");
//		insertarFicheroBD();

	}

	public static void insertarFicheroBD() {
		ShowDAO bd = new ShowDAO();
		String filename = "netflix_titles.csv";
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
				
				for (int i = 0; i < trozos.length; i++) {
					trozos[i] = trozos[i].replace("\"", "");
					trozos[i] = trozos[i].replace("'", "´");
				}
				
				shows.add(new Show(trozos[0],trozos[1],trozos[2],trozos[3],trozos[4],trozos[5],
				trozos[6],trozos[7],trozos[8],trozos[9],trozos[10],trozos[11], false));
				
				bd.insert(new Show(trozos[0],trozos[1],trozos[2],trozos[3],trozos[4],trozos[5],
				trozos[6],trozos[7],trozos[8],trozos[9],trozos[10],trozos[11], false));
				fila++;
				System.out.println(shows.get(fila-1));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Algo salio mal");
			e.printStackTrace();
		}
		sc.close();		
		System.out.println("\n"+shows.size());		
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

