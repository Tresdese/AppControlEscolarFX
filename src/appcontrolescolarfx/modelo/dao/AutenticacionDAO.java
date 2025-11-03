package appcontrolescolarfx.modelo.dao;

import appcontrolescolarfx.modelo.pojo.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutenticacionDAO {
    public static ResultSet autenticarUsuario(String numeroPersonal, String contrasenia, Connection conexionBaseDatos) throws SQLException {
        Profesor profesorSesion = null;
        
        if(conexionBaseDatos != null)  {
            String consulta = "SELECT idProfesor, nombre, " +
                    "apellidoPaterno, apellidoMaterno, numeroPersonal, p.idRol, rol " +
                    "FROM profesor p " +
                    "INNER JOIN rol r ON r.idRol = p.idRol " +
                    "WHERE numeroPersonal = ? AND contrasenia = ?";
            PreparedStatement sentencia = conexionBaseDatos.prepareStatement(consulta);
            sentencia.setString(1, numeroPersonal);
            sentencia.setString(2, contrasenia);
            sentencia.executeQuery();
            ResultSet resultado = sentencia.executeQuery();
            
            return resultado;
        }
        
        throw new SQLException("No hay conexión a la base de datos");
    }
}
