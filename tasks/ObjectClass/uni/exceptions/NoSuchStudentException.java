package uni.exceptions;

public class NoSuchStudentException extends Throwable {

	@Override
	public String toString() {
		return "No such student in the group!";
	}

}
