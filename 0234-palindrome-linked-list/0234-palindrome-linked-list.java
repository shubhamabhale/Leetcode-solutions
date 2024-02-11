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
        ListNode slow, fast;
        slow = fast = head;
        if(head==null || head.next==null){
            return true;
        }
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        Stack<ListNode> st = new Stack<>();
        
        while(slow!=null){
            st.push(slow);
            slow=slow.next;
        }
        
        while(!st.isEmpty()){
            if(st.peek().val==head.val)
                st.pop();
            else
                return false;
            head=head.next;
        }
        
        return st.isEmpty();
        
    }
}