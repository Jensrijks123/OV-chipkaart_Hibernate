package P7.DAO;

import P7.Domein.OVChipkaart;
import P7.Domein.Reiziger;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class OVChipkaartDAOHibernate extends BaseDAOHibernate implements  OVChipkaartDAO{

    public OVChipkaartDAOHibernate(Session sess) {
        super(sess);
    }

    @Override
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) throws SQLException {
        return null;
    }

    @Override
    public boolean save(OVChipkaart ovChipkaart) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OVChipkaart ovChipkaart) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(OVChipkaart ovChipkaart) throws SQLException {
        return false;
    }

    @Override
    public List<OVChipkaart> findAll() throws SQLException {
        return null;
    }
}
