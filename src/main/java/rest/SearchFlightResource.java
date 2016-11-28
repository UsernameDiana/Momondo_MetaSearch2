package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import connection.GetConnections;
import facades.SearchFlightFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import facades.ISearchFlight;
import java.net.URL;
import java.util.List;

@Path("flights")
public class SearchFlightResource {
    
    static SearchFlightFacade facade = new SearchFlightFacade();
    //Instance of gson for making JSON out of objects
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //Create an instance of the GetConnections to gain access to the methods
    static GetConnections getC = new GetConnections();
    
    @Context
    private UriInfo context;
    
    //Get method for the basic query so three parameters
//    @GET
//    @Path("/{origin}/{date}/{tickets}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getWithOriginDate(@PathParam("origin") String origin,
//            @PathParam("date") String date, @PathParam("tickets") int tickets) {        
//        //Using the rest to only call the method from inside getconnections
//        getC.GetWithThree(origin, date, tickets);
//        //returning the result and making it into a json object
//        return gson.toJson(getC);
//    }

//    @GET
//    @Path("/{origin}/{destination}/{date}/{tickets}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getWithAllParam(@PathParam("origin") String origin,
//            @PathParam("destination") String dest, @PathParam("date") String date) {
//    }
//    
//    @GET
//    @Path("/{origin}/{destination}/{tickets}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getWithTwoParam(@PathParam("origin") String origin, 
//            @PathParam("destination") String destination) {
//    }
//
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
