package facades;

import connection.GetConnections;

public class SearchFlightFacade implements ISearchFlight{

    GetConnections conn = new GetConnections();
    
    @Override
    public String getWithOriginDate(String origin, String date, int tickets) {
        conn.ThreeParameterConnection(origin, date, tickets);
        
        return null;
    }

    public String getWithAllParam(String origin, String dest, String date, int tickets) {
   return null;
    }

    @Override
    public String getFlightInfo(String flightId) {
        return null;
     }
}
