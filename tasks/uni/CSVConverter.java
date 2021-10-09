package uni;

import uni.exceptions.WrongCSVFormatException;

public interface CSVConverter {
	public String toCSVString();

	public Student fromCSVString(String str) throws WrongCSVFormatException;

}
