package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Profesor;

@Transactional
@ApplicationScoped
public class ProfesorRepoImpl implements IProfesorRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Profesor recuperaProfesorPorId(Integer id) {
        return this.entityManager.find(Profesor.class, id);   
    }

    @Override
    public List<Profesor> recuperarTodos(String contrato) {
        TypedQuery<Profesor> typedQuery = this.entityManager.createQuery("SELECT e FROM Profesor e WHERE e.contrato =:contrato ",Profesor.class);
        typedQuery.setParameter("contrato", contrato);
        return typedQuery.getResultList();
    }

    

    @Override
    public void borrarPorId(Integer id) {
        this.entityManager.remove(recuperaProfesorPorId(id));
    }

    @Override
    public void insertar(Profesor profesor) {
        this.entityManager.persist(profesor);
    }

    @Override
    public void actualizarProfesor(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

    @Override
    public void actualizarProfesorParcial(Profesor profesor) {
        this.entityManager.merge(profesor);
    }

}
