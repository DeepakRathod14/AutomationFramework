package Learning.Automation.testcases.api;

import io.restassured.RestAssured;

public class PatternExample {

	static private int id;
	static private String name;
	static private String add;
	static private long mobile;
	
	static PatternExample pe=null; 
	
	private PatternExample() {
	}
	
	private static PatternExample getPatternExample() {
		if(pe==null) {
			pe = new PatternExample();
		}
		return pe;
	}

	public static int getId() {
		return id;
	}
	
	public static PatternExample setId(int id) {
		PatternExample.id = id;
		return getPatternExample();
		//return new PatternExample();
	}
	public static String getName() {
		return name;
	}
	
	public static PatternExample setName(String name) {
		PatternExample.name = name;
		return getPatternExample();
		//return new PatternExample();
	}
	public static String getAdd() {
		return add;
	}
	
	public static PatternExample setAdd(String add) {
		PatternExample.add = add;
		return getPatternExample();
	}
	public static long getMobile() {
		return mobile;
	}
	public static PatternExample setMobile(long mobile) {
		PatternExample.mobile = mobile;
		return getPatternExample();
	}

}
