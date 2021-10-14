package P7.DAO;

import P7.Domein.Reiziger;
import P7.Main;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.security.auth.login.Configuration;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ReizigerDAOHibernate extends BaseDAOHibernate implements ReizigerDAO{
    private static SessionFactory factory;

    private EntityManager entityManager;

    public ReizigerDAOHibernate(Session sess) {
        super(sess);
    }

    @Override
    public void save(Reiziger reiziger) throws SQLException {
        try {
            executeInsideTransaction(entityManager -> entityManager.persist(reiziger));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sess.close();
        }
    }


    @Override
    public void update(Reiziger reiziger) throws SQLException {

    }

    @Override
    public void delete(Reiziger reiziger) throws SQLException {

    }

    @Override
    public Reiziger findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Reiziger> findByGbdatum(Date datum) throws SQLException {
        return null;
    }

    @Override
    public List<Reiziger> findAll() throws SQLException {
        return null;
    }
}
