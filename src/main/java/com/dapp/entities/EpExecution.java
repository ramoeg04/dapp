/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Geomar Salas
 */
@Entity
@Table(name = "ep_execution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EpExecution.findAll", query = "SELECT e FROM EpExecution e"),
    @NamedQuery(name = "EpExecution.findByEpExecutionId", query = "SELECT e FROM EpExecution e WHERE e.epExecutionId = :epExecutionId"),
    @NamedQuery(name = "EpExecution.findByJsonIn", query = "SELECT e FROM EpExecution e WHERE e.jsonIn = :jsonIn"),
    @NamedQuery(name = "EpExecution.findByJsonOut", query = "SELECT e FROM EpExecution e WHERE e.jsonOut = :jsonOut"),
    @NamedQuery(name = "EpExecution.findByReccreated", query = "SELECT e FROM EpExecution e WHERE e.reccreated = :reccreated"),
    @NamedQuery(name = "EpExecution.findByRecupdated", query = "SELECT e FROM EpExecution e WHERE e.recupdated = :recupdated")})
public class EpExecution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ep_execution_id")
    private Integer epExecutionId;
    @Column(name = "json_in")
    private String jsonIn;
    @Column(name = "json_out")
    private String jsonOut;
    @Basic(optional = false)
    @Column(name = "reccreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reccreated;
    @Column(name = "recupdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recupdated;
    @JoinColumn(name = "ep_configuration_id", referencedColumnName = "ep_configuration_id")
    @ManyToOne(optional = false)
    private EpConfiguration epConfigurationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "epExecutionId")
    private Collection<EpExecutionLog> epExecutionLogCollection;

    public EpExecution() {
    }

    public EpExecution(Integer epExecutionId) {
        this.epExecutionId = epExecutionId;
    }

    public EpExecution(Integer epExecutionId, Date reccreated) {
        this.epExecutionId = epExecutionId;
        this.reccreated = reccreated;
    }

    public Integer getEpExecutionId() {
        return epExecutionId;
    }

    public void setEpExecutionId(Integer epExecutionId) {
        this.epExecutionId = epExecutionId;
    }

    public String getJsonIn() {
        return jsonIn;
    }

    public void setJsonIn(String jsonIn) {
        this.jsonIn = jsonIn;
    }

    public String getJsonOut() {
        return jsonOut;
    }

    public void setJsonOut(String jsonOut) {
        this.jsonOut = jsonOut;
    }

    public Date getReccreated() {
        return reccreated;
    }

    public void setReccreated(Date reccreated) {
        this.reccreated = reccreated;
    }

    public Date getRecupdated() {
        return recupdated;
    }

    public void setRecupdated(Date recupdated) {
        this.recupdated = recupdated;
    }

    public EpConfiguration getEpConfigurationId() {
        return epConfigurationId;
    }

    public void setEpConfigurationId(EpConfiguration epConfigurationId) {
        this.epConfigurationId = epConfigurationId;
    }

    @XmlTransient
    public Collection<EpExecutionLog> getEpExecutionLogCollection() {
        return epExecutionLogCollection;
    }

    public void setEpExecutionLogCollection(Collection<EpExecutionLog> epExecutionLogCollection) {
        this.epExecutionLogCollection = epExecutionLogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epExecutionId != null ? epExecutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EpExecution)) {
            return false;
        }
        EpExecution other = (EpExecution) object;
        if ((this.epExecutionId == null && other.epExecutionId != null) || (this.epExecutionId != null && !this.epExecutionId.equals(other.epExecutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dapp.entities.EpExecution[ epExecutionId=" + epExecutionId + " ]";
    }
    
}
