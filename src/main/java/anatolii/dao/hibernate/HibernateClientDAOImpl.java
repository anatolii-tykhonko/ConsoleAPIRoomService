package anatolii.dao.hibernate;

import anatolii.dao.ClientDAO;
import anatolii.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;


public class HibernateClientDAOImpl implements ClientDAO {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public void save(Client client) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public Client get(Long id) {
        Session session = this.sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    @Override
    public void update(Client client) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void remove(Long id) {
        Session session =this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Client client = session.get(Client.class, id);
        session.remove(client);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Client> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Client");
        List<Client> clients = query.list();
        session.close();
        return clients;
    }
}
