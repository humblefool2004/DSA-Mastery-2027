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
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=dummy.next;
        while(curr!=null && curr.next!=null){
            boolean duplicate=false;
            while(curr.next!=null && curr.next.val== curr.val){
                curr=curr.next;
                duplicate=true;
            }
            if(curr.next==null && duplicate) prev.next=null;
            if(duplicate){
                prev.next=curr.next;
            }else{
                prev=curr;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}