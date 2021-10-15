package P7.DAO;

import P7.Domein.OVChipkaart;
import P7.Domein.Product;
import P7.Domein.Reiziger;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class OVChipkaartDAOHibernate extends BaseDAOHibernate implements  OVChipkaartDAO{

    public OVChipkaartDAOHibernate(Session sess) {
        super(sess);
    }
    private final EntityManager entityManager = sess;


    @Override
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) throws SQLException {
        Query query = entityManager.createQuery("SELECT e FROM ov_chipkaart e");
        return query.getResultList();
    }

    @Override
    public boolean save(OVChipkaart ovChipkaart) throws SQLException {
        try {
            executeInsideTransaction(entityManager -> entityManager.persist(ovChipkaart));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(OVChipkaart ovChipkaart) throws SQLException {
        try {
            ovChipkaart.setKlasse(2);
            ovChipkaart.setSaldo(25.1);
            executeInsideTransaction(entityManager -> entityManager.merge(ovChipkaart));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(OVChipkaart ovChipkaart) throws SQLException {
        try {
            executeInsideTransaction(entityManager -> entityManager.remove(ovChipkaart));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<OVChipkaart> findAll() throws SQLException {
        Query query = entityManager.createQuery("SELECT e FROM ov_chipkaart e");
        return query.getResultList();
    }
}
