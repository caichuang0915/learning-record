package com.tupelo.algorithm;

/**
 * @Author: caichuang
 * @Date: 2023/5/17 11:39
 */
public class TwoAdd {


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		return findNextNode(l1,l2,0);
	}


	public ListNode findNextNode(ListNode one, ListNode two,int addNext) {

		if(null==one && null==two){
			if(addNext==0){
				return null;
			}

			return new ListNode(1);
		}

		ListNode result = new ListNode();

		int num1 = null==one ? 0 : one.val;
		int num2 = null==two ? 0 : two.val;


		int i = num1 + num2 + addNext;
		result.val = i>=10 ? i-10 : i;
		addNext = i>=10 ? 1 : 0;
		result.next = findNextNode(null==one? null : one.next,  null==two? null : two.next, addNext);
		return result;
	}




	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


}
