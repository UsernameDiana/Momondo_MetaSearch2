package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import connection.GetConnections;
import java.io.IOException;
import java.net.ProtocolException;

public class SearchFlightFacade implements ISearchFlight {

    GetConnections conn = new GetConnections();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public SearchFlightFacade() {

    }

    @Override
    public String getWithOriginDate(String origin, String date, int tickets) throws ProtocolException, IOException {

        String temp = conn.ThreeParameterConnection(origin, date, tickets);
        return temp;

    }

    @Override
    public String getWithAllParam(String origin, String dest, String date, int tickets) throws ProtocolException, IOException {

        String temp = conn.FourParameterConnection(origin, dest, date, tickets);
        return temp;
    }

//    @Override
//    public String getFlightInfo(String flightId) {
//        
//        String temp = conn.viewFlightWithId(flightId);
//        
//        return temp;
//    }
}
