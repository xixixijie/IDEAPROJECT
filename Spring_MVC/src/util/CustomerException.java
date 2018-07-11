package util;

/**
 * Created by xixi on 2018/7/9.
 */
public class CustomerException extends Exception{
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomerException(String message){
        super(message);
        this.message=message;

    }
}
