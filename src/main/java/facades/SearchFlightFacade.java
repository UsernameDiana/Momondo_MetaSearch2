
package facades;

import java.sql.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class SearchFlightFacade implements ISearchFlight {
    
    EntityManagerFactory emf;

    public SearchFlightFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public SearchFlightFacade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
     @Override
    public String getWithOriginDate(String origin, String date) {
    Flights f;
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT f FROM Flights f WHERE f.origin = :origin and f.date = :date");
            query.setParameter("origin", origin);
            query.setParameter("date", date);
            f = (Flights) query.getSingleResult();
            return f;
            
        } finally {
            em.close();
        }    
    }

//    public String getWithAllParam(String origin, String dest, String date) {
//      EntityManager em = getEntityManager();
//        try {
//            Query query = em.createQuery("SELECT f FROM Flights f WHERE f.origin = '" 
//                            + origin + "'" + "AND f.destination = '" + dest + "'" + "AND f.date = '" + date + "'");
//            List<Flights> f = query.getResultList();
//            return f;
//        } finally {
//            em.close();
//        }  
//    }
//
//    public String getWithTwoParam(String origin, String dest) {
//    EntityManager em = getEntityManager();
//        try {
//            Query query = em.createQuery("SELECT f FROM Flights f WHERE f.origin = '" 
//                            + origin + "'" + "AND f.destination = '" + dest + "'");
//            List<Flights> f = query.getResultList();
//            return f;
//        } finally {
//            em.close();
//        }    
//    }
//
//
//    public String getFlightInfo(String flightId) {
//     Flights f;
//        EntityManager em = getEntityManager();
//        try {
//            Query query = em.createQuery("SELECT f FROM Flights f WHERE f.flightId = :flightId");
//            query.setParameter("flightId", flightId);
//            f = (Flights) query.getSingleResult();
//            return f;
//            
//            
//        } finally {
//            em.close();
//        }   
//     }

    
}
