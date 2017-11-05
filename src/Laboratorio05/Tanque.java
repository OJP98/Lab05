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
    
    public void setOcupado(boolean valor){
        ocupado = valor ;        
    }

    public String getnID() {
        return nID;
    }
    
    public void setValvulas(double necesidad){
        
        double porcentaje = ((necesidad*100)/(metros3*1000))/10;        
        
        int total = (int) Math.round(porcentaje);
        
        if (total == 0) {
            cValvulas = 0;
            
        } else if (total>10) {
            cValvulas=10;
            
        } else {
            
            cValvulas=total;
            
        }
        
    }
    
    public void setValulvas() {
        cValvulas = cValvulas;
    }

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
    
    public double usarTanques(){
        
        Random generadorRandom = new Random();
        
        int numRandom = generadorRandom.nextInt(5-1)+1;
        
        porcentaje = porcentaje - numRandom;
        
        metros3 = (porcentaje*metros3)/100;       
        
        return porcentaje;
        
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
