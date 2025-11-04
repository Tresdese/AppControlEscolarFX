package appcontrolescolarfx.modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBaseDatos {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection CONEXION = null;

    private static Properties cargarPropiedades() {
        Properties properties = new Properties();
        // Intentar cargar desde el classpath (por ejemplo, dentro del JAR / resources)
        try {
            java.io.InputStream is = ConexionBaseDatos.class.getClassLoader().getResourceAsStream("config.properties");
            if (is != null) {
                properties.load(is);
                is.close();
                return properties;
            }
        } catch (IOException e) {
            System.err.println("Error cargando config.properties desde classpath: " + e.getMessage());
            e.printStackTrace();
        }

        // Fallback: intentar cargar desde el working directory (archivo externo)
        try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("No se encontró config.properties en el classpath ni en el working directory: " + e.getMessage());
            e.printStackTrace();
        }

        return properties;
    }

    public static Connection abrirConexionBD() {
        Properties properties = cargarPropiedades();
        String urlBase = properties.getProperty("db.url");
        String USUARIO = properties.getProperty("db.user");
        String CONTRASENIA = properties.getProperty("db.password");

        if (urlBase == null || USUARIO == null) {
            System.err.println("Faltan propiedades de conexión en config.properties: db.url o db.user es nulo");
            return null;
        }

        String URL_CONEXION = urlBase + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        try {
            Class.forName(DRIVER);

            if (CONEXION == null || CONEXION.isClosed()) {
                System.out.println("Intentando conectar a: " + URL_CONEXION + " como usuario='" + USUARIO + "'");
                CONEXION = DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRASENIA);
                System.out.println("Conexión establecida correctamente.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC no encontrado: " + DRIVER + " -> " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }

        return CONEXION;
    }

    public static void cerrarConexionBD() {
        try {
            if (CONEXION != null && !CONEXION.isClosed()) {
                CONEXION.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CONEXION = null;
        }
    }
}
