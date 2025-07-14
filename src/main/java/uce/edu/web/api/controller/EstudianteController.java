package uce.edu.web.api.controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

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
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.Hijo;
import uce.edu.web.api.repository.modelo.HijoProfesor;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.IHijoService;
import uce.edu.web.api.service.mapper.EstudianteMapper;
import uce.edu.web.api.service.to.EstudianteTo;

// Tambien llamado Recurso/Resource
// Es parte del ath de la url que voy  a invocar 
// El nombre por convencion debe de ser en plural
@Path("/estudiantes")
public class EstudianteController extends BaseControllador {

    @Inject
    private IEstudianteService estudianteService;

    @Inject
    private IHijoService hijoService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        EstudianteTo estu = EstudianteMapper.toTo(this.estudianteService.buscarPorId(id));
        estu.buildURI(uriInfo);
        return Response.status(277).entity(estu).build();
    }

    // ?genero=F&provincia=pichincha
    @GET
    @Path("")
    public Response consultarTodos(@QueryParam("genero") String genero, @QueryParam("provincia") String provincia) {
        System.out.println(provincia);
        return Response.status(Response.Status.OK).entity(this.estudianteService.buscarTodos(genero)).build();
    }

    @POST
    @Path("")
    @Operation(summary = "Guardar Estudiante", description = "Esta capacidad permite guardar un estudiante ....")
    public Response guardar(@RequestBody EstudianteTo estudianteTo) {
        this.estudianteService.guardar(estudianteTo);
        return Response.status(Response.Status.OK).build();

    }

    @PUT
    @Path("/{id}")
    public Response actualizarPorId(@RequestBody EstudianteTo estudianteTo, @PathParam("id") Integer id) {
        estudianteTo.setId(id);
        this.estudianteService.actualizarPorId(estudianteTo);
        return Response.status(Response.Status.OK).build();
    }

    @PATCH
    @Path("/{id}")
    public Response actualizarParcialPorId(@RequestBody EstudianteTo estudianteTo, @PathParam("id") Integer id) {
        estudianteTo.setId(id);
        EstudianteTo eTo = EstudianteMapper.toTo(this.estudianteService.buscarPorId(id));
        if (estudianteTo.getApellido() != null) {
            eTo.setApellido(estudianteTo.getApellido());
        }
        if (estudianteTo.getFechaNacimiento() != null) {
            eTo.setFechaNacimiento(estudianteTo.getFechaNacimiento());
        }
        if (estudianteTo.getNombre() != null) {
            eTo.setNombre(estudianteTo.getNombre());
        }
        this.estudianteService.actualizarParcialPorId((eTo));
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response borrarPorId(@PathParam("id") Integer id) {
        this.estudianteService.borrarPorId(id);
        return Response.status(Response.Status.OK).build();

    }

    // /1/hijos
    @GET
    @Path("/{id}/hijos")
    public List<Hijo> obtenerHijosPorId(@PathParam("id") Integer id) {
        return this.hijoService.buscarPorEstudianteId(id);

    }

}
