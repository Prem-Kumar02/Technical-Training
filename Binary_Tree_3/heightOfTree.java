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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftH=height(root.left);
        int rightH=height(root.right);
        return Math.max(leftH,rightH)+1;
    }
    public int heightOfTree(TreeNode root) {
        return height(root);
    }
}