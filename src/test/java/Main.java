import anatolii.dao.HotelDAO;
import anatolii.dao.RoomDAO;
import anatolii.dao.UserDAO;
import anatolii.dao.hibernate.HibernateHotelDAOImpl;
import anatolii.dao.hibernate.HibernateRoomDAOImpl;
import anatolii.dao.hibernate.HibernateUserDAOImpl;
import anatolii.model.Hotel;
import anatolii.model.Room;
import anatolii.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        UserDAO userDAO = new HibernateUserDAOImpl();
//        User userTest = new User();
//        User userTest2 = new User();
//        userTest.setEmail("test@gmail.com");
//        userTest.setName("1testUser");
//        userTest.setSurname("testSurname");
//        userTest.setPassword("test");
//        userDAO.save(userTest);
//
        HotelDAO hotelDAO = new HibernateHotelDAOImpl();
        Hotel hotel = hotelDAO.get(1L);
        System.out.println(hotel.getRoomList().get(0));


//        RoomDAO roomDAO = new HibernateRoomDAOImpl();
//        Room roomTest = new Room();
//        roomTest.setPersons(5);
//        roomTest.setPrice(new BigDecimal(5000));
//        roomTest.setAvailableFrom(LocalDate.parse("2020-12-31"));
//        roomDAO.save(roomTest);
    }
}
