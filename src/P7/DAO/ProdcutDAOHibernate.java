package P7.DAO;

import P7.Domein.OVChipkaart;
import P7.Domein.Product;
import P7.Domein.Reiziger;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ProdcutDAOHibernate extends BaseDAOHibernate implements ProductDAO{

    public ProdcutDAOHibernate(Session sess) {
        super(sess);
    }

    private final EntityManager entityManager = sess;

    @Override
    public boolean save(Product product) throws SQLException {
        try {
            executeInsideTransaction(entityManager -> entityManager.persist(product));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        try {
            product.setBeschrijving("De beste op het moment");
            product.setNaam("XDDe Snelste");
            executeInsideTransaction(entityManager -> entityManager.merge(product));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Product product) throws SQLException {
        try {
            executeInsideTransaction(entityManager -> entityManager.remove(product));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart) throws SQLException {
        Query query = entityManager.createQuery("SELECT e FROM Product e");
        return query.getResultList();
    }

    @Override
    public List<Product> findAll() throws SQLException {
        Query query = entityManager.createQuery("SELECT e FROM Product e");
        return query.getResultList();
    }
}
