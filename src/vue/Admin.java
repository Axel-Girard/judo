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
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
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
		Html.head(request, response, "Admin");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Admin</h1>");
		if(request.getParameter("id") != null){
			Personne p = Base.findPersonne(Integer.parseInt(request.getParameter("id")));
			if(p != null){
				if(p.isAdmin()){
					out.println("<a href=\"ValidationInscription?id="+request.getParameter("id")+
							"\"><INPUT type=\"button\" name=\"validation inscription\" value=\"validation inscription\" ></a>");
					out.println("<a href=\"CreationCompetition?id="+request.getParameter("id")+
							"\"><INPUT type=\"button\" name=\"creation competition\" value=\"creation competition\" ></a>");
					out.println("<a href=\"NoterGagnant?id="+request.getParameter("id")+
							"\"><INPUT type=\"button\" name=\"noter gagnant\" value=\"noter gagnant\" ></a>");
				}
			}
		} else {
			out.println("<h2>Vous devez être connecté pour acceder à ce contenu</h2>");
			out.println("<a href=\"Login\"><INPUT type=\"button\" name=\"login\" value=\"login\" ></a>");
		}
		Html.foot(request, response);
	}
}
