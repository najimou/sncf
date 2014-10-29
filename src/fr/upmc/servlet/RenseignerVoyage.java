package fr.upmc.servlet;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.upmc.bean.TrasporteurBean;
import fr.upmc.bean.VoyageBean;
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.mappings.MappedNames;
import fr.upmc.metier.Voyage;


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
			// TODO controler si voyage existe deja
			VoyageBean bean = new VoyageBean();
			bean.setDepart(request.getParameter(MappedNames.GARE_DEPART).toString());
			bean.setHeureDepart(request.getParameter(MappedNames.HEURE_DEPART).toString());
			bean.setArrivee(request.getParameter(MappedNames.GARE_ARRIVEE).toString());
			bean.setHeureArrivee(request.getParameter(MappedNames.HEURE_ARRIVEE).toString());
			bean.setNumeroTrain(request.getParameter((MappedNames.NB_TRAIN).toString()));
			bean.setTransporteur((((TrasporteurBean) session.getAttribute("user"))));	
			bean.setDate(request.getParameter((MappedNames.DATE).toString()));
			Voyage v = new Voyage();
			v.ajouterVoyage(bean);
			response.sendRedirect(MappedJsp.LISTE_VOYAGES);
		}
		
	}

}
