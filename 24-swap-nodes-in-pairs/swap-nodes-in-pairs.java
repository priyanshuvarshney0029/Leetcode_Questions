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
    public ListNode swapPairs(ListNode head) {
        ListNode prev=null;
        ListNode first=head;
        while(first!=null && first.next!=null){ // km se km two node honi chaiye
             ListNode second=first.next;
             first.next=second.next;
             second.next=first;

             if(prev==null){
                head=second;
             }
             else{
                prev.next=second;
             }
             prev=first;
             first=first.next;
        }
        return head;
    }
}