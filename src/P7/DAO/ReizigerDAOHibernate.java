package P7.DAO;

import P7.Domein.Reiziger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ReizigerDAOHibernate extends BaseDAOHibernate implements ReizigerDAO{
    private static SessionFactory factory;

    public ReizigerDAOHibernate(Session sess) {
        super(sess);
    }

    private final EntityManager entityManager = sess;

    @Override
    public void save(Reiziger reiziger) throws SQLException {
        try {
            entityManager.getTransaction();
            executeInsideTransaction(entityManager -> entityManager.persist(reiziger));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void update(Reiziger reiziger) throws SQLException {
        try {
            reiziger.setAchternaam("Brokkenpiloot");
            reiziger.setVoorletters("XD");
            executeInsideTransaction(entityManager -> entityManager.merge(reiziger));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Reiziger reiziger) throws SQLException {
        try {
            executeInsideTransaction(entityManager -> entityManager.remove(reiziger));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Reiziger findById(int id) throws SQLException {
        return entityManager.find(Reiziger.class, id);
    }

    @Override
    public List<Reiziger> findByGbdatum(Date datum) throws SQLException {
        Query query = entityManager.createQuery("SELECT e FROM Reiziger e WHERE geboortedatum = 'datum'");
        return query.getResultList();
    }

    @Override
    public List<Reiziger> findAll() throws SQLException {
        Query query = entityManager.createQuery("SELECT e FROM Reiziger e");
        return query.getResultList();
    }
}
