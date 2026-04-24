package org.example.practica2;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.time.LocalDate;

public class EstudiantesController
{
    static Connection connection;

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
    private Button insertarButton;

    @FXML
    private Button guardarButton;

    @FXML
    private void initialize()
    {
        connection = Datos.conexion();

        niaTableColumn.setCellValueFactory(dato -> new SimpleStringProperty(dato.getValue().getNia()));
        nombreTableColumn.setCellValueFactory(dato -> new SimpleStringProperty(dato.getValue().getNombre()));
        fechaNacimientoTableColumn.setCellValueFactory(dato -> new ReadOnlyObjectWrapper<>(dato.getValue().getFechaNacimiento()));

        tablaTableView.setItems(Datos.consulta(connection));
    }

    public void onInsertarButtonClick()
    {
        String nia = niaTextField.getText();
        String nombre = nombreTextField.getText();
        LocalDate fechaNacimiento = fechaNacimientoDatePicker.getValue();

        if(nia == null || nombre == null || fechaNacimiento == null)
        {
            notificacionLabel.setText("Rellene todos los campos");
        }
        else if(!nia.matches("^[0-9]{8}$"))
        {
            notificacionLabel.setText("NIA inválido: Ha de ser una cadena de 8 dígitos (12345678)");
            niaTextField.clear();
        }
        else
        {
            notificacionLabel.setText("Estudiante insertado");
            tablaTableView.setItems(Datos.insertar(connection, new Estudiante(nia, nombre, fechaNacimiento)));
            limpiarCampos();
        }
    }

    public void onEditarButtonClick()
    {
        Estudiante estudiante = tablaTableView.getSelectionModel().getSelectedItem();

        if(estudiante != null)
        {
            insertarButton.setDisable(true);
            guardarButton.setDisable(false);
            niaTextField.setText(estudiante.getNia());
            nombreTextField.setText(estudiante.getNombre());
            fechaNacimientoDatePicker.setValue(estudiante.getFechaNacimiento());
        }
        else notificacionLabel.setText("No hay estudiante seleccionado");
    }

    public void onEliminarButtonClick()
    {
        Estudiante estudiante = tablaTableView.getSelectionModel().getSelectedItem();

        if(estudiante != null)
        {
            tablaTableView.setItems(Datos.eliminar(connection, estudiante.getNia()));
            notificacionLabel.setText("Estudiante eliminado");
        }
        else notificacionLabel.setText("No hay estudiante seleccionado");
    }

    public void onGuardarButtonClick()
    {
        String nia = niaTextField.getText();
        String nombre = nombreTextField.getText();
        LocalDate fechaNacimiento = fechaNacimientoDatePicker.getValue();

        if(nia == null || nombre == null || fechaNacimiento == null)
        {
            notificacionLabel.setText("Rellene todos los campos");
        }
        else if(!nia.matches("^[0-9]{8}$"))
        {
            notificacionLabel.setText("NIA inválido: Ha de ser una cadena de 8 dígitos (12345678)");
            niaTextField.clear();
        }
        else
        {
            tablaTableView.setItems(Datos.modificar(connection, new Estudiante(nia, nombre, fechaNacimiento)));
            notificacionLabel.setText("Estudiante modificado");
            guardarButton.setDisable(true);
            insertarButton.setDisable(false);
            limpiarCampos();
        }
    }

    public void limpiarCampos()
    {
        niaTextField.clear();
        nombreTextField.clear();
        fechaNacimientoDatePicker.getEditor().clear();
    }
}
