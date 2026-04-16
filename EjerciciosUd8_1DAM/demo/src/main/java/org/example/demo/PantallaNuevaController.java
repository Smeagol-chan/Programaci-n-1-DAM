package org.example.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PantallaNuevaController
{
    @FXML
    private TableView<Persona> personasTableView;

    @FXML
    private TableColumn<Persona, String> nombreTableColumn;

    @FXML
    private TableColumn<Persona, Integer> edadTableColumn;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField edadTextField;

    @FXML
    private void initialize()
    {
        nombreTableColumn.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        edadTableColumn.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getEdad()).asObject());
        personasTableView.setItems(DatosPersonas.getListaPersonas());
    }

    public void volverClickButton() throws IOException
    {
        HelloApplication.setRoot("hello-view");
    }

    public void onGuardarDatos()
    {
        DatosPersonas.insertarPersona(new Persona(nombreTextField.getText(), Integer.parseInt(edadTextField.getText())));
        limpiarCampos();
    }

    public void limpiarCampos()
    {
        nombreTextField.clear();
        edadTextField.clear();
    }
}
