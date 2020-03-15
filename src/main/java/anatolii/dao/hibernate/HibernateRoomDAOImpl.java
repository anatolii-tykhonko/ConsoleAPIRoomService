package anatolii.dao.hibernate;

import anatolii.dao.RoomDAO;
import anatolii.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateRoomDAOImpl implements RoomDAO {
         private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Override
    public void save(Room room) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(room);
        transaction.commit();
        session.close();
    }

    @Override
    public Room get(Long id) {
        Session session = this.sessionFactory.openSession();
        Room room = session.get(Room.class, id);
        session.close();
        return room;
    }

    @Override
    public void update(Room room) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(room);
        transaction.commit();
        session.close();
    }

    @Override
    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Room room = session.get(Room.class, id);
        session.delete(room);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Room> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Room");
        List<Room> rooms = query.list();
        session.close();
        return rooms;
    }
}
