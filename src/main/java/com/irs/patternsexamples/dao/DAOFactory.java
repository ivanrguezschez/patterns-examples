package com.irs.patternsexamples.dao;

import com.irs.patternsexamples.dao.derby.DerbyDAOFactory;
import com.irs.patternsexamples.dao.h2.H2DAOFactory;
import com.irs.patternsexamples.dao.mysql.MySqlDAOFactory;
import com.irs.patternsexamples.dao.oracle.OracleDAOFactory;
import com.irs.patternsexamples.dao.xml.XmlDAOFactory;

/**
 * Clase Padre Abstracta del Patron Data Access Object (DAO).
 *
 * @author IRS
 * @version 1.0.0
 */
public abstract class DAOFactory {
    
    /** Constante que indica que la fuente de datos es una base de datos H2. */
    public static final int H2 = 1;
    
    /** Constante que indica que la fuente de datos es una base de datos DERBY. */
    public final static int DERBY = 2;
    
    /** Constante que indica que la fuente de datos es una base de datos MYSQL. */
    public final static int MYSQL = 3;
    
    /** Constante que indica que la fuente de datos es una base de datos ORACLE. */
    public final static int ORACLE = 4;
    
    /** Constante que indica que la fuente de datos es un archivo XML. */
    public static final int XML = 5;
    
    /** Nombre del parametro que almacena el driver a la BB.DD. */
    protected final static String PARAM_DB_DRIVER = "db.driver";

    /** Nombre del parametro que almacena la url a la BB.DD. */
    protected final static String PARAM_DB_URL = "db.url";

    /** Nombre del parametro que almacena el nombre del usuario. */
    protected final static String PARAM_DB_USER = "db.user";

    /** Nombre del parametro que almacena la password del usuario. */
    protected final static String PARAM_DB_PWD = "db.pwd";

    /** Nombre del parametro que almacena el nombre JNDI del DataSsource. */
    protected final static String PARAM_DB_DATASOURCE = "db.datasource";
    
    /**
     * Objeto que almacena los parámetros de configuración de las diferentes
     * fuente de datos empleadas.
     */
    protected static DAOConfig config;
    static {
    	/*
        Una posilibidad es cargar inicialmente todos los archivos de propiedades
        que use el DAO, la otra es que cada tipo de Factory (H2, MySQL, Oracle, etc)
        carge los suyos, pero la variable config estaria aqui, la clase padre.
        Cargar Inicialemente todos aqui:
        DAOConfig config = DAOConfig.getInstance();
        config.add("mysql", "resources/mysql.properties");
	config.add("oracle", "resources/oracle.properties");
        config.add("mysql-provincias", "resources/mysql-provincias.properties");
        config.add("oracle-provincias", "resources/oracle-provincias.properties");
        */
	//System.out.println("Se carga el fichero de properties");
	//config = DAOConfig.getInstance("h2", "resources/h2.properties");
        
        config = DAOConfig.getInstance();
    } 
       
    /**
     * Metodo que devuelve el objeto de configuración que almacena los parámetros 
     * de configuración de las diferentes fuente de datos empleadas.
     * 
     * @return El objeto de configuración.
     */
    public static DAOConfig getConfig() {
        return config;
    }
      
    /**
     * Método que devuelve el tipo de Factoria de Objetos de Acceso a Datos de la fuente indicada.
     * 
     * @param type Tipo de factoria a obtener.
     * @return El tipo de factoria indicada.
     */
    public static DAOFactory getDAOFactory(final int type) {
        switch (type) {
            case DAOFactory.H2:
            	return new H2DAOFactory();
            case DAOFactory.DERBY:
            	return new DerbyDAOFactory();
            case DAOFactory.MYSQL:
            	return new MySqlDAOFactory();
            case DAOFactory.ORACLE:
                return new OracleDAOFactory();
            case DAOFactory.XML:
                return new XmlDAOFactory();
            default:
            	return null;
    	}
    }

    /**
     * Metodo abstracto que devuelve el DAO de Provincias especifico del tipo de
     * factoria de fuente de datos empleada.
     * 
     * @return El DAO de Provincias especifico del tipo de factoria empleada.
     */
    public abstract DAOProvincia getDAOProvincia();
}
