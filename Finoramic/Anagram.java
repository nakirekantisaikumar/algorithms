import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Anagram {

	public static ArrayList<ArrayList<Integer>> findAnagram(ArrayList<String> sortedInputList) {
		
		// Here result is an ArrayList of ArrayLists 
        ArrayList<ArrayList<Integer> > result =  
                  new ArrayList<ArrayList<Integer> >(); 
        
        ArrayList<Integer> temp;
        HashSet<String> found = new HashSet<String>();
        
        for (int i = 0; i < sortedInputList.size(); i++) {
        	temp = new ArrayList<Integer>();
        	
        	if(!found.contains(sortedInputList.get(i))) {
        		temp.add(i+1);//add index
            	
            	for (int j = 0; j < sortedInputList.size(); j++) {
            		if(i != j) {
            			
            			if(sortedInputList.get(i).equals(sortedInputList.get(j))) {
            				temp.add(j+1);
                			
                		}
            		}
            	}
            	
            	found.add(sortedInputList.get(i));
            	result.add(temp);
        	}
		}
        
        return result;
		
	}
	
	public static ArrayList<String> sortInputList(ArrayList<String> inputList) {
		
		ArrayList<String> sortedInputList = new ArrayList<String>();
		
		for (String inputString : inputList) {
			char tempArray[] = inputString.toCharArray(); 
	        // sort tempArray 
	        Arrays.sort(tempArray); 
	        // return new sorted string 
	        sortedInputList.add(new String(tempArray));
		}
		
		return sortedInputList;
	}
	
	public static void main(String[] args) {
		List<String> inputList = new ArrayList<>();
		inputList.add("cat");
		inputList.add("dog");
		inputList.add("god");
		inputList.add("tca");
		ArrayList<String> temp = new ArrayList<>();
		
		for (String string : inputList) {
			temp.add(string);
		}
		inputList = sortInputList(temp);
		System.out.println(inputList);
		findAnagram(temp);
	}
}
