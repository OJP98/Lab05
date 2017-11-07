/**
 * Clase que conecta el programa con la base de datos
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
    /**
     * esta funcion cierra la base de datos.
     */
    public void cerdadBD(){
        em.close();
        emf.close();                
    }
    /**
     * con esta funcion podemos obtener la infomacion guardad en la table de tanque, region e informe.
     */
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
    
    /**
     * con esta funcion se guarda un tanque cilindrico
     * @param cilindrico objeto tanque cilindrico el cual se guardara 
     */
    public void comprarTanqueCilindrico(Cilindrico cilindrico){
        
        em.getTransaction().begin();
        em.persist(cilindrico);
        em.getTransaction().commit();

    }   
    /**
     * con esta funcion se guarda una region
     * @param region objeto tipo regio el cual se guardara
     */
    public void agregarRegion(Region region) {
        
        em.getTransaction().begin();
        em.persist(region);
        em.getTransaction().commit();
        
    }
    /**
     * con esta funcion se gurada un tanque ortogonal
     * @param ortogonal objeto tanque tipo ortogonal el cual se guardara
     */
    public void comprarTanqueOrtogonal(Ortogonal ortogonal){
        
        em.getTransaction().begin();
        em.persist(ortogonal);
        em.getTransaction().commit();

    }  
    /**
     * con esta funcion se guardan los tanques cubicos
     * @param cubico objeto tanque tipo cubico que se guardara
     */
    public void comprarTanqueCubico(Cubico cubico){
        
        em.getTransaction().begin();
        em.persist(cubico);
        em.getTransaction().commit();

    }  
    /**
     * con esta funcion se guardara el informe obtenido de la simulacion
     * @param informe objeto tipo informe el cual se guardara
     */
    public void agregarInforme(Informe informe) {
        
        em.getTransaction().begin();
        em.persist(informe);
        em.getTransaction().commit();
        
    }
    /**
     * con esta funcion permite modificar los datos de cada tanque en la base de datos
     * @param metros3 valor nuevo en metros cubicos del tanque
     * @param porcentaje nuevo orcentjae que tiene el tanque a modificar
     * @param nID id para el tanque que se modificara.
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
    /**
     * esta funcion modifica lso valores booleanos de cada tanque cuando este recien abre.
     * @param metros3 valor en metros cubicos que cambiara
     * @param valvulas valvulas las cuales se abrieron
     * @param porcentaje porcentaje que se modificara del tanque
     * @param necesidad la cantidad de agua de cada tanque
     * @param nID id del tanque el cual se le modificara sus datos.
     */
    public void abrirTanque(double metros3, int valvulas, double porcentaje, double necesidad, String nID){
        
        Query q = em.createQuery("select t from Tanque t where t.nID = :nID");
        q.setParameter("nID", nID);
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
    /**
     * esta funcion tambien modifica los datos del tanque pero cambia el valor boolean de la valvula que se cerara
     * @param nID id del tanque el cual se esta cerrando.
     */
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
