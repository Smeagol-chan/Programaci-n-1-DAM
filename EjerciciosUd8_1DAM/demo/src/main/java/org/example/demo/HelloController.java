package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController
{
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
        Contador contador = new Contador();
        pruebaIdButton.setOnAction(action -> welcomeText.setText("Esto es una pueba."));
        clickerButton.setOnAction(action -> {
            contador.contar();
            contadorLabel.setText("Clicks: "+ (contador.getNumero()));
        });
    }

    public void siguienteClickButton()
    {
    }
}
