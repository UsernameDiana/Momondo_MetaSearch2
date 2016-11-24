
package facades;

import java.sql.Date;


public interface ISearchFlight {
//    public String getWithAllParam(String origin, String dest, String date);
//    public String getWithTwoParam(String origin, String dest);
//    public String getFlightInfo(String flightId);
    public String getWithOriginDate(String origin, String date);
}
