package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.IEstudianteService;

// Tambien llamado Recurso/Resource
// Es parte del ath de la url que voy  a invocar 
// El nombre por convencion debe de ser en plural
@Path("/estudiantes")
public class EstudianteController {

    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("/consultar/{id}")
    public Estudiante consultarPorId(@PathParam("id") Integer id){
        return this.estudianteService.buscarPorID(id);
    }

}
