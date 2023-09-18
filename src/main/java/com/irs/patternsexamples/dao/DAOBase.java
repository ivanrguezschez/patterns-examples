package com.irs.patternsexamples.dao;

import java.sql.Connection;

/**
 * Clase Base del Patron Data Access Object (DAO) de los diferentes DAO 
 * de la capa de persistencia.
 *
 * @author IRS
 * @version 1.0.0
 */
public class DAOBase {
    
    /** Objeto que almacena los parámetros de configuración. */
    protected DAOConfig config;
      
    /** Conexión a la base de datos. */
    protected Connection dbConnection = null;
 
    /**
     * Constructor.
     * 
     * @param config objeto que almacena los parámetros de configuración.
     */
    public DAOBase(DAOConfig config) {
        super();
        this.config = config;
    }
}
