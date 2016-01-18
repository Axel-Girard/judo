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
import beans.Personne;

/**
 * Servlet implementation class NoterGagnant
 */
@WebServlet("/NoterGagnant")
public class NoterGagnant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoterGagnant() {
        super();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Html.head(request, response, "Noter gagant");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Competition</h1>");
		if(request.getParameter("vainqueur") != null){
			for(Competition c: Base.getCompetitions()){
				if(c.getVainqueur() == null){
					c.setVainqueur(Base.findPersonne(Integer.parseInt(request.getParameter("vainqueur"))));
					out.println("<h3>Ajout des gagnants</h3>");
				}
			}
		}
		Html.foot(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Html.head(request, response, "Noter gagant");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Competition :</h1>");
		if(request.getParameter("id") != null){
			Personne p = Base.findPersonne(Integer.parseInt(request.getParameter("id")));
			if(p != null){
				if(p.isAdmin()){
					out.println("<form method=\"post\" action=\"NoterGagnant\">");
					for(Competition c: Base.getCompetitions()){
						if(c.getVainqueur() != null){
							out.println("<h3>date " + c.getDate() + " adresse :" + c.getAdresse() +
									" vainqueur : " + c.getVainqueur().getId() + "</h3>");
						} else {
							out.println("<h3>date " + c.getDate() + " adresse :" + c.getAdresse() +
									" vainqueur : <input name=\"vainqueur\" type=\"text\"></h3>");
						}
					}
					out.println("<input value=\"Envoyer\" type=\"submit\"></form> ");
				}
			}
		} else {
			out.println("<h2>Vous devez être connecté pour acceder à ce contenu</h2>");
			out.println("<a href=\"Login\"><INPUT type=\"button\" name=\"login\" value=\"login\" ></a>");
		}
		Html.foot(request, response);
	}
}
