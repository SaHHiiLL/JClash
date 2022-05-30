package Core.exception;

/**
 * Thrown if the API token is not valid
 */
public class AuthException extends ClashAPIException
{
	private static final long serialVersionUID = -5457344366834718627L;


    public AuthException(Throwable cause) {
        super("403", cause);
    }
}
