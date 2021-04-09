/**
 * 
 */
package com.smoothstack.weekone.dayfour;

/**
 * Week 1 Day 4 Two Thread Deadlock using Line class
 * 
 * @author Joa
 *
 */
public class TwoThreadDeadlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Line lineA = new Line(0, 0, 10, 10);
		Line lineB = new Line(0, 0, 5, 5);

		System.out.println("Start");
		Runnable threadA = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (lineA) {
						Thread.sleep(1000);
						synchronized (lineB) {
							System.out.println("Thread 1 got locks for both lines");

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Runnable threadB = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (lineB) {
						Thread.sleep(1000);
						synchronized (lineA) {
							System.out.println("Thread 2 got locks for both lines");

						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(threadA).start();
		new Thread(threadB).start();
		System.out.println("End");
	}

}
