import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
class Solution {
    static boolean isHeap(Node root) {
        if (root == null) return true;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean nullFound = false;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current == null) {
                nullFound = true;
            } else {
                if (nullFound)
                    return false; 

                q.add(current.left);
                q.add(current.right);
            }
        }

        return checkHeapProperty(root);
    }

    static boolean checkHeapProperty(Node root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        if (root.right == null)
            return (root.data >= root.left.data) && checkHeapProperty(root.left);

        return (root.data >= root.left.data &&
                root.data >= root.right.data &&
                checkHeapProperty(root.left) &&
                checkHeapProperty(root.right));
    }
}