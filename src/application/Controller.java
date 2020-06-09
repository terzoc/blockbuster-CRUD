package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blockbuster.Movie;
import blockbuster.MovieDAO;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private MovieDAO dao;
	  
	  public void init()
	  {
		  final String url = getServletContext().getInitParameter("JDBC-URL");
		  final String username = getServletContext().getInitParameter("JDBC-USERNAME");
		  final String password = getServletContext().getInitParameter("JDBC-PASSWORD");
	    
	    dao = new MovieDAO(url, username, password);
	  }
	  
	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException
	  {
	    doGet(request, response);
	  }
	  
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException
	  {
	    final String action = request.getServletPath();
	    
	    try {
	      switch (action) {
	        default:
	          viewMovies(request, response);
	          break;
	      }
	    } catch (SQLException e) {
	      throw new ServletException(e);
	    }
	  }
	  
	  private void viewMovies(HttpServletRequest request, HttpServletResponse response)
	      throws SQLException, ServletException, IOException
	  {
	    List<Movie> movies = dao.getMovies();
	    request.setAttribute("movies", movies);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("inventory.jsp");
	    dispatcher.forward(request, response);
	  }
}
