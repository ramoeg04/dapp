/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dapp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Geomar Salas
 */
@Entity
@Table(name = "ep_execution_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EpExecutionLog.findAll", query = "SELECT e FROM EpExecutionLog e"),
    @NamedQuery(name = "EpExecutionLog.findByEpExecutionLogId", query = "SELECT e FROM EpExecutionLog e WHERE e.epExecutionLogId = :epExecutionLogId"),
    @NamedQuery(name = "EpExecutionLog.findByTypeProcess", query = "SELECT e FROM EpExecutionLog e WHERE e.typeProcess = :typeProcess"),
    @NamedQuery(name = "EpExecutionLog.findByDescriptionProcess", query = "SELECT e FROM EpExecutionLog e WHERE e.descriptionProcess = :descriptionProcess"),
    @NamedQuery(name = "EpExecutionLog.findByStatus", query = "SELECT e FROM EpExecutionLog e WHERE e.status = :status"),
    @NamedQuery(name = "EpExecutionLog.findByReccreated", query = "SELECT e FROM EpExecutionLog e WHERE e.reccreated = :reccreated"),
    @NamedQuery(name = "EpExecutionLog.findByRecupdated", query = "SELECT e FROM EpExecutionLog e WHERE e.recupdated = :recupdated")})
public class EpExecutionLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ep_execution_log_id")
    private Integer epExecutionLogId;
    @Basic(optional = false)
    @Column(name = "type_process")
    private String typeProcess;
    @Column(name = "description_process")
    private String descriptionProcess;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "reccreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reccreated;
    @Column(name = "recupdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recupdated;
    @JoinColumn(name = "ep_execution_id", referencedColumnName = "ep_execution_id")
    @ManyToOne(optional = false)
    private EpExecution epExecutionId;

    public EpExecutionLog() {
    }

    public EpExecutionLog(Integer epExecutionLogId) {
        this.epExecutionLogId = epExecutionLogId;
    }

    public EpExecutionLog(Integer epExecutionLogId, String typeProcess, int status, Date reccreated) {
        this.epExecutionLogId = epExecutionLogId;
        this.typeProcess = typeProcess;
        this.status = status;
        this.reccreated = reccreated;
    }

    public Integer getEpExecutionLogId() {
        return epExecutionLogId;
    }

    public void setEpExecutionLogId(Integer epExecutionLogId) {
        this.epExecutionLogId = epExecutionLogId;
    }

    public String getTypeProcess() {
        return typeProcess;
    }

    public void setTypeProcess(String typeProcess) {
        this.typeProcess = typeProcess;
    }

    public String getDescriptionProcess() {
        return descriptionProcess;
    }

    public void setDescriptionProcess(String descriptionProcess) {
        this.descriptionProcess = descriptionProcess;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public EpExecution getEpExecutionId() {
        return epExecutionId;
    }

    public void setEpExecutionId(EpExecution epExecutionId) {
        this.epExecutionId = epExecutionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epExecutionLogId != null ? epExecutionLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EpExecutionLog)) {
            return false;
        }
        EpExecutionLog other = (EpExecutionLog) object;
        if ((this.epExecutionLogId == null && other.epExecutionLogId != null) || (this.epExecutionLogId != null && !this.epExecutionLogId.equals(other.epExecutionLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dapp.entities.EpExecutionLog[ epExecutionLogId=" + epExecutionLogId + " ]";
    }
    
}
