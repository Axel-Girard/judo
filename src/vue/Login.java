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
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Login.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		if(pseudo != null) {
			if(mdp != null) {
				Personne p = Base.findPersonne(pseudo, mdp);
				if(p != null){
					response.sendRedirect("Accueil?id=" + p.getId());
					logger.info("personne " + p.getId() + " loggée");
				}
			}
		}
		doGet(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Html.head(request, response, "Login");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Login</h1>");
		out.println("<form method=\"post\" action=\"Login\">");
		out.println("Pseudo : <input name=\"pseudo\" type=\"text\">");
		out.println("Mot de passe : <input name=\"mdp\" type=\"password\">");
		out.println("<input value=\"Envoyer\" type=\"submit\"></form> ");
		Html.foot(request, response);
	}
}
