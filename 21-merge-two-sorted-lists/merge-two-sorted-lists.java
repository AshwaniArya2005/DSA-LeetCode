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
        ListNode i = list1;
        ListNode j = list2;

        ListNode root = new ListNode(0);
        ListNode k = root;
        while(i!=null && j!= null){
            if(i.val<j.val){
                k.next = i;
                k = k.next;
                i = i.next;
            }else{
                k.next = j;
                k = k.next;
                j = j.next;
            }
        }
        if(i==null){
            k.next = j;
        }

        if(j == null){
            k.next = i;
        }

        return root.next;
    }
}