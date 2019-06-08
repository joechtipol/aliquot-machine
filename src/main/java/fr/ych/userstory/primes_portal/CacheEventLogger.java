package fr.ych.userstory.primes_portal;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheEventLogger implements CacheEventListener<Object, Object> {
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheEventLogger.class);

	public void onEvent(CacheEvent<Object, Object> event) {
		LOGGER.info("Event: " + event.getType() + " Key: " + event.getKey() + " old value: " + event.getOldValue()
				+ " new value: " + event.getNewValue());
		//event.getSource().getRuntimeConfiguration().get

	}
}
