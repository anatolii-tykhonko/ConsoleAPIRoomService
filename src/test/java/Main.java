import anatolii.controller.ClientController;
import anatolii.controller.ClientControllerImpl;
import anatolii.controller.HotelController;
import anatolii.controller.HotelControllerImpl;
import anatolii.dao.ClientDAO;
import anatolii.dao.HotelDAO;
import anatolii.dao.RoomDAO;
import anatolii.dao.hibernate.HibernateClientDAOImpl;
import anatolii.dao.hibernate.HibernateHotelDAOImpl;
import anatolii.dao.hibernate.HibernateRoomDAOImpl;
import anatolii.exception.HotelAlreadyExist;
import anatolii.exception.ValidStringNameException;
import anatolii.model.Client;
import anatolii.model.Hotel;
import anatolii.model.Room;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new HibernateClientDAOImpl();
//        System.out.println(clientDAO.getAll());
//        Client client = clientDAO.getByEmail("zzz@gmail.com");
//        System.out.println(client);
        Client clientTest = new Client();
        clientTest.setName("t");
        clientTest.setSurname("tt");
        clientTest.setEmail("t.com");
        clientTest.setPassword("pas");
        clientDAO.save(clientTest);
        System.out.println(clientDAO.get(1l));
//        clientDAO.reserveRoom(1L, 1L, LocalDate.of(2020, 04, 04));
//        clientDAO.cancelReserveRoom(1L);

        HotelDAO hotelDAO = new HibernateHotelDAOImpl();
//
//        List<Hotel> hotels = hotelDAO.getAll();
//        for(Hotel hotel : hotels){
//            System.out.println(hotel.getRoomList());
//        }

//        hotelDAO.remove(3L);
//        Hotel hotel = new Hotel();
//        hotel.setCityName("Kiev");
//        hotel.setHotelName("Star");
//        hotelDAO.save(hotel);
//        hotel = hotelDAO.get(1L);
//        System.out.println(hotelDAO.findHotelByCity("Kiev"));

        RoomDAO roomDAO = new HibernateRoomDAOImpl();
//        roomDAO.remove(2L);
//        Room roomTest = new Room();
//        roomTest.setPersons(5);
//        roomTest.setPrice(new BigDecimal(5000));
//        roomTest.setAvailableFrom(LocalDate.of(2020,12,31));
//        roomDAO.save(roomTest);
//        Room roomTest= roomDAO.get(100L);
//        System.out.println(roomTest);
//
//        roomTest.setHotel(hotel);
//        roomTest.setReserveBefore(LocalDate.of(2021,01,02));
//        roomTest.setStatus(true);
//        roomDAO.update(roomTest);
//        System.out.println(roomDAO.get(11L));
//        System.out.println(roomDAO.get(20L));
//        roomTest.setClient(clientDAO.get(4L));
//        roomDAO.update(roomTest);
//        roomDAO.remove(4L);
//        clientDAO.remove(4L);

//        HotelController hotelController = new HotelControllerImpl(new HibernateHotelDAOImpl());
//        try {
//            hotelController.addHotel("Smoke", "Lviv");
//        } catch (HotelAlreadyExist hotelAlreadyExist) {
//            System.out.println(hotelAlreadyExist.getMessage());
//        }
//        String line = "asnfjkbvkjnalnlD";
//        String line2 = "sknfan*dnafj!";
//        try {
//            System.out.println(validLine(line));
//            System.out.println(validLine(line2));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//        public static boolean validLine(String line) throws ValidStringNameException {
//        String param = "\\W";
//            Pattern pattern = Pattern.compile(param);
//            Matcher matcher = pattern.matcher(line);
//            if (matcher.find()) {
//                throw new ValidStringNameException("Название не должно включать цифры или символы!!!\nВведите данные заново!\n");
//            }
//            return true;
        }

}
