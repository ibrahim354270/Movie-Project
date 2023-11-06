import domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SaveFilm {
    public static void main(String[] args) {
        Configuration config = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Actor.class).
                addAnnotatedClass(Film.class).
                addAnnotatedClass(Category.class).
                addAnnotatedClass(Language.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Set<Actor> actorSet = new LinkedHashSet<>();
        actorSet.add(session.get(Actor.class, 7L));
        actorSet.add(session.get(Actor.class, 5L));

        Film film = new Film();
        film.setTitle("Titanic");
       // film.setLanguage(LanguageName.ENGLISH);
        film.setLength(194);
       // List<CategoryType> categoryList = new ArrayList<>();
     //  categoryList.add(CategoryType.ROMANCE);
     //  categoryList.add(CategoryType.FANTASY);
     //  categoryList.add(CategoryType.DRAMA);
      //  film.setCategoryList(categoryList);
        film.setRelaseYear(1997);
        film.setImdbScore(7.9);
        film.setActorList(actorSet);
        session.save(film);

        System.out.println(session.get(Film.class, 1L));




        tx.commit();
        session.close();
        sessionFactory.close();


    }
}
