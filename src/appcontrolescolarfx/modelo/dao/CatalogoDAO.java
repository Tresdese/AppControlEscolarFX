package appcontrolescolarfx.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogoDAO {
    public static ResultSet obtenerRoles(Connection conexionBD) throws SQLException {
        if(conexionBD != null) {
            String consulta = "SELECT * FROM rol";
            PreparedStatement sentencia = conexionBD.prepareStatement(consulta);
            return sentencia.executeQuery();
        }
        
        throw new SQLException("No hay conexión a la base de datos");
    }
    
    public static ResultSet obtenerFacultades(Connection conexionBD) throws SQLException {
        if(conexionBD != null) {
            String consulta = "SELECT * FROM facultad";
            PreparedStatement sentencia = conexionBD.prepareStatement(consulta);
            return sentencia.executeQuery();
        }
        
        throw new SQLException("No hay conexión a la base de datos");
    }
    
    public static ResultSet obtenerCarreras(Connection conexionBD) throws SQLException {
        if(conexionBD != null) {
            String consulta = "SELECT * FROM carrera";
            PreparedStatement sentencia = conexionBD.prepareStatement(consulta);
            return sentencia.executeQuery();
        }
        
        throw new SQLException("No hay conexión a la base de datos");
    }
    
    public static ResultSet obtenerCarrerasPorFacultad(Connection conexionBD, int idFacultad) throws SQLException {
        if(conexionBD != null) {
            String consulta = "SELECT * FROM carrera WHERE idFacultad = ?";
            PreparedStatement sentencia = conexionBD.prepareStatement(consulta);
            sentencia.setInt(1, idFacultad);
            return sentencia.executeQuery();
        }
        
        throw new SQLException("No hay conexión a la base de datos");
    }
}