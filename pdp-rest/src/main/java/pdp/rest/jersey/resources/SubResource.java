package pdp.rest.jersey.resources;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.glassfish.jersey.internal.guava.Lists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static pdp.rest.jersey.resources.Maps.entry;
import static pdp.rest.jersey.resources.Maps.newHashMap;

public class SubResource {

    private String owner;

    public SubResource(String owner) {
        this.owner = owner;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response getName() {
        return Response.ok(newHashMap(
                entry("owner", owner),
                entry("content", "sub-resource"))).build();
    }

    @GET @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getValue1(@PathParam("id") String id) {
        return Response.ok(newHashMap(
                entry("owner", owner),
                entry("content", id))).build();
    }
}
