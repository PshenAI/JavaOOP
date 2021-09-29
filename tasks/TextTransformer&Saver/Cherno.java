package com.gmail.antonvoloshyn25;

public class Cherno {

	public static void main(String[] args) {

		String text = "text";
		char[] arr = new char[text.length()];
		arr = text.toCharArray();
		String temp = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				arr[i] = Character.toUpperCase(arr[i]);
				temp += arr[i];
			} else {
				Character.toLowerCase(arr[i]);
				temp += arr[i];
			}
		}
		System.out.println(temp);

	}

}
