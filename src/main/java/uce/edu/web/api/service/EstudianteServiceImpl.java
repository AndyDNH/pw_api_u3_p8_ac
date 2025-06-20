package uce.edu.web.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepo;
import uce.edu.web.api.repository.modelo.Estudiante;

// A diferencia de repository Service solo tiene AplicationScoped
@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

    @Inject
    private IEstudianteRepo estudianteRepo;
    
    @Override
    public Estudiante buscarPorID(Integer Id) {
        return this.estudianteRepo.seleccionarPorID(Id);
    }

}
