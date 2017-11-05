/**
 * Clase region que contiene los atributos del mismo
 * @author: Oscar Juarez - 17315; Josue Lopez Florian - 17081
 * @version: 3/11/17
 * Programacion Orientada a Objetos
 */
package Laboratorio05;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class BaseDatos {
    
    Principal principal; //Los tanques con los que cuenta la bd
    EntityManagerFactory emf; //Especifica la Persistent Unit y conexion a base de datos
    EntityManager em; //manejador de las entidades en la base de datos
    public ArrayList<Tanque> tanquesBD;
    public ArrayList<Region> regionesBD;   
    public ArrayList<Informe> informesBD;           
    
    public BaseDatos(){
        emf = javax.persistence.Persistence.createEntityManagerFactory("Laboratorio05PU");
        em = emf.createEntityManager();        
    }       
    
    public void cerdadBD(){
        em.close();
        emf.close();                
    }
    
    public void recuperarDatos() {
        
        Query q1 = em.createQuery("select t from Tanque t");
        List<Tanque> listaTanques = q1.getResultList();
        tanquesBD = new ArrayList<Tanque>(listaTanques);
        
        Query q2 = em.createQuery("select r from Region r");
        List<Region> listaRegiones = q2.getResultList();   
        regionesBD = new ArrayList<Region>(listaRegiones);
        
        Query q3 = em.createQuery("select i from Informe i");
        List<Informe> listaInformes = q3.getResultList();
        informesBD = new ArrayList<Informe>(listaInformes);
        
    }
    

    public void comprarTanqueCilindrico(Cilindrico cilindrico){
        
        em.getTransaction().begin();
        em.persist(cilindrico);
        em.getTransaction().commit();

    }   
    
    public void agregarRegion(Region region) {
        
        em.getTransaction().begin();
        em.persist(region);
        em.getTransaction().commit();
        
    }
    
    public void comprarTanqueOrtogonal(Ortogonal ortogonal){
        
        em.getTransaction().begin();
        em.persist(ortogonal);
        em.getTransaction().commit();

    }  
    
    public void comprarTanqueCubico(Cubico cubico){
        
        em.getTransaction().begin();
        em.persist(cubico);
        em.getTransaction().commit();

    }  
    
    public void agregarInforme(Informe informe) {
        
        em.getTransaction().begin();
        em.persist(informe);
        em.getTransaction().commit();
        
    }
    
    /*
    public void modificarTanqueCubico(double metros3, int valvulas, double porcentaje, double necesidad){
        
        Query q = em.createQuery("select t from Tanque t where t.metros3 = :metros3");
        q.setParameter("metros3", metros3);
        Cubico cubico = (Cubico) q.getSingleResult();
        if (cubico != null){
            cubico.usarTanques();
            cubico.setMetros3();
            cubico.setValvulas(necesidad);
            em.getTransaction().begin();
            em.persist(cubico);
            em.getTransaction().commit();
        }        
    }
    */
    
    public void usarTanque(double metros3, double porcentaje, String nID){
        
        Query q = em.createQuery("select t from Tanque t where t.nID = :nID");
        q.setParameter("nID", nID);
        Tanque tanque = (Tanque) q.getSingleResult();
        if (tanque != null){
            tanque.usarTanques();                
            em.getTransaction().begin();
            em.persist(tanque);
            em.getTransaction().commit();
        }          
    }
    
    public void abrirTanque(double metros3, int valvulas, double porcentaje, double necesidad){
        
        Query q = em.createQuery("select t from Tanque t where t.metros3 = :metros3");
        q.setParameter("metros3", metros3);
        Tanque tanque = (Tanque) q.getSingleResult();
        if (tanque != null){
            tanque.usarTanques();                
            tanque.setValulvas();
            tanque.setOcupado(true);
            em.getTransaction().begin();
            em.persist(tanque);
            em.getTransaction().commit();
        }        
    }
    
    public void modificarNecesidad(double necesidad){
        
        Query q = em.createQuery("select r from Region r where r.necesidad = :necesidad");
        q.setParameter("necesidad", necesidad);
        Region region = (Region) q.getSingleResult();
        if (region != null) {
            region.setNecesidad();
            em.getTransaction().begin();
            em.persist(region);
            em.getTransaction().commit();
        }                
    }
    
    public void cerrarTanque(String nID){
        
        Query q = em.createQuery("select t from Tanque t where t.nID = :nID");
        q.setParameter("nID", nID);
        Tanque tanque = (Tanque) q.getSingleResult();
        if (tanque != null){
            tanque.setOcupado(false);
            tanque.setValvulas(0);
            em.getTransaction().begin();
            em.persist(tanque);
            em.getTransaction().commit();
        }
        
    }            
    
}
