package appcontrolescolarfx.modelo.pojo;

public class Alumno {
    private int idAlumno;
    private String matricula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private int idCarrera;
    private String nombreCarrera;
    private int idFacultad;
    private String nombreFacultad;
    private String fechaNacimiento;
    private byte[] foto; 
    
    public Alumno() {
        this.idAlumno = 0;
        this.matricula = "";
        this.nombre = "";
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.correo = "";
        this.idCarrera = 0;
        this.nombreCarrera = "";
        this.idFacultad = 0;
        this.nombreFacultad = "";
        this.fechaNacimiento = "";
        this.foto = null;
    }

    public Alumno(int idAlumno, String matricula, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, int idCarrera, String nombreCarrera, int idFacultad, String nombreFacultad, String fechaNacimiento, byte[] foto) {
        this.idAlumno = idAlumno;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.idFacultad = idFacultad;
        this.nombreFacultad = nombreFacultad;
        this.fechaNacimiento = fechaNacimiento;
        this.foto = foto;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
