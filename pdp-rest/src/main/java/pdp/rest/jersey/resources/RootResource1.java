package pdp.rest.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/root1")
public class RootResource1 {

    @GET
    @Produces(APPLICATION_JSON)
    public String getName() {
        return "root1";
    }

    // /root1/sub-resource/123
    // /root1/sub-resource/
    @Path("sub-resource")
    public SubResource subResource() {
        return new SubResource(this.getClass().getName());
    }
}
