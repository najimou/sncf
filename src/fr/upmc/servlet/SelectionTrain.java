package fr.upmc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.upmc.bean.VoyageBean;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.metier.Transport;
import fr.upmc.metier.Voyage;
import fr.upmc.service.TokenGenerator;

@WebServlet("/SelectionTrain")
public class SelectionTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectionTrain() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		String depart = (String) s.getAttribute("depart");
		String arrivee  = (String) s.getAttribute("arrivee");
		
		if (!depart.equals("") && !arrivee.equals("")){
			Voyage v = new Voyage();
			ArrayList<VoyageBean> array = v.getVoyagesByGares(depart, arrivee);
			request.setAttribute("voyages", array);
			this.getServletContext().getRequestDispatcher(MappedJsp.VENDEUR_SELECTIONNE_TRAIN_JSP).forward( request, response );
			
		}else{
			request.setAttribute("error", "Vous ne pouvez pas effectuer cette action");
			this.getServletContext().getRequestDispatcher( MappedJsp.ERROR).forward( request, response );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] voyages =  request.getParameterValues("option");
		
		StringBuffer s = new StringBuffer();
		s.append(voyages[0]);
		for (int i = 1; i < voyages.length; i++) {
			s.append(","+voyages[i]);
		}
		
		Transport t = new Transport();
		t.ajouterChoixVoyagesEnvoyeur(Integer.parseInt(request.getSession(true).getAttribute("transport").toString()), s.toString());
		String token = t.setToken(Integer.parseInt(request.getSession(true).getAttribute("transport").toString()));
		
		
		//clean session
		request.setAttribute("message", "Votre demande est bien enregistré. Un mail de confirmation vous sera envoyé avec les détails du voyage");
		HttpSession session = request.getSession(true);
		session.setAttribute("depart", "");
		session.setAttribute("arrivee", "");
		session.setAttribute("transport", "");
		
		//send mail + link with token
		
		request.setAttribute("link", MappedJsp.ROOT+"/ProposerVoyage?token="+token+"&mail="+session.getAttribute("mailReceveur"));
		
		this.getServletContext().getRequestDispatcher( MappedJsp.HOME_JSP).forward( request, response );
	}

}
