package taxi.srv.service;

import taxi.srv.exception.AuthenticationException;

/**
 * Created by anton.shevchenko on 22.11.2015.
 */
public interface AuthenticationService {
    boolean authenticate(String login, String pass) throws AuthenticationException;
    boolean setExpireTimeDays(String name, int expireTimeDays);
}
