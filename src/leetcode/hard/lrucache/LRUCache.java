package leetcode.hard.lrucache;

import java.util.HashMap;

public class LRUCache {

	MyDoubleLL list = new MyDoubleLL();

	HashMap<Integer, CacheValue> cache = null;
	int currentSize = 0;
	int capacity = 0;

	public boolean isCacheFull() {
		return currentSize >= capacity;
	}

	public LRUCache(int capacity) {
		cache = new HashMap<Integer, CacheValue>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {

		// do null and empty checks for cache
		if (cache.containsKey(key)) {
			CacheValue cv = cache.get(key);
			list.putAtEnd(cv.node);
			return cv.value;
		} else {
			return -1;
		}

	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			CacheValue cv = cache.get(key);
			cv.value = value;
			list.putAtEnd(cv.node);

		} else {
			if (!isCacheFull()) {
				Node node = list.addEnd(key);
				CacheValue cv = new CacheValue(value, node);
				cache.put(key, cv);
				currentSize++;
			} else {
				// find the least recently used entry to be deleted
				int keyToBeDeleted = list.removeHeadNode();
				cache.remove(keyToBeDeleted);
				Node node = list.addEnd(key);
				cache.put(key, new CacheValue(value, node));
			}

		}

	}

}

class CacheValue {
	int value;
	Node node;

	CacheValue(int value, Node node) {
		this.value = value;
		this.node = node;
	}

}

class MyDoubleLL {
	Node head, tail;

	Node addEnd(int key) {
		Node node = new Node(key);
		if (tail != null) {
			tail.right = node;
			node.left = tail;
			tail = node;
		} else {
			// means head is null as well
			head = tail = node;
		}
		return node; // address of node
	}

	public int removeHeadNode() {
		// TODO Auto-generated method stub
		if (head == null)
			return -1;
		int key = head.key;
		if (head == tail) // only one node
			tail = null;
		else {
			head.right.left = null;
		}
		head = head.right;
		return key;
	}

	void putAtEnd(Node node) {
		if (tail == node) {
			// do nothing
		} else if (head == node) {
			head = head.right;
			node.right = null;
			node.left = tail;
			tail.right = node;
			tail = node;
		} else {
			// delete from current position
			node.left.right = node.right;
			node.right.left = node.left;

			// put at tail position
			node.right = null;
			node.left = tail;
			tail.right = node;

			// update tail pointer
			tail = node;
		}
	}
}

class Node {
	int key;
	Node left, right;

	public Node(int key) {
		this.key = key;
	}

}
