package anatolii.dao.hibernate;

import anatolii.dao.RoomDAO;
import anatolii.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        return room;
    }

    @Override
    public void remove(Room room) {

    }

    @Override
    public List<Room> getAll() {
        return null;
    }
}
