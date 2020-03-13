import anatolii.dao.UserDAO;
import anatolii.dao.hibernate.HibernateUserDAOImpl;
import anatolii.model.User;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new HibernateUserDAOImpl();
        User userTest = new User();
        User userTest2 = new User();
        userTest.setEmail("test@gmail.com");
        userTest.setName("1testUser");
        userTest.setSurname("testSurname");
        userTest.setPassword("test");
        userDAO.save(userTest);
    }
}
