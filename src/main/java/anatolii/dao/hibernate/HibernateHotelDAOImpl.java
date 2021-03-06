package anatolii.dao.hibernate;

import anatolii.dao.HotelDAO;
import anatolii.model.Hotel;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateHotelDAOImpl implements HotelDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Override
    public void save(Hotel hotel) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(hotel);
        transaction.commit();
        session.close();
    }

    @Override
    public Hotel get(Long id) {
        Session session = this.sessionFactory.openSession();
        Hotel hotel = session.get(Hotel.class, id);
        Hibernate.initialize(hotel.getRoomList());
        session.close();
        return hotel;
    }

    @Override
    public void update(Hotel hotel) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(hotel);
        transaction.commit();
        session.close();
    }

    @Override
    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Hotel hotel = session.get(Hotel.class, id);
        session.delete(hotel);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Hotel> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Hotel");
        List<Hotel> hotels = query.list();
        session.close();
        return hotels;
    }

    @Override
    public List<Hotel> findHotelByName(String hotelName) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Hotel h WHERE h.hotelName = :hotelName");
        query.setParameter("hotelName", hotelName);
        List<Hotel> hotelsName = query.list();
        session.close();
        return hotelsName;
    }

    @Override
    public List<Hotel> findHotelByCity(String cityName) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Hotel h WHERE h.cityName = :cityName");
        query.setParameter("cityName", cityName);
        List<Hotel> hotelsByCity = query.list();
        hotelsByCity.forEach(hotel -> Hibernate.initialize(hotel.getRoomList()));
        session.close();
        return hotelsByCity;
    }
}
