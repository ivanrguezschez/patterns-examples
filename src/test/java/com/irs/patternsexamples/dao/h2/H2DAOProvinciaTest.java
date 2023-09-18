package com.irs.patternsexamples.dao.h2;

import com.irs.patternsexamples.dao.DAOFactory;
import com.irs.patternsexamples.dao.DAOProvincia;
import com.irs.patternsexamples.dao.exceptions.DAOException;
import com.irs.patternsexamples.dao.exceptions.DataNotFoundException;
import com.irs.patternsexamples.dao.util.DAOUtil;
import com.irs.patternsexamples.dao.vo.ProvinciaVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Test unitario para el patrón Data Access Object (DAO) con una factoria de una 
 * fuente de datos H2 de las provincias.
 *
 *  @author IRS
 *  @version 1.0.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class H2DAOProvinciaTest {
    
    private static final String SQL_CREATE_TABLE = 
            "CREATE TABLE provincias (id_provincia INT NOT NULL PRIMARY KEY, nombre VARCHAR(100) NOT NULL);";
    
    private static final String SQL_DROP_TABLE = 
            "DROP TABLE provincias;";
        
    private static DAOFactory factory = null;
    private static DAOProvincia daoProvincia = null;
            
    @BeforeAll
    public static void initAll() throws DAOException {
        factory = DAOFactory.getDAOFactory(DAOFactory.H2);
        daoProvincia = factory.getDAOProvincia();
        
        // Create Table
        Connection connection = null;
        Statement stmt = null;
        
        try {
            connection = H2DAOFactory.createConnection();
            stmt = connection.createStatement();
            stmt.execute(SQL_CREATE_TABLE);
        } catch (SQLException e) {
            System.out.println("Error creando las tablas: " + e.getMessage());
        } finally {
            DAOUtil.closeAll(connection, stmt);
        }
    }
    
    @AfterAll
    public static void tearDownAll() throws DAOException {
        factory = null;
        daoProvincia = null;
        
        // Drop Table
        Connection connection = null;
        Statement stmt = null;
        
        try {
            connection = H2DAOFactory.createConnection();
            stmt = connection.createStatement();
            stmt.execute(SQL_DROP_TABLE);
        } catch (SQLException e) {
            System.out.println("Error borrando las tablas: " + e.getMessage());
        } finally {
            DAOUtil.closeAll(connection, stmt);
        }
    }
    
    @Test
    @Order(1)
    public void testInsert() {
        int resultado = 0;
        
        try {
            resultado = daoProvincia.insert(new ProvinciaVO(1, "Madrid"));
            assertEquals(1, resultado);
            
            resultado = daoProvincia.insert(new ProvinciaVO(2, "Toledo"));
            assertEquals(1, resultado);
            
            resultado = daoProvincia.insert(new ProvinciaVO(3, "Segovia"));
            assertEquals(1, resultado);
            
            assertEquals(3, daoProvincia.findAll().size());
       } catch (DataNotFoundException | DAOException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    @Order(2)
    public void testUpdate() {
        try {
            int resultado = daoProvincia.update(new ProvinciaVO(1, "MADRID"));
            assertEquals(1, resultado);
            assertEquals("MADRID", daoProvincia.findById(1).getNombre());
            
            Exception exception = assertThrows(DataNotFoundException.class, 
                    () -> daoProvincia.update(new ProvinciaVO(10, "Zaragoza")));
            assertEquals("Provincia con codigo 10 no encontrada.", exception.getMessage());
        } catch (DataNotFoundException | DAOException e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    @Order(3)
    public void testDelete() {
        try {
            int resultado = daoProvincia.delete(3);
            assertEquals(1, resultado);
                        
            Exception exception = assertThrows(DataNotFoundException.class, 
                    () -> daoProvincia.findById(3));
            assertEquals("Provincia con codigo 3 no encontrada.", exception.getMessage());
        } catch (DataNotFoundException | DAOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void testFindById() {
        try {
            ProvinciaVO provincia = daoProvincia.findById(1);
            assertNotNull(provincia);
            assertEquals(1, provincia.getIdProvincia());
            assertEquals("MADRID", provincia.getNombre());
            
            Exception exception = assertThrows(DataNotFoundException.class, 
                    () -> daoProvincia.findById(100));
            assertEquals("Provincia con codigo 100 no encontrada.", exception.getMessage());
        } catch (DataNotFoundException | DAOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    @Order(5)
    public void testFindAll() {
         try {
            Collection provincias = daoProvincia.findAll();
            assertNotNull(provincias);
            assertFalse(provincias.isEmpty());
            assertEquals(2, provincias.size());
        } catch (DataNotFoundException | DAOException e) {
            fail(e.getMessage());
        }
    }
}
