/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio05;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JUMPSTONIK
 */
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
    public Cubico(String Nid, double Ancho, double Largo, double Profundo) {
        super(Nid, Ancho, Largo, Profundo);                
        setMetros3();
    }
    
    
    @Override
    /**
     * Metodo que calcula la capacidad de tanque segun su forma
     */
    public void setMetros3(){
        
        capacidad = profundo*ancho*largo;
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
