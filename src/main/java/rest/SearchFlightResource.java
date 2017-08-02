package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.ISearchFlight;
import facades.SearchFlightFacade;
import java.io.IOException;
import java.net.ProtocolException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("search")
public class SearchFlightResource {

    //Instance of gson, to make JSON out of objects
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static ISearchFlight flight = new SearchFlightFacade();

    @Context
    private UriInfo context;

    @GET
    @Path("/{origin}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWithOriginDate(@PathParam("origin") String origin,
            @PathParam("date") String date, @PathParam("tickets") int tickets) throws IOException
    {
        String temp = flight.getWithOriginDate(origin, date, tickets);
        return temp;
    }

    @GET
    @Path("/{origin}/{destination}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWithAllParam(@PathParam("origin") String origin,
            @PathParam("destination") String dest, @PathParam("date") String date, @PathParam("tickets") int tickets) throws IOException
    {
        String temp = flight.getWithAllParam(origin, dest, date, tickets);
        return temp;
    }

//    @GET
//    @Path("/{flightId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getFlightInfo(@PathParam("flightId")String flightId) throws ProtocolException{
//    String temp = flight.getFlightInfo(flightId);
//    
//    return temp;
//    }
//    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String makeReservation(String content) {
//        throw new UnsupportedOperationException();
//    }
}
