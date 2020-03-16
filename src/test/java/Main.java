import anatolii.dao.ClientDAO;
import anatolii.dao.HotelDAO;
import anatolii.dao.RoomDAO;
import anatolii.dao.hibernate.HibernateClientDAOImpl;
import anatolii.dao.hibernate.HibernateHotelDAOImpl;
import anatolii.dao.hibernate.HibernateRoomDAOImpl;
import anatolii.model.Client;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new HibernateClientDAOImpl();
//        Client clientTest = new Client();
//        clientTest.setName("t");
//        clientTest.setSurname("tt");
//        clientTest.setEmail("t.com");
//        clientTest.setPassword("pas");
//        clientDAO.save(clientTest);

        HotelDAO hotelDAO = new HibernateHotelDAOImpl();
//        hotelDAO.remove(3L);
//        Hotel hotel = new Hotel();
//        hotel.setCityName("Kiev");
//        hotel.setHotelName("Star");
//        hotelDAO.save(hotel);
//        hotel = hotelDAO.get(1L);

        RoomDAO roomDAO = new HibernateRoomDAOImpl();
//        roomDAO.remove(2L);
//        Room roomTest = new Room();
//        roomTest.setPersons(5);
//        roomTest.setPrice(new BigDecimal(5000));
//        roomTest.setAvailableFrom(LocalDate.of(2020,12,31));
//        roomDAO.save(roomTest);
//        Room roomTest= roomDAO.get(5L);
//        roomTest.setHotel(hotel);
//        roomTest.setReserveBefore(LocalDate.of(2021,01,02));
//        roomTest.setStatus(true);
//        roomDAO.update(roomTest);
//        System.out.println(roomDAO.get(11L));
//        System.out.println(roomDAO.get(20L));
//        roomTest.setClient(clientDAO.get(4L));
//        roomDAO.update(roomTest);
//        roomDAO.remove(4L);
        clientDAO.remove(4L);

    }
}
