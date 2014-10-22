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

import fr.upmc.bean.TransportBean;
import fr.upmc.bean.VoyageBean;
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.metier.Voyage;


@WebServlet("/RenseignerVoyage")
public class RenseignerVoyage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RenseignerVoyage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		TransportBean pojo = (TransportBean) session.getAttribute("User");
		if (pojo == null){
			request.setAttribute("error", MappedErrors.NOT_AUTORIZED);
			this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
		} else {
			this.getServletContext().getRequestDispatcher( MappedJsp.RENSEIGNER_VOYAGE).forward( request, response );
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		TransportBean pojo = (TransportBean) session.getAttribute("User");
		if (pojo == null){
			request.setAttribute("error", MappedErrors.NOT_AUTORIZED);
			this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
		} else {
			// TODO controler si voyage existe deja
			
			// TODO gestion dates
			VoyageBean bean = new VoyageBean();
			bean.setDepart(request.getParameter("").toString());
			//bean.setHeureDepart((Date)(request.getParameter(""))));
			bean.setArrivee(request.getParameter("").toString());
			//bean.setHeureArrivee(request.getParameter("").toString());
			bean.setNumeroTrain(request.getParameter("").toString());
			//bean.setTransporteur(request.getParameter("").toString());			
			Voyage v = new Voyage();
			v.ajouterVoyage(bean);
			this.getServletContext().getRequestDispatcher( MappedJsp.LISTE_VOYAGES).forward( request, response );
		}
		
	}

}
