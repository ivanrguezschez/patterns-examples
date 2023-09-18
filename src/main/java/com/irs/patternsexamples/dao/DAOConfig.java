package com.irs.patternsexamples.dao;

import com.irs.patternsexamples.dao.exceptions.DAOException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Clase que carga los archivos que contienen los parametros de configuración y 
 * sentencias sql empleados por los DAO's de la fuente de datos especificada.
 * 
 * Implementa el patron Singlenton.
 *
 * @author IRS
 * @version 1.0.0
 */
public class DAOConfig {
    
    /*
    Modificacion para considerar varios archivos de propiedades uno por base de 
    datos, por ejemplo h2.properties, mysql.properties, etc o bien uno por tabla 
    (DAO) sobre una misma base de datos, por ejemplo mysql.properties con los 
    parametros de configuracion, provincias-sentencias.properties con las sentencias 
    sobre la tabla Provincias, tiposvias-sentencias.properties con las sentencias 
    sobre la tabla Tipos de Vias y asi sucesivamente.
    
    Los datos son guardados en un hashmap donde la clave sera un nombre (h2, mysql, 
    etc o provincias, tiposvias, etc) y el valor sera un objeto properties los 
    cuales los voy cargando bajo demanda.
    */
    
    /** Objecto que contiene una instancia de la clase de configuracion. */
    private static DAOConfig instance = null;

    /** Objecto que contiene las propiedades cargadas del archivo de propiedades. */
    private Map<String,Properties> parametros = null;

    /**
     * Contructor privado.
     */
    private DAOConfig() {
    	parametros = new HashMap<>();
    }
    
     /**
     * Contructor privado.
     * 
     * @param daoName Nombre del DAO (clave) del que se almacenaran los parametros 
     *  de configuracion del archivo de configuracion.
     * @param fileNameConfig Nombre del archivo con los parametros de configuracion.
     * 
     * @throw DAOException si se produce algun error en la carga del archivo de configuración.
     */
    private DAOConfig(String daoName, String fileNameConfig) throws DAOException {
        parametros = new HashMap<>();
	Properties props = new Properties();
	try {
            //props.load(new FileInputStream(fileNameConfig));
            props.load(this.getClass().getClassLoader().getResourceAsStream(fileNameConfig));
	} catch (IOException e) {
            throw new DAOException("Archivo de configuracion de '" + daoName + "' no existe o no se puede cargar: " + e.getMessage(), e);
	}
     	parametros.put(daoName, props);
    }

    /**
     * Contructor privado.
     *
     * @param daoName Nombre del DAO (clave) del que se almacenaran los parametros 
     *  de configuracion del archivo de configuracion.
     * @param fileConfig Flujo de entrada con los parametros de configuracion.
     * 
     * @throw DAOException si se produce algun error en la carga del archivo de configuración.
     */
    private DAOConfig(String daoName, InputStream fileConfig) throws DAOException  {
        parametros = new HashMap<>();
	Properties props = new Properties();
	try {
            props.load(fileConfig);
	} catch (IOException e) {
            throw new DAOException("Archivo de configuracion de '" + daoName + "' no existe o no se puede cargar: " + e.getMessage(), e);
	}
    	parametros.put(daoName, props);
    }

    /**
     * Metodo que obtiene una instancia de la clase de configuración de DAO's.
     * 
     * @return Devuelve una instancia de la clase de configuración de DAO's.
     */
    public static DAOConfig getInstance() {
        if (instance == null) {
            synchronized (DAOConfig.class) {
                instance = new DAOConfig();
            }
	}
			
	return instance;
    }
    
    /**
     * Metodo que obtiene una instancia de la clase de configuración de DAO's.
     * 
     * @param daoName Nombre del DAO (clave) del que se almacenaran los parametros 
     *  de configuracion del fichero de configuración.
     * @param fileNameConfig Nombre del archivo con los parametros de configuración.
     * 
     * @return Devuelve una instancia de la clase de configuración de DAO's.
     * 
     * @throws DAOException si se produce algun error en la obtención de la instancia.
     */
    public static DAOConfig getInstance(String daoName, String fileNameConfig) throws DAOException {
        if (instance == null) {
            synchronized (DAOConfig.class) {
                instance = new DAOConfig(daoName, fileNameConfig);
            }
	}
			
	return instance;
    }
    
    /**
     * Metodo que obtiene una instancia de la clase de configuración de DAO's.
     * 
     * @param daoName Nombre del DAO (clave) del que se almacenaran los
     *        parametros de configuracion del archivo de configuración.
     * @param fileConfig Flujo de entrada con los parametros de configuracion.
     * 
     * @return Devuelve una instancia de la clase de configuración de DAO's.
     * 
     * @throws DAOException si se produce algun error en la obtención de la instancia.
     */
    public static DAOConfig getInstance(String daoName, InputStream fileConfig) throws DAOException {
        if (instance == null) {
            synchronized (DAOConfig.class) {
                instance = new DAOConfig(daoName, fileConfig);
            }
	}
			
	return instance;
    }
    
    /**
     * Metodo que añade un nuevo archivo con parametros de configuración y lo
     * almacena bajo la clave de daoName.
     * 
     * @param daoName Nombre del DAO (clave) del que se almacenaran los parametros 
     *  de configuración del archivo de configuración.
     * @param fileNameConfig Nombre del archivo con los parametros de configuración.
     * 
     * @throws DAOException si se produce algun error en la carga del archivo de configuración.
     */
    public void add(String daoName, String fileNameConfig) throws DAOException {
        // Si no existe, lo cargamos en la cache
        if (!parametros.containsKey(daoName)) {
            Properties props = new Properties();
            try {
                //props.load(new FileInputStream(fileNameConfig));
                props.load(this.getClass().getClassLoader().getResourceAsStream(fileNameConfig));
            } catch (IOException e) {
                throw new DAOException("Archivo de configuracion de '" + daoName + "' no existe o no se puede cargar: " + e.getMessage(), e);
            }
            parametros.put(daoName, props);
        }
    }
    
    
    /**
     * Metodo que obtiene el valor de un parametro como un String buscando dicho
     * valor en el archivo especificado (daoName), cuyo nombre es pasado como
     * parametro (key).
     * 
     * @param daoName Nombre del DAO (clave) del que se almacenaran los parametros 
     *  de configuración del archivo de configuración.
     * @param key El nombre del parametro cuyo valor deseamos obtener.
     * 
     * @return El valor del parámetro como String.
     * 
     * @throws DAOException si se produce algun error en la carga del archivo de configuración o en la obtención del valor del parámetro.
     */
    public String getParam(String daoName, String key) throws DAOException {
        String value = null;

        Properties props = (Properties) parametros.get(daoName);
	if (props != null) {
            value = props.getProperty(key);
            if (value == null || value.trim().length() == 0) {
                throw new DAOException("Nombre del parámetro '" + key + "' es null o no existe en el archivo de parámetros de configuración '" + daoName + "'.");
            }
        } else {
            throw new DAOException("Archivo de configuracion de '" + daoName + "' no existe o no se puede cargar.");
        }

        return value;
    }
    
    /**
     * Metodo que obtiene el valor de un parametro como un int buscando dicho
     * valor en el archivo especificado (daoName), cuyo nombre es pasado como
     * parametro (key).
     * 
     * @param daoName Nombre del DAO (clave) del que se almacenaran los parámetros 
     *  de configuración del archivo de configuración.
     * @param key El nombre del parámetro cuyo valor deseamos obtener.
     * 
     * @return El valor del parámetro como int.
     * 
     * @throws DAOException si se produce algun error en la carga del archivo de configuración o en la obtención del valor del parámetro.
     */
    public int getParamInt(String daoName, String key) throws DAOException {
        int value = 0;

	Properties props = (Properties) parametros.get(daoName);
	if (props != null) {
            try {
                value = Integer.parseInt(props.getProperty(key));
            } catch (NumberFormatException e) {
                throw new DAOException("Nombre del parámetro '" + key + "' es null, no existe en el archivo de parámetros de configuración '" + daoName + "' o no es un entero.", e);
            }
        } else {
             throw new DAOException("Archivo de configuracion de '" + daoName + "' no existe o no se puede cargar.");
        }

        return value;
    }
    
    /**
     * Metodo que obtiene el valor de un parametro como un boolean buscando dicho
     * valor en el archivo especificado (daoName), cuyo nombre es pasado como
     * parametro (key).
     * 
     * @param daoName Nombre del DAO (clave) del que se almacenaran los parámetros 
     *  de configuración del archivo de configuración.
     * @param key El nombre del parámetro cuyo valor deseamos obtener.
     * 
     * @return El valor del parámetro como boolean.
     * 
     * @throws DAOException si se produce algun error en la carga del archivo de configuración o en la obtención del valor del parámetro.
     */
    public boolean getParamBool(String daoName, String key) throws DAOException {
        boolean value = false;

	Properties props = (Properties) parametros.get(daoName);
        if (props != null) {
            try {
                value = Boolean.parseBoolean(props.getProperty(key));
            } catch (NumberFormatException e) {
                throw new DAOException("Nombre del parámetro '" + key + "' es null, no existe en el archivo de parámetros de configuración '" + daoName + "' o no es un boolean (true|false).", e);
            }
        } else {
            throw new DAOException("Archivo de configuracion de '" + daoName + "' no existe o no se puede cargar.");
        }

	return value;
    }
    
    /*
    // Version de metodos si solo hay un fichero de parametros
    public String getParam(String key) {
        String value = null;
        try {
            value = parameters.getProperty(key);
        } catch (Exception e) {
            throw new NullPointerException("El nombre del parametro es null o no existe en el fichero de parametros de configuracion.");
        }
        
        return value;
    }

    public int getParamInt(String key) {
        int value = 0;
        
        try {
            value = Integer.parseInt(parameters.getProperty(key));
        } catch (Exception e) {
            throw new NullPointerException("El nombre del parametro es null o no existe en el fichero de parametros de configuracion.");
        }
        
        return value;
    }

    public boolean getParamBool(String key) {
        boolean value = false;
        
        try {
            value = Boolean.valueOf(parameters.getProperty(key)).booleanValue();
        } catch (Exception e) {
            throw new NullPointerException("El nombre del parametro es null o no existe en el fichero de parametros de configuracion.");
        }
        
        return value;
    }
    */
}
