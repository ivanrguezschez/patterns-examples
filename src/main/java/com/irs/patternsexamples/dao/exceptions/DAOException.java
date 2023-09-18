package com.irs.patternsexamples.dao.exceptions;

/**
 * Clase padre de Excepcion de DAO que almacena el mensaje y la causa de la
 * excepcion que se producen cuando se accede a base de datos mediante los DAO's.
 *
 * @author IRS
 * @version 1.0.0
 */
public class DAOException extends Exception {
    
    /**
     * Construye una nueva instancia de <code>DAOException</code> vacia.
     */
    public DAOException() {
        super();
    }
        
    /**
     * Construye una instancia de <code>DAOException</code> con el mensaje 
     * especificado del detalle del error.
     * 
     * @param message El mensaje del detalle del error.
     */
    public DAOException(String message) {
        super(message);
    }
    
    /**
     * Construye una instancia de <code>DAOException</code> con la causa del error.
     * 
     * @param cause La causa del error.
     */
    public DAOException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Construye una instancia de <code>DAOException</code> con el mensaje 
     * especificado del detalle del error y la causa del mismo.
     * 
     * @param message El mensaje del detalle del error.
     * @param cause La causa del error.
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
