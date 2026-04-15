package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController
{
    Contador contador = new Contador();

    @FXML
    private Label welcomeText;

    @FXML
    private Label contadorLabel;

    @FXML
    private Button pruebaIdButton;

    @FXML
    private Button clickerButton;

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize()
    {
        pruebaIdButton.setOnAction(action -> welcomeText.setText("Esto es una pueba."));
        clickerButton.setOnAction(action -> {
            contador.contar();
            actualizarContador();
        });
    }

    @FXML
    public void reiniciarContadorClickButton()
    {
        contador.setNumero(0);
        actualizarContador();
    }

    public void siguienteClickButton() throws IOException
    {
        HelloApplication.setRoot("pantalla-nueva");
    }

    private void actualizarContador()
    {
        contadorLabel.setText("Clicks: "+ (contador.getNumero()));
    }
}
