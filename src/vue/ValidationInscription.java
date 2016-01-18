package vue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Base;
import beans.Personne;

/**
 * Servlet implementation class ValidationInscription
 */
@WebServlet("/ValidationInscription")
public class ValidationInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationInscription() {
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
		for(Personne pers: Base.findInvalidPersonne()){
			if(request.getParameter(pers.getPseudo()) != null){
				pers.setValider(true);
			} else {
				Base.removePersonne(pers);
			}
		}
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Html.head(request, response, "Validation des Inscription");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Admin</h1>");
		if(request.getParameter("id") != null){
			Personne p = Base.findPersonne(Integer.parseInt(request.getParameter("id")));
			if(p != null){
				if(p.isAdmin()){
					out.println("<form method=\"post\" action=\"ValidationInscription\">");
					for(Personne pers: Base.findInvalidPersonne()){
						out.println("<INPUT type=\"checkbox\" name=\""+pers.getPseudo()+"\" value=\""+pers.getPseudo()+"\">"+pers.getPseudo()+"<br />");
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
