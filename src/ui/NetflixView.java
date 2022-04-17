package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ShowDAO;
import models.Show;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class NetflixView {

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
	private JButton btnCargarFav;
	private JButton btnGuardarFav;
	private int favMode = 0;
	private Icon imgFav = new ImageIcon("D:/DAM1/PROG/Netflix/assets/star_fav.png");
	private Icon imgNoFav = new ImageIcon("D:/DAM1/PROG/Netflix/assets/star_nofav.png");
	private String username;
	
	private int pagina = 0;
	private ShowDAO showDAO;
	private ArrayList<Show> arrShows;
	private int modo = 1;
	private boolean searchActive = false;

	
	private JPanel panelBuscar;
	private JLabel lblInfoBuscador;
	private JPanel panelRojoBusqueda;
	private JTextField txfTextoABuscar;
	private JRadioButton rdbtnTitulo;
	private JRadioButton rdbtnAño;
	private JRadioButton rdbtnDirector;
	private JRadioButton rdbtnUnselecting;
	private ButtonGroup group;
	private JLabel lblInfoLabel1;
	private JLabel lblInfoLabel2;
	private JButton btnVolver;
	private JButton btnConfirmar;
	private JButton btnCancelSearch;
	private JLabel imgProfilePic2;
	private JLabel lblUserName2;



	/**
	 * Create the application.
	 */
	public NetflixView(JFrame login, String username) {
		this.username = username;
		this.showDAO  = new ShowDAO();
		this.arrShows = showDAO.getAll();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setUIComponents();
		setListeners();
		printPagina(arrShows);
	}

	public void setUIComponents() {
		frmNetflix = new JFrame();
		frmNetflix.getContentPane().setBackground(Color.GREEN);
		frmNetflix.setBounds(100, 100, 644, 456);
		frmNetflix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetflix.getContentPane().setLayout(null);
		

		setPanelNetflix();
		setPanelBuscar();
		
		
		changeVisibility(1);
		frmNetflix.setVisible(true);
	}

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
		
		group = new ButtonGroup();
		group.add(rdbtnAño);
		group.add(rdbtnDirector);
		group.add(rdbtnTitulo);
		group.add(rdbtnUnselecting);
		
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
		imgProfilePic2.setIcon(new ImageIcon("D:/DAM1/PROG/Netflix/assets/perfil.png"));
		
		lblUserName2 = new JLabel(username);
		lblUserName2.setBounds(538, 27, 86, 18);
		lblUserName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblUserName2.setForeground(Color.WHITE);
		panelBuscar.add(lblUserName2);
	}

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
		imgLetraN.setIcon(new ImageIcon("D:/DAM1/PROG/Netflix/assets/letra_n.png"));
		
		imgProfilePic = new JLabel("");
		imgProfilePic.setBounds(487, 11, 57, 52);
		panelNetflix.add(imgProfilePic);
		imgProfilePic.setIcon(new ImageIcon("D:/DAM1/PROG/Netflix/assets/perfil.png"));
		
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
		
		btnCargarFav = new JButton("Cargar");
		btnCargarFav.setBounds(324, 376, 145, 33);
		btnCargarFav.setBackground(Color.WHITE);
		panelNetflix.add(btnCargarFav);
		
		btnGuardarFav = new JButton("Guardar");
		btnGuardarFav.setBounds(479, 376, 145, 33);
		btnGuardarFav.setBackground(Color.WHITE);
		panelNetflix.add(btnGuardarFav);
	}
	
	private void setListeners() {
		btnFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(favMode == 0) {
					favMode = 1;
					btnFavorito.setIcon(imgFav);
				} else {
					favMode = 0;
					btnFavorito.setIcon(imgNoFav);
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
	}
	
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
	
	private String getSelectedClasificador() {
		if(rdbtnTitulo.isSelected()) 
			return "title";
		if(rdbtnAño.isSelected()) 
			return "release_year";
		if(rdbtnDirector.isSelected()) 
			return "director";
		return null;
	}
	
	private boolean buscadorVacio() {
		if(txfTextoABuscar.getText().isEmpty()) 
			return true;
		return false;
	}
	
	private boolean busquedaValida() {
		if(buscadorVacio()) {
			JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  Rellena todos los campos");
			return false;
		}
		
		if(getSelectedClasificador() == null) {
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
	
	private void printPagina(ArrayList<Show> arrShow) {
		if(arrShow.isEmpty()) 
			printVacio();
		else 
			printShow(arrShow);
	}
	
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
	
	private void printShow(ArrayList<Show> arrShow) {
		lblShowTitle.setText("<HTML><u>"+arrShow.get(pagina).getTitle()+"</u></HTML>");
		lblDescripcion.setText("<HTML><b>Descripción:</b>  "+arrShow.get(pagina).getDescription()+"</HTML>");
		lblActores.setText("<HTML><b>Actores:</b>  "+arrShow.get(pagina).getCast()+"</HTML>");
		lblAñoTipoDuration.setText(arrShow.get(pagina).getRelease_year()+" | "+arrShow.get(pagina).getType()+" | "+arrShow.get(pagina).getDuration());
		lblDirectores.setText("<HTML><b>Directores:</b>  "+arrShow.get(pagina).getDirector()+"</HTML>");
		btnSiguiente.setEnabled(true);
		btnAtras.setEnabled(true);
		btnFavorito.setVisible(true);
	}
	
	private void changeVisibility (int modo) {
		switch (modo) {
			case 1:
				panelNetflix.setVisible(true);
				panelBuscar.setVisible(false);
				break;
			case 2:
				panelNetflix.setVisible(false);
				panelBuscar.setVisible(true);
				btnCancelSearch.setEnabled(searchActive);
				break;
			default:
				panelNetflix.setVisible(true);
				panelBuscar.setVisible(false);
		}
	}
}
