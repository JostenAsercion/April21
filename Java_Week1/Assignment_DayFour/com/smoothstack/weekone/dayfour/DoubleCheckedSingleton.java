/**
 * 
 */
package com.smoothstack.weekone.dayfour;

/**
 * Week 1 Day 4 Singleton with double checked locking
 * @author Joa
 *
 */
public class DoubleCheckedSingleton {
	private DoubleCheckedSingleton object;

	public DoubleCheckedSingleton getInstance() {
		if (object == null) {
			synchronized (this) {
				if (object == null) {
					object = new DoubleCheckedSingleton();
				}
			}
		}
		return object;
	}

}
