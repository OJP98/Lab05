/**
 * Clase informe que contiene el objeto en si, con sus propios atributos y metodos
 * @author: Oscar Juarez - 17315; Josue Lopez Florian - 17081
 * @version: 3/11/17
 * Programacion Orientada a Objetos
 */
package Laboratorio05;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Informe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private int valvulas;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private String cambio;
    
    public Informe(){}

    public Informe(int valvulas, Date fecha, String cambio) {
        this.valvulas = valvulas;
        this.fecha = fecha;
        this.cambio = cambio;
    }        
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }    
    
    public String hacerInforme(){
        
        String informe = "";
        
        informe = "\n" + fecha+": \n" + cambio + " " + valvulas + " valvulas \n";
        
        return informe;
        
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informe)) {
            return false;
        }
        Informe other = (Informe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Laboratorio05.Informe[ id=" + id + " ]";
    }
    
}
