package com.gmail.antonvoloshyn25;

public class InverseTransformer extends TextTransformer {

	@Override
	public String transform(String text) {
		StringBuilder sb = new StringBuilder();
		sb.append(text);
		sb.reverse();

		return sb.toString();
	}
}
