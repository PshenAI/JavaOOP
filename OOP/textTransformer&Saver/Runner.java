package com.gmail.antonvoloshyn25;

public class Runner {

	public static void main(String[] args) {
		String test = "test";
		TextTransformer tx = new TextTransformer();
		InverseTransformer inv = new InverseTransformer();
		UpDownTransformer udt = new UpDownTransformer();

		TextSaver ts = new TextSaver();
//		ts.setTransformer(tx);
//		ts.saveTextToFile(test);
//		ts.setTransformer(inv);
//		ts.saveTextToFile(test);
		ts.setTransformer(udt);
		ts.saveTextToFile(test);

	}

}
