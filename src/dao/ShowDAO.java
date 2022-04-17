package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Show;

public class ShowDAO extends AbstractDAO {
	
	/**
	 * Inserta un Show en la base de datos
	 * @param s El Show a ingresar
	 */
	public void insert(Show s) {
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
	
	public ArrayList<Show> getAll() {
		final String QUERY = "SELECT showid, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description"
				+ " FROM netflix.shows";
		ArrayList<Show> arrShows = new ArrayList<Show>();
		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	String showid = rs.getString("showid");
		        	 	String type = rs.getString("type");
		        	 	String title = rs.getString("title");
		        	 	String director = rs.getString("director");
		        	 	String cast = rs.getString("cast");
		        	 	String country = rs.getString("country");
		        	 	String date = rs.getString("date_added");
		        	 	String year = rs.getString("release_year");
		        	 	String duration = rs.getString("duration");
		        	 	String rating = rs.getString("rating");
		        	 	String listed_in = rs.getString("listed_in");
		        	 	String description = rs.getString("description");


		        	 	Show s = new Show(showid, type, title, director, cast, country, date, year, rating, duration, listed_in, description);
		        	 	arrShows.add(s);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
				return arrShows;
	}
	
	public ArrayList<Show> getBusqueda(String text, String clasificador) {
		final String QUERY = "SELECT showid, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description"
				+ " FROM netflix.shows WHERE "+clasificador+" LIKE '%"+ text +"%'";
		ArrayList<Show> arrShows = new ArrayList<Show>();
		try { 
		         ResultSet rs = stmt.executeQuery(QUERY);		      
		         while(rs.next()){
		            //Display values
		        	 	String showid = rs.getString("showid");
		        	 	String type = rs.getString("type");
		        	 	String title = rs.getString("title");
		        	 	String director = rs.getString("director");
		        	 	String cast = rs.getString("cast");
		        	 	String country = rs.getString("country");
		        	 	String date = rs.getString("date_added");
		        	 	String year = rs.getString("release_year");
		        	 	String duration = rs.getString("duration");
		        	 	String rating = rs.getString("rating");
		        	 	String listed_in = rs.getString("listed_in");
		        	 	String description = rs.getString("description");


		        	 	Show s = new Show(showid, type, title, director, cast, country, date, year, rating, duration, listed_in, description);
		        	 	arrShows.add(s);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
				return arrShows;
	}
}
