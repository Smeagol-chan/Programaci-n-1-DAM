package org.example.mercadam;

public class ProductoNoEnCarritoException extends RuntimeException {
    public ProductoNoEnCarritoException() {
        super("El producto no está en el carrito.");
    }
}
