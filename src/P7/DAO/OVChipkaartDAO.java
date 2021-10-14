package P7.DAO;



import P7.Domein.OVChipkaart;
import P7.Domein.Reiziger;

import java.sql.SQLException;
import java.util.List;

public interface OVChipkaartDAO {

    List<OVChipkaart> findByReiziger(Reiziger reiziger) throws SQLException;

    boolean save(OVChipkaart ovChipkaart) throws SQLException;

    boolean update(OVChipkaart ovChipkaart) throws SQLException;

    boolean delete(OVChipkaart ovChipkaart) throws SQLException;

    List<OVChipkaart> findAll() throws SQLException;
}
