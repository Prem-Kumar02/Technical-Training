class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode temp=head;
        if(temp.next==null) return head;
        ListNode temp2=head.next;
        while(temp2!=null){
            if(temp.val==temp2.val){
                if(temp2.next==null){
                    temp.next=null;
                    break;
                } else{
                    temp2=temp2.next;
                    continue;
                }
                
            } else{
                temp.next=temp2;
                temp=temp2;
                temp2=temp2.next;
            }

        }
        return head;
    }
}