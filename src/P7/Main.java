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

    /**
     * Retouneer een Hibernate session.
     *
     * @return Hibernate session
     * @throws HibernateException
     */
    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
//        testFetchAll();
        testDAOHibernate();
    }

    /**
     * P6. Haal alle (geannoteerde) entiteiten uit de database.
     */
    private static void testFetchAll() {
        Session session = getSession();
        try {
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                Query query = session.createQuery("from " + entityType.getName());

                System.out.println("[Test] Alle objecten van type " + entityType.getName() + " uit database:");
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    private static ReizigerDAO rdao = new ReizigerDAOHibernate(getSession());

    private static void testDAOHibernate() throws SQLException {
        Session session = getSession();

        try {


            // Reiziger
            // Test Save Reiziger
            try {
                String gbdatumReiziger = "1995-12-03";
                Reiziger reiziger = new Reiziger();
                reiziger.setId(70);
                reiziger.setVoorletters("F");
                reiziger.setTussenvoegsel("van");
                reiziger.setAchternaam("Luc");
                reiziger.setGeboortedatum(java.sql.Date.valueOf(gbdatumReiziger));
                reiziger.setAdres(null);
                reiziger.setOvChipkaarten(null);
                rdao.save(reiziger);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test update Reiziger
            try {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test delete Reiziger
            try {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findById
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findByGbdatum
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findAll()
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            // Adres
            // Test Save Adres
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test update Adres
            try {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test delete Adres
            try {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findByReiziger
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findAll()
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            // OVChipkaart
            // Test findByReiziger
            try {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test save OVChipkaart
            try {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test update OVChipkaart
            try {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test delete OVChipkaart
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test findAll()
            try {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            // Product
            // Test save Product
            try {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test update Product
            try {
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Test delete Product
            try {

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