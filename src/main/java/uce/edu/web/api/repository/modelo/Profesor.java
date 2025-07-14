package uce.edu.web.api.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name = "profe_id")
    private Integer id; 

    @Column(name = "profe_nombre")
    private String nombre; 

    @Column(name = "profe_apellido")
    private String apellido; 

    @Column(name = "profe_correo")
    private String correo; 

    @Column(name = "profe_materia")
    private String materia; 

    @Column(name = "profe_salario")
    private Integer salario; 

    @Column(name = "profe_contrato")
    private String contrato; 

    @OneToMany(mappedBy = "profesor")
    private List<HijoProfesor> hijosprofesor;

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

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
    


}
