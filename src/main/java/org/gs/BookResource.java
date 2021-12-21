package org.gs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/books")
public class BookResource {

    @Inject
    BookService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        return Response.ok(service.getBooks()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getBookById(@PathParam("id") Long id) {
        return service.getBookById(id)
                .map(book -> Response.ok(book).build())
                .orElseGet(() -> Response.status(Status.NOT_FOUND).build());
    }
}