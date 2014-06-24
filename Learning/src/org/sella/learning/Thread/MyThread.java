package org.sella.learning.Thread;

public class MyThread {

	public static void main(final String[] args) throws InterruptedException {

		System.out.println("i am the Main thread...starting......");

		final Thread t1 = new Thread() {
			@Override
			public void run() {
				display("1");
				System.out.println("Thread 1");
			}
		};

		final Thread t2 = new Thread() {
			@Override
			public void run() {				
				display("2");
				System.out.println("Thread 2");
			}
		};
/*
		final Thread t3 = new Thread() {
			@Override
			public void run() {
				display("3");
				System.out.println("Thread 3");
			}
		};

		final Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				display("4");
				System.out.println("Thread 4");
			}
		});*/
		t1.start();
		Thread.sleep(5000);
		t2.start();
		Thread.sleep(5000);
		/*t3.start();
		t4.start();	*/
		System.out.println("i am Main thread finished");
	}

	synchronized protected static void display(final String from) {
		System.out.println("From "+from);
		final Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("Thread 5");
					synchronized (String.class) {
						
					}
				} catch (final InterruptedException e) {
					e.printStackTrace();
				}				
			}
		});
		t5.start();
		System.out.println("Calling finished");
	}

	
	
}
