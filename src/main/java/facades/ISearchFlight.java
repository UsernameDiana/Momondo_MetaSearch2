
package facades;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;


public interface ISearchFlight {
    public List<String> getWithOriginDate(String origin, String date, int tickets) throws ProtocolException, IOException;
    public List<String> getWithAllParam(String origin, String dest, String date, int tickets) throws ProtocolException, IOException;
    public List<String> getFlightInfo(String flightId) throws ProtocolException;
}
