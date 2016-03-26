package ces22;

public class WrongInputException extends Exception {

    private String message;

    WrongInputException(String a) {
        message = a;
    }

    @Override
    public String getMessage() {
        return message;
    }
}