package uce.edu.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Estudiante;

// Anotaciones necesarias de un Impl
@Transactional
@ApplicationScoped
public class EstudianteRepoImpl implements IEstudianteRepo{

    // me permite la interaccion con la base de datos 
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante seleccionarPorID(Integer Id) {
        return  this.entityManager.find(Estudiante.class, Id);
    }

}
