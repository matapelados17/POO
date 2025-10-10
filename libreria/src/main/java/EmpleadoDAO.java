import jakarta.persistence.*;
import java.util.List;

public class EmpleadoDAO {

    private EntityManagerFactory emf;

    public EmpleadoDAO() {
        emf = Persistence.createEntityManagerFactory("gestion_empleados_pu");
    }

    public void guardar(Empleado empleado) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(empleado);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Empleado buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public List<Empleado> buscarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void actualizar(Empleado empleado) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(empleado);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Empleado empleado = em.find(Empleado.class, id);
            if (empleado != null) {
                em.remove(empleado);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
