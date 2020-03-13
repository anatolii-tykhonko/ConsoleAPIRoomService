package anatolii.dao.hibernate;

import anatolii.dao.UserDAO;
import anatolii.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUserDAOImpl implements UserDAO {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public void save(User user) {
        Session session = this.sessionFactory.openSession();
        System.out.println("open session");
        Transaction transaction = session.getTransaction();
        transaction.begin();
            session.save(user);
            System.out.println("save user");
        /*
        Magic
        */
        transaction.commit();
        session.close();
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
