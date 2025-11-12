import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution
{
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        if (root == null) return new ArrayList<>();
        
        TreeMap<Integer, Integer> bottomViewMap = new TreeMap<>();
      
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0)); 
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;
 
     
            bottomViewMap.put(hd, node.data);
            
            
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }
        
        return new ArrayList<>(bottomViewMap.values());
    }
}
class Pair {
    Node node;
    int hd;
    
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}