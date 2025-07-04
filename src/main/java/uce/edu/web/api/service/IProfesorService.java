package uce.edu.web.api.service;

import java.util.List;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.to.ProfesorTo;

public interface IProfesorService {

    public ProfesorTo buscarPorId(Integer id, UriInfo uriInfo);
    public List<Profesor> buscarTodos(String contrato);

    public void actualizarProfesor(Profesor profesor);
    public void actualizarProfesorParcial(Profesor profesor);
    public void insertarProfesor(Profesor profesor);
    public void borrarPorId(Integer id);

}
