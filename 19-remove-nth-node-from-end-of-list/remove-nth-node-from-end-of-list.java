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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count_size=0;
        ListNode temp=head;
        while(temp!=null){
            count_size++;
            temp=temp.next;
        }
        if(count_size==n){
            return head.next;
        }
        int target=count_size-n;
        ListNode tt=head;
        int count=0;
        while(tt!=null){
            if(count==target-1){
                tt.next=tt.next.next;
            }
            tt=tt.next;
            count++;
        }
        return head;
    }
}