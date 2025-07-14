package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.repository.IProfesorRepo;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.mapper.ProfesorMapper;
import uce.edu.web.api.service.to.ProfesorTo;

@ApplicationScoped
public class ProfesorServiceImpl implements IProfesorService{

    @Inject
    private IProfesorRepo profesorRepo;

    @Override
    public Profesor buscarPorId(Integer id) {
        // Profesor p = this.profesorRepo.recuperaProfesorPorId(id);
        // ProfesorTo p1 = new ProfesorTo(p.getId(), p.getNombre(), p.getApellido(),
        //  p.getCorreo(), p.getMateria(), p.getSalario(), p.getContrato(), uriInfo);
        // return p1;  
        return this.profesorRepo.recuperaProfesorPorId(id);
    }

    @Override
    public List<Profesor> buscarTodos(String contrato) {
        return profesorRepo.recuperarTodos(contrato);
    }

    @Override
    public void actualizarProfesor(ProfesorTo profesorTo) {
        profesorRepo.actualizarProfesor(ProfesorMapper.toEntity(profesorTo));
    }

    @Override
    public void actualizarProfesorParcial(ProfesorTo profesorTo) {
        profesorRepo.actualizarProfesorParcial(ProfesorMapper.toEntity(profesorTo));
    }

    @Override
    public void insertarProfesor(ProfesorTo profesorTo) {
        profesorRepo.insertar(ProfesorMapper.toEntity(profesorTo));
    }

    @Override
    public void borrarPorId(Integer id) {
        profesorRepo.borrarPorId(id);
    }
    

}
