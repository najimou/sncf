package fr.upmc.servlet;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.mappings.MappedNames;
import fr.upmc.metier.Trasporteur;
import fr.upmc.security.SecurityPattern;
@WebServlet("/ResendPassword")
public class ResendPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResendPassword() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Pattern pattern = Pattern.compile(SecurityPattern.EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(request.getAttribute(MappedNames.MAIL).toString());
		if (!matcher.matches()){
			Trasporteur metier = new Trasporteur();
			if (metier.resendMail(request.getAttribute(MappedNames.MAIL).toString())){
				this.getServletContext().getRequestDispatcher( MappedJsp.LOGIN ).forward( request, response );
			}
			else {
				this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
			}
		}else {
			request.setAttribute("error", MappedErrors.MAUVAIS_MAIL);
			this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
		}	
	}

}
