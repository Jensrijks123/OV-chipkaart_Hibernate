package P7;

import P7.DAO.*;
import P7.Domein.Adres;
import P7.Domein.OVChipkaart;
import P7.Domein.Product;
import P7.Domein.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    // Creëer een factory voor Hibernate sessions.
    private static final SessionFactory factory;

    static {
        try {
            // Create a Hibernate session factory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
        testDAOHibernate();
    }


    private static ReizigerDAO rdao = new ReizigerDAOHibernate(getSession());
    private static ProductDAO pdao = new ProdcutDAOHibernate(getSession());
    private static OVChipkaartDAO odao = new OVChipkaartDAOHibernate(getSession());
    private static AdresDAO adao = new AdresDAOHibernate(getSession());

    private static void testDAOHibernate() throws SQLException {
        Session session = getSession();

        try {

            // Reiziger
            // Test Save Reiziger
            try {
                String gbdatumReiziger = "2015-12-03";
                Reiziger reiziger = new Reiziger(191, "P", "", "GeertBroek", java.sql.Date.valueOf(gbdatumReiziger), null, null);
//                rdao.save(reiziger);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test update Reiziger
            try {
                String gbdatumReizigerUpdate = "1994-12-03";
                Reiziger reizigerUpdate = new Reiziger(68, "Stijn", "van", "Nieuwpoort", java.sql.Date.valueOf(gbdatumReizigerUpdate), null, null);
//                rdao.update(reizigerUpdate);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test delete Reiziger
            try {
                String gbdatumReiziger = "2015-12-03";
                Reiziger reizigerDelete = new Reiziger(191, "P", "", "GeertBroek", java.sql.Date.valueOf(gbdatumReiziger), null, null);
//                rdao.delete(reizigerDelete);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findById
            try {
                int reizigerId = 191;
//                System.out.println(rdao.findById(reizigerId));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findByGbdatum
            try {
                String gbdatumReiziger1 = "2015-12-03";
//                System.out.println(rdao.findByGbdatum(java.sql.Date.valueOf(gbdatumReiziger1)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findAll()
            try {
//                System.out.println(rdao.findAll());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            // Adres
            // Test Save Adres
            try {
                Adres adres = new Adres(66, "3450CJ", "11", "Beneben", "Ijsselstein", null);
//                adao.save(adres);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test update Adres
            try {
                Adres adres = new Adres(66, "3450CJ", "11", "aaaaa", "Ijsselstein", null);
//                adao.update(adres);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test delete Adres
            try {
                Adres adres = new Adres(66, "3450CJ", "11", "Beneben", "Ijsselstein", null);
//                adao.delete(adres);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findByReiziger
            try {
                String gbdatumReiziger = "2015-12-03";
                Reiziger reiziger = new Reiziger(191, "P", "", "GeertBroek", java.sql.Date.valueOf(gbdatumReiziger), null, null);
//                System.out.println(adao.findByReiziger(reiziger));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findAll()
            try {
//                System.out.println(adao.findAll());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            // OVChipkaart
            // Test findByReiziger
            try {
                String gbdatumReiziger = "2015-12-03";
                Reiziger reiziger = new Reiziger(191, "P", "", "GeertBroek", java.sql.Date.valueOf(gbdatumReiziger), null, null);
//                System.out.println(odao.findByReiziger(reiziger));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test save OVChipkaart
            try {
                String gbdatumReiziger = "2022-12-03";
                OVChipkaart ovChipkaart = new OVChipkaart(57, java.sql.Date.valueOf(gbdatumReiziger), 1, 3.0, null, null);
//                odao.save(ovChipkaart);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test update OVChipkaart
            try {
                String gbdatumReiziger = "2022-12-03";
                OVChipkaart ovChipkaart = new OVChipkaart(57, java.sql.Date.valueOf(gbdatumReiziger), 1, 8.0, null, null);
//                odao.update(ovChipkaart);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test delete OVChipkaart
            try {
                String gbdatumReiziger = "2022-12-03";
                OVChipkaart ovChipkaart = new OVChipkaart(57, java.sql.Date.valueOf(gbdatumReiziger), 1, 3.0, null, null);
//                odao.delete(ovChipkaart);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findAll()
            try {
//                System.out.println(odao.findAll());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            // Product
            // Test save Product
            try {
                Product product = new Product(7, "BOB", "djfkgkldfg", 30.0, null);
//                pdao.save(product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test update Product
            try {
                Product product = new Product(7, "BOB", "aaaaaa", 30.0, null);
//                pdao.update(product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test delete Product
            try {
                Product product = new Product(7, "BOB", "djfkgkldfg", 30.0, null);
//                pdao.delete(product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test dfindByOVChipkaart
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findAll()
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } finally {
            session.close();
        }
    }
}