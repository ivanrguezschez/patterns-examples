package com.irs.patternsexamples.dao.exceptions;

/**
 * Clase Excepcion que controla las excepciones de las claves secundarias cuando
 * se accede a la base de datos.
 *
 * @author IRS
 * @version 1.0.0
 */
public class ForeignKeyException extends DAOException {
    
    /**
     * Contructor.
     * 
     * @param mensaje Mensaje de la excepcion.
     */
    public ForeignKeyException(String mensaje) {
        super(mensaje);
    }
}
