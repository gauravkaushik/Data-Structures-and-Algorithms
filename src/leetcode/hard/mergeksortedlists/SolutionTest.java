package leetcode.hard.mergeksortedlists;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		ListNode l1 = new ListNode(1);
		l1.appendEnd(4);
		l1.appendEnd(5);

		ListNode l2 = new ListNode(1);
		l2.appendEnd(3);
		l2.appendEnd(4);

		ListNode l3 = new ListNode(2);
		l3.appendEnd(6);

		ListNode expected = new ListNode(1);
		expected.appendEnd(1);
		expected.appendEnd(2);
		expected.appendEnd(3);
		expected.appendEnd(4);
		expected.appendEnd(4);
		expected.appendEnd(5);
		expected.appendEnd(6);

		ListNode[] lists = { l1, l2, l3 };

		ListNode actual = new Solution().mergeKLists(lists);

		assertTrue(areBothListsSame(expected, actual));

	}

	private boolean areBothListsSame(ListNode expected, ListNode actual) {
		ListNode exp = expected;
		ListNode act = actual;

		while (exp != null) {
			if (act == null || (act.val != exp.val))
				return false;
			exp = exp.next;
			act = act.next;
		}

		return true;
	}

}
