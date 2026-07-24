class Solution {
    public NestedInteger deserialize(String s) {

        
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        int num = 0;
        boolean negative = false;
        boolean hasNum = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                stack.push(new NestedInteger());
            } 
            else if (ch == '-') {
                negative = true;
            } 
            else if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                hasNum = true;
            } 
            else if (ch == ',' || ch == ']') {

                if (hasNum) {
                    if (negative) {
                        num = -num;
                    }

                    stack.peek().add(new NestedInteger(num));

                    num = 0;
                    negative = false;
                    hasNum = false;
                }

                if (ch == ']' && stack.size() > 1) {
                    NestedInteger curr = stack.pop();
                    stack.peek().add(curr);
                }
            }
        }

        return stack.pop();
    }
}