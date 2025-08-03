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
    public boolean isPalindrome(ListNode head) {
         ListNode mid=find_mid(head);
         ListNode reverse_head=reverse(mid);

         ListNode temp=head;
         ListNode temp1=reverse_head;


         while(temp1!=null){
            if(temp1.val!=temp.val){
                return false;
            }
            temp=temp.next;
            temp1=temp1.next;
         }
         return true;
    }
    public ListNode find_mid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode ahead=curr.next;
            curr.next=prev;
            prev=curr;
            curr=ahead;
        }
        return prev;
    }
}