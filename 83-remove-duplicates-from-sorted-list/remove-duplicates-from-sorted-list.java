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
        ListNode temp=head;
        HashSet<Integer> set=new HashSet<>();
        ListNode prev=null;
        while(temp!=null){
            if(!set.contains(temp.val)){
                prev=temp;
                set.add(temp.val);
                temp=temp.next;
            }
            else{
                prev.next=temp.next;
                temp=temp.next;
            }
        }
        return head;
    }
}