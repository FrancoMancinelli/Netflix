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
		ejecutarSonido("assets/tutumsound.wav"); //Sound Effects

	}

	/**
	 * Ejecuta un efecto de sonido
	 * @param url Url donde se encuentra ubicado el efecto de sonido
	 */
	private static void ejecutarSonido(String url) {
		try {
			Clip sonido = AudioSystem.getClip();
			
			File f = new File(url);
			sonido.open(AudioSystem.getAudioInputStream(f));
			sonido.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}	
}

