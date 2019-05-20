package pdp.rest.jersey.mentortask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/pdp-task")
public class TaskResource {

    private TaskService taskService = TaskService.getInstance();

    ObjectMapper objectMapper = new ObjectMapper();

    @GET
    @Produces(APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(taskService.get()).build();
    }

    @GET @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getAll(@PathParam("id") Long id) {
        return Response.ok(taskService.get(id)).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response create(TaskEntity taskEntity) throws JsonProcessingException {
        String s = objectMapper.writeValueAsString(taskEntity);
        System.out.println("create - " + s);
        if(taskEntity.getId() != null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("id not allowed").build();
        }
        long insertedId = taskService.add(taskEntity);
        return Response.ok("inserted id - " + insertedId).build();
    }

    @PUT
    @Consumes(APPLICATION_JSON)
    public Response update(TaskEntity taskEntity) throws JsonProcessingException {
        String s = objectMapper.writeValueAsString(taskEntity);
        System.out.println("update - " + s);

        if(taskEntity.getId() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("id is required").build();
        }
        taskService.update(taskEntity);
        return Response.ok().build();
    }


    @DELETE
    @Consumes(APPLICATION_JSON)
    public Response delete(Long id) {
        taskService.delete(id);
        return Response.ok().build();
    }

}
