/**
 * 
 */
package com.smoothstack.weekone.dayfour;

/**
 * Week 1 Day 4 Driver for ProducerConsumer
 * 
 * @author Joa
 *
 */
public class ProducerConsumerDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		final ProducerConsumer pc = new ProducerConsumer();

		// Creates producer thread
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Creates consumer thread
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Start both threads
		t1.start();
		t2.start();

		// Waits for threads to die
		t1.join();
		t2.join();
	}

}
