package repository;

import config.HibernateUtils;
import domain.Actor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ActorRepository {
    private Session session;
    public Actor findById(Long id) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Actor.class,id);

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public List<Actor> findAll() {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            String hql = "FROM Actor";
            List<Actor> actors = session.createQuery(hql, Actor.class).getResultList();
            HibernateUtils.closeSession(session);
            return actors;
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public void save(Actor actor) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            session.save(actor);

            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }
    public void deleteById(Actor actor) {
        try  {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(actor);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }

    }
}

