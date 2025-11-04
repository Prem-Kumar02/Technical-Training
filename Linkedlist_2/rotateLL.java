class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    ListNode findNode(ListNode temp, int k){
        int cnt=1;
        while(temp!=null){
            if(cnt==k) return temp;
            cnt++;
            temp=temp.next;
            
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }
        if(k%len==0) return head;
        k=k%len;
        tail.next=head;
        ListNode newLastNode=findNode(head,len-k);
        head=newLastNode.next;
        newLastNode.next=null;
        return head;

    }
}