package fr.upmc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.metier.Voyage;

@WebServlet("/ListeTransports")
public class ListeTransports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListeTransports() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// controler la session, si l'utilisateur est authentifie !
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
			//return code 200
		} else {
			
			this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/error.jsp" ).forward( request, response );
		}
		
	}

}
