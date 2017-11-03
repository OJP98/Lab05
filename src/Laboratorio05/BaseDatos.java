/**
 * Clase region que contiene los atributos del mismo
 * @author: Oscar Juarez - 17315; Josue Lopez Florian - 17081
 * @version: 3/11/17
 * Programacion Orientada a Objetos
 */
package Laboratorio05;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class BaseDatos {
    
    Tanque tanque; //Los tanques con los que cuenta la bd
    EntityManagerFactory emf; //Especifica la Persistent Unit y conexion a base de datos
    EntityManager em; //manejador de las entidades en la base de datos
    
    public BaseDatos(){
        emf = javax.persistence.Persistence.createEntityManagerFactory("TanquePU");
        em = emf.createEntityManager();
        tanque = new Tanque(); //tanque vacio
    }
    
    public void cerdadBD(){
        em.close();
        emf.close();                
    }
    
    public void recuperarDatos() {
        
        Query q1 = em.createQuery("select t from Tanque t");
        ArrayList<Tanque> tanques = (ArrayList<Tanque>) q1.getResultList();
        
        Query q2 = em.createQuery("select r from Region r");
        ArrayList<Region> regiones = (ArrayList<Region>) q2.getResultList();        
        
    }
    
    /*
    public void comprarTanqueCilindrico(String id, double Ancho, double Largo, double Profundo){
        
        Tanque tanque = new Tanque(id, Ancho, Largo, Profundo);
        em.getTransaction().begin();
        em.persist(tanque);
        em.getTransaction().commit();
        
        //Hace falta agregar el tanque al arraylist de tanques        
        
    }
    */    
    
}
