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
    public int pairSum(ListNode head) {
        if(head==null)
            return 0;
        
        List<Integer> temp = new ArrayList<>();
        
        ListNode curr = head;
        while(curr!=null)
        {
            temp.add(curr.val);
            curr=curr.next;
        }
        //System.out.println(temp.size());
        int max = Integer.MIN_VALUE;
        for(int i=0;i<temp.size()/2;i++)
        {
            int sum = temp.get(i) + temp.get(temp.size()-i-1);
            if(sum>max)
            {
                max = sum;
            }
        }
        return max;
    }
}