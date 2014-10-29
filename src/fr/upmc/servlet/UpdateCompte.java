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

import fr.upmc.bean.TransportBean;
import fr.upmc.bean.TrasporteurBean;
import fr.upmc.dao.TransporteurDAO;
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.mappings.MappedMessages;
import fr.upmc.mappings.MappedNames;
import fr.upmc.metier.Trasporteur;
import fr.upmc.security.SecurityPattern;

@WebServlet("/UpdateCompte")
public class UpdateCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCompte() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(true);
			TrasporteurBean bean = (TrasporteurBean) session.getAttribute("user");
			bean.getPrenom();
			this.getServletContext().getRequestDispatcher(MappedJsp.UPDATE_ACCOUNT_JSP).forward( request, response );
		} catch(NullPointerException e){
			request.setAttribute("error", MappedErrors.AUTHENTIFICATION_REQUIRED); 
			response.sendRedirect(MappedJsp.LOGIN);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		boolean canUpdate = true;	
		try {
			HttpSession session = request.getSession(true);
			TrasporteurBean bean = (TrasporteurBean) session.getAttribute("user");
		} catch(NullPointerException e){
			request.setAttribute("error", MappedErrors.AUTHENTIFICATION_REQUIRED); 
			canUpdate = false;
		}
		
		
		if (canUpdate)	{
			
			
			//************************************NOM		
			Pattern pattern = Pattern.compile(SecurityPattern.STANDARD_PATTERN);
			Matcher matcher = pattern.matcher(request.getParameter(MappedNames.NOM).toString());		
			if (!matcher.matches()){
				request.setAttribute("error", MappedErrors.NOM_INVALIDE); canUpdate = false;
			}
			
			//*************************************PRENOM		
			matcher = pattern.matcher(request.getParameter(MappedNames.PRENOM).toString());
			if (!matcher.matches()){
				request.setAttribute("error", MappedErrors.PRENOM_INVALIDE);canUpdate = false;
			}
			
			//*************************************PASSWORD
			pattern = Pattern.compile(SecurityPattern.PASSWORD_PATTERN);
			matcher = pattern.matcher(request.getParameter(MappedNames.PASSWORD).toString());
			if (!matcher.matches()){
				request.setAttribute("error", MappedErrors.PASSWORD_INVALIDE);canUpdate = false;
			}
			
			//*************************************PASSWORD2
			pattern = Pattern.compile(SecurityPattern.PASSWORD_PATTERN);
			matcher = pattern.matcher(request.getParameter(MappedNames.PASSWORDCONFIRMATION).toString());
			if (!matcher.matches()){
				request.setAttribute("error", MappedErrors.PASSWORD_INVALIDE);canUpdate = false;
			}
			
			//****************** Pass1 == Pass2
			if (!request.getParameter(MappedNames.PASSWORDCONFIRMATION).toString().equals(request.getParameter(MappedNames.PASSWORD).toString())){
				request.setAttribute("error", MappedErrors.PASSWORD_NOT_MATCH);canUpdate = false;
			}
			
			//*************************************MAIL
			pattern = Pattern.compile(SecurityPattern.EMAIL_PATTERN);
			matcher = pattern.matcher(request.getParameter(MappedNames.MAIL).toString());
			if (! matcher.matches()){
				request.setAttribute("error", MappedErrors.MAIL_INVALIDE);canUpdate = false;
			}
			
			if (canUpdate){
				Trasporteur metier = new Trasporteur();
					try {
						
						TransporteurDAO dao = new TransporteurDAO();
						TrasporteurBean bean = dao.getByMail(((TrasporteurBean)(request.getSession(true).getAttribute("user"))).getMail());
						
						bean.setNom((request.getParameter(MappedNames.NOM).toString()));
						bean.setPrenom(request.getParameter(MappedNames.PRENOM).toString());
						bean.setPassword(request.getParameter(MappedNames.PASSWORD).toString());
						bean.setMail(request.getParameter(MappedNames.MAIL).toString());
						dao.update(bean);
						request.setAttribute("message", MappedMessages.ACCOUNT_UPDATED);
						this.getServletContext().getRequestDispatcher(MappedJsp.ACCOUNT_JSP).forward( request, response );
					} catch (Exception e){
						e.printStackTrace();
						request.setAttribute("error", MappedErrors.GENERAL_ERROR);
						this.getServletContext().getRequestDispatcher(MappedJsp.UPDATE_ACCOUNT_JSP).forward( request, response );
					}
			}else{
				this.getServletContext().getRequestDispatcher(MappedJsp.UPDATE_ACCOUNT_JSP).forward( request, response );
		
				
			}
		 
			
		}
		else{
			request.setAttribute("error", MappedErrors.AUTHENTIFICATION_REQUIRED);		
			this.getServletContext().getRequestDispatcher(MappedJsp.LOGIN_JSP).forward( request, response );
			}
	}
		
	

}
