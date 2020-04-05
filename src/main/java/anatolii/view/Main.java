package anatolii.view;

import anatolii.apis.API;
import anatolii.apis.Application;
import anatolii.controller.*;
import anatolii.dao.ClientDAO;
import anatolii.dao.HotelDAO;
import anatolii.dao.RoomDAO;
import anatolii.dao.hibernate.HibernateClientDAOImpl;
import anatolii.dao.hibernate.HibernateHotelDAOImpl;
import anatolii.dao.hibernate.HibernateRoomDAOImpl;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new HibernateClientDAOImpl();
        HotelDAO hotelDAO = new HibernateHotelDAOImpl();
        RoomDAO roomDAO = new HibernateRoomDAOImpl();

        ClientController clientController = new ClientControllerImpl(clientDAO, roomDAO);
        HotelController hotelController = new HotelControllerImpl(hotelDAO);
        RoomController roomController = new RoomControllerImpl(roomDAO, hotelDAO);

        Application api = new Application(clientController, hotelController, roomController);

        ConsoleHelper consoleHelper = new ConsoleHelper(api);

        consoleHelper.loginService();
    }
}
