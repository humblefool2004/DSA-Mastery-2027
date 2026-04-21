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
        while(head!=null && head.next!=null){
            boolean duplicate=false;
            while(head.next!=null && head.next.val== head.val){
                head=head.next;
                duplicate=true;
            }

            if(duplicate){
                prev.next=head.next;
            }else{
                prev=head;
            }
            if(head.next==null) break;
            head=head.next;
        }
        return dummy.next;
    }
}