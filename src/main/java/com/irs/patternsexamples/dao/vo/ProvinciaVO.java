package com.irs.patternsexamples.dao.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Value Object asociado a la tabla PROVINCIAS.
 *
 * @author IRS
 * @version 1.0.0
 */
public class ProvinciaVO implements Serializable {
    
    /**
     * Identificador de la provincia. 
     */
    private Integer idProvincia;

    /** 
     * Nombre de la provincia. 
     */
    private String nombre;

    
    /**
     * Constructor por defecto.
     */
    public ProvinciaVO() {
        this(null, null);
    }

    /**
     * Constructor.
     * 
     * @param idProvincia Identificador de la provincia.
     * @param nombre Nombre de la provincia.
     */
    public ProvinciaVO(Integer idProvincia, String nombre) {
        super();
        this.idProvincia = idProvincia;
        this.nombre = nombre;
    }

    /**
     * Constructor de copia.
     * @param provincia Objeto provincia a copiar.
     */
    public ProvinciaVO(ProvinciaVO provincia) {
        this.idProvincia = provincia.getIdProvincia();
        this.nombre = provincia.getNombre();
    }

    /**
     * Metodo que devuelve el identificador de la provincia.
     * 
     * @return El identificador de la provincia.
     */
    public Integer getIdProvincia() {   
        return idProvincia;
    }

    /**
     * Metodo que establece el identificador de la provincia.
     * 
     * @param idProvincia El identificador de la provincia.
     */
    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }


    /**
     * Metodo que devuelve el nombre de la provincia.
     * 
     * @return El nombre de la provincia.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre de la provincia.
     * 
     * @param nombre El nombre de la provincia.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que calcula el hash code del value object ProvinciaVO.
     * 
     * @return Devuelve el has code del value object ProvinciaVO.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idProvincia);
        return hash;
    }

    /**
     * Método que indica si el objeto pasado es igual al value object ProvinciaVO.
     * 
     * @return Devuelve un boolean que indica si son iguales o no.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProvinciaVO other = (ProvinciaVO) obj;
        return Objects.equals(this.idProvincia, other.idProvincia);
    }

    
    /**
     * Método que convierte el value object ProvinciaVO en String.
     * 
     * @return Devuelve un String que representa el value object ProvinciaVO.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProvinciaVO{");
        sb.append("idProvincia=").append(idProvincia);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
}
