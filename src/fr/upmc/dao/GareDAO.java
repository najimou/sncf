package fr.upmc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GareDAO {

	    public ResultSet getGare(Connection connection, String gareName) throws SQLException
	    {
	        String sql = "SELECT * FROM gares WHERE libelle_point_d_arret = \""+gareName+"\"";
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        
	        return rs;
	    }
	}