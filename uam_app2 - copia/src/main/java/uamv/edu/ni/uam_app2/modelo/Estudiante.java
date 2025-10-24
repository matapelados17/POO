package uamv.edu.ni.uam_app2.modelo;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Estudiante {
    @Id
    private String cif;
    @Column(name = "nombre", length = 30, nullable = false)
    @Required(message = "Nombre no puede quedar vacio...")
    private String nombres;
    @Column(name = "Apellidos", length = 20, nullable = false)
    @Required(message = "Apellidos no puede quedar vacio...")
    private String apellidos;
    LocalDate fechaNac;

}