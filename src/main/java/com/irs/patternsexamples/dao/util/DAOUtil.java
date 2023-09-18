package com.irs.patternsexamples.dao.util;

import com.irs.patternsexamples.dao.exceptions.DAOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Clase de utilidad del Patron Data Access Object (DAO).
 *
 * @author IRS
 * @version 1.0.0
 */
public final class DAOUtil {
    
    /**
     * Método que cierra la conexión a la base de datos pasada como parámetro.
     * 
     * @param con Conexion a la base de datos.
     * 
     * @throws DAOException si se produce algun error en el cierre de la conexión.
     */
    public static void closeConnection(final Connection con) throws DAOException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new DAOException("Error cerrando Connection: " + e.getMessage(), e);
        }
    }
    
    /**
     * Método que cierra la sentencia a la base de datos pasada como parámetro.
     * 
     * @param stmt Sentencia a la base de datos.
     * 
     * @exception DAOException si se produce algun error en el cierre de la sentencia.
     */
    public static void closeStatement(final Statement stmt) throws DAOException {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new DAOException("Error cerrando Statement: " + e.getMessage(), e);
            }
        }
    }
    
    /**
     * Método que cierra la sentencia preparada a la base de datos pasada como parámetro.
     * 
     * @param pstmt Sentencia preparada a la base de datos.
     * 
     * @exception DAOException si se produce algun error en el cierre de la sentencia preparada.
     */
    public static void closePreparedStatement(final PreparedStatement pstmt) throws DAOException {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new DAOException("Error cerrando PreparedStatement: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Método que cierra la sentencia a procedimiento a la base de datos pasada como parámetro..
     * 
     * @param cstmt Sentencia procedimiento a la base de datos.
     * 
     * @exception DAOException si se produce algun error en el cierre de la sentencia procedimiento.
     */
    public static void closeCallableStatement(final CallableStatement cstmt) throws DAOException {
        if (cstmt != null) {
            try {
                cstmt.close();
            } catch (SQLException e) {
                throw new DAOException("Error cerrando CallableStatement: " + e.getMessage(), e);
            }
        }
    }
    
    /**
     * Méodo que cierra el conjunto de resultados a la base de datos pasada como parámetro...
     * 
     * @param rset Conjunto de resultados a la base de datos.
     * 
     * @exception DAOException si se produce algun error en el cierre del conjunto de resultados.
     */
    public static void closeResultSet(final ResultSet rset) throws DAOException {
        if (rset != null) {
            try {
                rset.close();
            } catch (SQLException e) {
                throw new DAOException("Error cerrando ResultSet: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Método que cierra todo.
     * 
     * @param con Conexion a la base de datos.
     * @param stmt Sentencia a la base de datos.
     * 
     * @throws DAOException si se produce algun error en el cierre.
     */
    public static void closeAll(final Connection con, final Statement stmt) throws DAOException {
        DAOUtil.closeStatement(stmt);
        DAOUtil.closeConnection(con);
    }

    /**
     * Método que cierra todo.
     * 
     * @param con Conexion a la base de datos.
     * @param psmt Sentencia preparada a la base de datos.
     * 
     * @throws DAOException si se produce algun error en el cierre.
     */
    public static void closeAll(final Connection con, final PreparedStatement psmt) throws DAOException {
        DAOUtil.closePreparedStatement(psmt);
        DAOUtil.closeConnection(con);
    }

    /**
     * Método que cierra todo.
     * 
     * @param con Conexion a la base de datos.
     * @param csmt Llamada a procedimiento a la base de datos.
     * 
     * @throws DAOException si se produce algun error en el cierre.
     */
    public static void closeAll(final Connection con, final CallableStatement csmt) throws DAOException {
        DAOUtil.closeCallableStatement(csmt);
        DAOUtil.closeConnection(con);
    }

    /**
     * Método que cierra todo.
     * 
     * @param con Conexion a la base de datos.
     * @param stmt Sentencia a la base de datos.
     * @param rset Conjunto de resultados a la base de datos.
     * 
     * @throws DAOException si se produce algun error en el cierre.
     */
    public static void closeAll(final Connection con, final Statement stmt, final ResultSet rset) throws DAOException {
	DAOUtil.closeResultSet(rset);
        DAOUtil.closeStatement(stmt);
	DAOUtil.closeConnection(con);
    }

    /**
     * Método que cierra todo.
     * 
     * @param con Conexion a la base de datos.
     * @param psmt Sentencia preparada a la base de datos.
     * @param rset Conjunto de resultados a la base de datos.
     * 
     * @throws DAOException si se produce algun error en el cierre.
     */
    public static void closeAll(final Connection con, final PreparedStatement psmt, final ResultSet rset) throws DAOException {
        DAOUtil.closeResultSet(rset);
        DAOUtil.closePreparedStatement(psmt);
	DAOUtil.closeConnection(con);
    }

    /**
     * Método que cierra todo.
     * 
     * @param con Conexion a la base de datos.
     * @param csmt Llamada a procedimiento a la base de datos.
     * @param rset Conjunto de resultados a la base de datos.
     * 
     * @throws DAOException si se produce algun error en el cierre.
     */
    public static void closeAll(final Connection con, final CallableStatement csmt, final ResultSet rset) throws DAOException {
        DAOUtil.closeResultSet(rset);
        DAOUtil.closeCallableStatement(csmt);
	DAOUtil.closeConnection(con);
    }

    /**
     * Método que realiza el commit de la trasaccion actual de la conexion.
     * 
     * @param con Conexion a la base de datos.
     * 
     * @exception DAOException si se produce algun error en la operacion de commit.
     */
    public static void commit(final Connection con) throws DAOException {
        try {
            if (con != null && !con.isClosed()) {
                con.commit();
            }
        } catch (SQLException e) {
            throw new DAOException("Error realizando commit de la transaccion: " + e.getMessage(), e);
        }
    }
    
    /**
     * Método que realiza el rollback de la trasaccion actual de la conexion.
     * 
     * @param con Conexion a la base de datos.
     * 
     * @exception DAOException si se produce algun error en la operacion de rollback.
     */
    public static void rollback(final Connection con) throws DAOException {
        try {
            if (con != null && !con.isClosed()) {
                con.rollback();
            }
        } catch (SQLException e) {
            throw new DAOException("Error realizando rollback de la transaccion: " + e.getMessage(), e);
        }
    }
    
    /*
    public static Collection collectionFromResultSet(final ResultSet rs,  final Class clase,  final int numColumnas) {
    	Collection result = new ArrayList();
    	try {
            Class[] argumentos = new Class[] {int.class, String.class};
            Object[] valores = new Object[numColumnas];
            Constructor argsConstructor = clase.getConstructor(argumentos);
            while (rs.next()) {
                for (int i=1; i<numColumnas; i++) {
                    if (argumentos[i-1].getName().equals("int")) 
                        valores[i-1] = new Integer(rs.getInt(i));
                    if (argumentos[i-1].getName().equals("java.lang.String")) 
    			valores[i-1] = rs.getString(i);
    		}
    		Object obj = argsConstructor.newInstance(valores);
    		result.add(obj);
            }
    	} catch (Exception ignored){}
    	
    	return result;
    }
    */

    /*
    	Me obliga a tener un constructor con el numero de parametros igual al
        numero de columnas, lo suyo es que se llamara a un constructor vacio
        y luego se llamara a los diversos metodos setXXXX()
    */
    public static Collection toCollection(final ResultSet rs, final Class clase, final int numcol) {
    	Collection result = new ArrayList();
    	try {
            Class[] argumentos = new Class[numcol];
            Field[] campos = clase.getDeclaredFields();
            for (int i = 0; i < numcol; i++) {
                argumentos[i] = campos[i].getType();
            }
            while (rs.next()) {
                Object obj = clase.newInstance();
                for (int i = 0; i < numcol; i++) {
                    String nombreMetodo = "set" + campos[i].getName().substring(0, 1).toUpperCase() + campos[i].getName().substring(1);
                    Method metodo = clase.getMethod(nombreMetodo,  new Class[] {argumentos[i]});
                    if (argumentos[i].getName().equals("int")) {
                        metodo.invoke(obj, new Object[] { new Integer(rs.getInt(i+1)) });
                    } else if (argumentos[i].getName().equals("java.lang.String")) {
                        metodo.invoke(obj, new Object[] { rs.getString(i+1) });
                    } else if (argumentos[i].getName().equals("byte")) {
			metodo.invoke(obj, new Object[] { new Byte(rs.getByte(i+1)) });
                    } else if (argumentos[i].getName().equals("short")) {
			metodo.invoke(obj, new Object[] { new Short(rs.getShort(i+1)) });
                    } else if (argumentos[i].getName().equals("long")) {
			metodo.invoke(obj, new Object[] { new Long(rs.getLong(i+1)) });
                    } else if (argumentos[i].getName().equals("float")) {
			metodo.invoke(obj, new Object[] { new Float(rs.getFloat(i+1)) });
                    } else if (argumentos[i].getName().equals("double")) {
			metodo.invoke(obj, new Object[] { new Double(rs.getDouble(i+1)) });
                    } else if (argumentos[i].getName().equals("boolean")) {
			metodo.invoke(obj, new Object[] { new Boolean(rs.getBoolean(i+1)) });
                    } else if (argumentos[i].getName().equals("java.util.Date")) {
			metodo.invoke(obj, new Object[] { new java.util.Date(rs.getDate(i+1).getTime()) });
                    } else if (argumentos[i].getName().equals("java.math.BigDecimal")) {
			metodo.invoke(obj, new Object[] { rs.getBigDecimal(i+1) });
                    } else {
			metodo.invoke(obj, new Object[] { rs.getObject(i+1) });
                    }
    		}
    		result.add(obj);
            }
    	} catch (Exception ignored) {}
    	
    	return result;
    }
}

