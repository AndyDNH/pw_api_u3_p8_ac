package uce.edu.web.api.service.to;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.controller.ProfesorController;


public class ProfesorTo {

    private Integer id; 
    private String nombre; 
    private String apellido; 
    private String correo; 
    private String materia; 
    private Integer salario; 
    private String contrato;
    public Map<String,String> _links = new HashMap<>(); 
    
    public ProfesorTo(Integer id, String nombre, String apellido, String correo, String materia, Integer salario,
            String contrato,UriInfo uriInfo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.materia = materia;
        this.salario = salario;
        this.contrato = contrato;

        URI todosHijosProfesor = uriInfo.getBaseUriBuilder().path(ProfesorController.class)
        .path(ProfesorController.class,"obtenerHijosProfesorPorId").build(id);

        _links.put("hijos", todosHijosProfesor.toString());
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public Integer getSalario() {
        return salario;
    }
    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    public String getContrato() {
        return contrato;
    }
    public void setContrato(String contrato) {
        this.contrato = contrato;
    } 

    

}
