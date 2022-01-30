package tr.com.r10.portal.exceptions;

public class NotFoundException extends RuntimeException{
    public static final String MESSAGE_CODE= "NOT_FOUND_EXCEPTION";
    public NotFoundException(String message) {
        super(message);
    }

    public static String getMessageCode() {
        return MESSAGE_CODE;
    }
}