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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Geomar Salas
 */
@Entity
@Table(name = "Ep_Configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EpConfiguration.findAll", query = "SELECT e FROM EpConfiguration e"),
    @NamedQuery(name = "EpConfiguration.findByEpConfigurationId", query = "SELECT e FROM EpConfiguration e WHERE e.epConfigurationId = :epConfigurationId"),
    @NamedQuery(name = "EpConfiguration.findByEndpointDapp", query = "SELECT e FROM EpConfiguration e WHERE e.endpointDapp = :endpointDapp"),
    @NamedQuery(name = "EpConfiguration.findByApikey", query = "SELECT e FROM EpConfiguration e WHERE e.apikey = :apikey"),
    @NamedQuery(name = "EpConfiguration.findByToken", query = "SELECT e FROM EpConfiguration e WHERE e.token = :token"),
    @NamedQuery(name = "EpConfiguration.findByStatus", query = "SELECT e FROM EpConfiguration e WHERE e.status = :status"),
    @NamedQuery(name = "EpConfiguration.findByReccreated", query = "SELECT e FROM EpConfiguration e WHERE e.reccreated = :reccreated"),
    @NamedQuery(name = "EpConfiguration.findByRecupdated", query = "SELECT e FROM EpConfiguration e WHERE e.recupdated = :recupdated")})
public class EpConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ep_configuration_id")
    private Integer epConfigurationId;
    @Size(max = 500)
    @Column(name = "endpoint_dapp")
    private String endpointDapp;
    @Size(max = 500)
	@Column(name = "apikey")
    private String apikey;
    @Size(max = 500)
    @Column(name = "token")
    private String token;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "reccreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reccreated;
    @Column(name = "recupdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recupdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "epConfigurationId")
    private Collection<EpExecution> epExecutionCollection;

    public EpConfiguration() {
    }

    public EpConfiguration(Integer epConfigurationId) {
        this.epConfigurationId = epConfigurationId;
    }

    public Integer getEpConfigurationId() {
        return epConfigurationId;
    }

    public void setEpConfigurationId(Integer epConfigurationId) {
        this.epConfigurationId = epConfigurationId;
    }

    public String getEndpointDapp() {
        return endpointDapp;
    }

    public void setEndpointDapp(String endpointDapp) {
        this.endpointDapp = endpointDapp;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    @XmlTransient
    @JsonIgnore
    public Collection<EpExecution> getEpExecutionCollection() {
        return epExecutionCollection;
    }

    public void setEpExecutionCollection(Collection<EpExecution> epExecutionCollection) {
        this.epExecutionCollection = epExecutionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epConfigurationId != null ? epConfigurationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EpConfiguration)) {
            return false;
        }
        EpConfiguration other = (EpConfiguration) object;
        if ((this.epConfigurationId == null && other.epConfigurationId != null) || (this.epConfigurationId != null && !this.epConfigurationId.equals(other.epConfigurationId))) {
            return false;
        }
        return true;
    }

	public EpConfiguration(Integer epConfigurationId, String endpointDapp, String apikey, String token, Boolean status,
			Date reccreated, Date recupdated, Collection<EpExecution> epExecutionCollection) {
		super();
		this.epConfigurationId = epConfigurationId;
		this.endpointDapp = endpointDapp;
		this.apikey = apikey;
		this.token = token;
		this.status = status;
		this.reccreated = reccreated;
		this.recupdated = recupdated;
		this.epExecutionCollection = epExecutionCollection;
	}

	@Override
	public String toString() {
		return "EpConfiguration [epConfigurationId=" + epConfigurationId + ", endpointDapp=" + endpointDapp
				+ ", apikey=" + apikey + ", token=" + token + ", status=" + status + ", reccreated=" + reccreated
				+ ", recupdated=" + recupdated + ", epExecutionCollection=" + epExecutionCollection + "]";
	}

   
    
}
