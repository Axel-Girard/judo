package vue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import base.Base;
import beans.Personne;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Inscription.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
		BasicConfigurator.configure();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("pseudo") != null) {
			if (request.getParameter("mdp") != null) {
				if (request.getParameter("ceinture") != null) {
					int id = (int) (Math.random() * 1000);
					Base.add(new Personne(id, request.getParameter("pseudo"),
							request.getParameter("mdp"), request
									.getParameter("ceinture")));
					response.sendRedirect("Accueil?id=" + id);
					logger.info("personne créée " + id);
				}
			}
		}
		doGet(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Html.head(request, response, "Inscription");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Inscription</h1>");
		out.println("<form method=\"post\" action=\"Inscription\">");
		out.println("Pseudo : <input name=\"pseudo\" type=\"text\">");
		out.println("Ceinture : <input name=\"ceinture\" type=\"text\">");
		out.println("Mot de passe : <input name=\"mdp\" type=\"password\">");
		out.println("<input value=\"Envoyer\" type=\"submit\"></form> ");
		Html.foot(request, response);
	}
}
