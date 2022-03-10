package Core.exception;

public class KeyGenerationFailedException extends Exception {
    public KeyGenerationFailedException(String message) {
        super("Unable to generate the key due to: "+ message);
    }
}
