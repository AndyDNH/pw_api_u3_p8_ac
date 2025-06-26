package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

    @Override
    public List<Estudiante> seleccionarTodos() {
        
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
        return myQuery.getResultList();
    }

}
