package appcontrolescolarfx.dominio;

import appcontrolescolarfx.modelo.ConexionBaseDatos;
import appcontrolescolarfx.modelo.dao.CatalogoDAO;
import appcontrolescolarfx.modelo.pojo.Rol;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CatalogoImplementacion {
    public static HashMap<String,Object> obtenerRolesProfesor() {
        HashMap<String,Object> respuesta = new LinkedHashMap<>();
        
        try {
            ResultSet resultado = CatalogoDAO.obtenerRoles(ConexionBaseDatos.abrirConexionBD());
            List<Rol> rolesBaseDatos = new ArrayList<>();
            
            while(resultado.next()) {
                Rol rol = new Rol();
                rol.setIdRol(resultado.getInt("idRol"));
                rol.setRol(resultado.getString("rol"));
                rolesBaseDatos.add(rol);
            }
            
            ConexionBaseDatos.cerrarConexionBD();
            respuesta.put("error", false);
            respuesta.put("roles", rolesBaseDatos);
        } catch (SQLException e){
            respuesta.put("error", true);
            respuesta.put("mensaje", e.getMessage());
        }
        
        return respuesta;
    }
}
