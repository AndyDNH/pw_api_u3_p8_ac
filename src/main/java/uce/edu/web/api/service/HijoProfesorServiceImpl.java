package uce.edu.web.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.HijoProfesorRepoImpl;
import uce.edu.web.api.repository.modelo.HijoProfesor;

@ApplicationScoped
public class HijoProfesorServiceImpl implements IHIjoProfesorService {

    @Inject
    private HijoProfesorRepoImpl hijoProfesorRepoImpl;

    @Override
    public List<HijoProfesor> buscarPorProfesorId(Integer id) {
        return this.hijoProfesorRepoImpl.buscarPorProfesorId(id);
    }

}
