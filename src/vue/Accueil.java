package vue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Base;
import beans.Competition;
import beans.Personne;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
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
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Html.head(request, response, "Accueil");
		PrintWriter out = response.getWriter();
		if(request.getParameter("id") != null) {
			Personne p = Base.findPersonne(Integer.parseInt(request.getParameter("id")));
			if(p != null){
				out.println("<h2>Pseudo : </h2><h3>"+p.getPseudo()+"</h3>");
				out.println("<h2>Ceinture : </h2><h3>"+p.getCeinture()+"</h3>");
				out.println("<h2>Victoires : </h2>");
				for(Competition c: vainqueur(p)){
					out.println("<h3>" + c.getDate() + c.getAdresse() + "</h3>");
				}
				out.println("<a href=\"InscriptionCompetition?id="+request.getParameter("id")+
						"\"><INPUT type=\"button\" name=\"inscription competition\" value=\"inscription competition\" ></a>");
				if(p.isAdmin()){
					out.println("<a href=\"Admin?id="+request.getParameter("id")+
							"\"><INPUT type=\"button\" name=\"page admin\" value=\"page admin\" ></a>");
				}
			} else {
				out.println("<a href=\"Inscription\"><INPUT type=\"button\" name=\"inscription\" value=\"inscription\" ></a>");
				out.println("<a href=\"Login\"><INPUT type=\"button\" name=\"login\" value=\"login\" ></a>");
			}
		} else {
			out.println("<a href=\"Inscription\"><INPUT type=\"button\" name=\"inscription\" value=\"inscription\" ></a>");
			out.println("<a href=\"Login\"><INPUT type=\"button\" name=\"login\" value=\"login\" ></a>");
			out.println("<h2>Competitions : </h2>");
			for(Competition c: Base.getCompetitions()){
				out.print("<h3>" + c.getDate() + c.getAdresse());
				if(c.getVainqueur() != null){
					out.print(" vainqueur : " + c.getVainqueur().getPseudo());
				}
				out.println("</h3>");
			}
		}
		Html.foot(request, response);
	}
	
	public ArrayList<Competition> vainqueur(Personne p){
		ArrayList<Competition> compet = new ArrayList<Competition>();
		for(Competition c: Base.getCompetitions()){
			if(c.getVainqueur() == p){
				compet.add(c);
			}
		}
		return compet;
	}
}
