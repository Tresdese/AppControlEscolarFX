package appcontrolescolarfx.controlador;

import appcontrolescolarfx.dominio.AlumnoImplementacion;
import appcontrolescolarfx.modelo.pojo.Alumno;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utilidad.Utilidades;

public class FXMLAdministrarAlumnoController implements Initializable {

    @FXML
    private TextField textFieldBuscarAlumno;
    
    @FXML
    private TableView<Alumno> tableViewAlumnos;
    @FXML
    private TableColumn columnMatricula;
    @FXML
    private TableColumn columnApellidoPaterno;
    @FXML
    private TableColumn columnApellidoMaterno;
    @FXML
    private TableColumn columnNombre;
    @FXML
    private TableColumn columnFacultad;
    @FXML
    private TableColumn columnCarrera;
    @FXML
    private TableColumn columnFechaNacimiento;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarInformacion();
    }    

    @FXML
    private void clicIrRegistrarAlumno(ActionEvent event) {
        irFormulario();
    }

    @FXML
    private void clicIrModificarAlumno(ActionEvent event) {
    }

    @FXML
    private void clicIrEliminarAlumno(ActionEvent event) {
    }

    @FXML
    private void clicIrExportar(ActionEvent event) {
    }
    
    private void irFormulario() {
        try {
            FXMLLoader cargador = Utilidades.obtenerVistaMemoria("vista/FXMLFormularioAlumno.fxml");
            Parent vista = cargador.load();
            Scene escena = new Scene(vista);
            Stage escenario = new Stage();
            escenario.setTitle("Formulario alumno");
            escenario.setScene(escena);
            escenario.initModality(Modality.APPLICATION_MODAL);
            escenario.showAndWait();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private ObservableList<Alumno> observableListAlumnos;

    private void configurarTabla(){
        columnMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        columnApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        columnApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        columnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnFacultad.setCellValueFactory(new PropertyValueFactory("carrera"));
        columnCarrera.setCellValueFactory(new PropertyValueFactory("carrera"));
        columnFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
    }

    private void cargarInformacion() {
        HashMap<String,Object> respuesta = AlumnoImplementacion.obtenerAlumnos();
        boolean error = (boolean) respuesta.get("error");
        if(!error) {
            ArrayList<Alumno> alumnosBaseDatos = (ArrayList<Alumno>) respuesta.get("alumnos");
            observableListAlumnos = FXCollections.observableArrayList();
            observableListAlumnos.addAll(alumnosBaseDatos);
            tableViewAlumnos.setItems(observableListAlumnos);
            configurarBusqueda();
        } else {
            Utilidades.mostrarAlertaSimple("Error", " " + respuesta.get("mensaje"), Alert.AlertType.ERROR);
        }
    }

    public void configurarBusqueda() {
        if(observableListAlumnos != null && observableListAlumnos.size() > 0) {
            FilteredList<Alumno> filtradoAlumnos = new FilteredList<>(observableListAlumnos, p->true);
            textFieldBuscarAlumno.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    filtradoAlumnos.setPredicate(alumno -> {
                        if(newValue == null || newValue.isEmpty()) {
                            return true;
                        }

                        String lowerNewValue = newValue.toLowerCase();
                        if(alumno.getNombre() != null && alumno.getNombre().toLowerCase().contains(lowerNewValue)) {
                            return true;
                        }
                        if(alumno.getMatricula() != null && alumno.getMatricula().toLowerCase().contains(lowerNewValue)) {
                            return true;
                        }
                        return false;
                    });
                }
            });

            SortedList<Alumno> sortedAlumno = new SortedList<>(filtradoAlumnos);
            sortedAlumno.comparatorProperty().bind(tableViewAlumnos.comparatorProperty());
            tableViewAlumnos.setItems(sortedAlumno);
        }
    }
}
