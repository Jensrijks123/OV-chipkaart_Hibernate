package P7.DAO;

import P7.Domein.Adres;
import P7.Domein.Reiziger;
import P7.Domein.Adres;

import java.sql.SQLException;
import java.util.List;

public interface AdresDAO {

    boolean save(Adres adres) throws SQLException;

    boolean update(Adres adres) throws SQLException;

    boolean delete(Adres adres) throws SQLException;

    Adres findByReiziger(Reiziger reiziger) throws SQLException;

    List<Adres> findAll() throws SQLException;

}
