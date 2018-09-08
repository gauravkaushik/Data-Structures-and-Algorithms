package leetcode.hard.lrucache;

import java.util.HashMap;

public class LRUCache {

	HashMap<Integer, CacheValue> cache = null;
	int mru = 0; // mosta recently used key
	long currentTime = 0; // current logical time of system
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
			mru = key;
			CacheValue cv = cache.get(key);
			cv.updateTime = currentTime;
			currentTime++;
			return cv.value;
		} else {
			return -1;
		}

	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			CacheValue cv = cache.get(key);
			cv.value = value;
			cv.updateTime = currentTime;
			currentTime++;
			mru = key;

		} else {
			if (!isCacheFull()) {
				CacheValue cv = new CacheValue(value, currentTime);
				currentTime++;
				mru = key;
				cache.put(key, cv);
				currentSize++;
			} else {
				// find the least recently used entry to be deleted
				long min = Long.MAX_VALUE;
				CacheValue cv;
				int keyToBeDeleted = -1;
				for (int ikey : cache.keySet()) {
					
					if(ikey == mru)
					{
						if(currentSize>1)
						{
							continue; //ignore mru key if there is atleast one more entry in the cache
						}
					}
					
					cv = cache.get(ikey);
					if (cv.updateTime < min) {					
						min = cv.updateTime ;
						keyToBeDeleted = ikey;
					} 
					
					/*else if (cv.updateTime== min) {
						if (keyToBeDeleted == mru) {
							keyToBeDeleted = ikey;
							// let most recent key stay in cache in case of a
							// collision
						}
					}*/
				}

				cache.remove(keyToBeDeleted);
				cache.put(key, new CacheValue(value, currentTime++));
				mru = key;
			}

		}

	}

}

class CacheValue {
	int value;
	long updateTime; // time when this entry was created
	//long delta; // relative freshness with respect to other entries (higher
				// value indicated more recently used)

	CacheValue(int value, long createTime) {
		this.value = value;
		this.updateTime = createTime;
		//this.delta = 0;
	}

}
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */