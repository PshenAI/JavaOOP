package uni;

import uni.exceptions.GenderChoiceException;

public interface CSVConverter {
	public String toCSVString();

	public Student fromCSVString(String str) throws GenderChoiceException;

}
