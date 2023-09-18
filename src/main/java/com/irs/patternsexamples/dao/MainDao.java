package com.irs.patternsexamples.dao;

import com.irs.patternsexamples.dao.exceptions.DAOException;
import com.irs.patternsexamples.dao.exceptions.DataNotFoundException;
import com.irs.patternsexamples.dao.h2.H2DAOFactory;
import com.irs.patternsexamples.dao.util.DAOUtil;
import com.irs.patternsexamples.dao.vo.ProvinciaVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

/**
 * Clase principal del patron DAO.
 * Ejemplo de uso del Patron Data Access Object con una factoria de una fuente de datos H2.
 *
 * @author IRS
 * @version 1.0.0
 */
public class MainDao {
    
    //private static final String SQL_CREATE_TABLE = 
    //        "DROP TABLE IF EXISTS provincias; " +
    //        "CREATE TABLE provincias (id_provincia INT NOT NULL PRIMARY KEY, nombre VARCHAR(100) NOT NULL);";
    
    private static final String SQL_CREATE_TABLE = 
            "CREATE TABLE provincias (id_provincia INT NOT NULL PRIMARY KEY, nombre VARCHAR(100) NOT NULL);";
    
    private static final String SQL_DROP_TABLE = 
            "DROP TABLE provincias;";
     
    public static void main(String[] args) {
        try {
            createTable();
                        
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.H2);
            DAOProvincia daoProvincia = factory.getDAOProvincia();
            int resultado = 0;
        
            resultado = daoProvincia.insert(new ProvinciaVO(1, "Madrid"));
            System.out.println(resultado + " provincias insertadas");
            
            resultado = daoProvincia.insert(new ProvinciaVO(2, "Toledo"));
            System.out.println(resultado + " provincias insertadas");
            
            resultado = daoProvincia.insert(new ProvinciaVO(3, "Segovia"));
            System.out.println(resultado + " provincias insertadas");
            
            resultado = daoProvincia.update(new ProvinciaVO(1, "MADRID"));
            System.out.println(resultado + " provincias actualizadas");
            
            resultado = daoProvincia.delete(2);
            System.out.println(resultado + " provincias eliminadas");
            
            ProvinciaVO provincia = daoProvincia.findById(1);
            System.out.println(provincia);
            
            Collection provincias = daoProvincia.findAll();
            System.out.println("PROVINCIAS\n" + provincias);
            
            dropTable();
        } catch (DataNotFoundException | DAOException e) {
            e.printStackTrace();
        }
    }
    
    private static void createTable() throws DAOException {
        Connection connection = null;
        Statement stmt = null;
        
        try {
            connection = H2DAOFactory.createConnection();
            stmt = connection.createStatement();
            stmt.execute(SQL_CREATE_TABLE);
        } catch (SQLException e) {
            System.out.println("Error creando las tablas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(connection, stmt);
        }
    }
    
    private static void dropTable() throws DAOException {
         Connection connection = null;
        Statement stmt = null;
        
        try {
            connection = H2DAOFactory.createConnection();
            stmt = connection.createStatement();
            stmt.execute(SQL_DROP_TABLE);
        } catch (SQLException e) {
            System.out.println("Error borrando las tablas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(connection, stmt);
        }
    }
}
