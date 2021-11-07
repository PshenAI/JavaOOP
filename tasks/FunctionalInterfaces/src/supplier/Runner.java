package supplier;

public class Runner {

	public static void main(String[] args) {
//		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		IntSupplier intSupp = new NumRet(nums);
//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(intSupp.getAsInt());
//		}

	}
}
// ** Task3
//class NumRet implements IntSupplier {
//	private int[] arr;
//	private int count = -1;;
//
//	public NumRet(int[] arr) {
//		super();
//		this.arr = arr;
//	}
//
//	@Override
//	public int getAsInt() {
//		count++;
//		return arr[count];
//	}
//
//}
// ** Task2
//List<String> text = List.of("Vortex", "Mistral", "Cado");
//
//Predicate<String> pred = a -> a.length() > 5;
//Supplier<String> supp = new SpecialWords(text, pred);
//for (int i = 0; i < text.size(); i++) {
//	System.out.println(supp.get());
//}
//class SpecialWords implements Supplier<String> {
//	private List<String> list;
//	private Predicate<String> pred;
//	private int count = -1;
//
//	public SpecialWords(List<String> list, Predicate<String> pred) {
//		super();
//		this.list = list;
//		this.pred = pred;
//	}
//
//	@Override
//	public String get() {
//		for (int i = count + 1; i < list.size(); i++) {
//			if (pred.test(list.get(i))) {
//				count = i;
//				return list.get(i);
//			}
//		}
//		return null;
//	}
//
//}
// ** Task1
//class FirstWord implements Supplier<String> {
//	private String text;
//	private int temp = -1;
//
//	public FirstWord(String text) {
//		super();
//		this.text = text;
//	}
//
//	@Override
//	public String get() {
//		String[] words = text.split(" ");
//		temp++;
//		return words[temp];
//	}
//
//}
