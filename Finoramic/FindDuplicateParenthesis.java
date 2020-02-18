import java.util.Stack;

public class FindDuplicateParenthesis {

    static int findDuplicateparenthesis(String input) { 
        Stack<Character> stack = new Stack<>(); 
        char[] inputCharArr = input.toCharArray(); 
        for (char ch : inputCharArr) { 
            if (ch == ')') { 
                char topChar = stack.peek(); 
                stack.pop(); 
                int elemInsidePar = 0; 
                while (topChar != '(') { 
                	elemInsidePar++; 
                    topChar = stack.peek(); 
                    stack.pop(); 
                } 
                if (elemInsidePar <= 1) { 
                    return 1; 
                } 
            } else { 
            	stack.push(ch); 
            } 
        } 

        return 0; 
    } 
	
	public static void main(String[] args) { 
        String str = "(a)"; 
        System.out.println(findDuplicateparenthesis(str));
	 } 
}
