import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;  // Empty tree is symmetric
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        
        while (!queue.isEmpty()) {
            TreeNode leftN = queue.pollFirst();
            TreeNode rightN = queue.pollFirst();
            
            if (leftN == null && rightN == null) {
                continue;
            }
            
            if (leftN == null || rightN == null || leftN.val != rightN.val) {
                return false;
            }
            
            queue.add(leftN.left);
            queue.add(rightN.right);
            queue.add(leftN.right);
            queue.add(rightN.left);
        }
        
        return true; 
    }
}