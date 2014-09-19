/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityes;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vanilson
 */
@Entity
@Table(name = "locais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locais.findAll", query = "SELECT l FROM Locais l"),
    @NamedQuery(name = "Locais.findByCodigoLocal", query = "SELECT l FROM Locais l WHERE l.codigoLocal = :codigoLocal"),
    @NamedQuery(name = "Locais.findByLatitudeLocal", query = "SELECT l FROM Locais l WHERE l.latitudeLocal = :latitudeLocal"),
    @NamedQuery(name = "Locais.findByLongitudeLocal", query = "SELECT l FROM Locais l WHERE l.longitudeLocal = :longitudeLocal")})
public class Locais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_local")
    private Integer codigoLocal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "nome_local")
    private String nomeLocal;
    @Column(name = "latitude_local")
    private double latitudeLocal;
    @Column(name = "longitude_local")
    private double longitudeLocal;

    public Locais() {
    }

    public Locais(Integer codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public Integer getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(Integer codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public double getLatitudeLocal() {
        return latitudeLocal;
    }

    public void setLatitudeLocal(double latitudeLocal) {
        this.latitudeLocal = latitudeLocal;
    }

    public double getLongitudeLocal() {
        return longitudeLocal;
    }

    public void setLongitudeLocal(double longitudeLocal) {
        this.longitudeLocal = longitudeLocal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLocal != null ? codigoLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locais)) {
            return false;
        }
        Locais other = (Locais) object;
        if ((this.codigoLocal == null && other.codigoLocal != null) || (this.codigoLocal != null && !this.codigoLocal.equals(other.codigoLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityes.Locais[ codigoLocal=" + codigoLocal + " ]";
    }
    
}
