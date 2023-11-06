package repository;

import config.HibernateUtils;
import domain.Language;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class LanguageRepo {//db bağlanmaya sağlayan methodları içericek-data çekme data gönderme
    private Session session;//oturum açmak için

    public List<Language> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            List<Language> languageList = session.createQuery("FROM Language", Language.class).getResultList();
            return languageList;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }



}
