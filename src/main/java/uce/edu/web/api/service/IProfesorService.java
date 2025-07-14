package uce.edu.web.api.service;

import java.util.List;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.to.ProfesorTo;

public interface IProfesorService {

    public Profesor buscarPorId(Integer id);
    public List<Profesor> buscarTodos(String contrato);

    public void actualizarProfesor(ProfesorTo profesorTo);
    public void actualizarProfesorParcial(ProfesorTo profesorTo);
    public void insertarProfesor(ProfesorTo profesorTo);
    public void borrarPorId(Integer id);

}
