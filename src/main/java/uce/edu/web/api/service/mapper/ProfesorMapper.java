package uce.edu.web.api.service.mapper;

import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.repository.modelo.Profesor;
import uce.edu.web.api.service.to.EstudianteTo;
import uce.edu.web.api.service.to.ProfesorTo;

public class ProfesorMapper {

    public static ProfesorTo toTo(Profesor profesor){
        
        ProfesorTo proTo =  new ProfesorTo();
        proTo.setId(profesor.getId());
        proTo.setNombre(profesor.getNombre());
        proTo.setApellido(profesor.getApellido());
        proTo.setContrato(profesor.getContrato());
        proTo.setCorreo(profesor.getCorreo());
        proTo.setMateria(profesor.getCorreo());
        proTo.setSalario(profesor.getSalario());
        return proTo;
    }

    public static Profesor toEntity(ProfesorTo profesorTo){
        Profesor p = new Profesor();
        p.setId(profesorTo.getId());
        p.setNombre(profesorTo.getNombre());
        p.setApellido(profesorTo.getApellido());
        p.setContrato(profesorTo.getContrato());
        p.setCorreo(profesorTo.getCorreo());
        p.setMateria(profesorTo.getMateria());
        p.setSalario(profesorTo.getSalario());
        return p;
    }

}
