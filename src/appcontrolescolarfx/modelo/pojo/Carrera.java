package appcontrolescolarfx.modelo.pojo;

public class Carrera {
    private int idFacultad;
    private int idCarrera;
    private String carrera;

    public Carrera() {
    }

    public Carrera(int idFacultad, int idCarrera, String carrera) {
        this.idFacultad = idFacultad;
        this.idCarrera = idCarrera;
        this.carrera = carrera;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public String toString() {
        return carrera;
    }
}
