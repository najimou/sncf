package fr.upmc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.upmc.bean.TrasporteurBean;
import fr.upmc.bean.VoyageBean;
import fr.upmc.dao.VoyageDAO;
import fr.upmc.mappings.MappedJsp;

@WebServlet("/ListeVoyages")
public class ListeVoyages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListeVoyages() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VoyageDAO dao = new VoyageDAO();
		
		try {
			HttpSession session = request.getSession(true);
			TrasporteurBean bean = (TrasporteurBean) session.getAttribute("user");
			int id = bean.getId();
			ArrayList<VoyageBean> voyages = dao.getByIdTransporteur(id);
			System.out.println(voyages.size());
			request.setAttribute("voyages", voyages);
			this.getServletContext().getRequestDispatcher( MappedJsp.LISTE_VOYAGES_JSP ).forward( request, response );
		} catch(NullPointerException e){
			ArrayList<VoyageBean> voyages = dao.getAllActives();
			request.setAttribute("voyages", voyages);
			System.out.println(voyages.size());
			this.getServletContext().getRequestDispatcher( MappedJsp.LISTE_VOYAGES_JSP ).forward( request, response );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
