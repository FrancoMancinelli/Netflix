package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ShowDAO;
import models.Show;

public class NetflixView {

	//Panel Netflix
	private JFrame frmNetflix;
	private JPanel panelNetflix;
	private JPanel panelRojo;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JLabel lblShowTitle;
	private JButton btnFavorito;
	private JPanel panelShows;
	private JLabel lblDescripcion;
	private JLabel lblActores;
	private JLabel lblAñoTipoDuration;
	private JLabel lblDirectores;
	private JLabel imgLetraN;
	private JLabel imgProfilePic;
	private JLabel lblUserName;
	private JButton btnBuscar;
	private Icon imgFav = new ImageIcon("assets/star_fav.png");
	private Icon imgNoFav = new ImageIcon("assets/star_nofav.png");
	private String username;
	
	//Utilidades
	private int pagina = 0;
	private ShowDAO showDAO;
	private ArrayList<Show> arrShows;
	private boolean searchActive = false;
	private String separador = ";";
	private ArrayList<String> arrFavs;
	private static String fileName;

	//Panel Buscar
	private JPanel panelBuscar;
	private JLabel lblInfoBuscador;
	private JPanel panelRojoBusqueda;
	private JTextField txfTextoABuscar;
	private JRadioButton rdbtnTitulo;
	private JRadioButton rdbtnAño;
	private JRadioButton rdbtnDirector;
	private JRadioButton rdbtnUnselecting;
	private ButtonGroup groupBuscar;
	private JLabel lblInfoLabel1;
	private JLabel lblInfoLabel2;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private JButton btnCancelSearch;
	private JLabel imgProfilePic2;
	private JLabel lblUserName2;
	
	//Panel Guardar
	private JPanel panelGuardar;
	private JLabel lblTituloGuardar;
	private JPanel panelRojoGuardar;
	private JLabel imgProfilePic3;
	private JLabel lblUserName3;
	private ButtonGroup groupGuardar;
	private JRadioButton rdbtnPuntoYComa;
	private JRadioButton rdbtnComa;
	private JRadioButton rdbtnTabulador;
	private JTextField txfFileName;
	private JButton btnConfirmFileName;
	private JLabel lblInfoGuardar;
	private JButton btnCrear;
	private JLabel lblInfoCrear;
	private JPanel panelSeparador;
	private JRadioButton rdbtnEmpty;
	
	/**
	 * Crea la aplicación
	 */
	public NetflixView(JFrame login, String username) {
		this.username = username;
		this.showDAO  = new ShowDAO();
		this.arrShows = showDAO.getAll();
		this.arrFavs = new ArrayList<String>();
		initialize();
	}

	/**
	 * Inicializa el Frame
	 */
	private void initialize() {
		setUIComponents();
		setListeners();
	}
	
	/**
	 * Construye los diferentes componentes generales del Frame
	 */
	public void setUIComponents() {
		frmNetflix = new JFrame();
		frmNetflix.getContentPane().setBackground(Color.GREEN);
		frmNetflix.setBounds(100, 100, 644, 456);
		frmNetflix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetflix.getContentPane().setLayout(null);
		

		setPanelNetflix();
		setPanelBuscar();
		setPanelFichero();
		
		changeVisibility(3);
		frmNetflix.setVisible(true);
	}
	
	/**
	 * Construye los componentes del Panel Fichero
	 */
	private void setPanelFichero() {
		panelGuardar = new JPanel();
		panelGuardar.setBackground(Color.BLACK);
		panelGuardar.setBounds(0, 0, 634, 427);
		panelGuardar.setLayout(null);
		frmNetflix.getContentPane().add(panelGuardar);
		
		lblTituloGuardar = new JLabel("<HTML><u>Guardado</u></HTML>");
		lblTituloGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloGuardar.setFont(new Font("Calibri", Font.BOLD, 60));
		lblTituloGuardar.setForeground(Color.WHITE);
		lblTituloGuardar.setBounds(162, 5, 302, 62);
		panelGuardar.add(lblTituloGuardar);
		
		panelRojoGuardar = new JPanel();
		panelRojoGuardar.setBounds(0, 74, 634, 287);
		panelRojoGuardar.setBackground(new Color(216, 31, 38));
		panelGuardar.add(panelRojoGuardar);
		panelRojoGuardar.setLayout(null);
		
		txfFileName = new JTextField();
		txfFileName.setBounds(144, 51, 330, 51);
		panelRojoGuardar.add(txfFileName);
		txfFileName.setColumns(10);
		
		btnConfirmFileName = new JButton("Confirmar");
		btnConfirmFileName.setBounds(240, 123, 134, 34);
		panelRojoGuardar.add(btnConfirmFileName);
		
		lblInfoGuardar = new JLabel("A continuaci\u00F3n indica el nombre del fichero done quieres guardar los favoritos");
		lblInfoGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoGuardar.setBounds(83, 11, 421, 29);
		panelRojoGuardar.add(lblInfoGuardar);
		
		groupGuardar = new ButtonGroup();
		
		panelSeparador = new JPanel();
		panelSeparador.setBounds(0, 168, 634, 119);
		panelRojoGuardar.add(panelSeparador);
		panelSeparador.setLayout(null);
		
		lblInfoCrear = new JLabel("<HTML>Parese que el fichero indicado a\u00FAn no existe. Por lo tanto crearemos uno nuevo. Indica a continuaci\u00F3n el separador que deseas utilizar</HTML>");
		lblInfoCrear.setBounds(91, 11, 421, 29);
		panelSeparador.add(lblInfoCrear);
		
		rdbtnComa = new JRadioButton("Coma");
		rdbtnComa.setBounds(101, 47, 109, 23);
		panelSeparador.add(rdbtnComa);
		groupGuardar.add(rdbtnComa);
		
		rdbtnPuntoYComa = new JRadioButton("Punto y Coma");
		rdbtnPuntoYComa.setBounds(237, 46, 109, 23);
		panelSeparador.add(rdbtnPuntoYComa);
		groupGuardar.add(rdbtnPuntoYComa);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(237, 85, 89, 23);
		panelSeparador.add(btnCrear);
		
		rdbtnTabulador = new JRadioButton("Tabulador");
		rdbtnTabulador.setBounds(396, 46, 109, 23);
		panelSeparador.add(rdbtnTabulador);
		groupGuardar.add(rdbtnTabulador);
		
		rdbtnEmpty = new JRadioButton("");
		rdbtnEmpty.setBounds(632, 123, -4, -4);
		panelSeparador.add(rdbtnEmpty);
		
		groupGuardar.add(rdbtnComa);
		groupGuardar.add(rdbtnPuntoYComa);
		groupGuardar.add(rdbtnTabulador);
		groupGuardar.add(rdbtnEmpty);
		
		imgProfilePic3 = new JLabel("");
		imgProfilePic3.setBounds(487, 11, 57, 52);
		panelGuardar.add(imgProfilePic3);
		imgProfilePic3.setIcon(new ImageIcon("assets/perfil.png"));
		
		lblUserName3 = new JLabel(username);
		lblUserName3.setBounds(538, 27, 86, 18);
		lblUserName3.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblUserName3.setForeground(Color.WHITE);
		panelGuardar.add(lblUserName3);
		
	}

	/**
	 * Construye los componentes del Panel Buscar
	 */
	private void setPanelBuscar() {
		panelBuscar = new JPanel();
		panelBuscar.setBackground(Color.BLACK);
		panelBuscar.setBounds(0, 0, 634, 427);
		panelBuscar.setLayout(null);
		frmNetflix.getContentPane().add(panelBuscar);
		
		lblInfoBuscador = new JLabel("<HTML><u>Buscador</u></HTML>");
		lblInfoBuscador.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoBuscador.setFont(new Font("Calibri", Font.BOLD, 60));
		lblInfoBuscador.setForeground(Color.WHITE);
		lblInfoBuscador.setBounds(162, 5, 302, 62);
		panelBuscar.add(lblInfoBuscador);
		
		panelRojoBusqueda = new JPanel();
		panelRojoBusqueda.setBounds(0, 74, 634, 287);
		panelRojoBusqueda.setBackground(new Color(216, 31, 38));
		panelBuscar.add(panelRojoBusqueda);
		panelRojoBusqueda.setLayout(null);
		
		txfTextoABuscar = new JTextField();
		txfTextoABuscar.setBounds(132, 51, 370, 50);
		panelRojoBusqueda.add(txfTextoABuscar);
		txfTextoABuscar.setColumns(10);
		txfTextoABuscar.setBorder(null);
		
		rdbtnTitulo = new JRadioButton("Titulo");
		rdbtnTitulo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		rdbtnTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTitulo.setBounds(131, 151, 100, 25);
		panelRojoBusqueda.add(rdbtnTitulo);
		
		rdbtnAño = new JRadioButton("A\u00F1o");
		rdbtnAño.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		rdbtnAño.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAño.setBounds(261, 151, 100, 25);
		panelRojoBusqueda.add(rdbtnAño);
		
		rdbtnDirector = new JRadioButton("Director");
		rdbtnDirector.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		rdbtnDirector.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnDirector.setBounds(391, 151, 100, 25);
		panelRojoBusqueda.add(rdbtnDirector);
		
		rdbtnUnselecting = new JRadioButton("");
		rdbtnUnselecting.setBounds(0, 0, 0, 0);
		panelRojoBusqueda.add(rdbtnUnselecting);
		
		groupBuscar = new ButtonGroup();
		groupBuscar.add(rdbtnAño);
		groupBuscar.add(rdbtnDirector);
		groupBuscar.add(rdbtnTitulo);
		groupBuscar.add(rdbtnUnselecting);
		
		lblInfoLabel1 = new JLabel("<HTML>A continuaci\u00F3n escriba la frase o palabra clave para clasificar su busqueda</HTML>");
		lblInfoLabel1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblInfoLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoLabel1.setForeground(Color.WHITE);
		lblInfoLabel1.setBounds(10, 11, 610, 38);
		panelRojoBusqueda.add(lblInfoLabel1);
		
		lblInfoLabel2 = new JLabel("<HTML>Selecciona una clasificaci\u00F3n de busqueda</HTML>");
		lblInfoLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoLabel2.setForeground(Color.WHITE);
		lblInfoLabel2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblInfoLabel2.setBounds(51, 111, 520, 38);
		panelRojoBusqueda.add(lblInfoLabel2);
		
		btnConfirmar = new JButton("Confirmar Busqueda");
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(Color.BLACK);
		btnConfirmar.setBounds(105, 207, 170, 35);
		panelRojoBusqueda.add(btnConfirmar);
		btnConfirmar.setBorder(null);
		
		btnCancelSearch = new JButton("Cancelar Busqueda");
		btnCancelSearch.setForeground(Color.WHITE);
		btnCancelSearch.setBackground(Color.BLACK);
		btnCancelSearch.setBounds(350, 207, 170, 35);
		panelRojoBusqueda.add(btnCancelSearch);
		btnCancelSearch.setBorder(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(35, 26, 100, 23);
		panelBuscar.add(btnVolver);
		btnVolver.setBorder(null);
		
		imgProfilePic2 = new JLabel("");
		imgProfilePic2.setBounds(487, 11, 57, 52);
		panelBuscar.add(imgProfilePic2);
		imgProfilePic2.setIcon(new ImageIcon("assets/perfil.png"));
		
		lblUserName2 = new JLabel(username);
		lblUserName2.setBounds(538, 27, 86, 18);
		lblUserName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblUserName2.setForeground(Color.WHITE);
		panelBuscar.add(lblUserName2);
	}

	/**
	 * Construye los componentes del Panel Netflix
	 */
	private void setPanelNetflix() {
		panelNetflix = new JPanel();
		panelNetflix.setBackground(Color.BLACK);
		panelNetflix.setBounds(0, 0, 634, 427);
		frmNetflix.getContentPane().add(panelNetflix);
		panelNetflix.setLayout(null);
		
		panelRojo = new JPanel();
		panelRojo.setBounds(0, 74, 634, 287);
		panelRojo.setBackground(new Color(216, 31, 38));
		panelRojo.setLayout(null);
		panelNetflix.add(panelRojo);

		panelShows = new JPanel();
		panelShows.setBackground(new Color(24, 24, 24));
		panelShows.setBounds(67, 11, 500, 265);
		panelShows.setLayout(null);
		panelRojo.add(panelShows);
		
		btnAtras = new JButton("<");
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBounds(10, 11, 47, 265);
		panelRojo.add(btnAtras);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.setBackground(Color.WHITE);
		btnSiguiente.setForeground(Color.BLACK);
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBounds(577, 11, 47, 265);
		panelRojo.add(btnSiguiente);
		
		lblShowTitle = new JLabel("<HTML><u>No Title Found</u></HTML>");
		lblShowTitle.setFont(new Font("Verdana", Font.BOLD, 26));
		lblShowTitle.setForeground(Color.WHITE);
		lblShowTitle.setBounds(10, 36, 376, 66);
		panelShows.add(lblShowTitle);
		
		btnFavorito = new JButton(imgNoFav);
		btnFavorito.setBounds(408, 31, 65, 61);
		btnFavorito.setBorder(null);
		panelShows.add(btnFavorito);
		
		lblDescripcion = new JLabel("<HTML><b>Descripción:</b>  ????????</HTML>");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setBounds(10, 100, 484, 55);
		panelShows.add(lblDescripcion);
		
		lblActores = new JLabel("<HTML><b>Actores:</b>  ????????</HTML>");
		lblActores.setFont(new Font("Arial", Font.PLAIN, 11));
		lblActores.setForeground(Color.WHITE);
		lblActores.setBounds(10, 153, 484, 65);
		panelShows.add(lblActores);
		
		lblAñoTipoDuration = new JLabel("???? | ???? | ????");
		lblAñoTipoDuration.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAñoTipoDuration.setForeground(Color.WHITE);
		lblAñoTipoDuration.setBounds(10, 11, 225, 14);
		panelShows.add(lblAñoTipoDuration);
		
		lblDirectores = new JLabel("<HTML><b>Directores:</b>  ????????</HTML>");
		lblDirectores.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDirectores.setForeground(Color.WHITE);
		lblDirectores.setBounds(10, 215, 484, 40);
		panelShows.add(lblDirectores);
		
		imgLetraN = new JLabel("");
		imgLetraN.setBounds(25, 11, 46, 52);
		panelNetflix.add(imgLetraN);
		imgLetraN.setIcon(new ImageIcon("assets/letra_n.png"));
		
		imgProfilePic = new JLabel("");
		imgProfilePic.setBounds(487, 11, 57, 52);
		panelNetflix.add(imgProfilePic);
		imgProfilePic.setIcon(new ImageIcon("assets/perfil.png"));
		
		lblUserName = new JLabel(username);
		lblUserName.setBounds(538, 27, 86, 18);
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblUserName.setForeground(Color.WHITE);
		panelNetflix.add(lblUserName);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 376, 145, 33);
		btnBuscar.setBackground(Color.WHITE);
		panelNetflix.add(btnBuscar);
	}
	
	/**
	 * Configura los diferentes Listeners
	 */
	private void setListeners() {
		btnFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnFavorito.getIcon() == imgNoFav)  {
					btnFavorito.setIcon(imgFav);
					addFavToFile(separador);
				} else {
					btnFavorito.setIcon(imgNoFav);
					removeFavToFile(separador);
				}				
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printAnterior();
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printSiguiente();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeVisibility(2);
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeVisibility(1);
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarBusqueda();
			}
		});
		
		btnCancelSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revertirBusqueda();
			}
		});
		
		btnConfirmFileName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txfFileName.getText().isEmpty()) 
					checkFileExist(txfFileName.getText());
				else 
					JOptionPane.showMessageDialog(btnConfirmFileName, "ERR0R! -  Rellena el campo solicitado");
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!getSelectedSeparador().equals(null)) {
					createFile(getSelectedSeparador());
				}
				JOptionPane.showMessageDialog(btnCrear, "ERR0R! -  Selecciona un separador");

			}
		});
	}
	
	/**
	 * Realiza una busqueda de Shows y posteriormente los muestra por pantalla
	 */
	private void realizarBusqueda() {
		if(busquedaValida()) {
			arrShows = showDAO.getBusqueda(txfTextoABuscar.getText(), getSelectedClasificador());
			pagina = 0;
			printPagina(arrShows);
			JOptionPane.showMessageDialog(btnConfirmar, "La busqueda se ha realizado con éxito. A continuación, \n"
														+ "se mostrará el catálogo según lo solicitado");
			changeVisibility(1);
			txfTextoABuscar.setText("");
			rdbtnUnselecting.doClick();
			searchActive = true;
		}
	}
	
	/**
	 * Revierte cualquier busqueda hecha y posteriormente muestra todos los shows
	 */
	private void revertirBusqueda() {
		arrShows = showDAO.getAll();
		pagina = 0;
		printPagina(arrShows);
		JOptionPane.showMessageDialog(btnConfirmar, "La busqueda se ha revertido con éxito. A continuación, \n"
													+ "se mostrará el catálogo completo nuevamente");
		changeVisibility(1);
		txfTextoABuscar.setText("");
		rdbtnUnselecting.doClick();
		searchActive = false;
	}
	
	/**
	 * Comprueba cual es el Radio Button seleccionado de los Clasificadores de busqueda
	 * @return El string correspondiente de cada RD | Null en caso de no seleccionar ninguno
	 */
	private String getSelectedClasificador() {
		if(rdbtnTitulo.isSelected()) 
			return "title";
		if(rdbtnAño.isSelected()) 
			return "release_year";
		if(rdbtnDirector.isSelected()) 
			return "director";
		return null;
	}
	
	/**
	 * Comprueba si la caja de texto del buscador esta vacia o no
	 * @return True en caso de estar vacia | False en caso contrario
	 */
	private boolean buscadorVacio() {
		return txfTextoABuscar.getText().isEmpty();
	}
	
	/**
	 * Comprueba si se cumplen todos los requisitos para realizar una busqueda
	 * @return True en caso de ser posible | False en caso contrario
	 */
	private boolean busquedaValida() {
		if(buscadorVacio()) {
			JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  Rellena todos los campos");
			return false;
		}
		
		if(getSelectedClasificador().equals(null)) {
			JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  Selecciona un clasificador");
			return false;
		}
		return true;
	}
	
	/**
	 * Imprime la pagina siguiente de manera circular
	 */
	private void printSiguiente() {
		pagina++;
		if(pagina == arrShows.size()) {
			pagina = 0;
		}
		printPagina(arrShows);
	}
	
	/**
	 * Imprime la pagina anterior de manera circular
	 */
	private void printAnterior() {
		pagina--;
		if(pagina < 0) {
			pagina = arrShows.size() - 1;
		}
		printPagina(arrShows);
	}
	
	/**
	 * Imprime la pagina actual o imprime una pagina vacia según corresponda
	 * @param arrShow Array de Shows para comprobar si hay shows que imprimir o no
	 */
	private void printPagina(ArrayList<Show> arrShow) {
		if(arrShow.isEmpty()) 
			printVacio();
		else 
			printShow(arrShow);
	}
	
	/**
	 * Imprime el panel vacio
	 */
	private void printVacio() {
		lblShowTitle.setText("<HTML><u>No Title Found</u></HTML>");
		lblDescripcion.setText("<HTML><b>Descripción:</b>  ????????</HTML>");
		lblActores.setText("<HTML><b>Actores:</b>  ????????</HTML>");
		lblAñoTipoDuration.setText("???? | ???? | ????");
		lblDirectores.setText("<HTML><b>Directores:</b>  ????????</HTML>");
		btnSiguiente.setEnabled(false);
		btnAtras.setEnabled(false);
		btnFavorito.setVisible(false);
	}
	
	/**
	 * Imprime el panel con el show correspondiente a la pagina actual
	 * @param arrShow Array de Shows para saber cual imprimir
	 */
	private void printShow(ArrayList<Show> arrShow) {
		lblShowTitle.setText("<HTML><u>"+arrShow.get(pagina).getTitle()+"</u></HTML>");
		lblDescripcion.setText("<HTML><b>Descripción:</b>  "+arrShow.get(pagina).getDescription()+"</HTML>");
		lblActores.setText("<HTML><b>Actores:</b>  "+arrShow.get(pagina).getCast()+"</HTML>");
		lblAñoTipoDuration.setText(arrShow.get(pagina).getRelease_year()+" | "+arrShow.get(pagina).getType()+" | "+arrShow.get(pagina).getDuration());
		lblDirectores.setText("<HTML><b>Directores:</b>  "+arrShow.get(pagina).getDirector()+"</HTML>");
		btnSiguiente.setEnabled(true);
		btnAtras.setEnabled(true);
		btnFavorito.setVisible(true);
		
		chargeFavShows(arrShows.get(pagina));
		
	}
	
	/**
	 * Cambia la visibilidad de los paneles
	 * @param modo Número para identificar que panel mostrar
	 */
	private void changeVisibility (int modo) {
		switch (modo) {
			case 1:
				panelNetflix.setVisible(true);
				panelBuscar.setVisible(false);
				panelGuardar.setVisible(false);
				panelSeparador.setVisible(false);
				printPagina(arrShows);
				break;
			case 2:
				panelNetflix.setVisible(false);
				panelBuscar.setVisible(true);
				btnCancelSearch.setEnabled(searchActive);
				break;
			case 3:
				panelNetflix.setVisible(false);
				panelBuscar.setVisible(false);
				panelGuardar.setVisible(true);
				panelSeparador.setVisible(false);
				btnConfirmFileName.setEnabled(true);
				txfFileName.setEnabled(true);
				break;
			case 4:
				panelSeparador.setVisible(true);
				btnConfirmFileName.setEnabled(false);
				txfFileName.setEnabled(false);
				break;
		}
	}
	
	/**
	 * Comprueba si un fichero ya existe y según ello mostrará un panel u otro
	 * @param name Nombre del fichero a comprobar
	 */
	private void checkFileExist(String name) {
		 fileName = name;

		if(!new File(name).exists()) 
			changeVisibility(4);
		else 
			changeVisibility(1);
	}
	
	/**
	 * Crea un fichero nuevo y asigna cual sera el separador
	 * @param separador Separador a utilizar
	 */
	private void createFile(String separador) {
			try {
				new File(fileName).createNewFile();
				this.separador = separador;
	        	changeVisibility(1);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
	/**
	 * Comprueba cual es el Radio Button seleccionado de los Separadores
	 * @return El string correspondiente de cada RD | Null en caso de no seleccionar ninguno
	 */
	private String getSelectedSeparador() {
		if(rdbtnComa.isSelected()) 
			return this.separador = ",";
		if(rdbtnPuntoYComa.isSelected()) 
			return this.separador = ";";
		if(rdbtnTabulador.isSelected()) 
			return this.separador = "\t";
		return null;
	}
	
	/**
	 * Añade un favorito al fichero utilizando el separador seleccionado
	 * @param separador El separador a utilizar
	 */
	private void addFavToFile(String separador) {
		if(!favoritoExist(arrShows.get(pagina).getShowID())) {
			try {
				FileWriter fw = new FileWriter(new File(fileName), true);
				fw.write(arrShows.get(pagina).getShowID()+separador);
				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(btnFavorito, "ERR0R! -  Este show ya está en favoritos");
		}
	}
	
	/**
	 * Remueve un favorito del fichero
	 * @param separador Separador a utilizar
	 */
	private void removeFavToFile(String separador) {
		try {
			Scanner sc = new Scanner(new File(fileName), "UTF-8");
			arrFavs.clear();
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				var trozos = s.split(",|;|\t");
				for (String t : trozos) {
					
					if (!arrShows.get(pagina).getShowID().equals(t)) {
						arrFavs.add(t);
					}
				}
			}
			addFavToFile(arrFavs, separador);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Añade un array de favoritos al fichero
	 * @param arr Array con las IDs de los Shows
	 * @param separador Separador a utilizar
	 */
	private void addFavToFile(ArrayList<String> arr, String separador) {
			try {
				FileWriter fw = new FileWriter(new File(fileName), false);
				for (String s : arr) {
					fw.write(s+separador);
				}
				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Comprueba si existe el favorito señalado
	 * @param showID El id del show a comprobar
	 * @return True en caso de existir | False en caso contrario
	 */
	private boolean favoritoExist(String showID) {
		try {
			Scanner sc = new Scanner(new File(fileName), "UTF-8");
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				var trozos = s.split(",|;|\t");
				for (String t : trozos) {
					if (showID.equals(t)) {
						sc.close();
						return true;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
		
	/**
	 * Carga a los Shows el estado amarillo del botón favorito en caso de que existan en el fichero
	 * @param s Show al cual asignarle el estado
	 */
	private void chargeFavShows(Show s) {
		if(favoritoExist(s.getShowID())) 
			btnFavorito.setIcon(imgFav);
		else
			btnFavorito.setIcon(imgNoFav);
	}
}