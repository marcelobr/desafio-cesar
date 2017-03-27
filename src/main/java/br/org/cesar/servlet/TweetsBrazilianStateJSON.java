package br.org.cesar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.service.SearchService;

/**
 * Servlet implementation class TwitterSearch
 */
@WebServlet("/NumberTweetsPerBrazilianState")
public class TweetsBrazilianStateJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TweetsBrazilianStateJSON() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hashtag = request.getParameter("hashtag");
		SearchService service = new SearchService();
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
