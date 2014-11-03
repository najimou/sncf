package fr.upmc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.upmc.bean.TrasporteurBean;
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;
import fr.upmc.metier.Transport;


@WebServlet("/manageTransport")
public class ManageTransport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ManageTransport() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		if (request.getParameter("type") != "" && request.getParameter("id") != "") {
			//ceck session
			HttpSession s = request.getSession(true);
			TrasporteurBean t = (TrasporteurBean) s.getAttribute("user");
			boolean annullation = true;
			try{ 
				int idTransporteur = t.getId();
				int idVoyage = Integer.parseInt(request.getParameter("id"));
				Transport tr = new Transport();
				if (request.getParameter("type").equals("accept")){
					tr.accepterTransport(idVoyage, idTransporteur);
					response.sendRedirect(MappedJsp.LISTE_TRANSPORTS);
				}
				else if (request.getParameter("type").equals("refus")){
					annullation = tr.refuserTransport(idVoyage, idTransporteur);
				}
				else {
					request.setAttribute("error", MappedErrors.GENERAL_ERROR);
					this.getServletContext().getRequestDispatcher( MappedJsp.ERROR).forward( request, response );
				}
				
			} catch (Exception e){
				request.setAttribute("error", "Vous devez etre connecté pour effectuer cette action");
				this.getServletContext().getRequestDispatcher( MappedJsp.ERROR).forward( request, response );
			}
			
			if (!annullation){
				// si le transporteur refuse, il faut informer le autres
			}
				
			}
			
			//response.sendRedirect(MappedJsp.LISTE_TRANSPORTS);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
	}

}
