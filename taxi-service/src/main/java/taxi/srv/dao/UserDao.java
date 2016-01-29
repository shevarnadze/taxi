package taxi.srv.dao;


import taxi.srv.domain.User;

import java.util.List;

/**
 * Created by anton.shevchenko on 26.11.2015.
 */
public interface UserDao {
    Long create(User user);
    User read(Long id);
    User read(String login);
    boolean update(User user);
//    boolean delete(User user);
    boolean isExisting(String name);
    List findAll();
    boolean authenticate(String login, String pass);
}
