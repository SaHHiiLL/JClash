package Core.exception;

/**
 * Parent class for ClashAPI exceptions
 */
public class ClashAPIException extends RuntimeException
{
	private static final long serialVersionUID = 4796823785326521342L;

	public ClashAPIException(String message, Throwable cause) {
		super(message, cause);
	}
}
