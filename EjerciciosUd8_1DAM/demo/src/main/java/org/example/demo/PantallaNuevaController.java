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
    private static ObservableList<Object> listaPersonal = FXCollections.observableArrayList();

    @FXML
    private TableView<Object> personasTableView;

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
        personasTableView.setItems(listaPersonal);
    }

    public void volverClickButton() throws IOException
    {
        HelloApplication.setRoot("hello-view");
    }

    public void onGuardarDatos()
    {
        String nombre = nombreTextField.getText();
        Integer edad;
        Persona persona;

        try
        {
            edad = Integer.parseInt(edadTextField.getText());
        }
        catch(NumberFormatException e)
        {
            return;
        }

        persona = new Persona(nombre, edad);
        listaPersonal.add(persona);
        limpiarCampos();
    }

    public void limpiarCampos()
    {
        nombreTextField.clear();
        edadTextField.clear();
    }
}
