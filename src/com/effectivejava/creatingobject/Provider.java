/**
 * 
 */
package com.effectivejava.creatingobject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Kaibo
 *
 */
public interface Provider {
	Service newService();
}

