package com.irs.patternsexamples.dao.util;

/**
 * Clase de utilidad que almacena diversas constantes.
 *
 * @author IRS
 * @version 1.0.0
 */
public final class DAOConstants {
    
    // Las sentencias SQL puden estar en los DAO's especificos (H2DAOProvincia, etc)
    // de cada fuente de datos, aqui o en el archivo properties especifico de la fuente de datos

    // Provincia
    public static String PARAM_PROVINCIA_INSERT = "provincia.insert";
    public static String PARAM_PROVINCIA_DELETE = "provincia.delete";
    public static String PARAM_PROVINCIA_UPDATE = "provincia.update";
    public static String PARAM_PROVINCIA_FIND_BY_ID = "provincia.find.by.id";
    public static String PARAM_PROVINCIA_FIND_ALL = "provincia.find.all";
}
