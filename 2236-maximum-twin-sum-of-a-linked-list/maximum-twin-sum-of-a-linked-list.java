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
    int len(ListNode head){
        if(head == null) return 0;
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    public int pairSum(ListNode head) {
        if(head == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode temp = head;
        int n = len(head);
        int ans = 0;
        for(int i = 0; i < n && temp != null; i++){
            if(i <= (n / 2) - 1) map.put(i, temp.val);
            else ans = Math.max(ans, temp.val + map.get(n - i - 1));
            temp = temp.next;
        }
        return ans;
    }
}