package uce.edu.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.modelo.Hijo;
import uce.edu.web.api.repository.modelo.HijoProfesor;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.IHIjoProfesorService;
import uce.edu.web.api.service.IHijoService;
import uce.edu.web.api.service.IProfesorService;
import uce.edu.web.api.service.mapper.ProfesorMapper;
import uce.edu.web.api.service.to.ProfesorTo;

@Path("/profesores")
public class ProfesorController {

    @Inject
    private IProfesorService profesorService;

    @Inject
    private IHIjoProfesorService hijoProfesorService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        ProfesorTo profe = ProfesorMapper.toTo(this.profesorService.buscarPorId(id));
        profe.buildURI(uriInfo);
        return Response.status(228).entity(profe).build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarTodos(@QueryParam("contrato") String contrato) {
        return Response.status(Response.Status.OK).entity(profesorService.buscarTodos(contrato)).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@RequestBody ProfesorTo profesorTo) {
        profesorService.insertarProfesor(profesorTo);
        return Response.status(229).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarPorId(@RequestBody ProfesorTo profesorTo, @PathParam("id") Integer id) {
        profesorTo.setId(id);
        profesorService.actualizarProfesor(profesorTo);
        return Response.status(230).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarParcial(@RequestBody ProfesorTo profesorTo, @PathParam("id") Integer id) {
        ProfesorTo prof = ProfesorMapper.toTo(profesorService.buscarPorId(id));
        profesorTo.setId(id);
        if (profesorTo.getApellido() != null) {
            prof.setApellido(profesorTo.getApellido());
        }
        if (profesorTo.getNombre() != null) {
            prof.setNombre(profesorTo.getNombre());
        }
        if (profesorTo.getCorreo() != null) {
            prof.setCorreo(profesorTo.getCorreo());
        }
        if (profesorTo.getMateria() != null) {
            prof.setMateria(profesorTo.getMateria());
        }
        if (profesorTo.getSalario() != null) {
            prof.setSalario(profesorTo.getSalario());
        }
        profesorService.actualizarProfesor(prof);
        return Response.status(231).build();
    }

    @DELETE
    @Path("/{id}")
    public Response borrarPorId(@PathParam("id") Integer id) {
        profesorService.borrarPorId(id);
        return Response.status(232).build();
    }

    @GET
    @Path("/{id}/hijos")
    public List<HijoProfesor> obtenerHijosProfesorPorId(@PathParam("id") Integer id) {
        return this.hijoProfesorService.buscarPorProfesorId(id);

    }

}
