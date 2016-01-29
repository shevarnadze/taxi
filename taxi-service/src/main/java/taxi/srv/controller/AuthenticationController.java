package taxi.srv.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import taxi.srv.exception.AuthenticationException;
import taxi.srv.service.AuthenticationService;

import java.util.Locale;

/**
 * Created by anton.shevchenko on 22.11.2015.
 * Оператор вводит логин и пароль.
 Если пароль с логином не совпадает то повторить ввод. Передача осуществляется методом POST.
 Колличество попыток ввода задается в properties файле. После последней неудачной попытки пользователь блокируется.
 Время действия пароля задается в сервисе
 После истечения действия пароля, пользователь должен поменять пароль. Предыдущий вводить нельзя

 hw8.taxi.service.AuthenticationService
 boolean authenticate(String login, String pass) throws AuthenticationException
 hw8.taxi.service.AuthenticationServiceImpl
 hw8.taxi.controller.AuthenticationController
 hw8.taxi.exception.AuthenticationException
 webapp
 WEB-INF
 jsps
 index.jsp - страница с формой аутентификации
 dashboard.jsp - поздравления об удачной аутентификации
 spring
 context.xml

 Задание выполнить в модуле name_surname_web
 */
@Controller
@SessionAttributes("Id")
//@ImportResource("classpath:conf.properties") TODO
public class AuthenticationController {
    public static final Logger log = Logger.getLogger(AuthenticationController.class);

    @Autowired
    public AuthenticationService authenticationService; //TODO

    public AuthenticationController() {
        Locale.setDefault(Locale.ENGLISH);
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

//    @RequestMapping(value = "/register", method = {RequestMethod.POST} )

    @RequestMapping(value = "/dashboard", method = {RequestMethod.POST} )
    public
    String authorization(@RequestParam("login") String login, @RequestParam("password") String password, Model model) {
        log.info("/dashboard service");
        try{
            if(authenticationService.authenticate(login, password)){
                log.info("/dashboard authorization: "+login);
                return "dashboard";
            }
        }catch(AuthenticationException e){
            e.printStackTrace();
        }
        log.info("/dashboard incorrect Login or pass for user: "+login);
        model.addAttribute("warning", login+": incorrect login or pass...");
        return "index";
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index() {
        log.info("/index controller");
        return "index";
    }

    @RequestMapping(value = "/angularModel", method = RequestMethod.GET)
    public String angularModel() {
        return "angularModel";
    }

}
