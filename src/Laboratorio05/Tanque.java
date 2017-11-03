/**
 * Clase Tanque que conserva las propiedades del mismo.
 * @author: Oscar Juarez - 17315; Josue Lopez Florian - 17081
 * @version: 3/11/17
 * Programacion Orientada a Objetos
 */

package Laboratorio05;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Usuario
 */
@Entity
public class Tanque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String nID;
    protected double porcentaje, capacidad, metros3, ancho, largo, profundo;
    protected int cValvulas;
    protected boolean ocupado;
    
    public Tanque (){}
    
    public Tanque(String Nid, double Ancho, double Largo, double Profundo) {
        nID = Nid;
        ancho = Ancho;
        largo = Largo;
        profundo = Profundo;     
        porcentaje = 100;
        metros3 = capacidad;
        ocupado = true;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public double getMetros3() {
        return metros3;
    }

    public void setMetros3() {

    }

    public int getcValvulas() {
        return cValvulas;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public String getnID() {
        return nID;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tanque)) {
            return false;
        }
        Tanque other = (Tanque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Laboratorio05.Tanque[ id=" + id + " ]";
    }
    
}
