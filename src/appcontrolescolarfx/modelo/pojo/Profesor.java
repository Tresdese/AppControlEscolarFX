package appcontrolescolarfx.modelo.pojo;

public class Profesor {
    private int idProfesor;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroPersonal;
    private String contrasenia;
    private String fechaNacimiento;
    private String fechaContratacion;
    private int idRol;
    private String rol;

    public Profesor() {
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public int getIdRol() {
        return idRol;
    }

    public String getRol() {
        return rol;
    }
}
