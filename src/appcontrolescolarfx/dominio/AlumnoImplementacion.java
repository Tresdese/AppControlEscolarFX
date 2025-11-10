package appcontrolescolarfx.dominio;

import appcontrolescolarfx.modelo.ConexionBaseDatos;
import appcontrolescolarfx.modelo.dao.AlumnoDAO;
import appcontrolescolarfx.modelo.pojo.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AlumnoImplementacion {
    public static HashMap<String,Object> obtenerAlumnos(){
        HashMap<String,Object> respuesta = new LinkedHashMap<>();

        try{
            ResultSet resultado = AlumnoDAO.obtenerAlumnos(ConexionBaseDatos.abrirConexionBD());

            ArrayList<Alumno> alumnosBaseDatos = new ArrayList<>();
            while(resultado.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(resultado.getInt("idAlumno"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setApellidoPaterno(resultado.getString("apellidoPaterno"));
                alumno.setApellidoMaterno(resultado.getString("apellidoMaterno"));
                alumno.setMatricula(resultado.getString("matricula"));
                alumno.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                try {
                    alumno.setIdCarrera(resultado.getInt("idCarrera"));
                } catch (Exception ex) {
                    // dejar idCarrera por defecto si no existe
                }
                // Solo leer la columna 'carrera' si está presente en el ResultSet
                try {
                    java.sql.ResultSetMetaData md = resultado.getMetaData();
                    boolean tieneCarrera = false;
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        if ("carrera".equalsIgnoreCase(md.getColumnName(i))) {
                            tieneCarrera = true;
                            break;
                        }
                    }
                    if (tieneCarrera) {
                        alumno.setCarrera(resultado.getString("carrera"));
                    }
                } catch (Exception ex) {
                    // ignorar y no establecer carrera
                }

                alumnosBaseDatos.add(alumno);
            }

            respuesta.put("error", false);
            respuesta.put("alumnos", alumnosBaseDatos);

            ConexionBaseDatos.cerrarConexionBD();
        } catch (SQLException e){
            respuesta.put("error", true);
            respuesta.put("mensaje", e.getMessage());
        }

        return respuesta;
    }
}
