package algorithms.huffman;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.easy.twosum.Solution;

//19:24
//19:55
class HuffmanNode {
	char c;
	int data;
	HuffmanNode left, right;

	HuffmanNode(char c, int data) {
		this.c = c;
		this.data = data;
	}
}

class MyComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode a, HuffmanNode b) {
		return a.data - b.data;
	}
}

class HuffmanEncoding {
	public void print(HuffmanNode root, String s) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (root.c != '-')
				System.out.println(root.c + ":" + s);
		} else {
			print(root.left, s + "0");
			print(root.right, s + "1");
		}
	}

	public void encodingForUnsortedData() {
		char[] c = { 'a', 'b', 'd', 'c', 'e', 'f' };
		int[] freq = { 5, 9, 13, 12, 16, 45 };

		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(c.length, new MyComparator());
		for (int i = 0; i < c.length; i++) {
			HuffmanNode node = new HuffmanNode(c[i], freq[i]);
			q.add(node);
		}

		HuffmanNode f = null;
		while (q.size() > 1) {
			HuffmanNode a = q.poll();
			HuffmanNode b = q.poll();
			f = new HuffmanNode('-', a.data + b.data);
			f.left = a;
			f.right = b;
			q.add(f);
		}

		new HuffmanEncoding().print(f, "");

	}

	// 21:04
	public void encodingWhenFrequenciesAreAlreadySorted() {
		char[] charArr = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] freq = { 5, 9, 12, 13, 16, 45 };
		LinkedList<HuffmanNode> q1 = new LinkedList<HuffmanNode>();
		for (int i = 0; i < charArr.length; i++) {
			q1.addLast(new HuffmanNode(charArr[i], freq[i]));
		}

		LinkedList<HuffmanNode> q2 = new LinkedList<HuffmanNode>();
		HuffmanNode a, b, c = null;
		while (q1.size() + q1.size() > 1) {
			if (q1.isEmpty()) {
				a = q2.remove();
				b = q2.remove();
			} else if (q2.isEmpty()) {
				a = q1.remove();
				b = q1.remove();
			} else {
				a = (q1.peek().data < q2.peek().data ? q1.remove() : q2.remove());
				if (q1.isEmpty()) {
					b = q2.remove();
				} else if (q2.isEmpty()) {
					b = q1.remove();
				} else {
					b = (q1.peek().data < q2.peek().data ? q1.remove() : q2.remove());
				}
			}
			c = new HuffmanNode('-', a.data + b.data);
			c.left = a;
			c.right = b;
			q2.addLast(c);
		}
		new HuffmanEncoding().print(c, "");
	}

	public static void main(String[] args) {
		new HuffmanEncoding().encodingForUnsortedData();
		new HuffmanEncoding().encodingWhenFrequenciesAreAlreadySorted();
	}

}