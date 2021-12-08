package collector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;

public class Runner {

	public static void main(String[] args) {
// *******************************************************************************************************************************
		// ** Task2
		String text = "Forever dsn't mean t, fr real";
		String[] array = text.split(" ");

		BiConsumer<HashMap<String, Integer>, String> accum = (map, str) -> {
			int check = vowelCounter(str);
			if (check > 0) {
				map.put(str, check);
			}
		};

		BinaryOperator<HashMap<String, Integer>> bop = (map1, map2) -> {
			HashMap<String, Integer> result = new HashMap<>(map1);
			map2.forEach((k, v) -> {
				result.put(k, v);
			});
			return result;
		};

		Map<String, Integer> vowels = Arrays.stream(array)
				.collect(Collector.of(HashMap::new, accum, bop, Collector.Characteristics.IDENTITY_FINISH));
		System.out.println(vowels);

	}

	public static int vowelCounter(String text) {
		char[] a = text.toCharArray();
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		int temp = 0;
		for (char c : a) {
			for (char d : vowels) {
				if (c == d) {
					temp++;
				}
			}
		}
		return temp;
	}

}

//*******************************************************************************************************************************	
// ** Task1
//String text = "Forever doesn't mean it, for real";
//String[] textArr = text.split(" ");
//
//Collector<String, HashSet<String>, HashSet<String>> toSet = new ToSet<>();
//
//HashSet<String> stringSet = Arrays.stream(textArr).collect(toSet);
//System.out.println(stringSet);
//class ToSet<T> implements Collector<T, HashSet<T>, HashSet<T>> {
//
//	@Override
//	public Supplier<HashSet<T>> supplier() {
//		return HashSet::new;
//	}
//
//	@Override
//	public BiConsumer<HashSet<T>, T> accumulator() {
//
//		return (hashSet, element) -> {
//			hashSet.add(element);
//		};
//	}
//
//	@Override
//	public BinaryOperator<HashSet<T>> combiner() {
//		return (hashSet1, hashSet2) -> {
//			HashSet result = new HashSet<>(hashSet1);
//			hashSet2.forEach(a -> result.add(a));
//			return result;
//		};
//	}
//
//	@Override
//	public Function<HashSet<T>, HashSet<T>> finisher() {
//		return Function.identity();
//	}
//
//	@Override
//	public Set<Characteristics> characteristics() {
//		// TODO Auto-generated method stub
//		return Set.of(Characteristics.IDENTITY_FINISH);
//	}
