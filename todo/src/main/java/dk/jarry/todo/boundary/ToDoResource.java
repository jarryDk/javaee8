package dk.jarry.todo.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dk.jarry.todo.entity.ToDo;

@Path("todos")
public class ToDoResource {

	@Context
	UriInfo context;

	@Inject
	ToDoService toDoService;

	@POST
	public Response create(ToDo toDo) {

		try {
			ToDo create = toDoService.create(toDo);
			return Response.created(context.getAbsolutePathBuilder().path(create.getId().toString()).build()).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GET
	@Path("{id}")
	public Response read(@PathParam("id") String id) {
		Response.ResponseBuilder response;
		try {
			ToDo todo = toDoService.read(id);
			if (todo == null) {
				response = Response.status(Response.Status.NOT_FOUND);
			} else {
				response = Response.ok(todo);
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return response.build();
	}

	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") String id, ToDo todo) {
		Response.ResponseBuilder response;
		try {
			if (toDoService.read( id) != null) {
				toDoService.update(todo);
				response = Response.status(Response.Status.NO_CONTENT);
			} else {
				response = Response.status(Response.Status.NOT_FOUND);
			}
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return response.build();
	}

	@DELETE
	@Path("{id}")
	public Response delte(@PathParam("id") String id) {
		Response.ResponseBuilder response;
		try {
			if (toDoService.read( id) != null) {
				toDoService.delete(id);
				response = Response.ok();
			} else {
				response = Response.status(Response.Status.NOT_FOUND);
			}
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return response.build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(@DefaultValue("0") @QueryParam("from") Long from,
			@DefaultValue("50") @QueryParam("limit") Long limit) throws Exception {
		Response.ResponseBuilder response;
		try {
			List<ToDo> list = toDoService.list(from, limit);
			response = Response.ok(list);
			return response.build();
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return response.build();
	}

}
