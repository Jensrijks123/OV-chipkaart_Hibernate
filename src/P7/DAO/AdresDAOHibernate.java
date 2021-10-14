package P7.DAO;

import P7.Domein.Adres;
import P7.Domein.Reiziger;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class AdresDAOHibernate extends BaseDAOHibernate implements AdresDAO{

    public AdresDAOHibernate(Session sess) {
        super(sess);
    }

    @Override
    public boolean save(Adres adres) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Adres adres) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Adres adres) throws SQLException {
        return false;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) throws SQLException {
        return null;
    }

    @Override
    public List<Adres> findAll() throws SQLException {
        return null;
    }
}
