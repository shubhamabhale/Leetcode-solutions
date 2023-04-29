/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
        {
            return null;
        }
        ListNode fastPtr = new ListNode();
        fastPtr = head;
        HashSet<ListNode> hset = new HashSet<>();
        while(fastPtr!=null)
        {
            if(hset.contains(fastPtr))
            {
                return fastPtr;
            }
            hset.add(fastPtr);
            fastPtr = fastPtr.next;
        }
        return null;
    }
}