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
    public ListNode mergeKLists(ListNode[] lists) {
        //naive approach, putting everything inside a min heap, then extracting one by one.
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->
            Integer.compare(a.val,b.val)
        );

        for(ListNode node : lists){
            if(node!=null) pq.add(node);
        }
        ListNode answer=new ListNode(0);
        ListNode temp= answer;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            temp.next=node;
            temp=temp.next;
            if(node.next!=null) pq.add(node.next);
        }
        return answer.next;
    }
}