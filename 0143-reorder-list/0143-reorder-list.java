class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // Step 1: Find the middle of the linked list
        ListNode ptrS = head, ptrF = head;
        while (ptrF != null && ptrF.next != null) {
            ptrS = ptrS.next;
            ptrF = ptrF.next.next;
        }

        // Step 2: Push nodes from the middle to the end onto a stack
        Stack<ListNode> stack = new Stack<>();
        while (ptrS != null) {
            stack.push(ptrS);
            ptrS = ptrS.next;
        }

        // Step 3 and 4: Reorder the list by popping nodes from the stack
        ListNode temp = head;
        ListNode prev = null;
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            if (top == temp) {
                break;
            }
            prev = temp.next;
            temp.next = top;
            top.next = prev;
            temp = prev;
        }
        temp.next = null;
    }
}
