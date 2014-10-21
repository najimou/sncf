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
import javax.servlet.http.HttpSession;

import fr.upmc.bean.TrasporteurBean;
import fr.upmc.dao.TransporteurDAO;
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.mappings.MappedNames;
import fr.upmc.security.SecurityPattern;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( MappedJsp.LOGIN ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//*************************************MAIL
		Pattern pattern = Pattern.compile(SecurityPattern.EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(request.getAttribute(MappedNames.MAIL).toString());
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.MAIL_INVALIDE);
		}
		
		
		//*************************************PASSWORD
		pattern = Pattern.compile(SecurityPattern.PASSWORD_PATTERN);
		matcher = pattern.matcher(request.getAttribute(MappedNames.PASSWORD).toString());
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.PASSWORD_INVALIDE);
		}
		
		if ("".equals(request.getAttribute("error"))){
			
				try {
					TransporteurDAO dao = new TransporteurDAO();
					TrasporteurBean pojo = dao.getByMail(request.getAttribute(MappedNames.MAIL).toString());
					if (!pojo.equals(null)){
						
						if (pojo.getPassword().equals(request.getAttribute(MappedNames.PASSWORD).toString())){
							// set session
							HttpSession session = request.getSession(true);
							pojo.setPassword("");
							session.setAttribute("user", pojo);
							// redirect
							this.getServletContext().getRequestDispatcher(MappedJsp.HOME ).forward( request, response );
						}
						else {
							request.setAttribute("error", MappedErrors.PASSWORD_INVALIDE);
							this.getServletContext().getRequestDispatcher(MappedJsp.LOGIN ).forward( request, response );	
						}
						
					}
				} catch (Exception e){
					request.setAttribute("error", MappedErrors.GENERAL_ERROR);		
				}
		}
		this.getServletContext().getRequestDispatcher(MappedJsp.LOGIN ).forward( request, response );		
	}
}
