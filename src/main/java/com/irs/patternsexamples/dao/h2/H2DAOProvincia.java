package com.irs.patternsexamples.dao.h2;

import com.irs.patternsexamples.dao.DAOBase;
import com.irs.patternsexamples.dao.DAOConfig;
import com.irs.patternsexamples.dao.DAOProvincia;
import com.irs.patternsexamples.dao.exceptions.DAOException;
import com.irs.patternsexamples.dao.exceptions.DataNotFoundException;
import com.irs.patternsexamples.dao.exceptions.ForeignKeyException;
import com.irs.patternsexamples.dao.util.DAOConstants;
import com.irs.patternsexamples.dao.util.DAOUtil;
import com.irs.patternsexamples.dao.vo.ProvinciaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Clase del Patron Data Access Object (DAO) que implementa las operaciones para
 * el DAO de Provincias para la fuente de datos de H2 sobre la tabla PROVINCIAS.
 *
 * @author IRS
 * @version 1.0.0
 */
public class H2DAOProvincia extends DAOBase implements DAOProvincia {
    
    //public final static String H2_PROVINCIAS_SENTENCIAS_KEY = "h2-provincias";
    
    private static final String MESSAGE_PROVINCIA_NOT_FOUND = "Provincia con codigo %s no encontrada.";
 
    /**
     * Constructor.
     * 
     * @param config objeto que almacena los parámetros de configuración.
     */
    public H2DAOProvincia(DAOConfig config) {
        super(config);
        //H2DAOFactory.getConfig().add(H2DAOProvincia.H2_PROVINCIAS_SENTENCIAS_KEY, "resources/h2-provincias-sentencias.properties");
    }
    
    /**
     * Método que inserta una provincia.
     * 
     * @param provincia Provincia a insertar.
     * 
     * @return Número de registros insertados.
     * 
     * @throws DAOException si se produce algun error en la insercion.
     */
    @Override
    public int insert(ProvinciaVO provincia) throws DAOException {
        if (provincia == null) {
            throw new NullPointerException("Parametro provincia null");
        }

      	PreparedStatement pstmt = null;
      	int resultado = -1;
        
        try {
            dbConnection = H2DAOFactory.createConnection();
            //pstmt = dbConnection.prepareStatement((DAOConstantes.INSERT_PROVINCIA_STATEMENT));
            pstmt = dbConnection.prepareStatement(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOConstants.PARAM_PROVINCIA_INSERT));
            pstmt.setInt(1, provincia.getIdProvincia());
            pstmt.setString(2, provincia.getNombre());
            resultado = pstmt.executeUpdate();
            if (resultado != 1) {
                throw new DAOException("Error insertando provincia: " + resultado);
            }

            return resultado;
        } catch (SQLException e) {
            throw new DAOException("Error insertando provincia: " + e.getMessage(), e);
        } finally {
            DAOUtil.closeAll(dbConnection, pstmt);
        }
    }

    /**
     * Método que modifica una provincia.
     * 
     * @param provincia Provincia a modificar.
     * 
     * @return Número de registros modificados.
     * 
     * @throws DAOException si se produce algun error general en la modificación.
     * @throws DataNotFoundException si no se encuentra la provincia a modificar.
     */
    @Override
    public int update(ProvinciaVO provincia) throws DAOException, DataNotFoundException {
        if (provincia == null) {
            throw new NullPointerException("Parametro provincia null");
        }

      	PreparedStatement pstmt = null;
      	int resultado = -1;
        
        try {
            dbConnection = H2DAOFactory.createConnection();
            pstmt = dbConnection.prepareStatement(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOConstants.PARAM_PROVINCIA_UPDATE));
            pstmt.setString(1, provincia.getNombre());
            pstmt.setInt(2, provincia.getIdProvincia());
            resultado = pstmt.executeUpdate();
            if (resultado <= 0) {
                throw new DataNotFoundException(String.format(MESSAGE_PROVINCIA_NOT_FOUND, provincia.getIdProvincia()));
            }

            return resultado;
        } catch (SQLException e) {
            throw new DAOException("Error actualizando provincia: " + e.getMessage(), e);
        } finally {
            DAOUtil.closeAll(dbConnection, pstmt);
        }
    }
        
    /**
     * Método que elimina una provincia.
     * 
     * @param idProvincia Identificador de la provincia a eliminar.
     * 
     * @return Número de registros eliminados.
     * 
     * @throws DAOException si se produce algun error general en la eliminacion.
     * @throws DataNotFoundException si no se encuentra la provincia a eliminar.
     * @throws ForeignKeyException si se intenta eliminar una provincia que esta asignada a alguna otra entidad.
     */
    @Override
    public int delete(Integer idProvincia) throws DAOException, DataNotFoundException, ForeignKeyException {
        return delete(new Integer[] { idProvincia });
    }

    /**
     * Método que elimina una lista de provincias.
     * 
     * @param ids Identificadores de las provincias a eliminar.
     * 
     * @return Número de provincias eliminadas.
     * 
     * @throws DAOException si se produce algun error general en la eliminacion.
     * @throws DataNotFoundException si no se encuentra la provincia a eliminar.
     * @throws ForeignKeyException si se intenta eliminar una provincia que esta asignada a alguna otra entidad.
     */
    @Override    
    public int delete(Integer[] ids) throws DAOException, DataNotFoundException, ForeignKeyException {
      	PreparedStatement pstmt = null;
      	int resultado = -1;

        try {
            dbConnection = H2DAOFactory.createConnection();
            dbConnection.setAutoCommit(false);
            pstmt = dbConnection.prepareStatement(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOConstants.PARAM_PROVINCIA_DELETE));
            for (int i = 0; i < ids.length; i++) {
                pstmt.setInt(1, ids[i]);
    	        resultado = pstmt.executeUpdate();
    	        if (resultado <= 0) {
                    DAOUtil.rollback(dbConnection);
                    throw new DataNotFoundException(String.format(MESSAGE_PROVINCIA_NOT_FOUND, ids[i]));
            	}
            }
            DAOUtil.commit(dbConnection);
            
            return ids.length;
        } catch (SQLException e) {
            DAOUtil.rollback(dbConnection);
            // Codigo 1451: Se intenta borra un registro cuya PK hace referencia en otra tabla como FK
            if (e.getErrorCode() == 1451) {
                throw new ForeignKeyException("Imposible eliminar provincia.");
            }
            throw new DAOException("Error eliminando provincia: " + e.getMessage(), e);
        } finally {
            DAOUtil.closeAll(dbConnection, pstmt);
        }
    }

    /**
     * Método que busca una provincia por identificador.
     * 
     * @param idProvincia Identificador de la provincia a eliminar.
     * 
     * @return La provincia encontrada.
     * 
     * @throws DAOException si se produce algun error general en la busqueda.
     * @throws DataNotFoundException si no se encuentra ningun dato.
     */
    @Override    
    public ProvinciaVO findById(Integer idProvincia) throws DAOException, DataNotFoundException {
      	PreparedStatement pstmt = null;
	ResultSet rset = null;
      	ProvinciaVO provincia = null;

        try {
            dbConnection = H2DAOFactory.createConnection();
            pstmt = dbConnection.prepareStatement(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOConstants.PARAM_PROVINCIA_FIND_BY_ID));
            pstmt.setInt(1, idProvincia);
            rset = pstmt.executeQuery();
            if (rset.next()) {
                provincia = new ProvinciaVO(rset.getInt(1), rset.getString(2));
            } else {
                throw new DataNotFoundException(String.format(MESSAGE_PROVINCIA_NOT_FOUND, idProvincia));
            }

            return provincia;
        } catch (SQLException e) {
            throw new DAOException("Error buscando provincia: " + e.getMessage(), e);
        } finally {
            DAOUtil.closeAll(dbConnection, pstmt, rset);
        }
    }

    /**
     * Método que busca todas las provincias.
     * 
     * @return Listado de las provincias encontradas.
     * 
     * @throws DAOException si se produce algun error general en la busqueda.
     * @throws DataNotFoundException si no se encuentra ningun dato.
     */
    @Override    
    public Collection findAll() throws DAOException, DataNotFoundException {
      	PreparedStatement pstmt = null;
	ResultSet rset = null;
      	//Collection provincias = new ArrayList();

        try {
            dbConnection = H2DAOFactory.createConnection();
            pstmt = dbConnection.prepareStatement(config.getParam(H2DAOFactory.H2_CONFIG_KEY, DAOConstants.PARAM_PROVINCIA_FIND_ALL));
            rset = pstmt.executeQuery();
            /*
            while (rset.next()) {
                provincias.add(new ProvinciaVO(rset.getInt(1), rset.getString(2)));
            }
            return provincias;
            */
            return DAOUtil.toCollection(rset, ProvinciaVO.class, pstmt.getMetaData().getColumnCount());
        } catch (SQLException e) {
            throw new DAOException("Error buscando todas las provincias: " + e.getMessage(), e);
        } finally {
            DAOUtil.closeAll(dbConnection, pstmt, rset);
        }
    }
}
