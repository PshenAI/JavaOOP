package sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Runner {

	public static void main(String[] args) {
		Yakuza dojima = new Yakuza();

		dojima.setFamilyName("Dojima");

		String[] members = { "Kiryu", "Nishikiyama", "Kuze", "Awano", "Sohei", "Kazama" };
		String[] ranks = { "Kyodai", "Kyodai", "Wakagashira", "Wakagashira", "Oyabun" };

		Map<String, String> familyMembers = new HashMap<>();
		for (int i = 0; i < members.length; i++) {
			String member = members[i];
			String rank = null;
			if (i < ranks.length) {
				rank = ranks[i];
			}
			familyMembers.put(member, rank);
		}

		dojima.setFamilyMembers(familyMembers);

//		dojima.expelFromFamily("Kazama");

		Class<?> cl = dojima.getClass();

		try {
			Method method = cl.getDeclaredMethod("expelFromFamily", String.class);
			TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
			method.invoke(dojima, testAnnotation.testParam());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Field[] fields = cl.getDeclaredFields();
//
//		Arrays.stream(fields).forEach(a -> {
//			a.setAccessible(true);
//			try {
//				a.set(dojima, null);
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
//		System.out.println(dojima);
	}

}
