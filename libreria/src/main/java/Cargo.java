import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "salario_base", nullable = false)
    private Double salarioBase;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private List<Empleado> empleados = new ArrayList<>();

    public Cargo() {}

    public Cargo(String nombre, String descripcion, Double salarioBase) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.salarioBase = salarioBase;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(Double salarioBase) { this.salarioBase = salarioBase; }

    public List<Empleado> getEmpleados() { return empleados; }
    public void setEmpleados(List<Empleado> empleados) { this.empleados = empleados; }

    @Override
    public String toString() {
        return "Cargo{id=" + id + ", nombre='" + nombre + "', descripcion='" + descripcion + "', salarioBase=" + salarioBase + "}";
    }
}