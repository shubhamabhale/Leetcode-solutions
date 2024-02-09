class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(); // Create a dummy node
        ListNode current = result; // Use a pointer to traverse the merged list
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; // Move the pointer to the next node
        }
        
        // Append the remaining nodes of list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        return result.next; // Skip the dummy node and return the merged list
    }

    public ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has only one node, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle of the list using the slow and fast pointer technique
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
