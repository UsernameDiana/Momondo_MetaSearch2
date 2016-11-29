
package facades;

import java.io.IOException;
import java.net.ProtocolException;



public interface ISearchFlight {
    public String getWithOriginDate(String origin, String date, int tickets) throws ProtocolException, IOException;
    public String getWithAllParam(String origin, String dest, String date, int tickets) throws ProtocolException, IOException;
//    public String getFlightInfo(String flightId) throws ProtocolException;
}
