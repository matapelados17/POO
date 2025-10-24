package uamv.edu.ni.uam_app2.modelo;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class Carrera{
    @Id
    private String id;
    @Column(name = "nombre", length = 50)
    @Required(message = "Nombre no puede quedar vacio...")
    private String nombres;
    @Column(name = "Descripcion de la carrera", length = 70)
    @Required(message = "descripcions no puede quedar vacio...")
    private String descripcion;

}
