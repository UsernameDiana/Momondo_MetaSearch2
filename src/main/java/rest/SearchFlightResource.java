
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.util.List;

@Path("flights")
public class SearchFlightResource {

    static ISearchFlight facade = new SearchFlightFacade();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Context
    private UriInfo context;


    public SearchFlightResource() {
    }
    
    @GET
    @Path("/{origin}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWithOriginDate(@PathParam("origin") String origin, @PathParam("date") String date) {
        List<Flights> f = facade.getWithOriginDate(origin, date);
        return gson.toJson(f);
    }

//    @GET
//    @Path("/{origin}/{destination}/{date}/{tickets}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getWithAllParam() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//    
//    @GET
//    @Path("/{origin}/{destination}/{tickets}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getWithTwoParam() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String makeReservation(String content) {
//        throw new UnsupportedOperationException();
//    }
//    @GET
//    @Path("/{flightId}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String getFlightInfo(String flightId){
//    throw new UnsupportedOperationException();
//    }
}
