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
        if(lists.length==0) return null;
        //mergeSort approach;
        return mergeSort(lists,0,lists.length-1);

    }
    private ListNode mergeSort(ListNode[] lists,int i, int n){
        if(n-i==0) return lists[i];
        int mid= i+ (n-i)/2;
        ListNode left= mergeSort(lists,i,mid);
        ListNode right= mergeSort(lists,mid+1,n);

        return merge(left,right);
    }


    private ListNode merge(ListNode a,ListNode b){
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        while(a!=null  && b!=null){
            if(a.val >b.val){
                temp.next=b;
                b=b.next;
            }
            else{
                temp.next=a;
                a=a.next;
            }
            temp=temp.next;
        }
        temp.next= (a!=null)? a : b;
        return ans.next;
    }
}

//naive approach, putting everything inside a min heap, then extracting one by one.
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
        
//         PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->
//             Integer.compare(a.val,b.val)
//         );

//         for(ListNode node : lists){
//             if(node!=null) pq.add(node);
//         }
//         ListNode answer=new ListNode(0);
//         ListNode temp= answer;
//         while(!pq.isEmpty()){
//             ListNode node=pq.poll();
//             temp.next=node;
//             temp=temp.next;
//             if(node.next!=null) pq.add(node.next);
//         }
//         return answer.next;
//     }
// }