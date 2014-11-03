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
import fr.upmc.bean.VoyageBean;
import fr.upmc.dao.VoyageDAO;
import fr.upmc.mappings.MappedErrors;
import fr.upmc.mappings.MappedJsp;


@WebServlet("/saveVoyage")
public class SaveVoyage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SaveVoyage() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		TrasporteurBean pojo = (TrasporteurBean) session.getAttribute("user");
		if (pojo == null){
			request.setAttribute("error", MappedErrors.NOT_AUTORIZED);
			this.getServletContext().getRequestDispatcher( MappedJsp.ERROR ).forward( request, response );
		} else {
		
			VoyageBean bean = (VoyageBean) session.getAttribute("voyagecache");
			String numtrain = request.getParameter("option").toString();
			bean.setNumeroTrain(numtrain);
			ArrayList<Train> trains = (ArrayList<Train>) session.getAttribute("listeTrains");
			Train t = new Train();
			for (int i =0; i <trains.size(); i++){	
				if (trains.get(i).getNumero().equals(numtrain)){t = trains.get(i);}
			}
			bean.setDate(t.getDateDepart());
			VoyageDAO dao = new VoyageDAO();
			bean.setHeureDepart(t.getDateDepart().substring(11, 16));
			bean.setHeureArrivee("0");
			dao.insert(bean);
			}
			response.sendRedirect(MappedJsp.LISTE_VOYAGES);
			
		}
	

}
