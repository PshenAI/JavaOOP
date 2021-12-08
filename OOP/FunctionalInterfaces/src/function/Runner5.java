package function;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

public class Runner5 {

	public static void main(String[] args) {
		Calendar cl = Calendar.getInstance();

		Function<Calendar, String> date = calenda -> {
			Date datto = calenda.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String result = sdf.format(datto);
			return result;
		};
		System.out.println(date.apply(cl));
	}

}
