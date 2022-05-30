package Core.exception;

public class KeyGenerationFailedException extends ClashAPIException {
    private static final String MESSAGE = "Key generation failed, username or password is incorrect";

    public KeyGenerationFailedException(Throwable cause) {
        super(MESSAGE, cause);
    }
    public KeyGenerationFailedException() {
        super(MESSAGE, new Throwable());
    }
}
