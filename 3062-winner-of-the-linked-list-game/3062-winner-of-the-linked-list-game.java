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
    public String gameResult(ListNode head) {
        int odd = 0, even=0;
        
        if(head==null)
            return "Tie";
        
        ListNode ptr = head;
        
        while(ptr!=null && ptr.next!=null){
            if(ptr.val>ptr.next.val){
                even++;
            } else if(ptr.val<ptr.next.val){
                odd++;
            } else {
                even++;
                odd++;
            }
            ptr = ptr.next.next;
        }
        
        if(odd==even)
            return "Tie";
        return odd>even?"Odd":"Even";
    }
}