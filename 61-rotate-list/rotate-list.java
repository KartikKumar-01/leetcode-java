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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int n = len(head);
        k = k % n;
        if(k == 0) return head;
        int x = n - k;
        ListNode temp = head;
        ListNode newHead = head;
        ListNode prev = null;
        while(x > 0){
            prev = newHead;
            newHead = newHead.next;
            x--;
        }
        ListNode cur = newHead;
        while(cur.next != null) cur = cur.next;
        cur.next = temp;
        prev.next = null;
        return newHead;
    }
    private int len(ListNode head){
        if(head == null) return 0;
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        
        return len;
    }
}