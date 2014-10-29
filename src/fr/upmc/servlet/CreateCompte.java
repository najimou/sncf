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
import fr.upmc.dao.TransporteurDAO;
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.mappings.MappedMessages;
import fr.upmc.mappings.MappedNames;
import fr.upmc.metier.Trasporteur;
import fr.upmc.security.SecurityPattern;

@WebServlet("/CreateCompte")
public class CreateCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
    public CreateCompte() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( MappedJsp.CREATE_ACCOUNT_JSP ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean error = false;
		try{
		//************************************NOM
		
		Pattern pattern = Pattern.compile(SecurityPattern.STANDARD_PATTERN);
		String cache = request.getParameter(MappedNames.NOM);
		Matcher matcher = pattern.matcher(cache);
		
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.NOM_INVALIDE); error = true;
		}
		
		
		//*************************************PRENOM
		matcher = pattern.matcher(request.getParameter(MappedNames.PRENOM).toString());
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.PRENOM_INVALIDE); error = true;
		}
		
		//*************************************PASSWORD
		pattern = Pattern.compile(SecurityPattern.PASSWORD_PATTERN);
		matcher = pattern.matcher(request.getParameter(MappedNames.PASSWORD).toString());
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.PASSWORD_INVALIDE); error = true;
		}
		
		//*************************************MAIL
		pattern = Pattern.compile(SecurityPattern.EMAIL_PATTERN);
		matcher = pattern.matcher(request.getParameter(MappedNames.MAIL).toString());
		if (!matcher.matches()){
			request.setAttribute("error", MappedErrors.MAIL_INVALIDE);error = true;
		}
		
		if (!error){
			Trasporteur metier = new Trasporteur();
					TransporteurDAO dao = new TransporteurDAO();
					TrasporteurBean bean = dao.getByMail(request.getParameter(MappedNames.MAIL).toString());
					if (bean == null){
							TrasporteurBean t = new TrasporteurBean();
							t.setNom((request.getParameter(MappedNames.NOM).toString()));
							t.setPrenom(request.getParameter(MappedNames.PRENOM).toString());
							t.setPassword(request.getParameter(MappedNames.PASSWORD).toString());
							t.setMail(request.getParameter(MappedNames.MAIL).toString());
							metier.createProfile(t);
							request.setAttribute("message", MappedMessages.ACCOUNT_CREATED);
							response.sendRedirect(MappedJsp.LOGIN);
					} else {
						request.setAttribute("error", MappedErrors.MAIL_DEJA_EXISTANT);error = true;
						this.getServletContext().getRequestDispatcher(MappedJsp.ERROR ).forward( request, response );
					}
		}else {
			this.getServletContext().getRequestDispatcher(MappedJsp.CREATE_ACCOUNT_JSP ).forward( request, response );
		}
		}
		catch (NullPointerException e){
			this.getServletContext().getRequestDispatcher(MappedJsp.CREATE_ACCOUNT_JSP ).forward( request, response );
		}
	}

}
