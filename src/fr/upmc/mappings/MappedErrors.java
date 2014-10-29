package fr.upmc.mappings;

/***********************************************************************
 * @author Nicolas Pigeot
 ***********************************************************************/


public class MappedErrors {
		
		
		
		//SECURITY
		public static String NOT_AUTORIZED 			= "Cette action n'est pas autorise";
		public static String MAIL_DEJA_EXISTANT 	= "Un compte existe deja avec cette adresse mail";
		public static String GENERAL_ERROR 			= "Une erreur est survenu! Contactez l'administrateur du site.";
		public static String DONNEES_INCORRECTES 	= "Les données saisi ne respectent pas les regles de securite du serveur";
		public static String ALREADY_LOGGED_IN 		= "Vous etes deja connecte!";
		
		// INSCRIPTION & RECUPERATION MDP
		public static String NOM_INVALIDE			= "Nom invalide! Minimum 3 characteres";
		public static String PRENOM_INVALIDE		= "Prenom invalide! Minimum 3 characteres";
		public static String MAIL_INVALIDE			= "Le mail n'est pas Valide !";
		public static String PASSWORD_INVALIDE 		= "Le mot de passe doit contenir une majuscule, une lettre minuscule, 8 caracteres minimum et un charactere special!";
		
		// LOGIN
		public static String MAUVAIS_MAIL			= "Ce mail n/'existe pas! Veuillez controler";
		public static String MAUVAIS_PASSWORD		= "Le mot de passe saisi ne correspond pas";
		public static String TROP_DE_TENTATIVES		= "Vous avez tente trop de fois, vous devez attendre 15 minutes";
		public static int NOMBRE_TENTATIVES			= 3;
		
		//UPDATE COMPTE
		public static String AUTHENTIFICATION_REQUIRED	 = "Vous devez etre authentifie pour effectuer cette action";
		public static String PASSWORD_NOT_MATCH			 = "Les deux passwords sont differents";


}
