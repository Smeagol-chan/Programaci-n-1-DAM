package org.example.pruebaconexionbasedatos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    private static Scene scene;

    private static Parent loadFXML(String fxml) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setRoot(String fxml) throws IOException
    {
        scene.setRoot(loadFXML(fxml));
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        final String VENTANA_INICIAL = "hello-view";
        final String NOMBRE_VENTANA = "Hello!";

        scene = new Scene(loadFXML(VENTANA_INICIAL), 320, 500);
        stage.setTitle(NOMBRE_VENTANA);
        stage.setScene(scene);
        stage.show();
    }
}