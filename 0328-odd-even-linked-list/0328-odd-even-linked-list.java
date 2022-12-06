class Solution 
{
    public ListNode oddEvenList(ListNode head) 
    {
        if (head == null) return head;

        ListNode dummy_odd = new ListNode(0, head), 
                 dummy_evn = new ListNode(0, head.next),
                 evn = dummy_evn, odd = dummy_odd;

        while (odd.next != null && (odd = odd.next) != null && (evn = evn.next) != null)
        {
            if (odd.next != null) odd.next = odd.next.next;
            if (evn.next != null) evn.next = evn.next.next;
        }

        odd.next = dummy_evn.next;

        return dummy_odd.next;
    }
}