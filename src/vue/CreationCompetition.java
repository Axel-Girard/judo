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
import beans.Competition;
import beans.Personne;

/**
 * Servlet implementation class CreationCompetition
 */
@WebServlet("/CreationCompetition")
public class CreationCompetition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CreationCompetition.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationCompetition() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Html.head(request, response, "Admin");
		String date = request.getParameter("date");
		String adresse = request.getParameter("adresse");
		if(date != null && adresse != null) {
			PrintWriter out = response.getWriter();
			out.println("<h1>Competition créée</h1>");
			Competition c = new Competition(date, adresse); 
			Base.addCompetitions(c);
			logger.info("competition " + c.getDate() + " " + c.getAdresse() + " créé");
		} else {
			doGet(request, response);
		}
		Html.foot(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Html.head(request, response, "Admin");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Admin</h1>");
		if(request.getParameter("id") != null){
			Personne p = Base.findPersonne(Integer.parseInt(request.getParameter("id")));
			if(p != null){
				if(p.isAdmin()){
					out.println("<form method=\"post\" action=\"CreationCompetition?id="
							+ request.getParameter("id") + "\">");
					out.println("Date : <input name=\"date\" type=\"text\">");
					out.println("Adresse : <input name=\"adresse\" type=\"text\">");
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
