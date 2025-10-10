import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Crear DAOs
        CargoDAO cargoDAO = new CargoDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        try {
            // Crear cargos
            Cargo gerente = new Cargo("Gerente", "Responsable del departamento", 5000.0);
            Cargo desarrollador = new Cargo("Desarrollador", "Desarrollo de software", 3000.0);

            cargoDAO.guardar(gerente);
            cargoDAO.guardar(desarrollador);

            // Crear empleados
            Empleado emp1 = new Empleado("Juan", "Pérez", "juan@empresa.com",
                    LocalDate.now(), 3500.0);
            emp1.setCargo(desarrollador);

            Empleado emp2 = new Empleado("María", "Gómez", "maria@empresa.com",
                    LocalDate.now(), 5500.0);
            emp2.setCargo(gerente);

            empleadoDAO.guardar(emp1);
            empleadoDAO.guardar(emp2);

            // Listar todos los empleados
            System.out.println("=== EMPLEADOS ===");
            empleadoDAO.buscarTodos().forEach(System.out::println);

            // Listar todos los cargos
            System.out.println("\n=== CARGOS ===");
            cargoDAO.buscarTodos().forEach(System.out::println);

        } finally {
            cargoDAO.close();
            empleadoDAO.close();
        }
    }
}