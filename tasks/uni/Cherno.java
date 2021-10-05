package uni;

import java.util.Arrays;

public class Cherno {
	public static void main(String[] args) {
		String a = "Aaron";
		char[] tempArr = a.toLowerCase().toCharArray();
		int[] arr = new int[a.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = indexGetter(tempArr[i]);
		}

		System.out.println(Arrays.toString(arr));

	}

	public static int indexGetter(char exm) {
		int fix = 0;
		char[] alph = { 'a', 'b', 'c', 'd', 'e', 'f', 'j', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < alph.length; i++) {
			char temp = exm;
			if (temp == alph[i]) {
				fix = i;
			}
		}
		return fix;
	}

}
