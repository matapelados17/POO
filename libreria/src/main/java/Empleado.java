import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", unique = true, length = 150)
    private String email;

    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "activo")
    private Boolean activo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    public Empleado() {}

    public Empleado(String nombre, String apellido, String email, LocalDate fechaContratacion, Double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }

    @Override
    public String toString() {
        return "Empleado{id=" + id + ", nombre='" + nombre + "', apellido='" + apellido +
                "', email='" + email + "', fechaContratacion=" + fechaContratacion +
                ", salario=" + salario + ", activo=" + activo +
                ", cargo=" + (cargo != null ? cargo.getNombre() : "Sin cargo") + "}";
    }
}