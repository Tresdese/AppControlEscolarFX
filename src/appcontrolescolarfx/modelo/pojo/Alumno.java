package appcontrolescolarfx.modelo.pojo;

public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String matricula;
    private String correo;
    private int idCarrera;
    private String carrera;
    private int idFacultad;
    private String facultad;
    private byte[] foto;

    public Alumno() {
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
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

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getIdAlumno() {
        return idAlumno;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public String getFacultad() {
        return facultad;
    }

    public byte[] getFoto() {
        return foto;
    }
}
