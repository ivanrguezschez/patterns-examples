package com.irs.patternsexamples.dao;

import com.irs.patternsexamples.dao.exceptions.DAOException;
import com.irs.patternsexamples.dao.exceptions.DataNotFoundException;
import com.irs.patternsexamples.dao.exceptions.ForeignKeyException;
import com.irs.patternsexamples.dao.vo.ProvinciaVO;
import java.util.Collection;

/**
 * Interface del Patron Data Access Object (DAO) con las operaciones para el
 * DAO de Provincias sobre la tabla de PROVINCIAS.
 *
 * @author IRS
 * @version 1.0.0
 */
public interface DAOProvincia {
 
    int insert(ProvinciaVO provincia) throws DAOException;

    int update(ProvinciaVO provincia) throws DAOException, DataNotFoundException;
    
    int delete(final Integer idProvincia) throws DAOException, DataNotFoundException;

    int delete(Integer[] ids) throws DAOException, DataNotFoundException, ForeignKeyException;

    ProvinciaVO findById(final Integer idProvincia) throws DAOException, DataNotFoundException;

    Collection<ProvinciaVO> findAll() throws DAOException, DataNotFoundException;
}
