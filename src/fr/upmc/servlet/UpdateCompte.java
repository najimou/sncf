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

import fr.upmc.bean.TrasporteurBean;
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
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error = "";
				
		//************************************NOM		
		Pattern pattern = Pattern.compile(SecurityPattern.STANDARD_PATTERN);
		Matcher matcher = pattern.matcher(request.getAttribute(MappedNames.NOM).toString());		
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.NOM_INVALIDE);
		}
		
		//*************************************PRENOM		
		matcher = pattern.matcher(request.getAttribute(MappedNames.PRENOM).toString());
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.PRENOM_INVALIDE);
		}
		
		//*************************************PASSWORD
		pattern = Pattern.compile(SecurityPattern.PASSWORD_PATTERN);
		matcher = pattern.matcher(request.getAttribute(MappedNames.PASSWORD).toString());
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.PASSWORD_INVALIDE);
		}
		
		//*************************************MAIL
		pattern = Pattern.compile(SecurityPattern.EMAIL_PATTERN);
		matcher = pattern.matcher(request.getAttribute(MappedNames.MAIL).toString());
		if (! matcher.matches()){
			request.setAttribute("error", MappedErrors.MAIL_INVALIDE);
		}
		
		if ("".equals(error)){
			Trasporteur metier = new Trasporteur();
				try {
					// TODO change with session!
					TrasporteurBean t = new TrasporteurBean(); 
					
					t.setNom((request.getAttribute(MappedNames.NOM).toString()));
					t.setPrenom(request.getAttribute(MappedNames.PRENOM).toString());
					t.setPassword(request.getAttribute(MappedNames.PASSWORD).toString());
					t.setMail(request.getAttribute(MappedNames.MAIL).toString());
					metier.updateProfile(t);
					request.setAttribute("message", MappedMessages.ACCOUNT_UPDATED);
					this.getServletContext().getRequestDispatcher(MappedJsp.ACCOUNT).forward( request, response );
				} catch (Exception e){
					request.setAttribute("error", MappedErrors.GENERAL_ERROR);			
				}
		}
	 this.getServletContext().getRequestDispatcher(MappedJsp.UPDATE_ACCOUNT).forward( request, response );
		
	}
		
	

}
