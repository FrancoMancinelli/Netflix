package dao;

import java.sql.SQLException;

import models.Show;

public class ShowDAO extends AbstractDAO {
	
	/**
	 * Inserta un Show en la base de datos
	 * @param s El Show a ingresar
	 */
	public void insertShows(Show s) {
		final String INSERT = "INSERT INTO netflix.shows (showid, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description)"
				+ " VALUES ('"+s.getShowID()+"', '"+s.getType()+"', '"+s.getTitle()+"', '"+s.getDirector()
				+"', '"+s.getCast()+"', '"+s.getCountry()+"', '"+s.getDate_added()+"', "+s.getRelease_year()
				+", '"+s.getRating()+"', '"+s.getDuration()+"', '"+s.getListed_in()+"', '"+s.getDescription()+"')";
		try { 
			stmt.executeUpdate(INSERT);		      
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		} 
	}
}
