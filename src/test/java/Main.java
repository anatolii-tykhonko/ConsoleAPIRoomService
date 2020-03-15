import anatolii.dao.ClientDAO;
import anatolii.dao.hibernate.HibernateClientDAOImpl;
import anatolii.model.Client;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new HibernateClientDAOImpl();
        System.out.println("EXCEPTION");
        Client clientTest = new Client();
        clientTest.setName("t");
        clientTest.setSurname("tt");
        clientTest.setEmail("t.com");
        clientTest.setPassword("pas");
        clientDAO.save(clientTest);

//        HotelDAO hotelDAO = new HibernateHotelDAOImpl();
//        Hotel hotel = hotelDAO.get(1L);


//        RoomDAO roomDAO = new HibernateRoomDAOImpl();
//        Room roomTest = new Room();
//        roomTest.setPersons(5);
//        roomTest.setPrice(new BigDecimal(5000));
//        roomTest.setAvailableFrom(LocalDate.parse("2020-12-31"));
//        roomDAO.save(roomTest);
    }
}
