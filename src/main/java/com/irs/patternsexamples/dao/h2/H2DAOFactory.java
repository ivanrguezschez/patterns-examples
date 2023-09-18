package com.irs.patternsexamples.dao.h2;

import com.irs.patternsexamples.dao.DAOFactory;
import com.irs.patternsexamples.dao.DAOProvincia;
import com.irs.patternsexamples.dao.exceptions.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase del Patron Data Access Object (DAO) que representa una factoria de una
 * fuente de datos H2.
 *
 * @author IRS
 * @version 1.0.0
 */
public class H2DAOFactory extends DAOFactory {

    /*
    // Para el caso de abrir conexiones directas
    public final static String DB_DRIVER = "org.h2.Driver";
    public final static String DB_URL = "jdbc:h2:mem:testdb";
    public final static String DB_USER = "sa";
    public final static String DB_PWD = "password";
    
    // Para el caso de usar un pool con DataSource
    private static String DB_DATASOURCE = "java:comp/env/jdbc/NombreDataSource";
    */
    
    /** Clave del archivo de configuracion para la fuente de datos H2. */
    public final static String H2_CONFIG_KEY = "h2";
           
    // Cargo el archivo de parámetros para la fuente de datos de H2
    static {
        try {
            //config = DAOConfig.getInstance(H2DAOFactory.H2_CONFIG_KEY, "resources/h2.properties");
            config.add(H2DAOFactory.H2_CONFIG_KEY, "h2.properties");
        } catch (DAOException e) {
            e.fillInStackTrace();
        }
    }    
    
    /**
     * Método que crea una conexión a la fuente de datos H2.
     * 
     * @return Una conexion a la fuente de datos H2.
     * 
     * @throws DAOException si se produce algun error en la creación de la conexión.
     */
    public static Connection createConnection() throws DAOException {
        /*
        // Obtener la conexion directamente
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_URL, DB_PWD);
        } catch (ClassNotFoundException e) {
            throw new DAOException("Controlador JDBC no encontrado: " + e.getMessage(), e);
        } catch (SQLException e) {
            throw new DAOException("Error obteniendo conexion a BD: " + e.getMessage(), e);
        }
        */
        
        /*
        // Obtener la conexion mediante DataSource
        try {
            InitialContext ic = new InitialContext();
            DataSource datasource = (DataSource)ic.lookup(DB_DATASOURCE);
            return datasource.getConnection();
        } catch (NamingException e) {
            throw new DAOException("Nombre de la fuente de datos " + DB_DATASOURCE + " no encontrado: " + e.getMessage(), e);
        } catch (SQLException e) {
            throw new DAOException("Error obteniendo conexion a BD: " + e.getMessage(), e);
        }
        */
        
        // Obtener la conexion directamente
        try {
            //System.out.println(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOFactory.PARAM_DB_DRIVER));
            //System.out.println(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOFactory.PARAM_DB_URL));
            //System.out.println(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOFactory.PARAM_DB_USER));
            //System.out.println(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOFactory.PARAM_DB_PWD));

            Class.forName(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOFactory.PARAM_DB_DRIVER));
            return DriverManager.getConnection(
                    config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOFactory.PARAM_DB_URL),
                   config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOFactory.PARAM_DB_USER),
		config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOFactory.PARAM_DB_PWD));
        } catch (ClassNotFoundException e) {
            throw new DAOException("Controlador JDBC no encontrado: " + e.getMessage(), e);
        } catch (SQLException e) {
            throw new DAOException("Error obteniendo conexion a BD: " + e.getMessage(), e);
        }
    }
    
    @Override
    public DAOProvincia getDAOProvincia() {
         return new H2DAOProvincia(config);
    }
}

