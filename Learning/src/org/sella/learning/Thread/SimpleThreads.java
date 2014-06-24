package org.sella.learning.Thread;

public class SimpleThreads {

	// Display a message, preceded by
	// the name of the current thread
	static void threadMessage(final String message) {
		final String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {
		@Override
		public void run() {
			final String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too" };
			try {
				for (int i = 0; i < importantInfo.length; i++) {
					// Pause for 4 seconds
					Thread.sleep(4000);
					// Print a message
					threadMessage(importantInfo[i]);
				}
			} catch (final InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}

	@SuppressWarnings("static-access")
	public static void main(final String args[]) throws InterruptedException {

		// Delay, in milliseconds before
		// we interrupt MessageLoop
		// thread (default one hour).
		long patience = 1000 * 60 * 60;

		// If command line argument
		// present, gives patience
		// in seconds.
		if (args.length > 0) {
			try {
				patience = Long.parseLong(args[0]) * 1000;
			} catch (final NumberFormatException e) {
				System.err.println("Argument must be an integer.");
				System.exit(1);
			}
		}

		threadMessage("Starting MessageLoop thread");
		final long startTime = System.currentTimeMillis();
		final Thread t = new Thread(new MessageLoop());
		//final Thread t1 = new Thread(new MessageLoop());
		t.start();
		// t1.start();
		threadMessage("Waiting for MessageLoop thread to finish");
		// loop until MessageLoop
		// thread exits
		while (t.isAlive()) {
			threadMessage("Still waiting...");
			// Wait maximum of 1 second
			// for MessageLoop thread
			// to finish.
			t.sleep(10);
			if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				// Shouldn't be long now
				// -- wait indefinitely
				//t.join();
			}
		}
		threadMessage("Finally!");
	}
}