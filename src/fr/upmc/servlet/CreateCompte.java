package fr.upmc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.bean.MappedNames;
import fr.upmc.bean.TrasporteurBean;

/**
 * Servlet implementation class CreateCompte
 */
@WebServlet("/CreateCompte")
public class CreateCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCompte() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Afficher formulaire
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrasporteurBean t = new TrasporteurBean();
		
		// TODO add regular expressions 
		t.setNom(request.getAttribute(MappedNames.NOM).toString());
		t.setPrenom(request.getAttribute(MappedNames.PRENOM).toString());
		t.setMail(request.getAttribute(MappedNames.MAIL).toString());
		t.setPassword(request.getAttribute(MappedNames.PASSWORD).toString());
		
		fr.upmc.metier.Trasporteur metier = new fr.upmc.metier.Trasporteur();
		metier.createProfile(t);
		
		
	}

}
