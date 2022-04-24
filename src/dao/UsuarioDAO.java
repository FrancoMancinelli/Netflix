package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Usuario;

public class UsuarioDAO extends AbstractDAO {
	
	/**
	 * Coomprueba si existe un usuario en la base de datos
	 * según email y contraseña hash
	 * @param email El email a buscar
	 * @param hashPass La contraseña hash
	 * @return True en caso de encontrar al usuario | False en caso contrario
	 */
	public boolean login(String email, String hashPass) {
		final String QUERY = "SELECT email, password FROM usuarios "+
							"WHERE email = '" + email + "' AND " +
							"password = '" + hashPass + "'";
		try { 
	         ResultSet rs = stmt.executeQuery(QUERY);		      
	         return rs.next();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
			return false;
	}
	
	
	/**
	 * Inserta un usuario en la base de datos
	 * @param usuario Usuario a insertar
	 */
	public void registro(Usuario usuario) {
		final String INSERT = "INSERT INTO netflix.usuarios (name, email, password, codigo)"
							+ " VALUES ('"+ usuario.getName() 
							+ "', '"+ usuario.getEmail() 
							+ "', '" + usuario.getPassword() 
							+ "', '" + usuario.getCodigo_verificacion() 
							+"');";
		try { 
		 stmt.executeUpdate(INSERT);		      
		} catch (SQLException e) {
		 e.printStackTrace();
		} 
	}
	
	/**
	 * Cambia el código de verificación a un usuario
	 * @param email Email del usuario
	 * @param code Nuevo código
	 */
	public void changeCode(String email, int code) {
		final String UPDATE = "UPDATE netflix.usuarios\r\n"
				+ "SET\r\n"
				+ "codigo = '"+code+"'\r\n"
				+ "WHERE email = '"+email+"';";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Busca el código de verificación de un usuario
	 * @param email Email del usuario
	 * @return El código de verificación actual del usuario
	 */
	public int getCode(String email) {
		final String QUERY = "SELECT codigo FROM usuarios WHERE email = '"+email+"'";

		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		        	 //Display Values
		           return rs.getInt("codigo");
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		return -1; 
	}
	
	/**
	 * Cambia el estado de verificación de la cuenta de un usuario a 1
	 * @param email Email del usuario
	 */
	public void validateCode(String email) {
		final String UPDATE = "UPDATE netflix.usuarios\r\n"
				+ "SET\r\n"
				+ "verificado = '1'\r\n"
				+ "WHERE email = '"+email+"';";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Comprueba el estado de verificación de un usuario
	 * @param email
	 * @return 1 En caso de estar verificado | 0 En caso de no estarlo
	 */
	public int checkVerified(String email) {
		final String QUERY = "SELECT verificado FROM usuarios WHERE email = '"+email+"'";

		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		        	 //Display Values
		           return rs.getInt("verificado");
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		return 0; 
	}
	
	/**
	 * Busca el nombre de un usuario en la base de datos
	 * @param email Email del usuario
	 * @return El nombre del usuario si es que se encuentra | Null en caso contrario
	 */
	public String getUsername(String email) {
		final String QUERY = "SELECT name FROM netflix.usuarios WHERE email = '"+email+"'";

		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		        	 //Display Values
		           return rs.getString("name");
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		return null; 
	}
	
	/**
	 * Comprueba si existe un email en la base de datos
	 * @param email Email a comprobar su existencia
	 * @return True en caso de que exista | Falso en caso contrario
	 */
	public boolean emailExist(String email) {
		final String QUERY = "SELECT email FROM usuarios "+
							"WHERE email = '" + email + "'";
		try { 
	         ResultSet rs = stmt.executeQuery(QUERY);		      
	         return rs.next();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
			return false;
	}
	
	/**
	 * Cambia la contraseña a un usuario en la base de datos
	 * @param email Email del usuario
	 * @param pass Nueva contraseña
	 */
	public void changePassword(String email, String pass) {
		final String UPDATE = "UPDATE netflix.usuarios\r\n"
				+ "SET\r\n"
				+ "password = '"+pass+"'\r\n"
				+ "WHERE email = '"+email+"';";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
