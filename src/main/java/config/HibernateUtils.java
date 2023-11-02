package config;

import domain.Actor;
import domain.Category;
import domain.Film;
import domain.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    //uygulama çalıştığında config yapılsın o yüzden static bloack içine aldık
    static {
        try {
            Configuration config = new Configuration().//yapılandırma ayarlarını xml dosyasına ve Annotatec classlarına göre yap dedik.
                    configure("hibernate.cfg.xml").//parametre zorunlu değil,default olarak hibernate.cfg.xml bu şekilde ar,o yüzden xml dosyasına bu ismi verdik
                    addAnnotatedClass(Actor.class).
                    addAnnotatedClass(Film.class).
                    addAnnotatedClass(Category.class).
                    addAnnotatedClass(Language.class);

            sessionFactory = config.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initial Session Factory is failed!");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //sf kapatalım
    public static void shutDown() {
        getSessionFactory().close();
    }

    //sessionı da kapatalım
    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) { //böyle bir sessin varsa ve açıksa bunu kapat
            session.close();
        }
    }


}
