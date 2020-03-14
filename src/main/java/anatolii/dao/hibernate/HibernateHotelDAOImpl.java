package anatolii.dao.hibernate;

import anatolii.dao.HotelDAO;
import anatolii.model.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateHotelDAOImpl implements HotelDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Override
    public void save(Hotel hotel) {

    }

    @Override
    public Hotel get(Long id) {
        Session session = this.sessionFactory.openSession();
        Hotel hotel = session.get(Hotel.class, id);
        session.close();
        return hotel;
    }

    @Override
    public void remove(Hotel hotel) {

    }

    @Override
    public List<Hotel> getAll() {
        return null;
    }
}
