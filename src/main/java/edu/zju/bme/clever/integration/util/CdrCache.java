package edu.zju.bme.clever.integration.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public enum CdrCache {

	INSTANCE;

	private final int cacheSize = 1000;
	private Map<Class<?>, Map<Integer, Object>> cacheMap = new HashMap<>();
	private Map<Class<?>, Queue<Integer>> cacheQueue = new HashMap<>();

	private CdrCache() {
	}
	
	public void put(Class<?> c, Integer k, Object o) {
		if (cacheMap.containsKey(c)) {
			Map<Integer, Object> map = cacheMap.get(c);
			map.put(k, o);
		} else {
			Map<Integer, Object> map = new HashMap<>();
			map.put(k, o);
			cacheMap.put(c, map);
		}
		
		if (cacheQueue.containsKey(c)) {
			Queue<Integer> queue = cacheQueue.get(c);
			queue.add(k);
			if (queue.size() > cacheSize) {
				Integer old = queue.poll();
				Map<Integer, Object> map = cacheMap.get(c);
				map.remove(old);
			}
		} else {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(k);
			cacheQueue.put(c, queue);
		}
	}
	
	public Object get(Class<?> c, Integer k) {
		if (cacheMap.containsKey(c)) {
			Map<Integer, Object> map = cacheMap.get(c);
			return map.get(k);
		}
		
		return null;
	}

	public int getCacheSize() {
		return cacheSize;
	}
	
}
