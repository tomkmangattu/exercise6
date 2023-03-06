package customexceptions;

public class NoHistoryFoundException extends Exception{
	public String message;
	
	public NoHistoryFoundException(String message){
		this.message = message;
	}
}
