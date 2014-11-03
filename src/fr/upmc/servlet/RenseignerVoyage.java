package fr.upmc.servlet;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

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
import fr.upmc.bean.VoyageBean;
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.mappings.MappedNames;
import fr.upmc.metier.Voyage;
import fr.upmc.service.SncfService;


@WebServlet("/RenseignerVoyage")
public class RenseignerVoyage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RenseignerVoyage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		TrasporteurBean pojo = (TrasporteurBean) session.getAttribute("user");
		if (pojo == null){
			request.setAttribute("error", MappedErrors.NOT_AUTORIZED);
			this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
		} else {
			this.getServletContext().getRequestDispatcher( MappedJsp.RENSEIGNER_VOYAGE_JSP).forward( request, response );
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		TrasporteurBean pojo = (TrasporteurBean) session.getAttribute("user");
		if (pojo == null){
			request.setAttribute("error", MappedErrors.NOT_AUTORIZED);
			this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
		} else {
			VoyageBean bean = new VoyageBean();
			bean.setDepart(request.getParameter(MappedNames.GARE_DEPART).toString());
			//bean.setHeureDepart(request.getParameter(MappedNames.HEURE_DEPART).toString());
			bean.setArrivee(request.getParameter(MappedNames.GARE_ARRIVEE).toString());
			//bean.setHeureArrivee(request.getParameter(MappedNames.HEURE_ARRIVEE).toString());
			//bean.setNumeroTrain(request.getParameter((MappedNames.NB_TRAIN).toString()));
			bean.setTransporteur((((TrasporteurBean) session.getAttribute("user"))));	
			//bean.setDate(request.getParameter((MappedNames.DATE).toString()));
			//Voyage v = new Voyage();
			//v.ajouterVoyage(bean);
			session.setAttribute("voyagecache", bean);
			try{ 
				SncfService srv = new SncfService();
				ArrayList<Train> trains =  srv.getListeParDepartArrive(request.getParameter("depart"), request.getParameter("arrivee"));
				request.setAttribute("listeTrains", trains);
				session.setAttribute("listeTrains", trains);
				this.getServletContext().getRequestDispatcher( MappedJsp.LISTETRAINS).forward( request, response);
			} catch (Exception e){
				request.setAttribute("error", "Vous devez etre connecté pour effectuer cette action");
				this.getServletContext().getRequestDispatcher( MappedJsp.ERROR).forward( request, response );
			}
		}
		
	}

}
