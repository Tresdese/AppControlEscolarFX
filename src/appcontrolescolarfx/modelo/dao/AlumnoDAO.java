package appcontrolescolarfx.modelo.dao;

import appcontrolescolarfx.modelo.pojo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoDAO {
	public static ResultSet obtenerAlumnos(Connection conexionBaseDatos) throws SQLException {
		if (conexionBaseDatos == null) {
			throw new SQLException("No hay conexión a la base de datos.");
		}

		// Intentamos varias variantes de la consulta para adaptarnos a esquemas distintos de la tabla 'carrera'
		String[] consultas = new String[] {
				// Variante 1: columna 'nombre' en tabla carrera
				"SELECT a.idAlumno, a.nombre, a.apellidoPaterno, a.apellidoMaterno, "
				+ "a.matricula, a.fechaNacimiento, a.idCarrera, c.nombre AS carrera "
				+ "FROM alumno a LEFT JOIN carrera c ON c.idCarrera = a.idCarrera;",
                
				"SELECT a.idAlumno, a.nombre, a.apellidoPaterno, a.apellidoMaterno, "
				+ "a.matricula, a.fechaNacimiento, a.idCarrera, c.carrera AS carrera "
				+ "FROM alumno a LEFT JOIN carrera c ON c.idCarrera = a.idCarrera;",

				"SELECT a.idAlumno, a.nombre, a.apellidoPaterno, a.apellidoMaterno, "
				+ "a.matricula, a.fechaNacimiento, a.idCarrera "
				+ "FROM alumno a;"
		};

		SQLException lastException = null;
		for (String consulta : consultas) {
			try {
				PreparedStatement sentencia = conexionBaseDatos.prepareStatement(consulta);
				return sentencia.executeQuery();
			} catch (SQLException e) {
				// Guardar excepción y probar la siguiente variante
				lastException = e;
			}
		}

		// Si ninguna variante funcionó, lanzar la última excepción para diagnóstico
		throw lastException != null ? lastException : new SQLException("Error al preparar la consulta de alumnos");
	}

	public static int registrarAlumno(Alumno alumno, Connection conexionBaseDatos) throws SQLException {
		if(conexionBaseDatos != null) {
			String insercion = "INSERT INTO alumno (idCarrera, nombre, apellidoPaterno, apellidoMaterno, "
					+ "matricula, correo, fechaNacimiento) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement sentencia = conexionBaseDatos.prepareStatement(insercion);
			sentencia.setInt(1, alumno.getIdCarrera());
			sentencia.setString(2, alumno.getNombre());
			sentencia.setString(3, alumno.getApellidoPaterno());
			sentencia.setString(4, alumno.getApellidoMaterno());
			sentencia.setString(5, alumno.getMatricula());
			sentencia.setString(6, alumno.getCorreo());
			sentencia.setString(7, alumno.getFechaNacimiento());
			return sentencia.executeUpdate();
		}

		throw new SQLException("No hay conexión a la base de datos");
	}

	public static int editarAlumno(Alumno alumno, Connection conexionBaseDatos) throws SQLException {
		if(conexionBaseDatos != null) {
			String consulta = "UPDATE alumno SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, "
					+ "correo = ?, fechaNacimiento = ?, idCarrera = ? "
					+ "WHERE idAlumno = ?";
			PreparedStatement sentencia = conexionBaseDatos.prepareStatement(consulta);
			sentencia.setString(1, alumno.getNombre());
			sentencia.setString(2, alumno.getApellidoPaterno());
			sentencia.setString(3, alumno.getApellidoMaterno());
			sentencia.setString(4, alumno.getCorreo());
			sentencia.setString(5, alumno.getFechaNacimiento());
			sentencia.setInt(6, alumno.getIdCarrera());
			sentencia.setInt(7, alumno.getIdAlumno());
			return sentencia.executeUpdate();
		}

		throw new SQLException("No hay conexión a la base de datos.");
	}

	public static int eliminarAlumno(int idAlumno, Connection conexionBaseDatos) throws SQLException {
		if(conexionBaseDatos != null) {
			String eliminacion = "DELETE FROM alumno WHERE idAlumno = ?";
			PreparedStatement sentencia = conexionBaseDatos.prepareStatement(eliminacion);
			sentencia.setInt(1, idAlumno);
			return sentencia.executeUpdate();
		}

		throw new SQLException("No hay conexión a la base de datos.");
	}
}
