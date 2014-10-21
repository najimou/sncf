package fr.upmc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.bean.VoyageBean;
import fr.upmc.metier.Voyage;


@WebServlet("/RenseignerVoyage")
public class RenseignerVoyage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RenseignerVoyage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO gestion dates et controles de surface
		VoyageBean bean = new VoyageBean();
		bean.setDepart(request.getParameter("").toString());
		//bean.setHeureDepart((Date)(request.getParameter(""))));
		bean.setArrivee(request.getParameter("").toString());
		//bean.setHeureArrivee(request.getParameter("").toString());
		bean.setNumeroTrain(request.getParameter("").toString());
		//bean.setTransporteur(request.getParameter("").toString());
		
		Voyage v = new Voyage();
		v.ajouterVoyage(bean);
		
	}

}
