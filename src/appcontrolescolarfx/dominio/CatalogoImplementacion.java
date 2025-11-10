package appcontrolescolarfx.dominio;

import appcontrolescolarfx.modelo.ConexionBaseDatos;
import appcontrolescolarfx.modelo.dao.CatalogoDAO;
import appcontrolescolarfx.modelo.pojo.Carrera;
import appcontrolescolarfx.modelo.pojo.Facultad;
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
    
    public static HashMap<String,Object> obtenerFacultades() {
        HashMap<String,Object> respuesta = new LinkedHashMap<>();
        
        try {
            ResultSet resultado = CatalogoDAO.obtenerFacultades(ConexionBaseDatos.abrirConexionBD());
            List<Facultad> facultadesBaseDatos = new ArrayList<>();
            
            while(resultado.next()) {
                Facultad facultad = new Facultad();
                facultad.setIdFacultad(resultado.getInt("idFacultad"));
                facultad.setFacultad(resultado.getString("facultad")); 
                facultadesBaseDatos.add(facultad);
            }
            
            ConexionBaseDatos.cerrarConexionBD();
            respuesta.put("error", false);
            respuesta.put("facultades", facultadesBaseDatos); 
        } catch (SQLException e){
            respuesta.put("error", true);
            respuesta.put("mensaje", e.getMessage());
        }
        
        return respuesta;
    }
    
    public static HashMap<String,Object> obtenerCarreras() {
        HashMap<String,Object> respuesta = new LinkedHashMap<>();
        
        try {
            ResultSet resultado = CatalogoDAO.obtenerCarreras(ConexionBaseDatos.abrirConexionBD());
            List<Carrera> carrerasBaseDatos = new ArrayList<>();
            
            while(resultado.next()) {
                Carrera carrera = new Carrera();
                carrera.setIdCarrera(resultado.getInt("idCarrera"));
                carrera.setCarrera(resultado.getString("carrera")); 
                carrera.setIdFacultad(resultado.getInt("idFacultad")); 
                carrerasBaseDatos.add(carrera);
            }
            
            ConexionBaseDatos.cerrarConexionBD();
            respuesta.put("error", false);
            respuesta.put("carreras", carrerasBaseDatos); 
        } catch (SQLException e){
            respuesta.put("error", true);
            respuesta.put("mensaje", e.getMessage());
        }
        
        return respuesta;
    }

    public static HashMap<String,Object> obtenerCarrerasPorFacultad(int idFacultad) {
        HashMap<String,Object> respuesta = new LinkedHashMap<>();
        
        try {
            ResultSet resultado = CatalogoDAO.obtenerCarrerasPorFacultad(ConexionBaseDatos.abrirConexionBD(), idFacultad);
            List<Carrera> carrerasBaseDatos = new ArrayList<>();
            
            while(resultado.next()) {
                Carrera carrera = new Carrera();
                carrera.setIdCarrera(resultado.getInt("idCarrera"));
                carrera.setCarrera(resultado.getString("carrera"));
                carrera.setIdFacultad(resultado.getInt("idFacultad"));
                carrerasBaseDatos.add(carrera);
            }
            
            ConexionBaseDatos.cerrarConexionBD();
            respuesta.put("error", false);
            respuesta.put("carreras", carrerasBaseDatos);
            
        } catch (SQLException e){
            respuesta.put("error", true);
            respuesta.put("mensaje", e.getMessage());
        }
        
        return respuesta;
    }
}