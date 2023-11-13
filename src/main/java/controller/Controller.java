package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manejador.Manejador;
import model.Pokemon;
import model.ResultAll;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		
		switch (op) {
		case "inicio": {
			Manejador manejador = new Manejador("https://pokeapi.co/api/v2/pokemon-species?limit=1017");
			ResultAll result = manejador.getResult();
			
			for(Pokemon pokemon: result.getPokemons()) {
				String foto = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"; //poner dentro del for
				String[] trozosFoto = pokemon.getUrl().split("/");
				foto += trozosFoto[trozosFoto.length-1] + ".png";
				pokemon.setNumber(trozosFoto[trozosFoto.length-1]);
				pokemon.setFoto(foto);
			}
			// actuar en consecuencia
			//session.setAttribute("Key", objeto);
			request.setAttribute("pokemons", result.getPokemons());
			request.getRequestDispatcher("home.jsp").forward(request, response); //llamamos home a la página principal
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
