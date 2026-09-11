class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumy = new ListNode(0);  // Dummy head node
        ListNode dummy = dumy;            // Pointer to build result list

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;   // ✅ fixed line
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        // Attach remaining nodes from list1 or list2
        if (list1 != null) dummy.next = list1;
        else dummy.next = list2;

        return dumy.next;  // Return head of merged list (skip dummy node)
    }
}
