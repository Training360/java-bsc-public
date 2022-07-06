package catalog;

public class WrongFormatException extends RuntimeException {

    public WrongFormatException() {
    }

    public WrongFormatException(String message) {
        super(message);
    }

    public WrongFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
