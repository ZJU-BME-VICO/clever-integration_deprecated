package edu.zju.bme.clever.integration.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

import org.apache.log4j.Logger;

import edu.zju.bme.snippet.java.Reflector;

public enum CdrCache {

	INSTANCE;

	private static Logger logger = Logger.getLogger(CdrCache.class.getName());

	private final int cacheSize = 1000;
	private Map<Class<?>, Map<Integer, Object>> cacheMap = new HashMap<>();
	private Map<Class<?>, Queue<Integer>> cacheQueue = new HashMap<>();

	private CdrCache() {
	}
	
	public void clear() {
		cacheMap.clear();
		cacheQueue.clear();
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
			if (map != null) {
				return map.get(k);				
			}
		}
		
		return null;
	}

	public int getCacheSize() {
		return cacheSize;
	}
	
	public int calculateHashCode(Object target) {
		Iterable<Field> fields = 
				Reflector.INSTANCE.getFieldsUpTo(target.getClass(), null);
		List<Object> values = new ArrayList<>();
		fields.forEach(f -> {
			f.setAccessible(true);
			try {
				values.add(f.get(target));
			} catch (Exception e) {
				logger.error(e);
			}
		});
		
		return Objects.hash(values);
	}
	
}
