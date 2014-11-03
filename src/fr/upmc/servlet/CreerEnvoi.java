package fr.upmc.servlet;

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
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.mappings.MappedNames;
import fr.upmc.metier.Transport;
import fr.upmc.security.SecurityPattern;

@WebServlet("/CreerEnvoi")
public class CreerEnvoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreerEnvoi() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( MappedJsp.CREATE_TRANSPORT_JSP).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				boolean error = false;
		
				Pattern pattern = Pattern.compile(SecurityPattern.EMAIL_PATTERN);
				String cache = request.getParameter(MappedNames.MAIL_ENVOYEUR);
				Matcher matcher = pattern.matcher(cache);
				
				if (!matcher.matches()){
					request.setAttribute("error", MappedErrors.MAIL_INVALIDE_ENVOYEUR); error = true;
				}
				
				
				cache = request.getParameter(MappedNames.MAIL_RECEVEUR);
				matcher = pattern.matcher(cache);
				
				if (!matcher.matches()){
					request.setAttribute("error", MappedErrors.MAIL_INVALIDE_RECEVEUR); error = true;
				}
				
				// TODO controler donnees sur la textarea
				
				
				if (error == false){
					TransportBean pojo = new TransportBean();
					pojo.setAccepted(false);
					pojo.setColisDescription("Moyen");
					pojo.setFinished(false);
					pojo.setColisDescription(request.getParameter(MappedNames.DESCRIPTION_COLIS));
					pojo.setMailEnvoi(request.getParameter(MappedNames.MAIL_ENVOYEUR));
					pojo.setMailReception(request.getParameter(MappedNames.MAIL_RECEVEUR));
					Transport t = new Transport();
					if (!t.creer(pojo)){
						request.setAttribute("error", MappedErrors.GENERAL_ERROR); error = true;
					}else{
						HttpSession session = request.getSession(true);
						session.setAttribute("transport", pojo.getId());
						session.setAttribute("depart", request.getParameter(MappedNames.GARE_DEPART));
						session.setAttribute("arrivee", request.getParameter(MappedNames.GARE_ARRIVEE));
					}
				}
				HttpSession s = request.getSession(true);
				s.setAttribute("mailReceveur", request.getParameter(MappedNames.MAIL_RECEVEUR));
				if (error == true) this.getServletContext().getRequestDispatcher( MappedJsp.ERROR).forward( request, response );
				else response.sendRedirect(MappedJsp.VENDEUR_SELECTIONNE_TRAIN);
	}

}
