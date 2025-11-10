import java.util.Stack;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = asteroids.length - 1; i >= 0; i--) {
            int asteroid = asteroids[i];
            boolean destroyed = false;
  
            while (!stack.isEmpty() && asteroid > 0 && stack.peek() < 0) {
                int top = stack.peek();
                if (Math.abs(asteroid) > Math.abs(top)) {
                    // Current asteroid destroys the one on the stack
                    stack.pop();
                } else if (Math.abs(asteroid) == Math.abs(top)) {
                    // Both asteroids are destroyed
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // The asteroid on the stack destroys the current one
                    destroyed = true;
                    break;
                }
            }
            
            // If the current asteroid survives, push it onto the stack
            if (!destroyed) {
                stack.push(asteroid);
            }
        }
        
        // Convert stack to result array 
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop(); 
        }
        return result;
    }
}