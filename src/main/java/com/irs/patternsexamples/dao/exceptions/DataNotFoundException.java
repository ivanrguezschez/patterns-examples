package com.irs.patternsexamples.dao.exceptions;

/**
 * Clase de Excepcion de DAO lanzada cuando no se encuentran datos en una 
 * consulta contra la base de datos.
 *
 * @author IRS
 * @version 1.0.0
 */
public class DataNotFoundException extends Exception {
    
    /**
     * Construye una nueva instancia de <code>DataNotFoundException</code> vacia.
     */
    public DataNotFoundException() {
        super();
    }
        
    /**
     * Construye una instancia de <code>DataNotFoundException</code> con el 
     * mensaje  especificado del detalle del error.
     * 
     * @param message El mensaje del detalle del error.
     */
    public DataNotFoundException(String message) {
        super(message);
    }
    
     /**
     * Construye una instancia de <code>DataNotFoundException</code> con 
     * la causa del error.
     * 
     * @param cause La causa del error.
     */
    public DataNotFoundException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Construye una instancia de <code>DataNotFoundException</code> con el mensaje 
     * especificado del detalle del error y la causa del mismo.
     * 
     * @param message El mensaje del detalle del error.
     * @param cause La causa del error.
     */
    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
