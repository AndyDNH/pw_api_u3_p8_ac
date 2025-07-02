package uce.edu.web.api.controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.IProfesorService;

@Path("/profesor")
public class  ProfesorController {

    @Inject
    private IProfesorService profesorService;

    @GET
    @Path("/{id}")
    public Profesor consultarPorId(@PathParam ("id") Integer id){
        return profesorService.buscarPorId(id);
    }

    @GET
    @Path("")
    public List<Profesor> consultarTodos(){
        return profesorService.buscarTodos();
    }

    @POST
    @Path("")
    public void guardar (@RequestBody Profesor profesor){
        profesorService.insertarProfesor(profesor);
    } 

    @PUT
    @Path("/{id}")
    public void actualizarPorId(@RequestBody Profesor profesor,@PathParam("id") Integer id){
        profesor.setId(id);
        profesorService.actualizarProfesor(profesor);
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcial(@RequestBody Profesor profesor,@PathParam("id") Integer id){
        Profesor p = consultarPorId(id);
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
    }

    @DELETE
    @Path("/{id}")
    public void borrarPorId(@PathParam("id") Integer id){
        profesorService.borrarPorId(id);
    }


}
