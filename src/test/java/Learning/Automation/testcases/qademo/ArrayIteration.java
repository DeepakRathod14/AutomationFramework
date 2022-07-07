package Learning.Automation.testcases.qademo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayIteration {

	public static void main(String[] args) {
		String[] inputs = {"SMILE","HELLO","LIMES","LELOH","MILES","WORLD"};
		int index=0;
		for(String input : inputs){ //HELLO
			index++; //1,2
			char[] array1 = input.toCharArray();
			for(int i=index; i<inputs.length; i++){
				char[] array2 = inputs[index].toCharArray();
//				if(Arrays.compare){
//					System.out.println("Found : "+inputs[i]);
//				}
			}
		}
	}
	
	
	private static List<Character> converToWrapper(String input){
		List<Character> char1 = new ArrayList<>();
		for(char c : input.toCharArray()) {
			char1.add(new Character(c));
		}
		return char1;
	}
}
