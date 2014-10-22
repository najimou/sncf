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
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.metier.Voyage;

@WebServlet("/ListeTransports")
public class ListeTransports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListeTransports() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		TransportBean pojo = (TransportBean) session.getAttribute("User");
		if (pojo == null){
			request.setAttribute("error", MappedErrors.NOT_AUTORIZED);
			this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
		} else {
			this.getServletContext().getRequestDispatcher( MappedJsp.LISTE_TRANSPORTS).forward( request, response );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		TransportBean pojo = (TransportBean) session.getAttribute("User");
		if (pojo == null){
			request.setAttribute("error", MappedErrors.NOT_AUTORIZED);
			this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
		} else {
			
			int id_voyage = Integer.parseInt(request.getParameter(""));
			String accept =  request.getParameter("");
			Voyage metier = new Voyage();
			boolean ok = false;
			if (accept == "0"){
				ok = metier.accepterTransport(id_voyage);
			}else if (accept == "1"){
				ok = metier.refuserTransport(id_voyage);	
			}else if (accept == "2"){
				ok = metier.finaliserTrasport(id_voyage);	
			}
			
			if (ok){
				// faire un retour json? pas besoin de retourner toute la page
				this.getServletContext().getRequestDispatcher( MappedJsp.LISTE_TRANSPORTS).forward( request, response );
			} else {
				
				this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
			}
		} 
	}

}
