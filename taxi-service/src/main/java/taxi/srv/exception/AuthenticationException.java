package taxi.srv.exception;

/**
 * Created by anton.shevchenko on 22.11.2015.
 */
public class AuthenticationException extends Exception{
    private final String message = "AuthenticationException ... ";

    public AuthenticationException() {
    }
    public AuthenticationException(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return message;
    }
}
