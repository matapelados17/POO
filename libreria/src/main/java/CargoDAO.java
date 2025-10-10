import jakarta.persistence.*;
import java.util.List;

public class CargoDAO {

    private EntityManagerFactory emf;

    public CargoDAO() {
        emf = Persistence.createEntityManagerFactory("gestion_empleados_pu");
    }

    public void guardar(Cargo cargo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(cargo);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Cargo buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cargo.class, id);
        } finally {
            em.close();
        }
    }

    public List<Cargo> buscarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cargo c", Cargo.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void actualizar(Cargo cargo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(cargo);
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
            Cargo cargo = em.find(Cargo.class, id);
            if (cargo != null) {
                em.remove(cargo);
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