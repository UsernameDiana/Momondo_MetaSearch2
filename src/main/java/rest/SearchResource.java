
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.ISearch;
import facades.SearchFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("search")
public class SearchResource {

    static ISearch facade = new SearchFacade();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Context
    private UriInfo context;


    public SearchResource() {
    }

//    @GET
//    @Path("allparameters/{origin}/{destination}/{date}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getWithAllParam() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//    
//    @GET
//    @Path("twoparameters/{origin}/{destination}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getWithTwoParam() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
    
    @GET
    @Path("withorigin/{origin}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWithOriginDate() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String viewFlightInfo(String content) {
        throw new UnsupportedOperationException();
    }
}
