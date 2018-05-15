package db;

import models.Folder;
import models.Owner;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBOwner {

    private static Session session;

    public static List<Folder> getFoldersFromOwner(Owner owner){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Folder> results = null;
        try {
            Criteria cr = session.createCriteria(Folder.class);
            cr.add(Restrictions.eq("owner", owner));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
