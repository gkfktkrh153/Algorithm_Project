import java.util.Stack;

class Solution {
static boolean solution(String s) {
            if (s.charAt(0) == ')') {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

        }

        if (stack.size() > 0) {
            return false;
        }

        return true;
    }

}