//elab-source: TooYoungException.java
// เขียนคลาส TooYoungException ที่ช่องนี้

public class TooYoungException extends Exception {
    public TooYoungException() {
    }

    public TooYoungException(String message) {
        super(message);
    }
}
