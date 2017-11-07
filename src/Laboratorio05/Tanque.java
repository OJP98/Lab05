/**
 * Clase Tanque que conserva las propiedades del mismo.
 * @author: Oscar Juarez - 17315; Josue Lopez Florian - 17081
 * @version: 3/11/17
 * Programacion Orientada a Objetos
 */

package Laboratorio05;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JComboBox;
import java.util.Random;

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
        ocupado = false;        
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
     * esta funcion permite obtener el valor de la variable porcentaje
     * @return el valor del porcentaje
     */
    public double getPorcentaje() {
        return porcentaje;
    }
    /**
     * esta fucnion permite obtener el valor de los metros cubicos aun disponibles en el tanque
     * @return valor en metros cubicos en el tanque
     */
    public double getMetros3() {
        return metros3;
    }
    /**
     * esta funcion es para un override de lso metros cubicos
     */
    public void setMetros3() {

    }
    /**
     * con esta funcion la obtencion dle valor de cuantas valvulas tiene el tanque conectados.
     * @return la cantidad de valvulas conectadas
     */
    public int getcValvulas() {
        return cValvulas;
    }
    /**
     * esta funcion devuleve el estado del tanque
     * @return esta del tanque
     */
    public boolean isOcupado() {
        return ocupado;
    }
    /**
     * esta funcion pone el valor del estado del tanque
     * @param valor 
     */
    public void setOcupado(boolean valor){
        ocupado = valor ;        
    }
    /**
     * esta funcion devuelve el id del tanque
     * @return id del tanque
     */
    public String getnID() {
        return nID;
    }
    /**
     * esta funcion le dara su valor de a las valvular con su necesidad
     * @param necesidad cantidad de agua que debe consumir.
     */
    public void setValvulas(double necesidad){
        
        double porcentaje = ((necesidad*100)/(metros3*1000))/10;        
        
        int total = (int) Math.round(porcentaje);
        
        if (total == 0 && isOcupado()==true) {
            cValvulas = 1;
            
        } else if (!isOcupado()) {
            cValvulas = 0;
            
        } else if (total>10) {
            cValvulas=10;
            
        } else {
            
            cValvulas=total;
            
        }
        
    }
    /**
     * iguala la cantidad de valvulas a la cantidad de valvulas
     */
    public void setValulvas() {
        cValvulas = cValvulas;
    }
    /**
     * esta funcion imprime en el combobox los valores dentro de la lista de tanques.
     * @param comboBox combobox el cual se le agregara en el cada tnqeu que hay.
     * @param lista lista de los tanque que hay.
     */
    public void imprimirTanques(JComboBox comboBox, ArrayList<Tanque> lista){
        
        comboBox.removeAllItems();
        comboBox.addItem("Seleccione el tanque");
        int contador = 0;
        
        for (Tanque x: lista) {
            
            contador++;
            
            String ID = x.getnID();
            comboBox.addItem("Tanque " + contador + ", ID: " + ID);
            
        }        
    }
    /**
     * esta funcion permitira ver la cantidad de agua que fue usada del tanque de manera aleatoria
     * @return valor que tiene en porcentaje el taque
     */
    public double usarTanques(){
        
        Random generadorRandom = new Random();
        
        int numRandom = generadorRandom.nextInt(5-1)+1;
        
        porcentaje = porcentaje - numRandom;
        
        metros3 = (porcentaje*metros3)/100;       
        
        return porcentaje;
        
    }
    
    /**
     * Metodo que calcula la cantidad total de valvulas de tanques cilindricos que estan funcionando
     * @param lista: La lista de los tanques
     * @return 
     */
    public int totalValvulasC(ArrayList<Tanque> lista){
        
        int totalValvulas = 0;
        
        for (Tanque x: lista) {
            
            if (x instanceof Cilindrico) {
                
                totalValvulas = totalValvulas + x.getcValvulas();
                
            }            
        }
        
        return totalValvulas;
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
