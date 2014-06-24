package org.sella.learning.Thread;
public class SleepMessages {
    public static void main(final String args[])
        throws InterruptedException {
        final String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
            Thread.sleep(1000,1000);
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }
}