package edu.zju.bme.clever.integration.entity;

import edu.zju.bme.clever.integration.util.CdrCache;

public class Entity {
	
	public Entity() {
		super();
	}
	
	@Override
	public int hashCode() {
		return CdrCache.INSTANCE.calculateHashCode(this);
	}
	
}
