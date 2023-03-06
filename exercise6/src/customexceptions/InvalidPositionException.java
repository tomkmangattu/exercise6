package customexceptions;

public class InvalidPositionException extends Exception{
	public String message;
	
	public InvalidPositionException(String message) {
		this.message = message;
	}
}
