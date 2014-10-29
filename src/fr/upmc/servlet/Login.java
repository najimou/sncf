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
	
		try {
			HttpSession session = request.getSession(true);
			TrasporteurBean bean = (TrasporteurBean) session.getAttribute("user");
			bean.getPrenom();
			request.setAttribute("error", MappedErrors.ALREADY_LOGGED_IN); 
			response.sendRedirect(MappedJsp.HOME);
		} catch(NullPointerException e){
			this.getServletContext().getRequestDispatcher( MappedJsp.LOGIN_JSP ).forward( request, response );
		}	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean canlogin = true;
		//*************************************MAIL
		Pattern pattern = Pattern.compile(SecurityPattern.EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(request.getParameter(MappedNames.MAIL).toString());
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.MAIL_INVALIDE); canlogin = false;
		}
		
		
		//*************************************PASSWORD
		pattern = Pattern.compile(SecurityPattern.PASSWORD_PATTERN);
		matcher = pattern.matcher(request.getParameter(MappedNames.PASSWORD).toString());
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.PASSWORD_INVALIDE);canlogin = false;
		}
		
		if (canlogin){
			
				try {
					TransporteurDAO dao = new TransporteurDAO();
					TrasporteurBean pojo = dao.getByMail(request.getParameter(MappedNames.MAIL).toString());
					if (!pojo.getMail().equals(null)){
						
						if (pojo.getPassword().equals(request.getParameter(MappedNames.PASSWORD).toString())){
							
							HttpSession session = request.getSession(true);
							pojo.setPassword("");
							session.setAttribute("user", pojo);
							
							response.sendRedirect(MappedJsp.HOME);
						}
						else {
							request.setAttribute("error", MappedErrors.MAUVAIS_PASSWORD);
							this.getServletContext().getRequestDispatcher(MappedJsp.LOGIN_JSP ).forward( request, response );
						}
						
					}
					
				}catch (NullPointerException e){	
					request.setAttribute("error", MappedErrors.MAUVAIS_MAIL);
					this.getServletContext().getRequestDispatcher(MappedJsp.LOGIN_JSP ).forward( request, response );
				}catch (Exception e){
					e.printStackTrace();
					request.setAttribute("error", MappedErrors.GENERAL_ERROR);	
					this.getServletContext().getRequestDispatcher(MappedJsp.LOGIN_JSP ).forward( request, response );
				}
		}else {
			this.getServletContext().getRequestDispatcher(MappedJsp.LOGIN_JSP ).forward( request, response );
		}
	}
}
