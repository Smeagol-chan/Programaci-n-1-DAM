package org.example.practica2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;

public class Datos
{
    private static ObservableList<Estudiante> listadoEstudiantes = FXCollections.observableArrayList();

    public static Connection conexion()
    {
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3310/";
        String user = "root";
        String psw = "";
        String bd = "instituto";

        try
        {
            conexion = DriverManager.getConnection(host+bd,user,psw);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static ObservableList<Estudiante> consulta(Connection conexion)
    {
        String query = "SELECT * FROM estudiante;";

        Statement stmt;
        ResultSet respuesta;

        try
        {
            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while(respuesta.next())
            {
                String nia = respuesta.getString("NIA");
                String nombre = respuesta.getString("Nombre");
                LocalDate fecha_nacimiento = respuesta.getDate("FechaNacimiento").toLocalDate();
                listadoEstudiantes.add(new Estudiante(nia, nombre, fecha_nacimiento));
            }

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listadoEstudiantes;
    }

    public static ObservableList<Estudiante> insertar(Connection connection, Estudiante estudiante)
    {
        String query = "INSERT INTO estudiante VALUES ('"+ estudiante.getNia() +"', '"
                + estudiante.getNombre() +"', '"+ estudiante.getFechaNacimiento() +"');";
        Statement stmt;

        try
        {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listadoEstudiantes;
    }

    public static ObservableList<Estudiante> eliminar(Connection connection, String nia)
    {
        String query = "DELETE FROM estudiante WHERE NIA='"+ nia +"';";
        Statement stmt;

        try
        {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listadoEstudiantes;
    }

    public static ObservableList<Estudiante> modificar(Connection connection, Estudiante estudiante)
    {
        String query = "UPDATE estudiante " +
                "SET Nombre = '"+ estudiante.getNombre() +"', "+
                "FechaNacimiento = '"+ estudiante.getFechaNacimiento() +"'"+
                " WHERE NIA='"+ estudiante.getNia() +"';";
        Statement stmt;

        try
        {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listadoEstudiantes;
    }
}
