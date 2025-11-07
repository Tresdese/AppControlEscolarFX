package appcontrolescolarfx.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLAdminAlumnoController implements Initializable {

    @FXML
    private TextField searchTextField;
    @FXML
    private Button registerStudentButton;
    @FXML
    private Button editStudentButton;
    @FXML
    private Button deleteStudentButton;
    @FXML
    private Button exportStudentButton;
    @FXML
    private TableView<?> studentTableView;
    @FXML
    private TableColumn<?, ?> tuitionTableColumn;
    @FXML
    private TableColumn<?, ?> nameTableColumn;
    @FXML
    private TableColumn<?, ?> dadLastnameTableColumn;
    @FXML
    private TableColumn<?, ?> momLastnameTableColumn;
    @FXML
    private TableColumn<?, ?> carreraTableColumn;
    @FXML
    private TableColumn<?, ?> facultadTableColumn;
    @FXML
    private TableColumn<?, ?> birthDateTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleRegisterStudentButton(ActionEvent event) {
        irFormularioRegistroAlumno();
    }

    @FXML
    private void handleEditStudentButton(ActionEvent event) {
    }

    @FXML
    private void handleDeleteStudentButton(ActionEvent event) {
    }

    @FXML
    private void handleExportStudentButton(ActionEvent event) {
    }

    private void irFormularioRegistroAlumno() {
        // Lógica para ir al formulario de registro de alumno
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/appcontrolescolarfx/vista/FXMLRegistroAlumno.fxml"));

            Parent vista = loader.load();
            Scene escena = new Scene(vista);
            Stage escenario = new Stage();

            escenario.setTitle("Registro de Alumno");
            escenario.setScene(escena);
            escenario.initModality(Modality.APPLICATION_MODAL);
            escenario.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
