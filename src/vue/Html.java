package vue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Html {

	public static void head(HttpServletRequest request, HttpServletResponse response, String titre) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head> <title>" + titre + "</title> </head>");
		out.println("<body>");
	}

	public static void foot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		out.println("</body>"); 
		out.println("</html>");
	}
}
