package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Usuario;

public class UsuarioDAO extends AbstractDAO {
	
	/**
	 * Método que coomprueba si existe un usuario en la base de datos
	 * según nombre y contraseña
	 * @param usuario El usuario a buscar
	 * @return True en caso de encontrar al usuario
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
	 * Actualiza la contraseña de un usuario en la base de datos
	 * @param pass La contraseña nueva a actualizar
	 * @param user El nombre del usuario a actualizar la contraseña
	 */
	public void updatePassword(String pass, String user) {
		final String UPDATE = "UPDATE pokedex.users\r\n"
				+ "SET\r\n"
				+ "password = '"+pass+"'\r\n"
				+ "WHERE username = '"+user+"';";
		try {
			stmt.executeUpdate(UPDATE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
