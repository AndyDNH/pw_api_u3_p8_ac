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
    public List<Estudiante> seleccionarTodos(String genero) {
        
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.genero =:genero",Estudiante.class);
        myQuery.setParameter("genero", genero);
        return myQuery.getResultList();
    }

    @Override
    public void actualizarPorId(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void actualizarParcialPorId(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.entityManager.remove(this.seleccionarPorID(id));
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

}
