package DB;

import models.File;
import models.Folder;
import models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static void update(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T>List<T> getList(Criteria criteria){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try{
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T>List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(classType);
        results = getList(criteria);
        return results;

    }

    public static List<File> getFilesFromFolder(Folder folder){
        session = HibernateUtil.getSessionFactory().openSession();
        List<File> results = null;
        Criteria criteria = session.createCriteria(File.class);
        criteria.add(Restrictions.eq("folder", folder));
        results = getList(criteria);
        return results;

    }

    public static List<Folder> getFoldersFromOwner(Owner owner){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Folder> results = null;
        Criteria criteria = session.createCriteria(Folder.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("owner", owner));
        results = getList(criteria);
        return results;
    }




}
