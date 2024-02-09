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
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;

        result = new ListNode();
        ListNode ans = result;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val)
            {
                result.next = list1;
                list1=list1.next;
                result=result.next;
            }
            else
            {
                result.next = list2;
                list2=list2.next;
                result=result.next;
            }
            
        }
        if(list1!=null){
            result.next = list1;
        }
        else{
            result.next = list2;
        }
        
        return ans.next;
    }

    
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To split the list into two halves
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the list into two halves
        prev.next = null; // Break the link
        
        // Recursively sort the two halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        // Merge the sorted halves
        return mergeTwoLists(left, right);
        

    }
}