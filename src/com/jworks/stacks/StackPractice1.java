package com.jworks.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackPractice1 {

/*    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

    ApproachTaken:

    1. Build a hashMap of all the available characters and their matching pairs.
    2. create a stack ST
    3. Go through the string s and for each character c do
        i. if c is the opening char then add to stack ST.
        Else
            1.if c is closing char then compare c with the opening equivalent with that of the peek of the stack.
                if they match: pop the current element
                else: return false
        if stack is not empty return false.

        "()[]{}"


    */

    public static void main(String[] args) {
        // write your code here

        StackPractice1 stackPractice1 = new StackPractice1();
        System.out.println(stackPractice1.isValid("([)]"));
    }

    public boolean isValid(String word) {

        Stack<Character> parenthesesStack = new Stack<>();
        HashMap<Character, Character> parenthesesMap = new HashMap();
        parenthesesMap.put(')','(' );
        parenthesesMap.put('}','{');
        parenthesesMap.put(']','[');

        for (char parenthesesChar : word.toCharArray()) {

            if(parenthesesMap.containsKey(parenthesesChar)){

                Character character = parenthesesMap.get(parenthesesChar);

                if(parenthesesStack.isEmpty()) return false;

                Character peekCharacter = parenthesesStack.peek();

                if(peekCharacter.equals(character)){
                    parenthesesStack.pop();
                }else{
                    return false;
                }
            }else {
                parenthesesStack.push(parenthesesChar);
            }
        }

        return parenthesesStack.isEmpty();
    }


}
