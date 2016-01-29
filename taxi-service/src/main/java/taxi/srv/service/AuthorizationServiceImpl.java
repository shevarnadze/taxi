package taxi.srv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taxi.srv.dao.UserDao;
import taxi.srv.domain.User;
import taxi.srv.exception.AuthenticationException;

/**
 * Created by anton.shevchenko on 26.11.2015.
 * Реализовать регистрацию пользователя системы (оператора).
 Пользователь вводит:
 - логин (должен быть не менее 4 символов, не должен содержать пробелы)
 - идентификационный номер (10 цифр, без букв и других знаков)
 - пароль (должен быть не менее 8 символов,
 включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)
 - подтверждение пароля
 - пользователь с таким логином должен быть уникальным

 hw8.taxi.service.AuthorizationService
 boolean register(String login, String id, String pass, String confirm) throws AuthenticationException
 hw8.taxi.service.AuthorizationServiceImpl
 hw8.taxi.controller.RegisterController
 hw8.taxi.exception.AuthorizationException
 webapp
 jsps
 index.jsp
 register.jsp - форма регистрации
 spring
 context.xml

 Задание выполнить в модуле name_surname_web
 */
@Service("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    UserDao userDao;

    public AuthorizationServiceImpl() {
    }

    @Override
    public boolean register(String login, String id, String pass, String confirm) throws AuthenticationException {
        User user = new User(login, pass);
        System.out.println(user.getName());
        if(userDao.create(user)!=null){
            return true;
        }
        return false;
    }
}
