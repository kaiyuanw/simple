package edu.ut.ece;

public class Class2TestInnerClass {
	
	private int instanceField;
	private static int staticField;

	public int instanceMethod(String arg1, int arg2, Dog d) {
		int a = 0 + arg2 - this.instanceField;
		String b = a + "" + arg1;
		return Integer.valueOf(instanceField) + Integer.valueOf(b) + staticField;
	}
	
	public Bird instanceMethod2() {
		instanceMethod("", 0, new Dog(){
			private int instanceField2;
			private String instanceField3;
			int instanceFieldS;
			public String instanceMethod(String arg1, int arg2, Dog d) {
				return instanceField3 + Integer.valueOf(instanceField) + "";
			}
			
			public int instanceMethod2(String arg1, int arg2) {
				return Integer.valueOf(staticField) + instanceField2;
			}
		});
		return new Bird(){
			int staticField = 1;
			String instanceField = "BB";
		};
	}

	public static String staticMethod(String arg1, int arg2) {
		String s = arg1 + arg2 + Class2TestInnerClass.staticField;
		return s;
	}
}
