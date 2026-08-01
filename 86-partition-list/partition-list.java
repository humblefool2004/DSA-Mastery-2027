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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        ListNode smaller= new ListNode(-101);
        ListNode temps=smaller;
        ListNode larger= new ListNode(-101);
        ListNode templ=larger;
        while(head!=null){
            if(head.val<x){
                temps.next=new ListNode(head.val);
                temps=temps.next;
            }else{
                templ.next= new ListNode(head.val);
                templ=templ.next;
            }
            head=head.next;
        }
        temps.next=larger.next;
        return smaller.next;
    }
}