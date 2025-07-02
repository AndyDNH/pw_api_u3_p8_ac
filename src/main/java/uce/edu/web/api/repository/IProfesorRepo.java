package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.Profesor;

public interface IProfesorRepo {

    public Profesor recuperaProfesorPorId(Integer id);
    public List<Profesor> recuperarTodos();
    public void insertar(Profesor profesor);
    public void actualizarProfesor(Profesor profesor);
    public void actualizarProfesorParcial(Profesor profesor);
    public void borrarPorId(Integer id);

}
