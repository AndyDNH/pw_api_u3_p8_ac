package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepo;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.mapper.EstudianteMapper;
import uce.edu.web.api.service.to.EstudianteTo;

// A diferencia de repository Service solo tiene AplicationScoped
@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

    @Inject
    private IEstudianteRepo estudianteRepo;
    
    @Override
    public Estudiante buscarPorId(Integer id) {
        // Estudiante e1 = 
        return this.estudianteRepo.seleccionarPorID(id);
    //     EstudianteTo e =  new EstudianteTo(e1.getId(), e1.getNombre(), e1.getApellido(), e1.getFechaNacimiento(),
    //      e1.getGenero(), uriInfo);
    //     return e;
    }

    @Override
    public List<Estudiante> buscarTodos(String genero) {
        return this.estudianteRepo.seleccionarTodos(genero);
    }

    @Override
    public void actualizarPorId(EstudianteTo estudianteTo) {
          this.estudianteRepo.actualizarPorId(EstudianteMapper.toEntity(estudianteTo));
    }

    @Override
    public void actualizarParcialPorId(EstudianteTo estudianteTo) {
        this.estudianteRepo.actualizarParcialPorId(EstudianteMapper.toEntity(estudianteTo));
    }

    @Override
    public void borrarPorId(Integer id) {
        this.estudianteRepo.borrarPorId(id);
    }

    @Override
    public void guardar(EstudianteTo estudianteTo) {
        this.estudianteRepo.insertar(EstudianteMapper.toEntity(estudianteTo));
    }

}
