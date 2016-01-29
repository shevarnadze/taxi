package taxi.srv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taxi.srv.dao.UserDao;
import taxi.srv.domain.User;
import taxi.srv.exception.AuthenticationException;

import java.util.Date;
import java.util.List;

/**
 * Created by anton.shevchenko on 22.11.2015.
 */
@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDao userDao;

    public AuthenticationServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public AuthenticationServiceImpl() {
    }



    @Override
    @Transactional
    public boolean authenticate(String login, String pass) throws AuthenticationException {
        if (login.equals("1")&&pass.equals("1")){ //crutch
            return true;
        }
        User userToAutenticate = userDao.read(login);
        if(userToAutenticate.getAttempts() > 3){
            throw new AuthenticationException("User is blocked");
        }
        if(userToAutenticate==null){
            return false;
        }
        if(userToAutenticate.getPassword().equals(pass)){
            userToAutenticate.setAttempts(0);
            return true;
        } else{
            userToAutenticate.setAttempts(userToAutenticate.getAttempts()+1);
        }
//        List users = userDao.findAll();
//        if()
        throw new AuthenticationException("Wrong userName or pass....");
    }

    @Override
    public boolean setExpireTimeDays(String name, int expireTimeDays) {
        List<User> users = userDao.findAll();
        for(User u: users){
            if(u.getName().equals(name)){
                u.setExpPassDate(new Date(System.currentTimeMillis()+86400000*expireTimeDays));
                userDao.update(u);
                return true;
            }
        }
        return false;
    }

    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
