package uni.exceptions;

public class WrongCSVFormatException extends Throwable {

	@Override
	public String toString() {
		return "Wrong CSV Format! /n Check the sequence of variables, or type of delimeter you're using (must be ':')!";
	}

}
