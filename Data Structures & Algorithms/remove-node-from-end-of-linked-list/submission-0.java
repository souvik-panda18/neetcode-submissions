class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode temp = head;

        // First pass: count the number of nodes
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // Edge case: if we need to remove the head node
        if (cnt == n) {
            return head.next;
        }

        // Second pass: go to the (cnt - n - 1)-th node
        temp = head;
        for (int i = 1; i < cnt - n; i++) {
            temp = temp.next;
        }

        // Remove the N-th node from the end
        temp.next = temp.next.next;

        return head;
    }
}
