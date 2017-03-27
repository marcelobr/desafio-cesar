package br.org.cesar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.bean.TweetsByState;
import br.org.cesar.service.SearchService;

/**
 * Servlet implementation class TwitterSearch
 */
@WebServlet("/NumberTweetsPerBrazilianState")
public class TwitterSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TwitterSearch() {
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
		//List<TweetsByState> lista = service.getNumberTweetsPerBrazilianState(hashtag);
		String stringlista = service.getNumberTweetsPerBrazilianState(hashtag);
		// service.getNumberTweetsPerBrazilianState(hashtag);
		//request.setAttribute("tweetList", lista);
		//request.getRequestDispatcher("detail.jsp").forward(request, response);

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
