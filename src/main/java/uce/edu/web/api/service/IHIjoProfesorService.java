package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.repository.modelo.HijoProfesor;

public interface IHIjoProfesorService {

    public List<HijoProfesor> buscarPorProfesorId(Integer id);

}
