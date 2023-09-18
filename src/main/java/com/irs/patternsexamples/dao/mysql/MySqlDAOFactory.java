package com.irs.patternsexamples.dao.mysql;

import com.irs.patternsexamples.dao.DAOFactory;
import com.irs.patternsexamples.dao.DAOProvincia;

/**
 * Clase del Patron Data Access Object (DAO) que representa una factoria de una
 * fuente de datos MySQL.
 *
 * @author IRS
 * @version 1.0.0
 */
public class MySqlDAOFactory extends DAOFactory {

    @Override
    public DAOProvincia getDAOProvincia() {
        return null;
    }
}
