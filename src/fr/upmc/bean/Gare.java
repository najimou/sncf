package fr.upmc.bean;



import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gare implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private int code_uic;
	private String libelle_point_d_arret ;
	private String libelle; 
	private String libelle_stif_info_voyageurs ;
	private String libelle_sms_gare ;
	private String nom_gare ;
	private String adresse ;
	private int code_insee_commune ;
	private String commune ;
	private int x_lambert_ii_etendu ;
	private int y_lambert_ii_etendu ;
	private String coord_gps_wgs84 ;
	private int zone_navigo ;
	private int gare_non_sncf ;
	
	
    public Gare(ResultSet rs) throws SQLException
    {
    	code_uic = rs.getInt(1);
    	libelle_point_d_arret = rs.getString(2); 
    	libelle = rs.getString(3);
    	libelle_stif_info_voyageurs = rs.getString(4); 
    	libelle_sms_gare = rs.getString(5); 
    	nom_gare = rs.getString(6); 
    	adresse = rs.getString(7); 
    	code_insee_commune = rs.getInt(8); 
    	commune = rs.getString(9);
    	x_lambert_ii_etendu = rs.getInt(10);
    	y_lambert_ii_etendu = rs.getInt(11);
    	coord_gps_wgs84 = rs.getString(12);
    	zone_navigo = rs.getInt(13);
    	gare_non_sncf = rs.getInt(14);

    }
	
	
	
	
	public Integer getCode_uic() {
		return code_uic;
	}
	public void setCode_uic(Integer code_uic) {
		this.code_uic = code_uic;
	}
	public String getLibelle_point_d_arret() {
		return libelle_point_d_arret;
	}
	public void setLibelle_point_d_arret(String libelle_point_d_arret) {
		this.libelle_point_d_arret = libelle_point_d_arret;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLibelle_stif_info_voyageurs() {
		return libelle_stif_info_voyageurs;
	}
	public void setLibelle_stif_info_voyageurs(String libelle_stif_info_voyageurs) {
		this.libelle_stif_info_voyageurs = libelle_stif_info_voyageurs;
	}
	public String getLibelle_sms_gare() {
		return libelle_sms_gare;
	}
	public void setLibelle_sms_gare(String libelle_sms_gare) {
		this.libelle_sms_gare = libelle_sms_gare;
	}
	public String getNom_gare() {
		return nom_gare;
	}
	public void setNom_gare(String nom_gare) {
		this.nom_gare = nom_gare;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Integer getCode_insee_commune() {
		return code_insee_commune;
	}
	public void setCode_insee_commune(Integer code_insee_commune) {
		this.code_insee_commune = code_insee_commune;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public Integer getX_lambert_ii_etendu() {
		return x_lambert_ii_etendu;
	}
	public void setX_lambert_ii_etendu(Integer x_lambert_ii_etendu) {
		this.x_lambert_ii_etendu = x_lambert_ii_etendu;
	}
	public Integer getY_lambert_ii_etendu() {
		return y_lambert_ii_etendu;
	}
	public void setY_lambert_ii_etendu(Integer y_lambert_ii_etendu) {
		this.y_lambert_ii_etendu = y_lambert_ii_etendu;
	}
	public String getCoord_gps_wgs84() {
		return coord_gps_wgs84;
	}
	public void setCoord_gps_wgs84(String coord_gps_wgs84) {
		this.coord_gps_wgs84 = coord_gps_wgs84;
	}
	public Integer getZone_navigo() {
		return zone_navigo;
	}
	public void setZone_navigo(Integer zone_navigo) {
		this.zone_navigo = zone_navigo;
	}
	public Integer getGare_non_sncf() {
		return gare_non_sncf;
	}
	public void setGare_non_sncf(Integer gare_non_sncf) {
		this.gare_non_sncf = gare_non_sncf;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	


}
