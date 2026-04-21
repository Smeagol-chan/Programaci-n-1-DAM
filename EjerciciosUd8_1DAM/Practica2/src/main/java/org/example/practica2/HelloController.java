package org.example.practica2;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class HelloController
{
    @FXML
    private Label notificacionLabel;

    @FXML
    private TableView<Estudiante> tablaTableView;

    @FXML
    private TableColumn<Estudiante, String> niaTableColumn;

    @FXML
    private TableColumn<Estudiante, String> nombreTableColumn;

    @FXML
    private TableColumn<Estudiante, LocalDate> fechaNacimientoTableColumn;

    @FXML
    private TextField niaTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private DatePicker fechaNacimientoDatePicker;

    @FXML
    private void initialize()
    {

    }

    public void guardarButtonClick()
    {
        EstudiantesAlmacenados.insertStudent(new Estudiante(niaTextField.getText(), nombreTextField.getText(), fechaNacimientoDatePicker.getValue()));

    }

    public void limpiarCampos()
    {
        niaTextField.clear();
        nombreTextField.clear();
        fechaNacimientoDatePicker.getEditor().clear();
    }
}
