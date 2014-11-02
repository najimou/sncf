package fr.upmc.mappings;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

public class MappedJsp {
	
	
	public static String ROOT					= "";
	public static String HOME_JSP 				= "/index.jsp";
	public static String HOME					= ROOT+"/index.jsp";
	
	public static String CREATE_ACCOUNT 		= ROOT+"/CreateCompte";
	public static String CREATE_ACCOUNT_JSP 	= "/WEB-INF/jsp/createCompte.jsp";	
	
	public static String UPDATE_ACCOUNT 		= ROOT+"/UpdateCompte";
	public static String UPDATE_ACCOUNT_JSP 	= "/WEB-INF/jsp/updateCompte.jsp";
	
	public static String ACCOUNT				= ROOT+"/Account";
	public static String ACCOUNT_JSP			= "/WEB-INF/jsp/compte.jsp";
	
	public static String LOGIN					= ROOT+"/Login";
	public static String LOGIN_JSP 				= "/WEB-INF/jsp/login.jsp";
	
	public static String LOGOUT					= ROOT+"/Logout";
	
	public static String ERROR					= "/error.jsp";
	
	public static String SEND_PASSWORD			= ROOT+"/SendPassword";
	public static String SEND_PASSWORD_JSP		= "/WEB-INF/jsp/sendPassword.jsp";
	
	public static String RENSEIGNER_VOYAGE 		= ROOT+"/RenseignerVoyage";
	public static String RENSEIGNER_VOYAGE_JSP	= "/WEB-INF/jsp/renseignerVoyage.jsp";
	
	public static String LISTE_VOYAGES 			= ROOT+"/ListeVoyages";
	public static String LISTE_VOYAGES_JSP		= "/WEB-INF/jsp/listeVoyages.jsp";
	
	public static String LISTE_TRANSPORTS 		= ROOT+"/ListeTransports";
	public static String LISTE_TRANSPORTS_JSP	= "/WEB-INF/jsp/listeTransports.jsp";
	
	public static final String CREATE_TRANSPORT 	= ROOT+"/CreerEnvoi";
	public static final String CREATE_TRANSPORT_JSP	= "/WEB-INF/jsp/creerEnvoi.jsp";
	
	public static final String VENDEUR_SELECTIONNE_TRAIN 		= ROOT+"/SelectionTrain";
	public static final String VENDEUR_SELECTIONNE_TRAIN_JSP 	= "/WEB-INF/jsp/selectionTrain.jsp";
	
	public static final String CHOIX_VOYAGE_RECEVEUR			= ROOT+"/SelectionVoyage";
	public static final String CHOIX_VOYAGE_RECEVEUR_JSP		= "/WEB-INF/jsp/selectionVoyage.jsp";
	
}
