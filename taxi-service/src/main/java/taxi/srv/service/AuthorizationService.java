package taxi.srv.service;


import taxi.srv.exception.AuthenticationException;

/**
 * Created by anton.shevchenko on 26.11.2015.
 */
public interface AuthorizationService {
    boolean register(String login, String id, String pass, String confirm) throws AuthenticationException;
}
