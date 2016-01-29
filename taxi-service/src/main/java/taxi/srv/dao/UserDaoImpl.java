package taxi.srv.dao;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.srv.domain.User;

import java.util.List;

/**
 * Created by anton.shevchenko on 26.11.2015.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private static Logger log = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Override
//    @Transactional(readOnly = true)
    public boolean isExisting(String name){
        Session session = null;
        try{
            session = sessionFactory.openSession();
            Query q = session.createQuery("from User u where u.name=?");
            q.setString(0,name);
            if(q.list().size()>0){
                return true;
            }
        }catch (HibernateException e) {
            log.error("Open session filed");
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return false;
    }

    @Override
    public Long create(User user) {
        if(!isExisting(user.getName())){
            return null;
        }
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            long id = (long) session.save(user);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException e){
            log.error("Open session filed");
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return null;
    }

    @Override
//    @Transactional(readOnly = true)
    public User read(Long id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            return (User) session.get(User.class, id);
        }catch (HibernateException e){
            log.error("Open session filed");
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public User read(String login) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            Query q = session.createQuery("from User u where u.name=?");
            q.setString(0,login);
            List<User> users = q.list();
            if(q.list().size()>0){
                return users.get(0);
            }
        }catch (HibernateException e) {
            log.error("Open session filed");
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(User user) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(user);
            return true;
        }catch (HibernateException e){
            log.error("Open session filed");
            session.getTransaction().rollback();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return false;
    }

    @Override
//    @Transactional(readOnly = true)
    public List findAll() {
        Session session = null;
        List users;
        Query q;
        try{
            session = sessionFactory.openSession();
        }catch (HibernateException e){
            log.error("Open session filed");
        }try{
            q = session.createQuery("from User");
            users = q.list();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        return users;
    }

    @Override
    public boolean authenticate(String login, String pass) {
        if(!isExisting(login)){
            return false;
        }
        List<User> users = findAll();
        if(users!=null){
            for (User u:users){
                if(u.getName().equals(login)){
                    if(u.getPassword().equals(pass)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
