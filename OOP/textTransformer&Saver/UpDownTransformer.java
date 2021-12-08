package com.gmail.antonvoloshyn25;

public class UpDownTransformer extends TextTransformer {

	@Override
	public String transform(String text) {
		char[] arr = new char[text.length()];
		arr = text.toCharArray();
		String temp = "";
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] = Character.toUpperCase(arr[i]);
				temp += arr[i];
			} else {
				arr[i] = Character.toLowerCase(arr[i]);
				temp += arr[i];
			}
		}
		return temp;

	}
}
