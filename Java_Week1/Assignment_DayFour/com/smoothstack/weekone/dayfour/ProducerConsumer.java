/**
 * 
 */
package com.smoothstack.weekone.dayfour;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Week 1 Day 4 One thread produces, one thread consumes, both have access to
 * bounded buffer
 * 
 * @author Joa
 *
 */
public class ProducerConsumer {

	/**
	 * @param args
	 */
	Queue<Integer> list = new LinkedList<>();
	int size = 3;
	int randomNumber = 0;

//Produces random integers into the list
	public void produce() throws InterruptedException {
		while (true) {
			synchronized (this) {
				// Does not produce if list is full
				while (list.size() == size)
					wait();

				randomNumber = (int) (Math.random() * 100);
				System.out.println("Producer added " + randomNumber);
				list.add(randomNumber);

				notify();
				Thread.sleep(500);
			}
		}
	}

//Consumes ints from list
	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				// Does not consume if list is empty
				while (list.size() == 0)
					wait();

				// Consumes head of queue
				int consumedInt = list.remove();

				System.out.println("Consumer ate " + consumedInt);

				notify();
				Thread.sleep(500);
			}
		}
	}

}
