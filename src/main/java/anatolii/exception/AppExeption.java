package anatolii.exception;

public class AppExeption extends Exception {
    String message;
    public AppExeption(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
