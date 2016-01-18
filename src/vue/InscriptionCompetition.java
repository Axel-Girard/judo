package vue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Base;
import beans.Competition;

/**
 * Servlet implementation class InscriptionCompetition
 */
@WebServlet("/InscriptionCompetition")
public class InscriptionCompetition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionCompetition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Html.head(request, response, "Inscription effectuée");
		if(request.getParameter("id") != null){
			String compet = request.getParameter("compet");
			String date = "";
			String ville = "";
			int i = 0;
			for(String retval : compet.split("-", 2)) {
				if(i++ == 0){
					date = retval;
				} else {
					ville += retval;
				}
			}
			Competition c = Base.findCompet(date,ville);
			if(c != null){
				c.addCompetiteurs(Integer.parseInt(request.getParameter("id")));
				out.println("<h1>Vous vous êtes inscrit</h1>");
				out.println("<a href=\"Accueil?id=" + request.getParameter("id") +
						"\"><INPUT type=\"button\" name=\"accueil\" value=\"accueil\" ></a>");
			} else {
				out.println("<h1>Une erreur est survenue, veuilliez vous connecter</h1>");
				out.println("<a href=\"Login\"><INPUT type=\"button\" name=\"login\" value=\"login\" ></a>");
			}
		} else {
			out.println("<h2>Vous devez être connecté pour acceder à ce contenu</h2>");
			out.println("<a href=\"Login\"><INPUT type=\"button\" name=\"login\" value=\"login\" ></a>");
		}
		Html.foot(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Html.head(request, response, "Inscription à une compétition");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(request.getParameter("id") != null){
			out.println("<h1>Inscription</h1>");
			out.println("<form method=\"post\" action=\"InscriptionCompetition?id="
					+ request.getParameter("id") + "\">");
			out.println("<select name=\"compet\" >");
			for (Competition compet : Base.getCompetitions()) {
				out.println("<option value=\"" + compet.getDate() + "-"
						+ compet.getAdresse() + "\">" + compet.getDate() + " - "
						+ compet.getAdresse() + "</option>");
			}
			out.println("</section>");
			out.println("<input value=\"Envoyer\" type=\"submit\"></form> ");
		} else {
			out.println("<h2>Vous devez être connecté pour acceder à ce contenu</h2>");
			out.println("<a href=\"Login\"><INPUT type=\"button\" name=\"login\" value=\"login\" ></a>");
		}
		Html.foot(request, response);
	}

}
