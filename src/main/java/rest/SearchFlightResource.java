package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import connection.URLConnection;
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
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    private static List <String> listOfUrls;
    URLConnection UrlConn = new URLConnection();
    
    @Context
    private UriInfo context;

    @GET
    @Path("/{origin}/{date}/{tickets}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getWithOriginDate(@PathParam("origin") String origin, @PathParam("date") String date) 
    {   
       
        // looping through the list of urls. Two items
        
        for (String url : listOfUrls) 
        {
            //url +=                  // for each of the url's apend the 
            
        }
        return null;
    }

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
