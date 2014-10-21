package fr.upmc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.upmc.bean.MappedNames;
import fr.upmc.bean.TrasporteurBean;
import fr.upmc.metier.Trasporteur;
@WebServlet("/ResendPassword")
public class ResendPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResendPassword() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrasporteurBean t = new TrasporteurBean();
		
		// TODO add regular expression 
		t.setMail(request.getAttribute(MappedNames.MAIL).toString());
		
		Trasporteur metier = new Trasporteur();
		metier.resendMail(t);
	}

}
