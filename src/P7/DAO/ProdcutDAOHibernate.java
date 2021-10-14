package P7.DAO;

import P7.Domein.OVChipkaart;
import P7.Domein.Product;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ProdcutDAOHibernate extends BaseDAOHibernate implements ProductDAO{
    public ProdcutDAOHibernate(Session sess) {
        super(sess);
    }

    @Override
    public boolean save(Product product) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Product product) throws SQLException {
        return false;
    }

    @Override
    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        return null;
    }
}
