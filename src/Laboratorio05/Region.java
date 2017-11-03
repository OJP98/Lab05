/**
 * Clase region que contiene los atributos del mismo
 * @author: Oscar Juarez - 17315; Josue Lopez Florian - 17081
 * @version: 3/11/17
 * Programacion Orientada a Objetos
 */

package Laboratorio05;

import java.io.Serializable;
import java.lang.reflect.Array;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String[] Municipios;
    private int[] Habitantes;
    
    public Region(){}
    
    public Region(String[] Municipios, int[]Habitantes, String M1, String M2, String M3, String M4, String M5, String M6, String M7, String M8, String M9, String M10, int H1, int H2, int H3, int H4, int H5, int H6, int H7, int H8, int H9, int H10) {                
        
        Municipios = new String[]{M1, M2, M3, M4, M5, M6, M7, M8, M9, M10};
        Habitantes = new int[]{H1, H2, H3, H4, H5, H6, H7, H8, H9, H10};
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setMunicipios(String M1, String M2, String M3, String M4, String M5, String M6, String M7, String M8, String M9, String M10) {
        
        Municipios[0] = M1;
                
    }
    
    public void setHabitantes(int H1, int H2, int H3, int H4, int H5, int H6, int H7, int H8, int H9, int H10) {
        
        Habitantes = new int[]{H1, H2, H3, H4, H5, H6, H7, H8, H9, H10};        
        
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
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Laboratorio05.Region[ id=" + id + " ]";
    }
    
}
