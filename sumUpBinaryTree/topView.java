import java.util.* ;
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


class Solution {
    static ArrayList<Integer> topView(Node root) {
         if (root == null) return new ArrayList<>();
        
        TreeMap<Integer, Integer> topViewMap = new TreeMap<>();
      
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0)); 
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;
 
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }
            
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }
        
        return new ArrayList<>(topViewMap.values());
        
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