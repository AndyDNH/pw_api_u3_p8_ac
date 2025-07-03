package uce.edu.web.api.controller;

import java.util.List;

import javax.print.DocFlavor.READER;

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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.IProfesorService;

@Path("/profesor")
public class  ProfesorController {

    @Inject
    private IProfesorService profesorService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam ("id") Integer id){
        return Response.status(228).entity(profesorService.buscarPorId(id)).build();      
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarTodos(@QueryParam("contrato")String contrato ){
        return Response.status(Response.Status.OK).entity(profesorService.buscarTodos(contrato)).build();           
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar (@RequestBody Profesor profesor){
        profesorService.insertarProfesor(profesor);
        return Response.status(229).build();
    } 

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarPorId(@RequestBody Profesor profesor,@PathParam("id") Integer id){
        profesor.setId(id);
        profesorService.actualizarProfesor(profesor);
        return Response.status(230).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarParcial(@RequestBody Profesor profesor,@PathParam("id") Integer id){
        Profesor p = profesorService.buscarPorId(id);
        profesor.setId(id);
        if (profesor.getApellido()!= null) {
            p.setApellido(profesor.getApellido());
        }
        if (profesor.getNombre()!= null) {
            p.setNombre(profesor.getNombre());
        }
        if (profesor.getCorreo()!= null) {
            p.setCorreo(profesor.getCorreo());
        }
        if (profesor.getMateria()!= null) {
            p.setMateria(profesor.getMateria());
        }
        if (profesor.getSalario()!= null) {
            p.setSalario(profesor.getSalario());
        }
        profesorService.actualizarProfesor(p); 
        return Response.status(231).build();
    }

    @DELETE
    @Path("/{id}")
    public Response borrarPorId(@PathParam("id") Integer id){
        profesorService.borrarPorId(id);
        return Response.status(232).build();
    }


}
