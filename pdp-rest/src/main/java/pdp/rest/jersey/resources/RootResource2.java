package pdp.rest.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/root2")
public class RootResource2 {
    @GET
    @Produces(APPLICATION_JSON)
    public String getName() {
        return "root2";
    }

    // /root1/sub-resource/sub-value/123
    @Path("sub-resource")
    public SubResource subResource() {
        return new SubResource(this.getClass().getName());
    }
}
