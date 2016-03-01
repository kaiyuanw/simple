package edu.ut.ece;

public class Class2TestInnerClass {
	
	private int instanceField;
	private static int staticField;

	public int instanceMethod(String arg1, int arg2) {
		int a = 0 + arg2;
		String b = a + "" + arg1;
		return instanceField + Integer.valueOf(b) + staticField;
	}

	public static String staticMethod(String arg1, int arg2) {
		String s = arg1 + arg2 + staticField;
		return s;
	}
}
