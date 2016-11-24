
package facades;

import java.sql.Date;


public interface ISearch {
//    public String getWithAllParam(String origin, String dest, Date date);
//    public String getWithTwoParam(String origin, String dest);
//    public String getFlightInfo(String flightId);
    public String getWithOriginDate(String origin, Date date);
}
