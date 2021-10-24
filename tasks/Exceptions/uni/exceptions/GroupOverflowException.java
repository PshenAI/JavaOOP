package uni.exceptions;

public class GroupOverflowException extends Throwable {

	@Override
	public String toString() {
		return "Group is already assembled!";
	}

}
