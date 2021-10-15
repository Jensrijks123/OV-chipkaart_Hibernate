package P7.DAO;

import P7.Domein.Adres;
import P7.Domein.OVChipkaart;
import P7.Domein.Product;
import P7.Domein.Reiziger;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class AdresDAOHibernate extends BaseDAOHibernate implements AdresDAO{

    public AdresDAOHibernate(Session sess) {
        super(sess);
    }

    private final EntityManager entityManager = sess;


    @Override
    public boolean save(Adres adres) throws SQLException {
        try {
            executeInsideTransaction(entityManager -> entityManager.persist(adres));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Adres adres) throws SQLException {
        try {
            adres.setHuisnummer("47");
            adres.setWoonplaats("Benschop");
            executeInsideTransaction(entityManager -> entityManager.merge(adres));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Adres adres) throws SQLException {
        try {
            executeInsideTransaction(entityManager -> entityManager.remove(adres));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    @Override
    public Adres findByReiziger(Reiziger reiziger) throws SQLException {
        return entityManager.find(Adres.class, reiziger.getAdres());
    }

    @Override
    public List<Adres> findAll() throws SQLException {
        Query query = entityManager.createQuery("SELECT e FROM Adres e");
        return query.getResultList();
    }
}
