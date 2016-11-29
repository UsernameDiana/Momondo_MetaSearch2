package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import connection.GetConnections;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchFlightFacade implements ISearchFlight {

    GetConnections conn = new GetConnections();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public SearchFlightFacade() {

    }

    @Override
    public List<String> getWithOriginDate(String origin, String date, int tickets) throws ProtocolException, IOException {

        List<String> temp = conn.ThreeParameterConnection(origin, date, tickets);
        return temp;

    }

    @Override
    public List<String> getWithAllParam(String origin, String dest, String date, int tickets) throws ProtocolException, IOException {
        
        List<String> temp = conn.FourParameterConnection(origin, dest, date, tickets);
        return temp;
    }

    @Override
    public List<String> getFlightInfo(String flightId) {
        return null;
    }
}
