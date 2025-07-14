package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Hijo;
import uce.edu.web.api.repository.modelo.HijoProfesor;
import uce.edu.web.api.repository.modelo.Profesor;


@ApplicationScoped
@Transactional  
public class HijoProfesorRepoImpl implements IHijoProfesorRepo {

    @PersistenceContext 
    private EntityManager entityManager;

    @Override
    public List<HijoProfesor> buscarPorProfesorId(Integer id) {
        TypedQuery<HijoProfesor> myQuery = this.entityManager.createQuery("SELECT hprof FROM HijoProfesor hprof WHERE hprof.profesor.id = :id", HijoProfesor.class);
        myQuery.setParameter("id", id);
        return myQuery.getResultList();
    }

}
