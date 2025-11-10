import java.util.Stack;
class Solution {
    public int evaluatePostfix(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();

        for (String token : arr) {

            if (token.equals("+") || token.equals("-") || token.equals("*") 
                || token.equals("/") || token.equals("^")) {

                int b = st.pop();
                int a = st.pop();
                int result = 0;

                switch (token) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": 
                        int div = a / b;
                        int mod = a % b;
                        if (mod != 0 && ((a < 0) ^ (b < 0))) {
                            div--; 
                        }
                        result = div;
                        break;

                    case "^": result = (int)Math.pow(a, b); break;
                }

                st.push(result);
            }
            else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}