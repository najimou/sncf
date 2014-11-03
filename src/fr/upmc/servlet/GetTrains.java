package fr.upmc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.upmc.bean.Train;
import fr.upmc.bean.TrasporteurBean;
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.metier.Transport;
import fr.upmc.service.SncfService;

@WebServlet("/getTrains")
public class GetTrains extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetTrains() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ((request.getParameter("depart") != "" && request.getParameter("arrivee") != "")){
			try{ 
				SncfService srv = new SncfService();
				ArrayList<Train> trains =  srv.getListeParDepartArrive(request.getParameter("depart"), request.getParameter("arrivee"));
				request.setAttribute("listeTrains", trains);
				this.getServletContext().getRequestDispatcher( MappedJsp.LISTETRAINS).forward( request, response);
			} catch (Exception e){
				request.setAttribute("error", "Vous devez etre connecté pour effectuer cette action");
				this.getServletContext().getRequestDispatcher( MappedJsp.ERROR).forward( request, response );
			}
			
			
			}else{			
				request.setAttribute("error", "Vous devez etre connecté pour effectuer cette action");
				this.getServletContext().getRequestDispatcher( MappedJsp.ERROR).forward( request, response );
			}

	}



}
