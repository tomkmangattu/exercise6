package customexceptions;

public class InvalidURLException extends Exception {
	public String message;
	
	public InvalidURLException(String message){
		this.message = message;
	}
}
