/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { 
            val = x;
       }
 * }
 */
public class SolutionListNode{
	public ListNode middleNode(ListNode head) {
		int counted = 0;
		ListNode exem = head;
		try{ 
			while(exem.val!=0){
				counted++;
				exem = exem.next;
			}
		}
		catch(NullPointerException e){ 
		} 

		for(int i=0;i<counted/2;i++){
			head = head.next;
		}
		return head;
	}
}
