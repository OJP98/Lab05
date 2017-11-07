/**
 * Clase region que contiene los atributos del mismo
 * @author: Oscar Juarez - 17315; Josue Lopez Florian - 17081
 * @version: 3/11/17
 * Programacion Orientada a Objetos
 */

package Laboratorio05;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.IntStream;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JComboBox;

@Entity
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String[] Municipios;
    private int[] Habitantes;
    private double necesidad;
    
    public Region(){}
    
    public Region(String M1, String M2, String M3, String M4, String M5, String M6, String M7, String M8, String M9, String M10, int H1, int H2, int H3, int H4, int H5, int H6, int H7, int H8, int H9, int H10) {                
        
        necesidad = 0;
        Municipios = new String[]{M1, M2, M3, M4, M5, M6, M7, M8, M9, M10};
        Habitantes = new int[]{H1, H2, H3, H4, H5, H6, H7, H8, H9, H10};
        
    }
    /**
     * esta funcion devulve el id
     * @return el id
     */
    public Long getId() {
        return id;
    }
    /**
     * esta funcion pone su id al objeto
     * @param id varaible el cual pasara el id el cual se le dara al objeto
     */
    public void setId(Long id) {
        this.id = id;
    }        
    /**
     * con esta funcion se imprime la informacion dentro del combobox de las regiones.
     * @param comboBox combobox el cual sera agregado sus datos de la lista
     * @param lista lista la cual imprimira sus valores dentro del combobox
     */
    public void imprimirRegiones(JComboBox comboBox, ArrayList<Region> lista){
        
        int contador = 0;
        comboBox.removeAllItems();
        comboBox.addItem("Seleccione la region");
        
        for (Region x: lista) {
            
            contador++;
            comboBox.addItem("Region " + contador);
            
        }              
    }
    /**
     * en esta funcion se da el valor a la la variable necesidad por la cantidad de habitantes del municipio
     */
    public void setNecesidad(){
        
        int tHabitantes = IntStream.of(Habitantes).sum();
        
        necesidad = tHabitantes*137;
        
    }
    /**
     * esta funcion nos devuelve el valor de la necesidad
     * @return valor de la variable necesidad
     */
    public double getNecesidad(){
        return necesidad;
    }
    /**
     * esta funcion devuelve la lista de los municipios
     * @return lista de los municipios registrados
     */
    public String[] getMunicipios() {        
        return Municipios;
        
    }
    /**
     * con esta funcion se te devuelve la lista de cada habitante segun su municipio
     * @return devuelve la lsita de lso habitantes
     */
    public int[] getHabitantes(){
        return Habitantes;
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
