/**
 * Clase hija de Tanque, posee metodos unicos.
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

@Entity
public class Cubico extends Tanque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Cubico(){}
    
    public Cubico(String Nid, double Ancho, double Largo, double Profundo) {
        super(Nid, Ancho, Largo, Profundo);                
        capacidad = largo*largo*largo;
        metros3 = capacidad;
    }
    
    
    @Override
    /**
     * Metodo que calcula la capacidad de tanque segun su forma
     */
    public void setMetros3(){
        
        capacidad = largo*largo*largo;
        metros3 = capacidad;
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
        if (!(object instanceof Cubico)) {
            return false;
        }
        Cubico other = (Cubico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Laboratorio05.cubico[ id=" + id + " ]";
    }
    
}
