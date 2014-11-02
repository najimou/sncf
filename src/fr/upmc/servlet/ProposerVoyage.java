package fr.upmc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.bean.TransportBean;
import fr.upmc.bean.VoyageBean;
import fr.upmc.dao.TransportDAO;
import fr.upmc.dao.VoyageDAO;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.metier.Transport;
import fr.upmc.metier.Voyage;

@WebServlet("/ProposerVoyage")
public class ProposerVoyage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProposerVoyage() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("token") != "" && request.getParameter("token") != null && request.getParameter("mail") != "" && request.getParameter("mail") != null){
			Transport t = new Transport();
			TransportBean bean = t.getTransportByTokenAndMail(request.getParameter("token"), request.getParameter("mail"));
			try{
				String propositions = bean.getPropositionVoyagesEnvoi();
				Voyage v = new Voyage();
				ArrayList<VoyageBean> voyages = v.getVoyagesById(propositions);
				request.setAttribute("choixVoyages", voyages);
				this.getServletContext().getRequestDispatcher( MappedJsp.CHOIX_VOYAGE_RECEVEUR_JSP ).forward( request, response );
				
			}catch (NullPointerException e ){
				request.setAttribute("error", "Cette proposition d'expedition n'est plus valide");
				this.getServletContext().getRequestDispatcher( MappedJsp.ERROR).forward( request, response );
			}
		}
		else {
		request.setAttribute("error", "Cette proposition d'expedition n'est plus valide");
		this.getServletContext().getRequestDispatcher( MappedJsp.ERROR).forward( request, response );}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//mettre a jour les données du transport et envoyer mail transporteur
		request.getParameter("id");
		request.getParameter("token");
		request.getParameter("mail");
		//TODO controle sur champ de saisi
		request.getParameter("prix");
		
		// maj base
		TransportDAO dao = new TransportDAO();
		TransportBean bean = dao.getByTokenAndMail(request.getParameter("token"), request.getParameter("mail"));
		
		VoyageDAO daov = new VoyageDAO();
		VoyageBean vbean = daov.getById(Integer.parseInt(request.getParameter("id")));
		
		bean.setCout(request.getParameter("prix"));
		bean.setVoyage(vbean);
		
		dao.update(bean);
		
		
		//envoi mail
		
		
		
		//redirect
		request.setAttribute("message", "Merci d'avoir utilisé Gratis Trip, un mail de confirmation vous sera envoyé lors de la confirmation de la part du transporteur");
		this.getServletContext().getRequestDispatcher( MappedJsp.HOME_JSP).forward( request, response );
	}

}
