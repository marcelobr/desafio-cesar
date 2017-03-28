package br.org.cesar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.service.TweetsBrazilianStateService;

/**
 * Servlet implementation to return the json that represents the list of states and number of tweets
 */
@WebServlet("/NumberTweetsPerBrazilianState")
public class TweetsBrazilianStateJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TweetsBrazilianStateJSON() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hashtag = request.getParameter("hashtag");
		TweetsBrazilianStateService service = new TweetsBrazilianStateService();
		String stringlista = service.getNumberTweetsPerBrazilianState(hashtag);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(stringlista);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
