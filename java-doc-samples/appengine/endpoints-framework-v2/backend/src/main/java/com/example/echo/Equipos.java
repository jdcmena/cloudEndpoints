/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.echo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jdcm
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e")
    , @NamedQuery(name = "Equipos.findByEquipoId", query = "SELECT e FROM Equipos e WHERE e.equipoId = :equipoId")
    , @NamedQuery(name = "Equipos.findByNombreEquipo", query = "SELECT e FROM Equipos e WHERE e.nombreEquipo = :nombreEquipo")
    , @NamedQuery(name = "Equipos.findByAnioFundacion", query = "SELECT e FROM Equipos e WHERE e.anioFundacion = :anioFundacion")
    , @NamedQuery(name = "Equipos.findByTitulosGanados", query = "SELECT e FROM Equipos e WHERE e.titulosGanados = :titulosGanados")})
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EQUIPO_ID", nullable = false)
    private Integer equipoId;
    @Basic(optional = false)
    @Column(name = "NOMBRE_EQUIPO", nullable = false, length = 30)
    private String nombreEquipo;
    @Basic(optional = false)
    @Column(name = "ANIO_FUNDACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date anioFundacion;
    @Basic(optional = false)
    @Column(name = "TITULOS_GANADOS", nullable = false)
    private int titulosGanados;

    public Equipos() {
    }

    public Equipos(Integer equipoId) {
        this.equipoId = equipoId;
    }

    public Equipos(Integer equipoId, String nombreEquipo, Date anioFundacion, int titulosGanados) {
        this.equipoId = equipoId;
        this.nombreEquipo = nombreEquipo;
        this.anioFundacion = anioFundacion;
        this.titulosGanados = titulosGanados;
    }

    public Integer getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Integer equipoId) {
        this.equipoId = equipoId;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Date getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(Date anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public int getTitulosGanados() {
        return titulosGanados;
    }

    public void setTitulosGanados(int titulosGanados) {
        this.titulosGanados = titulosGanados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipoId != null ? equipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.equipoId == null && other.equipoId != null) || (this.equipoId != null && !this.equipoId.equals(other.equipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.echo.Equipos[ equipoId=" + equipoId + " ]";
    }
    
}
