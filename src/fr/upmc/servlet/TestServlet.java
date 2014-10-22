package fr.upmc.servlet;


import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import fr.upmc.bean.Train;


public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private Document parseXML(InputStream stream) throws Exception {
		DocumentBuilderFactory objDocumentBuilderFactory = null;
		DocumentBuilder objDocumentBuilder = null;
		Document doc = null;
		try {
			objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			doc = objDocumentBuilder.parse(stream);
		} catch (Exception ex) {
			throw ex;
		}

		return doc;
	}

	private URLConnection connectTo(String url) throws IOException {
		URL connect = null;
		String userPassword = "tnhtn181" + ":" + "4em7Q8cQ";
		String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes());
		try {
			connect = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		URLConnection yc = connect.openConnection();
		yc.setRequestProperty("Authorization", "Basic " + encoding);
		yc.setRequestProperty("Content-Type", "application/xml");
		yc.setRequestProperty("accept", "application/json");
		return yc;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String numGareDepart = (String) request.getParameter("numGareDepart");
		String numGareArrivee = (String) request.getParameter("numGareArrivee");
		
		request.setAttribute("numGareDepart", numGareDepart);
		request.setAttribute("numGareArrivee", numGareArrivee);
		
//		URLConnection yc = connectTo("http://api.transilien.com/gare/"+ numGareDepart + "/depart/");
		URLConnection yc = connectTo("http://api.transilien.com/gare/"+ numGareDepart + "/depart/"+numGareArrivee+"/");
		
		Document doc;
		yc.connect();
		ArrayList<Train> trains = new ArrayList<Train>();
		
		try {
			doc = parseXML(yc.getInputStream());
			NodeList descNodesNum = doc.getElementsByTagName("num");
			NodeList descNodesDateDepart = doc.getElementsByTagName("date");
			NodeList descNodesMiss = doc.getElementsByTagName("miss");
			NodeList descNodesTerm = doc.getElementsByTagName("term");
//			NodeList descNodesEtat = doc.getElementsByTagName("etat");

			for (int i = 0; i < descNodesNum.getLength(); i++) {
				Train train = new Train();
				train.setNumero(descNodesNum.item(i).getTextContent());
				train.setDateDepart(descNodesDateDepart.item(i).getTextContent());
				train.setMiss(descNodesMiss.item(i).getTextContent());
				train.setTerm(descNodesTerm.item(i).getTextContent());
//				train.setEtat(descNodesEtat.item(i).getTextContent());
				trains.add(train);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("trainsAlaGare", trains);

		// reponse HTTP (erreur - success)
		
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/trainsDepartGare.jsp")
				.forward(request, response);
	}
}

