package uni.exceptions;

public class GenderChoiceException extends Throwable {

	@Override
	public String toString() {
		return "You've entered wrong gender!";
	}
}
