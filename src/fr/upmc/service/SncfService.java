package fr.upmc.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import fr.upmc.bean.Gare;
import fr.upmc.bean.Train;
import fr.upmc.dao.GareDAO;

public class SncfService {

	public List<Train> getListeDepartsParStation(String station){return null;}
	
	public ArrayList<Train> getListeParDepartArrive(String depart, String arrive) throws IOException{
		ArrayList<Train> trains = new ArrayList<Train>();
		String nameGareDepart = depart;
		String nameGareArrivee = arrive;
		String disp = "/formGares.jsp";

		if(nameGareDepart.length()>0 && nameGareArrivee.length()>0){
			
//			String classeNameDriver = "org.postgresql.Driver";
//			String user = "postgres";
//			String mdp = "postgres";
//			String jdbc_DB = "jdbc:postgresql://localhost:5432/test";
//			String dataBaseName = "PostGres";
			
			
			
			String classeNameDriver = "com.mysql.jdbc.Driver";
			String user = "root";
			String mdp = "usbw";
			String jdbc_DB = "jdbc:mysql://localhost:3307/test";
			String dataBaseName = "MySQL";
			
			Connection connection = null;
			BddUtility bu = new BddUtility(classeNameDriver, user, mdp, jdbc_DB, dataBaseName, connection);
			bu.initConnection();
			connection = bu.getConnection();
	        
			GareDAO dao = new GareDAO();
			ArrayList<Gare> gares = new ArrayList<Gare>();
			ResultSet rsDepart = null;
			ResultSet rsArrivee = null;
			try {
				rsDepart = dao.getGare(connection, nameGareDepart);
				rsArrivee = dao.getGare(connection, nameGareArrivee);
				while(rsDepart.next())
				{
				    Gare g = new Gare(rsDepart);
				    gares.add(g);
				}
				while(rsArrivee.next())
				{
					Gare g = new Gare(rsArrivee);
					gares.add(g);
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
			if(gares.size()==2){
				String numGareDepart = ""+gares.get(0).getCode_uic();
				String numGareArrivee = ""+gares.get(1).getCode_uic();
				
		//		value= "87393009"   	VERSAILLES CHANTIERS
		//		value= "87393033"		INVALIDES
				
//				request.setAttribute("nameGareDepart", nameGareDepart);
//				request.setAttribute("nameGareArrivee", nameGareArrivee);
//				request.setAttribute("numGareDepart", numGareDepart);
//				request.setAttribute("numGareArrivee", numGareArrivee);
				
				URLConnection yc = connectTo("http://api.transilien.com/gare/"+ numGareDepart + "/depart/"+numGareArrivee+"/");
				
				Document doc;
				yc.connect();
				
				
				try {
					doc = parseXML(yc.getInputStream());
					NodeList descNodesNum = doc.getElementsByTagName("num");
					NodeList descNodesDateDepart = doc.getElementsByTagName("date");
					NodeList descNodesMiss = doc.getElementsByTagName("miss");
					NodeList descNodesTerm = doc.getElementsByTagName("term");
		
					for (int i = 0; i < descNodesNum.getLength(); i++) {
						Train train = new Train();
						train.setNumero(descNodesNum.item(i).getTextContent());
						train.setDateDepart(descNodesDateDepart.item(i).getTextContent());
						train.setMiss(descNodesMiss.item(i).getTextContent());
						train.setTerm(descNodesTerm.item(i).getTextContent());
						trains.add(train);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
								
				
				
			}

		}
		return  trains;


		// reponse HTTP (erreur - success)

//		this.getServletContext()
//				.getRequestDispatcher(disp)
//				.forward(request, response);
	}
		
	
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


public class BddUtility {
	
	String classeNameDriver;
	String user;
	String mdp;
	String jdbc_DB;
	String dataBaseName;
	Connection connection;
	

	public BddUtility(String classeNameDriver, String user, String mdp,
			String jdbc_DB, String dataBaseName, Connection connection) {
		super();
		this.classeNameDriver = classeNameDriver;
		this.user = user;
		this.mdp = mdp;
		this.jdbc_DB = jdbc_DB;
		this.dataBaseName = dataBaseName;
		this.connection = connection;
	}

	public String getClasseNameDriver() {
		return classeNameDriver;
	}

	public void setClasseNameDriver(String classeNameDriver) {
		this.classeNameDriver = classeNameDriver;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getJdbc_DB() {
		return jdbc_DB;
	}

	public void setJdbc_DB(String jdbc_DB) {
		this.jdbc_DB = jdbc_DB;
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void initConnection() {
 
		System.out.println("-------- "+dataBaseName+" JDBC Connection Testing ------------");
	 
		try {
			Class.forName(classeNameDriver);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your "+dataBaseName+" JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println(dataBaseName+" JDBC Driver Registered!");
	
	 
		try {
			connection = DriverManager.getConnection(jdbc_DB,user, mdp);
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	
  }
}
}