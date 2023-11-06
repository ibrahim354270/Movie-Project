import domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {
        Actor actor = new Actor();
        actor.setName("Leonardo Di Caprio");
        actor.setGender(Gender.MALE);
        actor.setAge(48);

        Actor actor1 = new Actor();
        actor1.setName("Robert De Niro");
        actor1.setGender(Gender.MALE);
        actor1.setAge(80);

        Actor actor2 = new Actor();
        actor2.setName("Natalie Portman");
        actor2.setGender(Gender.FEMALE);
        actor2.setAge(38);

        Actor actor3 = new Actor();
        actor3.setName("Christian Bale");
        actor3.setGender(Gender.MALE);
        actor3.setAge(51);

        Actor actor4 = new Actor();
        actor4.setName("Angelina Jolie");
        actor4.setGender(Gender.FEMALE);
        actor4.setAge(48);

        Actor actor5 = new Actor();
        actor5.setName("Kate Winslet");
        actor5.setGender(Gender.FEMALE);
        actor5.setAge(48);
        Actor actor6 = new Actor();
        actor6.setName("Cillian Murphy");
        actor6.setGender(Gender.MALE);
        actor6.setAge(47);

       Configuration config = new Configuration().//yapılandırma ayarlarını xml dosyasına ve Annotatec classlarına göre yap dedik.
                configure("hibernate.cfg.xml").//parametre zorunlu değil,default olarak hibernate.cfg.xml bu şekilde ar,o yüzden xml dosyasına bu ismi verdik
                addAnnotatedClass(Actor.class).
                addAnnotatedClass(Film.class).
                addAnnotatedClass(Category.class).
                addAnnotatedClass(Language.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session= sessionFactory.openSession();

        Transaction tx=session.beginTransaction();

        session.save(actor);
        session.save(actor1);
        session.save(actor2);
        session.save(actor3);
        session.save(actor4);
        session.save(actor5);
        session.save(actor6);




        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
