package leetcode.easy.linkedlistcycle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLLWithASingleElementAndWithoutCycle() {
		ListNode ll = new ListNode(1);
		assertFalse(new Solution().hasCycle(ll));
	}

	@Test
	public void testLLWithASingleElementAndWithCycle() {
		ListNode ll = new ListNode(1);
		ll.next = ll;
		assertTrue(new Solution().hasCycle(ll));
	}

	@Test
	public void testLLWithTwoElementsAndWithoutCycle() {
		ListNode ll = new ListNode(1);
		ll.next = new ListNode(2);
		assertFalse(new Solution().hasCycle(ll));
	}

	@Test
	public void testLLWithTwoElementsAndWithCycle() {
		ListNode ll = new ListNode(1);
		ll.next = new ListNode(2);
		ll.next.next = ll;
		assertTrue(new Solution().hasCycle(ll));
	}

	@Test
	public void testLLWithThreeElementsAndWithCycle() {
		ListNode ll = new ListNode(1);
		ll.next = new ListNode(2);
		ll.next.next = new ListNode(3);
		ll.next.next = ll;
		assertTrue(new Solution().hasCycle(ll));
	}

}
