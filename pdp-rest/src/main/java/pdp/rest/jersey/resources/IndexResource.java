package pdp.rest.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static pdp.rest.jersey.resources.Maps.entry;
import static pdp.rest.jersey.resources.Maps.newHashMap;

@Path("/")
public class IndexResource {

    @GET
    public Response getName() {
        return Response.ok("mmaltsau").build();
    }

    @GET
    @Path("/object")
    @Produces(APPLICATION_JSON)
    public Response getObject() {
        return Response.ok(newHashMap(entry("height", 172), entry("weight", 80))).build();
    }

}
