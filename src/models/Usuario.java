package models;

public class Usuario {

	// ~~~ ATRIBUTOS
	protected int id;
	protected String name;
	protected String email;
	protected String password;
	protected int codigo_verificacion;
	protected boolean validado;
	
	// ~~~ CONSTRUCTOR
	/**
	 * Construye un usuario
	 * @param id ID del usuario
	 * @param name Nombre del usuario
	 * @param email Email del usuario
	 * @param password Password del usuario
	 * @param codigo_verificacion Codigo de verificación enviado al email
	 */
	public Usuario(String name, String email, String password, int codigo_verificacion) {
		super();
		this.id = 0;
		this.name = name;
		this.email = email;
		this.password = password;
		this.codigo_verificacion = codigo_verificacion;
		this.validado = false;
	}
	
	public Usuario(String email, int codigo_verificacion) {
		super();
		this.email = email;
		this.codigo_verificacion = codigo_verificacion;
	}

	// ~~~ GETTERS & SETTERS
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getCodigo_verificacion() {
		return codigo_verificacion;
	}


	public void setCodigo_verificacion(int codigo_verificacion) {
		this.codigo_verificacion = codigo_verificacion;
	}


	public boolean isValidado() {
		return validado;
	}


	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	
	
}
