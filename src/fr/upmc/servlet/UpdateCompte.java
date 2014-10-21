package fr.upmc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.bean.MappedNames;
import fr.upmc.bean.TrasporteurBean;
import fr.upmc.metier.Trasporteur;

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
		TrasporteurBean t = new TrasporteurBean();
		
		// TODO add regular expressions 
		t.setNom(request.getAttribute(MappedNames.NOM).toString());
		t.setPrenom(request.getAttribute(MappedNames.PRENOM).toString());
		t.setMail(request.getAttribute(MappedNames.MAIL).toString());
		t.setPassword(request.getAttribute(MappedNames.PASSWORD).toString());
		
		Trasporteur metier = new Trasporteur();
		if (metier.updateProfile(t)){
			// ok 
			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/login.jsp" ).forward( request, response );
		}
		else{
			// ko
			request.setAttribute("error", "erreur lors de la modification de votre profile");
			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/error.jsp" ).forward( request, response );
		}
	}

}
