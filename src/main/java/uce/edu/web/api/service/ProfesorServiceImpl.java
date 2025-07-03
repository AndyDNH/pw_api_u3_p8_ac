package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IProfesorRepo;
import uce.edu.web.api.repository.modelo.Profesor;

@ApplicationScoped
public class ProfesorServiceImpl implements IProfesorService{

    @Inject
    private IProfesorRepo profesorRepo;

    @Override
    public Profesor buscarPorId(Integer id) {
        return profesorRepo.recuperaProfesorPorId(id);  
    }

    @Override
    public List<Profesor> buscarTodos(String contrato) {
        return profesorRepo.recuperarTodos(contrato);
    }

    @Override
    public void actualizarProfesor(Profesor profesor) {
        profesorRepo.actualizarProfesor(profesor);
    }

    @Override
    public void actualizarProfesorParcial(Profesor profesor) {
        profesorRepo.actualizarProfesorParcial(profesor);
    }

    @Override
    public void insertarProfesor(Profesor profesor) {
        profesorRepo.insertar(profesor);
    }

    @Override
    public void borrarPorId(Integer id) {
        profesorRepo.borrarPorId(id);
    }
    

}
