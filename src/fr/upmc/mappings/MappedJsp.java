package fr.upmc.mappings;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/

public class MappedJsp {
	
	
	public static String ROOT					= "/DAR_UPMC";
	public static String HOME					= ROOT+"/index.jsp";
	
	public static String CREATE_ACCOUNT 		= "/DAR_UPMC/CreateCompte";
	public static String CREATE_ACCOUNT_JSP 	= "/WEB-INF/jsp/createCompte.jsp";	
	
	public static String UPDATE_ACCOUNT 		= "/DAR_UPMC/UpdateCompte";
	public static String UPDATE_ACCOUNT_JSP 	= "/WEB-INF/jsp/updateCompte.jsp";
	
	public static String ACCOUNT				= "/DAR_UPMC/Account";
	public static String ACCOUNT_JSP			= "/WEB-INF/jsp/compte.jsp";
	
	public static String LOGIN					= "/DAR_UPMC/Login";
	public static String LOGIN_JSP 				= "/WEB-INF/jsp/login.jsp";
	
	public static String LOGOUT					= "/DAR_UPMC/Logout";
	
	public static String ERROR					= "/error.jsp";
	
	public static String SEND_PASSWORD			= "/DAR_UPMC/SendPassword";
	public static String SEND_PASSWORD_JSP		= "/WEB-INF/jsp/sendPassword.jsp";
	
	public static String RENSEIGNER_VOYAGE 		= "/DAR_UPMC/RenseignerVoyage";
	public static String RENSEIGNER_VOYAGE_JSP	= "/WEB-INF/jsp/renseignerVoyage.jsp";
	
	public static String LISTE_VOYAGES 			= "/DAR_UPMC/ListeVoyages";
	public static String LISTE_VOYAGES_JSP		= "/WEB-INF/jsp/listeVoyages.jsp";
	
	public static String LISTE_TRANSPORTS 		= "/DAR_UPMC/ListeTransports";
	public static String LISTE_TRANSPORTS_JSP	= "/WEB-INF/jsp/listeTransports.jsp";
	
	public static final String CREATE_TRANSPORT 	= "/DAR_UPMC/CreerEnvoi";
	public static final String CREATE_TRANSPORT_JSP	= "/WEB-INF/jsp/creerEnvoi.jsp";
	
}
