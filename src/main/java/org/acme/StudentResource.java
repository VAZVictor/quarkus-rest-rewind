package org.acme;

import io.vertx.core.parsetools.RecordParser;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/students")
public class StudentResource {

    private final Map<Long, Student> students = new HashMap<>();
    private Long nextId = 1L;

    public StudentResource() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Student s = Student.builder().id(nextId++)
                .fullName("Gerald Unterrainer")
                .email("gerald@unterrainer.info")
                .birthDate(LocalDateTime.parse("1975-05-02 00:00", f)).build();
        students.put(s.getId(), s);

        s = Student.builder().id(2L)
                .fullName("Kasperl Unterrainer")
                .email("kasperl@unterrainer.info")
                .birthDate(LocalDateTime.parse("1995-10-23 00:00", f)).build();
        students.put(s.getId(), s);
    }

    @GET
    @Path("/{id}")
    public Response getStudent(@PathParam("id") long id) {
        Student s = students.get(id);

        if (s == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Map.of("error", "Student not found")).build();
        }

        return Response.ok(s).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response students() {
        return Response.ok(students.values()).build();
    }
}
