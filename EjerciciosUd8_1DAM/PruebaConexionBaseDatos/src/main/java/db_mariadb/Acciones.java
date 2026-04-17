package db_mariadb;

import java.sql.*;
import java.util.Iterator;

public class Acciones
{
    public static void menuAcciones(Connection conexion)
    {
        cargarLista(conexion);

        consulta();
        System.out.println();

        insertar(conexion);
        consulta();
        System.out.println();

        modificar(conexion);
        consulta();
        System.out.println();

        borrar(conexion);
        consulta();
        System.out.println();
    }

    private static void cargarLista(Connection conexion)
    {
        String query = "SELECT * FROM estudiante";
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
                Date fecha_nacimiento = respuesta.getDate("FechaNacimiento");
                ListaEstudiantes.insertarEstudiante(new Estudiante(nia, nombre, fecha_nacimiento));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void consulta()
    {
        Iterator<Estudiante> estudianteIterator = ListaEstudiantes.getListaEstudiantes().iterator();
        Estudiante estudiante;

        while(estudianteIterator.hasNext())
        {
            estudiante = estudianteIterator.next();

            String nia = estudiante.getNia();
            String nombre = estudiante.getNombre();
            java.util.Date fechaNacimiento = estudiante.getFechaNacimiento();
            System.out.println("NIA: " + nia + " - Nombre: " + nombre + " - Fecha de nacimiento: " + fechaNacimiento);
        }
    }

    private static void insertar(Connection conexion)
    {
        System.out.println("Insertando...");
        String nia = "009009123", nombre = "Luisa", fecha_nacimiento = "2013-12-02";

        String query = "INSERT INTO estudiante (NIA, Nombre, FechaNacimiento) VALUES ('009009123', 'Luisa', '2013-12-02')";
        Statement stmt;

        try
        {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void modificar(Connection conexion)
    {
        System.out.println("Modificando...");

        String query = "UPDATE estudiante SET Nombre = 'Patri' WHERE NIA = 009009123";
        Statement stmt;

        try
        {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void borrar(Connection conexion)
    {
        System.out.println("Borrando...");

        String query = "DELETE FROM estudiante WHERE Nombre = 'Luisa' OR Nombre = 'Patri'";
        Statement stmt;

        try
        {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
