package org.example;
import org.example.mercadam.*;

import java.util.*;

public class AppZonaClientes
{
    private static final Mercadam mercadam = new Mercadam();
    private static Cliente cliente = null;

    public static void autentificacion(Set<Cliente> listaClientes)
    {
        String usuario = "";
        String contrasenya = "";
        for(int i = 2; i >= 0; i--)
        {
            System.out.print("Usuario: ");
            usuario = FuncionesComunes.solicitarString();
            System.out.print("Contrasenya: ");
            contrasenya = FuncionesComunes.solicitarString();

            if(listaClientes.contains(new Cliente(usuario, contrasenya))) break;
            else
            {
                System.out.println("Credenciales inválidas. Intentos: "+ i);
                if(i == 0) return;
            }
        }
        cliente = new Cliente(usuario, contrasenya);
    }

    public static void iniciarCompra()
    {
        System.out.println("\n\nCreando nuevo pedido...");
        cliente.crearPedido();
    }

    public static void imprimirProductos()
    {
        for(Producto producto : Producto.values())
            System.out.println(producto.name() +": "+ producto.getPrecio() +"€");
    }

    public static void generarResumen(boolean mostrarOrdenados)
    {
        System.out.println("\n\n === RESUMEN DE TU CARRITO DE LA COMPRA ===");
        List<Map.Entry<Producto, Integer>> carrito = new LinkedList<>(cliente.getPedido().getPedido().entrySet());

        if(mostrarOrdenados)
        {
            System.out.println("Productos ordenados por uds:");
            carrito.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        }
        else System.out.println("Productos:");

        for(Map.Entry<Producto, Integer> producto : carrito)
            System.out.println(producto.getValue() +" "
                    + producto.getKey().name() +" "
                    + producto.getKey().getPrecio() +"€");

        System.out.println("\nIMPORTE TOTAL: "+ cliente.getPedido().getImporteTotal() +"€");
    }

    public static void imprimirDespedida()
    {
        System.out.println("\n\n === GRACIAS POR SU PEDIDO ===");
        System.out.println("Lo recibirá en unos días en la dirección "+ cliente.getDireccion() +".");
    }

    public static void mostrarOpciones()
    {
        System.out.println(" ======================================");
        System.out.println("¿Qué desea hacer?");
        System.out.println("[1]. Aplicar promos.");
        System.out.println("[2]. Mostrar resumen ordenado por uds.");
        System.out.println("[3]. Terminar pedido.");
    }

    public static void seleccionarOpcion()
    {
        while(true)
        {
            mostrarOpciones();
            switch(FuncionesComunes.solicitudChar())
            {
                case '1':
                    if(cliente.getPromociones())
                        System.out.println("No tienes descuentos disponibles.");
                    else
                    {
                        cliente.aplicarPromociones();
                        generarResumen(false);
                    }
                    break;

                case '2':
                    generarResumen(true);
                    break;

                case '3':
                    return;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    public static void preguntarQuitarProducto()
    {
        System.out.println("¿Quieres eliminar productos (S/N)?");
        if(FuncionesComunes.solicitarSNChar())
        {
            solicitarProducto(true);
        }
    }

    public static void imprimirCarrito()
    {
        for(Map.Entry<Producto, Integer> dato : cliente.getPedido().getPedido().entrySet())
            System.out.println(dato.getKey().name() +": "+ dato.getValue() +" uds.");
    }

    public static void solicitarProducto(boolean activarEliminarProductos)
    {
        Producto producto;
        while(true)
        {
            System.out.println("\n\nElige un producto de la lista...");
            if(activarEliminarProductos) imprimirCarrito();
            else imprimirProductos();
            System.out.print(" ======================================\n> ");
            try
            {
                producto = Producto.valueOf(FuncionesComunes.solicitarString().toUpperCase());
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Producto no reconocido. Elige otro...");
                continue;
            }

            if(activarEliminarProductos)
            {
                try
                {
                    cliente.quitarDelCarrito(producto);
                }
                catch(ProductoNoEnCarritoException e)
                {
                    System.out.println(e.getMessage() +" Elige otro...");
                    continue;
                }
            }
            else cliente.anyadirAlCarrito(producto);

            System.out.println("Has "
                    + (activarEliminarProductos ? "eliminado " : "añadido ")
                    + producto.name() +" con un precio de "+ producto.getPrecio() +"€");
            System.out.println("Importe total del pedido: "+ cliente.getPedido().getImporteTotal() +"€");

            if(activarEliminarProductos && cliente.getPedido().getPedido().isEmpty())
            {
                System.out.println("El carrito está vacío. Saliendo...");
                break;
            }

            System.out.println("¿Queres "
                    + (activarEliminarProductos ? "eliminar" : "añadir")
                    +" más productos (S/N)?");
            if(!FuncionesComunes.solicitarSNChar()) break;
        }
    }

    public static boolean validarInicioSesion()
    {
        if(cliente == null)
        {
            System.out.println("ERROR DE AUTENTIFICACIÓN");
            return false;
        }
        else
        {
            System.out.println("Bienvenido, "+ cliente.getUsuario());
            return true;
        }
    }

    public static void recuperarDatos()
    {
        for(int i = 0; i < 10; i++)
            mercadam.generarClientes();
        System.out.println(mercadam.getListaClientes().size() +" clientes generados:"+ mercadam.getListaClientes());
    }

    static void main()
    {
        recuperarDatos();
        System.out.println("\t === COMPRA ONLINE EN MERCADAM ===");
        autentificacion(mercadam.getListaClientes());

        if(validarInicioSesion())
        {
            iniciarCompra();
            solicitarProducto(false);
            generarResumen(false);
            preguntarQuitarProducto();

            if(cliente.getPedido().getPedido().isEmpty())
            {
                System.out.println("\n\n === PEDIDO CANCELADO ===");
                System.out.println("¡Hasta la próxima!");
            }
            else
            {
                seleccionarOpcion();
                imprimirDespedida();
            }
        }

        System.out.println(cliente);
    }
}
