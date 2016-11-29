package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import connection.GetConnections;
import facades.ISearchFlight;
import facades.SearchFlightFacade;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("search")
public class SearchFlightResource {

    //static SearchFlightFacade facade = new SearchFlightFacade();
    //Instance of gson for making JSON out of objects
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //
    static ISearchFlight flight = new SearchFlightFacade();

    @Context
    private UriInfo context;

    /**
     * Retrieves representation of an instance of rest.SearchFlightResource
     *
     * @param origin
     * @param tickets
     * @param date
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{origin}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWithOriginDate(@PathParam("origin") String origin,
            @PathParam("date") String date, @PathParam("tickets") int tickets) throws IOException {

        List<String> temp = flight.getWithOriginDate(origin, date, tickets);

        //returning the result and making it into a json object
        return temp.toString();
    }

    @GET
    @Path("/{origin}/{destination}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWithAllParam(@PathParam("origin") String origin,
            @PathParam("destination") String dest, @PathParam("date") String date, @PathParam("tickets") int tickets) throws IOException {
        List<String> temp = flight.getWithAllParam(origin, dest, date, tickets);

        //returning the result and making it into a json object
        return temp.toString();
    }

//    @GET
//    @Path("/{flightId}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String getFlightInfo(@PathParam("flightId")String flightId){
//    }
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String makeReservation(String content) {
//        throw new UnsupportedOperationException();
//    }
}
